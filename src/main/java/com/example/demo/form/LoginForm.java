package com.example.demo.form;
/**
 * 
 * @author satakemisako
 *
 *ユーザーログイン時の入力フォーム
 */
public class LoginForm {
	private String emailAddress;
	private String password;
	
	

	@Override
	public String toString() {
		return "LoginForm [emailAddress=" + emailAddress + ", password=" + password + "]";
	}
	

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
