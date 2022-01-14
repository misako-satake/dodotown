package com.example.demo.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.domain.User;
import com.example.demo.form.RegistUserForm;
import com.example.demo.service.UserLoginService;

/**
 * 
 * @author satakemisako
 *ユーザー固有情報表示のためのコントローラークラス
 */
@Controller
@RequestMapping("/userinfo")
public class UserInfoController {

	@Autowired
	private UserLoginService service;
	
	
	//お知らせに飛ぶ
	@RequestMapping("/info")
	public String info() {
		return "user/informationforuser";
	}
	
	//お気に入りに飛ぶ
	@RequestMapping("/fav")
	public String fav() {
		return "user/favorites";
	}
	
	
	//ユーザー登録画面に飛ぶ
	@RequestMapping("/toRegister")
	public String toRegister() {
		return "user/registeruser";
	}
	
	
	//ユーザー新規登録
	@RequestMapping("/registeruser")
	public String registeruser(RegistUserForm form,Integer selectYear,Integer selectMonth, Integer selectDate) {
		System.out.println(form);
		System.out.println(selectYear + "年"+selectMonth+"月" + selectDate+"日");
		Date birthday = null;
		try {
			String sbirthday = Integer.toString(selectYear) + "-" + Integer.toString(selectMonth) + "-" + Integer.toString(selectDate);
			SimpleDateFormat sdFormat = new SimpleDateFormat("yyyy-MM-dd");
			birthday = sdFormat.parse(sbirthday);
			
		}catch(ParseException e) {
			e.printStackTrace();
		}
		form.setBirthday(birthday);
		form.setUserId(form.getEmailAddress());
		
		User user = new User();
		BeanUtils.copyProperties(form,user);
		service.insertUser(user);
		return "login/userlogin";
	}
	
	
	
}
