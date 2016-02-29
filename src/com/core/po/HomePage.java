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
 * @version ����ʱ�䣺2016��2��26�� ����2:36:30 
 * ��˵�� 
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
		if(!dr.getTitle().equals("��ҳ - ֪��")) {
			throw new IllegalStateException("This is not Home Page of logged in user, current page" +
                    "is: " +dr.getTitle());
		}
	}

	@Override
	public PageAction validation() {
		// TODO Auto-generated method stub
		String textString = cm.findElement(lc_account).getText();
		Assert.assertEquals(textString, "��ҶҶ");

		return new HomePage(dr);
	}

	@Override
	public void action(int sheet, int CaseNum) {
		// TODO Auto-generated method stub
		lc_account = locatorMap.get(homedao.textaccount);
		
		validation();
	}
	
	/*
	 * ����������ͷ��
	 * */
	public void fun1() {
		//���ظ���ͷ��ҳ��
	}
	
	
	/*
	 * ��������ҳ��ĳ������
	 * */
	public void fun2() {
		//����ĳ������ҳ��
	}
	
	/*
	 * ���������ҳ�ġ���(��Ҫ�ǵ����ҳ�淢������ת��
	 * */
}
