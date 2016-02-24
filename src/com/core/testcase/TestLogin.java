package com.core.testcase;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.core.base.BaseProvider;
import com.core.base.MidConvert;
import com.core.po.LoginPage;
import com.core.util.OptionFile;


/** 
 * @author QiaoJiafei 
 * @version ����ʱ�䣺2015��12��23�� ����11:19:51 
 * ��˵�� 
 */
@Listeners({com.core.base.BaseListener.class})
public class TestLogin extends MidConvert{
	public int sheet = 2;
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
	
	//�Ƽ�ʹ�ø÷�������ʱҳ��Ԫ�ر��ˣ�ֻҪ��LoginPage�༴�ɣ��ҿ��Թ�������ֱ�ӵ��õ�¼
	//@Test(retryAnalyzer=com.core.listener.TestRetryAnalyzer.class)
	@Test(dataProvider="testdp",dataProviderClass = BaseProvider.class)
	public void testlogin(Object caseNum) {
		System.out.println(caseNum);
		int rowNum = (int)caseNum;
		LoginPage lp = new LoginPage(dr);
		lp.action(sheet, rowNum);
		try {
			Thread.sleep(30000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("----------------------------------------------");
		//System.out.println(5/0);
	}

/*	
	@Test(enabled=false)//���Ƽ�ʹ�ø÷�������Ϊһ��ҳ��Ԫ�ر��ˣ���Ҫ�Ĳ����࣬����Ҳ��Ҫ��LoginPage��
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
	}*/
}
