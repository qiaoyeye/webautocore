package com.core.dao;

import com.core.base.BaseLocator;

/** 
 * @author QiaoJiafei 
 * @version ����ʱ�䣺2015��12��23�� ����2:01:20 
 * ��˵�� 
 */
public class LoginLocator implements BaseLocator{
	public Locator getLc_name() {
		return lc_name;
	}
	public void setLc_name(Locator lc_name) {
		this.lc_name = lc_name;
	}
	public Locator getLc_pwd() {
		return lc_pwd;
	}
	public void setLc_pwd(Locator lc_pwd) {
		this.lc_pwd = lc_pwd;
	}
	private Locator lc_name;
	private Locator lc_pwd;
}
