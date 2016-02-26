package com.core.dao;


/** 
 * @author QiaoJiafei 
 * @version 创建时间：2015年12月23日 下午2:01:20 
 * 类说明 
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
