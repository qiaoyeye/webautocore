package com.core.dao;

import com.core.base.BaseLocator;

/** 
 * @author QiaoJiafei 
 * @version ����ʱ�䣺2015��12��23�� ����2:01:20 
 * ��˵�� 
 */
public class LoginLocator implements BaseLocator{

	private String username;
	private String password;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
}
