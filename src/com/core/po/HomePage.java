package com.core.po;

import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;


import com.core.base.BasePage;
import com.core.base.MidConvert;
import com.core.dao.HomeDao;
import com.core.dao.Locator;
import com.core.dao.LoginDao;
import com.core.util.OptionFile;


/** 
 * @author QiaoJiafei 
 * @version 创建时间：2016年2月26日 下午2:36:30 
 * 类说明 
 */
public class HomePage extends MidConvert implements BasePage{
	Locator lc_account;
	
	HomeDao homedao = new HomeDao();
	
	public HomePage() {
		super();
		// TODO Auto-generated constructor stub
	}

	public HomePage(WebDriver dr) {
		super(dr);
		// TODO Auto-generated constructor stub
		if(!dr.getTitle().equals("首页 - 知乎")) {
			throw new IllegalStateException("This is not Home Page of logged in user, current page" +
                    "is: " +dr.getTitle());
		}
	}

	

	@Override
	public BasePage validation() {
		// TODO Auto-generated method stub
		/*if(baseLocator instanceof HomeDao) {
			HomeDao homedao = (HomeDao)baseLocator;*/
			Map<String, Locator> locatorMap = OptionFile.getXMLMap(XMLPATH,
	                this.getClass().getCanonicalName());
			System.out.println("-----------name："+this.getClass().getCanonicalName()); 
			lc_account = locatorMap.get(homedao.textaccount);
			String textString = cm.findElement(lc_account).getText();
			Assert.assertEquals(textString, "乔叶叶");
		/*}
		else {
			log.warn("传入的BaseLocator不是LoginLocator");
		}*/
		return new HomePage(dr);
	}

	@Override
	public void action(int sheet, int CaseNum) {
		// TODO Auto-generated method stub
		validation();
	}
	
}
