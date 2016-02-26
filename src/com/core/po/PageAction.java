package com.core.po;

import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.core.base.BasePage;
import com.core.base.MidConvert;
import com.core.dao.Locator;
import com.core.util.Common;
import com.core.util.Log;
import com.core.util.OptionFile;

/** 
 * @author QiaoJiafei 
 * @version ����ʱ�䣺2016��2��26�� ����6:13:32 
 * ��˵�� 
 */
public class PageAction {
	protected WebDriver dr; 
	Map<String, Locator> locatorMap;
	protected Log log = new Log(this.getClass());
	protected Common cm = new Common();
	
	public PageAction() {
		// TODO Auto-generated constructor stub
	}
	
	public PageAction(WebDriver dr) {
		this.dr = dr;
		cm.setDriver(this.dr);
		locatorMap = OptionFile.getXMLMap(BasePage.XMLPATH,
                this.getClass().getCanonicalName());
		log.debug("XML��ȡ����page name��"+this.getClass().getCanonicalName());
	}

}
