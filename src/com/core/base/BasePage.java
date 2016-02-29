package com.core.base;

import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.core.dao.Locator;
import com.core.po.PageAction;
import com.core.util.Common;
import com.core.util.Log;
import com.core.util.OptionFile;

/** 
* ����ҳ���࣬����po�ڵ�ҳ�涼Ҫ�̳и��࣬�����װ��common���webdriver��ʼ�������ͻ�ȡXML��Ԫ��Ϊpage�µ�����map���磺
*     <page name="com.core.po.LoginPage">
*		<element ByType="name" value="account">username</element>
*    </page>
* map��key=username��value��Locator���󣬰���ByType��value
* @ClassName: BasePage 
* @Description: TODO(����ҳ���࣬����po�ڵ�ҳ�涼Ҫ�̳и��࣬�����װ��common���webdriver��ʼ�������ͻ�ȡXML��Ԫ��Ϊpage�µ�����map) 
* @author qiaojiafei 
* @date 2016��2��29�� ����11:19:10 
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
		log.debug("XML��ȡ����page name��"+this.getClass().getCanonicalName());
	}
	
	public WebDriver getDriver() {
		return dr;
	}

}
