package com.core.po;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.events.WebDriverEventListener;

import com.core.base.BaseLocator;
import com.core.base.BasePage;
import com.core.base.MidConvert;
import com.core.dao.Locator;
import com.core.dao.LoginLocator;
import com.core.util.OptionFile;

/** 
* @ClassName: LoginPage 
* @Description: TODO(处理登录的页面) 
* @author qiaojiafei 
* @date 2015年12月23日 下午3:08:15 
*  
*/
public class LoginPage extends MidConvert implements BasePage{

	String name = OptionFile.getPropertiesValue("logininfo.properties", "product_site_username");
	String pwd = OptionFile.getPropertiesValue("logininfo.properties", "product_site_password");
	
	Locator lc_name = cm.getLocator("id", "user", name);
	Locator lc_pwd = cm.getLocator("id", "pwd", pwd);
	
	public LoginPage(){
	}

	public LoginPage(WebDriver dr){
		super(dr);	
	}
		
	@Override
	public void validation(BaseLocator baseLocator) {
		// TODO Auto-generated method stub
		if(baseLocator instanceof LoginLocator) {
			LoginLocator lc = (LoginLocator)baseLocator;
			cm.sendkeys(lc.getLc_name());
			cm.sendkeys(lc.getLc_pwd());
			cm.findElement(lc.getLc_name()).submit();
		}else {
			log.warn("传入的BaseLocator不是LoginLocator");
		}
	}

	@Override
	public void action() {
		// TODO Auto-generated method stub	
		LoginLocator loginLocator = new LoginLocator();
		loginLocator.setLc_name(lc_name);
		loginLocator.setLc_pwd(lc_pwd);
		validation(loginLocator);
	}
	

}
