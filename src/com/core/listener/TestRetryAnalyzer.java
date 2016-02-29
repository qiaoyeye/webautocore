package com.core.listener;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;
import org.testng.annotations.Test;

import com.core.util.Log;

/** 
* 失败重试监听类，需要在测试类中注解：@Test(retryAnalyzer=com.core.listener.TestRetryAnalyzer.class)
* 考虑影响测试用例的执行效率，可根据实际情况使用，建议使用该类，不使用MyRetry……
* @ClassName: TestRetryAnalyzer 
* @Description: 失败重试监听类，需要在测试类中注解：@Test(retryAnalyzer=com.core.listener.TestRetryAnalyzer.class) ,该类与BaseListener配合使用
* @author qiaojiafei 
* @date 2015年11月11日 下午12:25:18 
*  
*/
public class TestRetryAnalyzer implements IRetryAnalyzer{

    private static final String TEST_RETRY_COUNT = "testRetryCount";
    private int count = 1;
    private int maxCount = 1;
    
    Log log = new Log(TestRetryAnalyzer.class);
    public TestRetryAnalyzer() {
		String retryMaxCount = System.getProperty(TEST_RETRY_COUNT);
		if (retryMaxCount != null) {
			maxCount = Integer.parseInt(retryMaxCount);
		}
	}

    public int getCount() {
              return this.count;
    }

    public int getMaxCount() {
              return this.maxCount;
    }
    
	@Override
	public synchronized boolean retry(ITestResult result) {
		// TODO Auto-generated method stub
		//从xml中读取"maxRetries"的最大重试次数
		String maxRetriesStr = result.getTestContext().getSuite().getParameter("maxRetries");
		maxCount = Integer.parseInt(maxRetriesStr);
		String testClassName = String.format("%s.%s", result.getMethod().getRealClass().toString(), result.getMethod().getMethodName());

		if (count <= maxCount) {
			result.setAttribute("RETRY", new Integer(count));
			log.debug("============[RETRYING] " + testClassName + " FAILED, "

                                              + "Retrying " + count + " time");
			count += 1;
			return true;
		}
		return false;
	}
}
