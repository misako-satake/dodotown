package com.example.demo.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.domain.User;
import com.example.demo.form.LoginForm;
import com.example.demo.service.UserLoginService;

/**
 * 
 * @author satakemisako
 * ユーザーログイン時のコントローラー
 *
 */
@Controller
@RequestMapping("/user")
public class UserLoginController {

	@Autowired
	private UserLoginService service;
	
	@ModelAttribute
	public LoginForm setUpLoginForm() {
		LoginForm loginForm = new LoginForm();
		return loginForm;//リクエストパラメーターにloginFormが格納された
	}
	
	@Autowired
	private HttpSession session;
	
	@RequestMapping("")
	public String test() {
		return "test/test";
	}
	
	@RequestMapping("/toLogin")
	public String toLogin() {
		return "login/userlogin";
	}
	
	@RequestMapping("/login")
	public String login(LoginForm form,Model model){
		System.out.println("ID:"+ form.getEmailAddress());
		System.out.println("pass:"+form.getPassword());
		User user = service.findByUserIdAndPassword(form.getEmailAddress(), form.getPassword());
		session.setAttribute("emailAddress", form.getEmailAddress());
		session.setAttribute("userId", user.getId());
		
		if(user != null) {
			return "item/toppage";
		}else {
			model.addAttribute("loginErrorMessage", "メールアドレス（ZOZOID）、またはパスワードが不正です");
			return "userlogin";
		}
	}
	
	@RequestMapping("/logout")
	public String logout() {
		session.invalidate();
		return "item/toppage";
	}
	
}
