package com.staroot.mybatis.controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.staroot.mybatis.domain.City;
import com.staroot.mybatis.domain.Hotel;
import com.staroot.mybatis.domain.Message;
import com.staroot.mybatis.domain.MessageRepository;
import com.staroot.mybatis.mapper.CityMapper;
import com.staroot.mybatis.mapper.HotelMapper;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

@Controller
@RequestMapping("/test")
public class TestController {
	
	// inject via application.properties
	@Value("${app.properties.message}")
	private String MESSAGE = "";

	@Value("${app.properties.title}")
	private String TITLE = "";
		
	@Autowired
	HotelMapper hotelMapper;
	@Autowired
	CityMapper cityMapper;

	@Autowired
	private MessageRepository messageRepository;

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@GetMapping("/test1")
	public String getTest1(HttpServletRequest request,Model model) {
		logger.debug("11111111111111111TestController is called :: called function : getTest1");
		logger.debug("11111111111111111TestController Properties Reading TEST [MESSAGE] :"+MESSAGE);
		logger.debug("11111111111111111TestController Properties Reading TEST [TITLE] :"+TITLE);
	    Hotel hotel = new Hotel();
	    hotel = hotelMapper.selectByCityId(1);
	    System.out.println("hotel:"+hotel.getName());
	    //return "/index";
	    return "index";
	}
	@GetMapping("/test2")
	public String getTest2(HttpServletRequest request,Model model) {
		logger.debug("11111111111111111111111TestController is called :: called function : getTest2");
	    City city = new City();
	    city = cityMapper.selectCityById(1);
	    System.out.println("city:"+city.getName());
	    System.out.println("city:"+city.getCountry());
	    return "/index";
	}
	@GetMapping("/test3")
	public String getTest3(HttpServletRequest request,Model model) {
		logger.debug("33333333333333333TestController is called :: called function : getTest1");
		logger.debug("33333333333333333TestController Properties Reading TEST [MESSAGE] :"+MESSAGE);
		logger.debug("33333333333333333TestController Properties Reading TEST [TITLE] :"+TITLE);
	    Hotel hotel = new Hotel();
	    hotel = hotelMapper.selectByCityId(1);
	    return "index";
	}
	@GetMapping("/test4")
	public String getTest4(HttpServletRequest request,Model model) {
		logger.debug("ffffff :: called function : getTest4");
		return "index";

	}
	
	
	@ApiOperation(value ="메시지조회하기(alert)-api custom test 18.12.15")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "title", value = "제목", required = true, dataType = "string", paramType = "query", defaultValue = ""),
            @ApiImplicitParam(name = "content", value = "내용", required = true, dataType = "string", paramType = "query", defaultValue = ""),
    })
	@GetMapping("/alert")
	public String msgList(Model model) {
		List<Message> msgList = new ArrayList<Message>();

		// msgList = messageRepository.getMsgLists();
		// msgList = messageRepository.findAll(); //(arg0, arg1);
		// msgList = messageRepository.findAll();//잘됨
		// msgList = messageRepository.findAllByOrderByIdDesc();//잘됨
		// msgList = messageRepository.findTop2ByOrderByIdDesc();//잘됨
		// msgList = messageRepository.findAll(Pageable a)
		Page<Message> messages = messageRepository.findAll(new PageRequest(0, 5)); // int
																					// page,
																					// int
																					// size

		System.out.println("messages.getSize():" + messages.getSize());
		System.out.println("messages.getTotalElements():" + messages.getTotalElements());
		System.out.println("messages.getTotalPages():" + messages.getTotalPages());
		System.out.println("messages.getSize():" + messages.getSize());
		System.out.println("messages.getNumber():" + messages.getNumber());
		System.out.println("messages.getNumberOfElements():" + messages.getNumberOfElements());
		msgList = messages.getContent();
		System.out.println("msgList.size():" + msgList.size());
		System.out.println("msgList.toString():" + msgList.toString());

		for (Iterator iterator = msgList.iterator(); iterator.hasNext();) {
			Message message = (Message) iterator.next();
			System.out.println("message :::" + message.getMsgTitle());

		}

		model.addAttribute("msgList", msgList);
		return "/user/alert";

	}
	

}
