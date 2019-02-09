package com.staroot.mybatis.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import com.staroot.mybatis.domain.MessageRepository;
import com.staroot.mybatis.mapper.CityMapper;
import com.staroot.mybatis.mapper.HotelMapper;

@RunWith(SpringRunner.class)
//@WebMvcTest(HomeController.class) //RestController는오류남
//@WebMvcTest(UserController.class)
@WebMvcTest(TestController.class)
public class ApiUserControllerWebMvcTest {

	@Autowired
    private MockMvc mvc;
	
	
	//Controller에서 필요한 bean을 MockBean으로 추가필요함!
	@MockBean
	HotelMapper hotelMapper;
	@MockBean
	CityMapper cityMapper;
	@MockBean
	private MessageRepository messageRepository;

	@Test
	public void testApiUsers1() throws Exception {
		//when
	    final ResultActions actions = mvc.perform(get("/test/test3", 1L)
	            .contentType(MediaType.APPLICATION_JSON_UTF8))
	            .andDo(print());	

	    actions.andExpect(status().isOk());
	    
	    mvc.perform(get("/test/test3")
		      //.contentType(MediaType.APPLICATION_JSON))
		      .contentType(MediaType.APPLICATION_JSON_UTF8))
		      .andExpect(status().isOk());
		      //.andExpect(jsonPath("$", hasSize(1)))
		      //.andExpect(jsonPath("$[0].name", is(alex.getName())));
	
	
	}
	
}