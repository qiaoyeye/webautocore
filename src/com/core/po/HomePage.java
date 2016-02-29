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
public class HomePage extends BasePage implements PageAction{
	Locator lc_account;
	WebDriver dr;
	HomeDao homedao = new HomeDao();
	
	public HomePage() {
		super();
		// TODO Auto-generated constructor stub
	}

	public HomePage(WebDriver dr) {
		super(dr);
		this.dr = dr;
		// TODO Auto-generated constructor stub
		if(!dr.getTitle().equals("首页 - 知乎")) {
			throw new IllegalStateException("This is not Home Page of logged in user, current page" +
                    "is: " +dr.getTitle());
		}
	}

	@Override
	public PageAction validation() {
		// TODO Auto-generated method stub
		String textString = cm.findElement(lc_account).getText();
		Assert.assertEquals(textString, "乔叶叶");

		return new HomePage(dr);
	}

	@Override
	public void action(int sheet, int CaseNum) {
		// TODO Auto-generated method stub
		lc_account = locatorMap.get(homedao.textaccount);
		
		validation();
	}
	
	/*
	 * 比如点击个人头像
	 * */
	public void fun1() {
		//返回个人头像页面
	}
	
	
	/*
	 * 比如点击主页的某个链接
	 * */
	public void fun2() {
		//返回某个链接页面
	}
	
	/*
	 * 比如点点击主页的……(主要是点击后页面发生了跳转）
	 * */
}
