package com.core.testcase;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.core.base.BaseProvider;
import com.core.base.MidConvert;
import com.core.po.LoginPage;
import com.core.util.OptionFile;
import com.sun.jna.Native.ffi_callback;

/** 
* 测试类：测试登录
* @ClassName: TestLogin 
* @Description: TODO(这里用一句话描述这个类的作用) 
* @author qiaojiafei 
* @date 2016年2月29日 上午11:55:48 
*  
*/
@Listeners({com.core.base.BaseListener.class})
public class TestLogin extends MidConvert{
	public int sheet = 2;	
	
	@BeforeMethod
	public void beforeClass() {
		super.initDriver();
		super.testURL();
	}
	@AfterMethod
	public void afterClass() {
		super.tearDown();
	}
	
	//推荐使用该方法，即时页面元素变了，只要该LoginPage类即可，且可以共其它类直接调用登录
	//@Test(retryAnalyzer=com.core.listener.TestRetryAnalyzer.class)
	@Test(dataProvider="testdp",dataProviderClass = BaseProvider.class)
	public void testlogin(Object caseNum) {
		int rowNum = (int)caseNum;
		LoginPage lp = new LoginPage(dr);
		lp.action(sheet, rowNum);
		
	}

}
