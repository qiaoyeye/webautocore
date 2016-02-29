package com.core.util;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

/** 
* 浏览器初始化，根据Myconfig配置文件创建相应的浏览器
* @ClassName: InitBrowser 
* @Description: TODO(这里用一句话描述这个类的作用) 
* @author qiaojiafei 
* @date 2016年2月29日 上午11:58:15 
*  
*/
public class InitBrowser {

	public static WebDriver init(WebDriver dr) {
		Log log = new Log(InitBrowser.class);
		log.info("初始化浏览器开始");
		String browser = OptionFile.readProperties("./conf/Myconfig.properties", "init");
		
		if(browser!=null) {
			if(browser.equals("firefox")) {
				log.info("启动firefox浏览器");
				String key = "webdriver.firefox.bin";
				String value = OptionFile.readProperties("./conf/Myconfig.properties", "firePath");
				System.setProperty(key, value);
				dr = new FirefoxDriver();
				dr.manage().window().maximize();
				dr.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			}else if(browser.equals("IE")) {
				log.info("启动IE浏览器");
				String key = "webdriver.ie.driver";
				String value = OptionFile.readProperties("./conf/Myconfig.properties", "IEPath");
				System.setProperty(key, value);
				dr = new InternetExplorerDriver();
				dr.manage().window().maximize();
				dr.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			}else if (browser.equals("chrome")) {
				log.info("chrome");
				String key = "webdriver.chrome.driver";
				String value = OptionFile.readProperties("./conf/Myconfig.properties", "chromePath");
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
