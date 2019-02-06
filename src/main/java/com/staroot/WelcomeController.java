package com.staroot;

import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class WelcomeController {

	// inject via application.properties
	@Value("${app.properties.message}")
	private String MESSAGE = "";

	@Value("${app.properties.title}")
	private String TITLE = "";

	@RequestMapping("/hometest")
	public String welcome(Map<String, Object> model) {
		System.out.println("WebcomeController Called!~");
		model.put("title", TITLE);
		model.put("message", MESSAGE);
		return "welcome";
	}
}