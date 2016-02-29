package com.core.listener;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;
import org.testng.annotations.Test;

import com.core.util.Log;

/** 
* ʧ�����Լ����࣬��Ҫ�ڲ�������ע�⣺@Test(retryAnalyzer=com.core.listener.TestRetryAnalyzer.class)
* ����Ӱ�����������ִ��Ч�ʣ��ɸ���ʵ�����ʹ�ã�����ʹ�ø��࣬��ʹ��MyRetry����
* @ClassName: TestRetryAnalyzer 
* @Description: ʧ�����Լ����࣬��Ҫ�ڲ�������ע�⣺@Test(retryAnalyzer=com.core.listener.TestRetryAnalyzer.class) ,������BaseListener���ʹ��
* @author qiaojiafei 
* @date 2015��11��11�� ����12:25:18 
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
		//��xml�ж�ȡ"maxRetries"��������Դ���
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
