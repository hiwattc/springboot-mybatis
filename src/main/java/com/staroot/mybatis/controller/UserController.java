package com.staroot.mybatis.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.staroot.mybatis.domain.Hotel;
import com.staroot.mybatis.mapper.HotelMapper;

@Controller
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	HotelMapper hotelMapper;

	@GetMapping("/test")
	public String login(HttpServletRequest request,Model model) {
	    Hotel hotel = new Hotel();
	    hotel = hotelMapper.selectByCityId(1);
	    System.out.println("hotel:"+hotel.getName());
	    
	    return "";
	}

}
