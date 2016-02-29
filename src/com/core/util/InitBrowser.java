package com.core.util;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

/** 
* �������ʼ��������Myconfig�����ļ�������Ӧ�������
* @ClassName: InitBrowser 
* @Description: TODO(������һ�仰��������������) 
* @author qiaojiafei 
* @date 2016��2��29�� ����11:58:15 
*  
*/
public class InitBrowser {

	public static WebDriver init(WebDriver dr) {
		Log log = new Log(InitBrowser.class);
		log.info("��ʼ���������ʼ");
		String browser = OptionFile.readProperties("./conf/Myconfig.properties", "init");
		
		if(browser!=null) {
			if(browser.equals("firefox")) {
				log.info("����firefox�����");
				String key = "webdriver.firefox.bin";
				String value = OptionFile.readProperties("./conf/Myconfig.properties", "firePath");
				System.setProperty(key, value);
				dr = new FirefoxDriver();
				dr.manage().window().maximize();
				dr.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			}else if(browser.equals("IE")) {
				log.info("����IE�����");
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
			log.warn("��ȡ�������������Ϊ"+browser);
		}
		return dr;
	}
/*	
	
	 * ��ʼ����������
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
	
	
	
	 * ��ʼ��IE�����
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
	
	
	 * ��ʼ���ȸ������
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
