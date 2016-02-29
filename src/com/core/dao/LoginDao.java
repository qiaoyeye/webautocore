package com.core.dao;

/** 
* 封装登录页面的测试数据类
* @ClassName: LoginDao (登录页面的封装测试数据的类) 
* @author qiaojiafei 
* @date 2016年2月29日 上午11:32:00 
*  
*/
public class LoginDao {

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
	
	public final String textusername = "username";
	public final String textpassword = "password";
	public final String textsubmit = "but_submit";
}
