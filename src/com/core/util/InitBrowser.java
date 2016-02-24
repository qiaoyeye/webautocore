package com.core.util;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

/** 
 * @author QiaoJiafei 
 * @version 创建时间：2015年10月22日 下午12:08:20 
 * 类说明 
 */
public class InitBrowser {

	public static WebDriver init(WebDriver dr) {
		Log log = new Log(InitBrowser.class);
		log.info("初始化浏览器开始");
		String browser = OptionFile.getPropertiesValue("Myconfig.properties", "init");
		
		if(browser!=null) {
			if(browser.equals("firefox")) {
				log.info("启动firefox浏览器");
				String key = "webdriver.firefox.bin";
				String value = OptionFile.getPropertiesValue("Myconfig.properties", "firePath");
				System.setProperty(key, value);
				dr = new FirefoxDriver();
				dr.manage().window().maximize();
				dr.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			}else if(browser.equals("IE")) {
				log.info("启动IE浏览器");
				String key = "webdriver.ie.driver";
				String value = OptionFile.getPropertiesValue("Myconfig.properties", "IEPath");
				System.setProperty(key, value);
				dr = new InternetExplorerDriver();
				dr.manage().window().maximize();
				dr.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			}else if (browser.equals("chrome")) {
				log.info("chrome");
				String key = "webdriver.chrome.driver";
				String value = OptionFile.getPropertiesValue("Myconfig.properties", "chromePath");
				System.setProperty(key, value);
				dr = new ChromeDriver();
				dr.manage().window().maximize();
				dr.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			}
		}else {
			log.warn("获取到的浏览器名称为"+browser);
		}
		return dr;
	}
/*	
	
	 * 初始化火狐浏览器
	 * 
	public  WebDriver initFireFox(WebDriver dr) {
		
		
		String key = "webdriver.firefox.bin";
		String value = "C:/Program Files (x86)/Mozilla Firefox/firefox.exe";
		System.setProperty(key, value);
		dr = new FirefoxDriver();
		dr.manage().window().maximize();
		dr.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		  
		return dr;		
		
	}
	
	
	
	 * 初始化IE浏览器
	 * 
	public  WebDriver initIE(WebDriver dr) {
		
		String key = "webdriver.ie.driver";
		String value = "./other/IEDriverServer.exe";
		System.setProperty(key, value);
		dr = new InternetExplorerDriver();
		dr.manage().window().maximize();
		dr.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		return dr;
		
	}
	
	
	 * 初始化谷歌浏览器
	 * 
	public  WebDriver initChrome(WebDriver dr) {
		
		String key = "webdriver.chrome.driver";
		String value = "./other/chromedriver.exe";
		System.setProperty(key, value);
		dr = new ChromeDriver();
		dr.manage().window().maximize();
		dr.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		return dr;		
	}
	*/
}
