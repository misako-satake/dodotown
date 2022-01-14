package com.example.demo.form;

import java.util.Date;

/**
 * 
 * @author satakemisako
 * ユーザー新規登録用フォーム
 *
 */
public class RegistUserForm {

	private String userId;
	private Integer gender;
	private Date birthday;
	private Integer zipcode;
	private String address;
	private String emailAddress;
	private String password;
	
	
	
	@Override
	public String toString() {
		return "RegistUserForm [userId=" + userId + ", gender=" + gender + ", birthday=" + birthday + ", zipcode="
				+ zipcode + ", address=" + address + ", emailAddress=" + emailAddress + ", password=" + password + "]";
	}
	
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public Integer getGender() {
		return gender;
	}
	public void setGender(Integer gender) {
		this.gender = gender;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public Integer getZipcode() {
		return zipcode;
	}
	public void setZipcode(Integer zipcode) {
		this.zipcode = zipcode;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
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
