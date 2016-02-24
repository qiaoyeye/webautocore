package com.core.base;

import org.openqa.selenium.WebDriver;

import com.core.dao.Locator;
import com.core.util.Common;
import com.core.util.InitBrowser;
import com.core.util.Log;

/** 
* @ClassName: MidConvert 
* @Description: TODO �м�ת���࣬�̳�BaseClass�����еĲ����࣬���Լ̳и��࣬����Ҫ�ټ���BaseClass
* @author qiaojiafei 
* @date 2015��12��23�� ����11:36:29 
*  
*/
public class MidConvert extends BaseClass{
	protected WebDriver dr; 
	protected Locator lc = null;
	protected Log log = new Log(MidConvert.class);
	protected Common cm = new Common();
	
	/**
	 * Ĭ�Ϲ��캯��
	 */
	public MidConvert() {
		
	}
	
	/**
	 * �������Ĺ��캯������ʼ������WebDriver��Common���WebDriver
	 * @param dr
	 */
	protected MidConvert(WebDriver dr) {
		super(dr);
		this.dr = dr;
		cm.setDriver(dr);
	}
	
	/** 
	 * ��д�����setDriver,���ڸ�����͸����WebDriver��ֵ
	 */
	protected void setDriver(WebDriver dr) {
		this.dr = dr;
		super.setDriver(dr);
	}
	
	/** 
	* @Title: initDriver 
	* @Description: ��ʼ��������Ĳ��������ҽ���ʼ����WebDriver���������Common��ͬһ����ֻ�ɵ���һ��
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
	
	/** 
	* @Title: tearDown 
	* @Description: �ر����������
	* @return void
	* @throws 
	*/
	protected void tearDown() {
		dr.quit();
	}

}
