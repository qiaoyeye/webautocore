package com.core.dao;

import com.core.base.BaseLocator;

/** 
 * @author QiaoJiafei 
 * @version 创建时间：2015年12月23日 下午2:01:20 
 * 类说明 
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
