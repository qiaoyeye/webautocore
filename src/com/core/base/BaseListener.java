package com.core.base;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.IResultMap;
import org.testng.ITestContext;
import org.testng.ITestNGMethod;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.TestListenerAdapter;
import org.testng.annotations.Listeners;

import com.core.listener.TestRetryAnalyzer;
import com.core.util.Log;

/** 
* @ClassName: BaseListener 
* @Description: 基础监听类，包含自动截图，失败自动重试方法 ，所有测试类都要添加@Listeners({com.core.base.BaseListener.class})
* @author qiaojiafei 
* @date 2015年10月22日 上午10:29:54 
*  
*/
public class BaseListener extends TestListenerAdapter{
	BaseClass bc = new BaseClass();
	Log log = new Log(BaseListener.class);
	boolean isRetryHandleNeeded = false;
	IResultMap failedCases ;
	IResultMap skippedCases;
	
	@Override  
    public synchronized void onTestFailure(ITestResult result) { 
		//failedCases = removeFailedTestsInTestNG(result.getTestContext());
		failedCases = result.getTestContext().getFailedTests();
		
		/*该方法除了卸载baseclass类，也可卸载这里
		Object currentClass = result.getInstance();  
		WebDriver webDriver = ((BaseClass) currentClass).getDriver();        
		    if (webDriver != null)  
		     {  
				Date currentTime = new Date();
				SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");
				String dateString = formatter.format(currentTime);
				File scrFile = ((TakesScreenshot) webDriver).getScreenshotAs(OutputType.FILE);
				try {
					
					File screenshot = new File("./screenshotimg/" + dateString
					+ ".png");
					FileUtils.copyFile(scrFile,screenshot);
				} catch (IOException e) {
					e.printStackTrace();
				}
		           
		} */

		//super.onTestFailure(result);
		log.error(result.getName()+": failed");
		bc.takeScreenShort(result);
		/*===========================以上代码是自动截图,下面是自动重试====================================*/
		if(result.getMethod().getRetryAnalyzer() !=null) {
			TestRetryAnalyzer testRetryAnalyzer = (TestRetryAnalyzer) result.getMethod().getRetryAnalyzer();
			if(testRetryAnalyzer.getCount() <= testRetryAnalyzer.getMaxCount()) {
				result.setStatus(ITestResult.SKIP);
				Reporter.setCurrentTestResult(null);
			}else {
				failedCases.addResult(result, result.getMethod());
			}
			isRetryHandleNeeded = true;
		}
	
	}

	@Override
	public void onFinish(ITestContext testContext) {
		if(isRetryHandleNeeded) {
			//emoveIncorrectlySkippedTests(testContext,failedCases);
			removeIncorrectlySkippedTests(testContext,removeFailedTestsInTestNG(testContext));
			removeFailedTestsInTestNG(testContext);
		}else {
			skippedCases= testContext.getSkippedTests();
			failedCases= testContext.getFailedTests();
		}
	}
	
	protected IResultMap removeIncorrectlySkippedTests(ITestContext test,IResultMap map) {    
		List<ITestNGMethod> failsToRemove =new ArrayList<ITestNGMethod>();
		IResultMap returnValue = test.getSkippedTests();
		for(ITestResult result : returnValue.getAllResults()) {
			for(ITestResult resultToCheck : map.getAllResults()) {
				if(resultToCheck.getMethod().equals(result.getMethod())) {
					failsToRemove.add(resultToCheck.getMethod());
					break;
				}
			}   

	      for(ITestResult resultToCheck : test.getPassedTests().getAllResults()) {

	          if(resultToCheck.getMethod().equals(result.getMethod())) {
	        	  failsToRemove.add(resultToCheck.getMethod());
	        	  break;
	          }
	      }   
		}

	    for(ITestNGMethod method : failsToRemove) {
	    	returnValue.removeResult(method);
	    } 
	    skippedCases= returnValue;
	    return returnValue;
	}
	
	private IResultMap removeFailedTestsInTestNG(ITestContext test) {     
		failedCases = test.getFailedTests();
		IResultMap returnValue = test.getFailedTests();
		for(ITestResult result : returnValue.getAllResults()) {            
        boolean isFailed = false;

        for(ITestResult resultToCheck : failedCases.getAllResults()) {
            if(result.getMethod().equals(resultToCheck.getMethod()))
            {
            	log.debug("passed:"+result.getMethod().getMethodName());
            	isFailed = true;
                break;
            }
        }
        if(!isFailed) {
        	returnValue.removeResult(result.getMethod());
        	test.getFailedConfigurations().removeResult(result.getMethod());
        }
      }
      return returnValue;
      
    }

}
