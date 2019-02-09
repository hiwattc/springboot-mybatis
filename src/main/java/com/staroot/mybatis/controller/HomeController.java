package com.staroot.mybatis.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	// inject via application.properties
	@Value("${app.properties.message}")
	private String MESSAGE = "";

	@Value("${app.properties.title}")
	private String TITLE = "";

	//@GetMapping("/")
	
	@RequestMapping("/home")
	public String index(Model model) {
		List<HashMap> resultList = new ArrayList<HashMap>(); 
		HashMap map = new HashMap();
		map.put("name", "hiwatt");
	    resultList.add(map);
		model.addAttribute("resultList", resultList);
		logger.debug("=====================HomeController is called=====================");
		
		return "/index";
	}
	
	@RequestMapping("/")
	public String welcome(Map<String, Object> model) {
		model.put("title", TITLE);
		model.put("message", MESSAGE);
		logger.debug("=====================HomeController is called=====================");
		return "index";
	}	
	
	// test 5xx errors
	@RequestMapping("/5xx")
	public String ServiceUnavailable() {
		throw new RuntimeException("5xx");
	}	
	// test 4xx errors
	@RequestMapping("/404")
	public String ServiceUnavailable2() {
		throw new RuntimeException("4xx");
	}
	
	/*
	@RequestMapping("/error")
	public String Error() {
		throw new RuntimeException("Error");
	}*/	
}
