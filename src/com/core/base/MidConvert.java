package com.core.base;

import org.openqa.selenium.WebDriver;

import bsh.This;

import com.core.dao.Locator;
import com.core.util.Common;
import com.core.util.InitBrowser;
import com.core.util.Log;
import com.core.util.OptionFile;

/** 
* 中间转换类，继承BaseClass后，所有的测试类，可以继承该类，不需要再集成BaseClass
* 为了节省测试类中，每次都要new comm，new log对象，所以在该类中集中进行了对象的初始化操作
* @ClassName: MidConvert 
* @Description: TODO 中间转换类，继承BaseClass后，所有的测试类，可以继承该类，不需要再集成BaseClass
* @author qiaojiafei 
* @date 2015年12月23日 上午11:36:29 
*  
*/
public class MidConvert extends BaseClass{
	protected WebDriver dr; 
	protected Locator lc = null;
	protected Log log = new Log(this.getClass());
	protected Common cm = new Common();
	
	/**
	 * 默认构造函数
	 */
	public MidConvert() {
		
	}
	
	/**
	 * 含参数的构造函数，初始化父类WebDriver和Common类的WebDriver
	 * @param dr
	 */
	protected MidConvert(WebDriver dr) {
		super(dr);
		this.dr = dr;
		cm.setDriver(dr);
	}
	
	/** 
	 * 重写父类的setDriver,用于给本类和父类的WebDriver赋值
	 */
	protected void setDriver(WebDriver dr) {
		this.dr = dr;
		super.setDriver(dr);
	}
	
	/** 
	* @Title: initDriver 
	* @Description: 初始化浏览器的操作，并且将初始化的WebDriver传给父类和Common，同一方法只可调用一次
	* @return void
	* @throws 
	*/
	protected void initDriver() {
		this.setDriver(InitBrowser.init(dr));
		super.setDriver(dr);
		cm.setDriver(dr);
	}
	
/*	protected void initDriver() {
		dr = InitBrowser.init(dr);
		super.setDriver(dr);
		cm.setDriver(dr);
	}*/
	
	protected void testURL() {
		final String URL = OptionFile.readProperties("./conf/logininfo.properties", "product_site");
		dr.get(URL);
	}
	
	/** 
	* @Title: tearDown 
	* @Description: 关闭浏览器操作
	* @return void
	* @throws 
	*/
	protected void tearDown() {
		dr.quit();
	}

}
