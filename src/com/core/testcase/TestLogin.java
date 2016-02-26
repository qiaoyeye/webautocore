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
 * @author QiaoJiafei 
 * @version 创建时间：2015年12月23日 上午11:19:51 
 * 类说明 
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
