package com.staroot.mybatis.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

@RunWith(SpringRunner.class)
@WebMvcTest(ApiUserController.class)
public class ApiUserControllerWebMvcTest {

	@Autowired
    private MockMvc mvc;
 
    
	@Test
	public void testApiUsers1() throws Exception {
	mvc.perform(get("/api/users/1")
		      .contentType(MediaType.APPLICATION_JSON))
		      .andExpect(status().isOk());
		      //.andExpect(jsonPath("$", hasSize(1)))
		      //.andExpect(jsonPath("$[0].name", is(alex.getName())));
	}
}