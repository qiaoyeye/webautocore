package com.core.base;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.uncommons.reportng.HTMLReporter;

/** 
* @ClassName: BaseClass 
* @Description: 基本原始类，所有测试类都要添加
* @author qiaojiafei 
* @date 2015年10月22日 上午10:29:19 
*  
*/
public class BaseClass {
	private WebDriver dr;   

	protected BaseClass() {
		
	}
	
	protected BaseClass(WebDriver dr) {
		this.dr = dr;
	}
	
	protected void setDriver(WebDriver dr) {
		this.dr = dr;
	}
	
	protected WebDriver getDriver() {  
		return dr;  
	} 
/*	
	public String getClassName() {
		return this.getClass().getSimpleName();
	}
	*/
	protected void takeScreenShort(ITestResult result) {
	     Object currentClass = result.getInstance();  
	     WebDriver webDriver = ((BaseClass) currentClass).getDriver();  
	  
	     if (webDriver != null) {  
			Date currentTime = new Date();
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");
			String dateString = formatter.format(currentTime);
			File scrFile = ((TakesScreenshot) webDriver).getScreenshotAs(OutputType.FILE);
			try {
				String filename = dateString+result.getName()+ ".png";
				File screenshot = new File("screenshotimg/" + filename);
				FileUtils.copyFile(scrFile,screenshot);
				
				Reporter.setCurrentTestResult(result);
				//String filepath = screenshot.getAbsolutePath().replace(".\\screenshotimg", "screenshotimg");
				String filepath = screenshot.getAbsolutePath();
				
				//Reporter.log("<img src=\"file:///" + filepath + "\"/>",true);
				Reporter.log("<a href=\"" + filepath + "\" target=\"_blank\">Failed Screen Shot</a>",true);
				
				//HTMLReporter html = new HTMLReporter();
				//Reporter r = html.generateReport(List<XmlSuite> xmlSuites,List<ISuite> suites, "sdfsdf");
				//r.log("<a href=\"" + filepath + "\" target=\"_blank\">Failed Screen Shot</a>",true);
			} catch (IOException e) {
				e.printStackTrace();
			}
	               
	     } 
	}
}
