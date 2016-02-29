package com.core.po;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.WebDriverEventListener;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;








import com.core.base.MidConvert;
import com.core.base.BasePage;
import com.core.dao.Locator;
import com.core.dao.LoginDao;
import com.core.factory.PageFactory;
import com.core.util.TestData;
import com.core.util.OptionFile;

/** 
* @ClassName: LoginPage 
* @Description: TODO(处理登录的页面) ,知乎为例子
* @author qiaojiafei 
* @date 2015年12月23日 下午3:08:15 
*  
*/
public class LoginPage extends BasePage implements PageAction{
		
	Locator lc_name;
	Locator lc_pwd;
	Locator but_submit;
	WebDriver dr;
	LoginDao loginDao = new LoginDao();
		
	public LoginPage(){
		super();
	}

	public LoginPage(WebDriver dr){
		super(dr);
		this.dr = dr;
		if(!dr.getTitle().equals("知乎 - 与世界分享你的知识、经验和见解")) {
			throw new IllegalStateException("This is not sign in page, current page is: "
                    +dr.getTitle());
		}
	}
		
	@Override
	public PageAction validation(){
		// TODO Auto-generated method stub
		//if(baseLocator instanceof LoginDao) {
			//LoginDao loginLocator = (LoginDao)baseLocator;
			
			//-----------------------------尝试新写法开始----------------------------------
			//获得XML中相应的page元素map
			
			
			typeUsername();
			typePassword();
			submit();
			
	        WebDriverWait wait = new WebDriverWait(dr, 10);
	        wait.until(new ExpectedCondition<WebElement>(){

				@Override
				public WebElement apply(WebDriver arg0) {
					// TODO Auto-generated method stub
					return arg0.findElement(By.id(":0"));
				}
	        	
	        }).isDisplayed();
			//----------------------------尝试新写法结束,和下面不可共存------------------------------------
			
			/*
			//注意，这里是获取Locator对象
			lc_name = cm.getLocatorByXML(XMLPATH, loginLocator.textusername);
			lc_pwd = cm.getLocatorByXML(XMLPATH, loginLocator.textpassword);
			
			cm.sendkeys(lc_name, loginLocator.getUsername());
			cm.sendkeys(lc_pwd, loginLocator.getPassword());
			cm.findElement(lc_name).submit();
			*/
			
			/*或这样写
			cm.findElement(lc_name).sendKeys(loginLocator.getUsername());			
			cm.findElement(lc_pwd).sendKeys(loginLocator.getPassword());
			cm.findElement(lc_name).submit();
			*/
		//}else {
		//	log.warn("传入的BaseLocator不是LoginLocator");
		//}
	      
	        /*
		//不使用pagefactory
	    return new HomePage(dr);
	        */
	    //使用pagefactory
		return   (HomePage) PageFactory.getPage(HomePage.class, getDriver());

	}

	@Override
	public void action(int sheet, int caseNum) {
		
		// TODO Auto-generated method stub	
		//LoginDao loginLocator = new LoginDao();
		
		//获取Locator的页面元素
		/*Map<String, Locator> locatorMap = OptionFile.getXMLMap(XMLPATH,
                this.getClass().getCanonicalName());*/
		//System.out.println("-----------name："+this.getClass().getCanonicalName()); 
		lc_name = locatorMap.get(loginDao.textusername);
		lc_pwd = locatorMap.get(loginDao.textpassword);
		but_submit = locatorMap.get(loginDao.textsubmit);
		
		
		//注意，这里是获取测试数据
		Map<String, String> map = TestData.getTestData(sheet, caseNum);
		loginDao.setUsername(map.get("username"));
		loginDao.setPassword(map.get("password"));
		
		
		//调用业务逻辑方法

		validation();

	}
	
	
	/** 
	* 输入用户名方法
	* @Title: typeUsername 
	* @Description: TODO
	* @return void
	* @throws 
	*/
	protected void typeUsername() {
		System.out.println("--------------"+lc_name.getBy()+";"+lc_name.getElement()+";"+loginDao.getUsername());
		cm.sendkeys(lc_name, loginDao.getUsername());
	}
	/** 
	* 输入密码方法
	* @Title: typePassword 
	* @Description: TODO
	* @return void
	* @throws 
	*/
	protected void typePassword() {
		cm.sendkeys(lc_pwd, loginDao.getPassword());
	}
	
	/** 
	* 登录提交方法
	* @Title: submit 
	* @Description: TODO
	* @return void
	* @throws 
	*/
	protected void submit() {
		cm.click(but_submit);
	}	

}
