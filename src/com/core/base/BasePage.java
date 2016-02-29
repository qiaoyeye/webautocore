package com.core.base;

import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.core.dao.Locator;
import com.core.po.PageAction;
import com.core.util.Common;
import com.core.util.Log;
import com.core.util.OptionFile;

/** 
* 基本页面类，所有po内的页面都要继承该类，该类封装了common类的webdriver初始化操作和获取XML中元素为page下的所有map，如：
*     <page name="com.core.po.LoginPage">
*		<element ByType="name" value="account">username</element>
*    </page>
* map的key=username，value是Locator对象，包含ByType和value
* @ClassName: BasePage 
* @Description: TODO(基本页面类，所有po内的页面都要继承该类，该类封装了common类的webdriver初始化操作和获取XML中元素为page下的所有map) 
* @author qiaojiafei 
* @date 2016年2月29日 上午11:19:10 
*  
*/
public class BasePage {
	protected WebDriver dr; 
	protected Map<String, Locator> locatorMap;
	protected Log log = new Log(this.getClass());
	protected Common cm = new Common();
	
	public BasePage() {
		// TODO Auto-generated constructor stub
	}
	
	public BasePage(WebDriver dr) {
		this.dr = dr;
		cm.setDriver(this.dr);
		locatorMap = OptionFile.getXMLMap(PageAction.XMLPATH,
                this.getClass().getCanonicalName());
		log.debug("XML获取到的page name："+this.getClass().getCanonicalName());
	}
	
	public WebDriver getDriver() {
		return dr;
	}

}
