package com.staroot.mybatis.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.staroot.mybatis.domain.User;



@Controller
@RequestMapping("/user")
public class UserController {
	
	List<User> users = new ArrayList<User>();

	@Autowired
	//private UserRepository userRepository;

	/*
	@GetMapping("/login")
	public String login(HttpServletRequest request,Model model) {
		return "/user/login";
	}
	*/

	/*
	@PostMapping("/login")
	public String login(String userId, String password, HttpSession session, HttpServletRequest request) {
		System.out.println("request.getParameter(userId) ::"+request.getParameter("userId"));
		System.out.println("request.getParameter(password) ::"+request.getParameter("password"));
		System.out.println("request.getAttribute(userId) ::"+request.getAttribute("userId"));
		System.out.println("request.getAttribute(password) ::"+request.getAttribute("password"));
		System.out.println("Login Success!");
		User user = new User();
		user.setUserId("1");
		user.setName("hiwatt");
		session.removeAttribute(HttpSessionUtil.LOGIN_FAILED_CNT_KEY);
		session.setAttribute(HttpSessionUtil.USER_SESSION_KEY, user);

		return "redirect:/";
	}
	*/

	/*
	@GetMapping("/logout")
	public String logout(HttpServletRequest request,HttpSession session) {
		session.removeAttribute(HttpSessionUtil.USER_SESSION_KEY);
		session.removeAttribute(HttpSessionUtil.LOGIN_FAILED_CNT_KEY);
		return "redirect:/user/login";
	}
	*/

	@GetMapping("/register")
	public String registerForm() {
		return "/user/register3";
	}

	@PostMapping("/register")
	public String register(User user, Model model, HttpSession session) {
		System.out.println(user.toString());
		return "redirect:/user/member";

	}
}
