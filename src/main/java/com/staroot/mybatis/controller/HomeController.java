package com.staroot.mybatis.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
	@GetMapping("/")
	public String index(Model model) {
		List<HashMap> resultList = new ArrayList<HashMap>(); 
		HashMap map = new HashMap();
		map.put("name", "hiwatt");
	    resultList.add(map);
		model.addAttribute("resultList", resultList);
		
		return "/index";
	}
}
