package com.core.po;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.events.WebDriverEventListener;

import com.core.base.BaseLocator;
import com.core.base.BasePage;
import com.core.base.MidConvert;
import com.core.dao.Locator;
import com.core.dao.LoginLocator;
import com.core.util.TestData;
import com.core.util.OptionFile;

/** 
* @ClassName: LoginPage 
* @Description: TODO(�����¼��ҳ��) 
* @author qiaojiafei 
* @date 2015��12��23�� ����3:08:15 
*  
*/
public class LoginPage extends MidConvert implements BasePage{

	String xmlpath = "D:/git/webautocore/excel/loginpage.xml";
	public LoginPage(){
	}

	public LoginPage(WebDriver dr){
		super(dr);	
	}
		
	@Override
	public void validation(BaseLocator baseLocator) {
		// TODO Auto-generated method stub
		if(baseLocator instanceof LoginLocator) {
			LoginLocator loginLocator = (LoginLocator)baseLocator;
			//ע�⣬�����ǻ�ȡLocator����
			Locator lc_name = cm.getLocatorByXML(xmlpath, loginLocator.textusername);
			Locator lc_pwd = cm.getLocatorByXML(xmlpath, loginLocator.textpassword);
			
			cm.findElement(lc_name).sendKeys(loginLocator.getUsername());			
			cm.findElement(lc_pwd).sendKeys(loginLocator.getPassword());
			cm.findElement(lc_name).submit();
		}else {
			log.warn("�����BaseLocator����LoginLocator");
		}
	}

	@Override
	public void action(int sheet, int caseNum) {
		// TODO Auto-generated method stub	
		LoginLocator loginLocator = new LoginLocator();
		//ע�⣬�����ǻ�ȡ��������
		Map<String, String> map = TestData.getTestData(sheet, caseNum);
		loginLocator.setUsername(map.get("username"));
		loginLocator.setPassword(map.get("password"));
		
		validation(loginLocator);
	}

		

}
