package com.core.listener;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

/** 
* ʧ�����Ե��࣬�����ڲ�������Ĳ��Է�����ע�⣺(retryAnalyzer=com.core.base.MyRetryAnalyzer.class)��ʽ�����û���ʹ��
* RetryListener�࣬���RetryListener��˵��
* @ClassName: MyRetryAnalyzer 
* @Description: TODO(������һ�仰��������������) 
* @author qiaojiafei 
* @date 2016��2��29�� ����11:33:46 
*  
*/
public class MyRetryAnalyzer implements IRetryAnalyzer {
	
	private static final String TEST_RETRY_COUNT = "testRetryCount";
	private int currentTry = 0;
	private int m_maxRetries = 0;

	public MyRetryAnalyzer() {
		currentTry=0;
		m_maxRetries=1;
	}

	public int getCount() {
		return this.currentTry;
	}

	public int getMaxCount() {
		return this.m_maxRetries;
	}

	@Override
	public synchronized boolean retry(ITestResult result) {
		String maxRetriesStr = result.getTestContext().getSuite().getParameter("maxRetries");        
        if(maxRetriesStr != null)
        {
            try        
            {
            	m_maxRetries = Integer.parseInt(maxRetriesStr);
            	System.out.println("Get failed Retry count from xml:" + m_maxRetries);
            }
            catch (final NumberFormatException e)
            {
            	System.out.println("NumberFormatException while parsing maxRetries from suite file." + e);
            }
        }		
		
		String testClassName = String.format("%s.%s", result.getMethod().getRealClass().toString(),
				result.getMethod().getMethodName());
		 if ( !result.isSuccess() )
	        {
	            if ( currentTry < m_maxRetries )
	            {
	                ++currentTry;
	              
	                System.out.println(
	    					"[RETRYING] " + testClassName + " FAILED, " + "Retrying " + currentTry + " time");
	                return true;
	            }
	        }
		 	currentTry=0;
	        return false;	
		}
	

}
