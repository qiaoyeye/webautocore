package com.core.dao;


/** 
 * @author QiaoJiafei 
 * @version ����ʱ�䣺2015��12��23�� ����2:01:20 
 * ��˵�� 
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
