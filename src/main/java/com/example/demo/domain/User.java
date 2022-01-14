package com.example.demo.domain;
/**
 * @author satakemisako
 * ユーザー情報のドメイン
 * 
 */
import java.util.Date;

import lombok.Data;

@Data
public class User {

	private Integer id;
	private String userId;
	private Integer gender;
	private Date birthday;
	private Integer zipcode;
	private String address;
	private String emailAddress;
	private String password;
	
	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
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

	public Integer getGender() {
		return gender;
	}
	
	public void setGender(Integer gender) {
		this.gender = gender;
	}
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", userId=" + userId + ", gender=" + gender + ", birthday=" + birthday + ", zipcode="
				+ zipcode + ", address=" + address + ", emailAddress=" + emailAddress + ", password=" + password + "]";
	}
	
	
}
