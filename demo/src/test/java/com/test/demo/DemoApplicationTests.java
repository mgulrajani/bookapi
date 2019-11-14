package com.test.demo;


import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.test.controller.HelloResource;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class DemoApplicationTests {
	HelloResource helloresource = new HelloResource();
MockMvc mock = MockMvcBuilders.standaloneSetup(helloresource).build();
	@Test
	public void contextLoads() throws Exception {
		mock.perform(MockMvcRequestBuilders.get("/hello").accept(MediaType.TEXT_PLAIN)).
		andExpect(status().isOk()).andExpect(content().string("hello"));
		
		
		
	}

}
