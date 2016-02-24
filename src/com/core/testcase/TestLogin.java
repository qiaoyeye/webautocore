package com.core.testcase;

import org.apache.http.client.utils.URLEncodedUtils;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.core.base.MidConvert;
import com.core.dao.Locator;
import com.core.dao.LoginLocator;
import com.core.po.LoginPage;
import com.core.po.LoginPage1;
import com.core.util.InitBrowser;
import com.core.util.OptionFile;

/** 
 * @author QiaoJiafei 
 * @version 创建时间：2015年12月23日 上午11:19:51 
 * 类说明 
 */
@Listeners({com.core.base.BaseListener.class})
public class TestLogin extends MidConvert{
	
	final String URL = OptionFile.getPropertiesValue("logininfo.properties", "product_site");
	
	@BeforeMethod
	public void beforeClass() {
		super.initDriver();
		dr.get(URL);
	}
	@AfterMethod
	public void afterClass() {
		super.tearDown();
	}
	
	//推荐使用该方法，即时页面元素变了，只要该LoginPage类即可，且可以共其它类直接调用登录
	@Test(retryAnalyzer=com.core.listener.TestRetryAnalyzer.class)
	public void testlogin() {
		LoginPage lp = new LoginPage(dr);
		lp.action();
		System.out.println("----------------------------------------------");
		System.out.println(5/0);
	}

	
	@Test(enabled=false)//不推荐使用该方法，因为一旦页面元素变了，需要改测试类，并且也需要改LoginPage类
	public void testlogin1() {
		String name = OptionFile.getPropertiesValue("logininfo.properties", "product_site_username");
		String pwd = OptionFile.getPropertiesValue("logininfo.properties", "product_site_password");
		
		Locator lc_name = cm.getLocator("id", "user", name);
		Locator lc_pwd = cm.getLocator("id", "pwd", pwd);
		LoginLocator loginLocator = new LoginLocator();
		loginLocator.setLc_name(lc_name);
		loginLocator.setLc_pwd(lc_pwd);
		
		LoginPage1 lp = new LoginPage1(dr, loginLocator);
		lp.action();
	}
}
