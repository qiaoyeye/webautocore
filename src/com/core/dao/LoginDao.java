package com.core.dao;

/** 
* ��װ��¼ҳ��Ĳ���������
* @ClassName: LoginDao (��¼ҳ��ķ�װ�������ݵ���) 
* @author qiaojiafei 
* @date 2016��2��29�� ����11:32:00 
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
