package com.core.po;

import org.openqa.selenium.WebDriver;

import com.core.base.BaseLocator;
import com.core.base.BasePage;
import com.core.base.MidConvert;
import com.core.dao.LoginLocator;

/** 
 * @author QiaoJiafei 
 * @version 创建时间：2015年12月23日 下午2:53:37 
 * 类说明 
 */
/*
public class LoginPage1 extends MidConvert implements BasePage{

	LoginLocator loginLocator1;
	
	public LoginPage1(WebDriver dr, LoginLocator loginLocator){
		super(dr);	
		this.loginLocator1 = loginLocator;
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
		validation(loginLocator1);
	}

}*/
