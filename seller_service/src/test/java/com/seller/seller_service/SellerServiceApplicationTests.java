package com.seller.seller_service;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.seller.seller_service.controller.Sellercontroller;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringRunner.class)
@ComponentScan(basePackages = "com.seller.seller_service")
@ContextConfiguration(classes = SellerServiceApplication.class)
@WebMvcTest(Sellercontroller.class)
class SellerServiceApplicationTests {


	@Autowired
	private MockMvc mockmvc;

	@Autowired
	private WebApplicationContext wac;

	@Before
	public void setUp()
	{
		this.mockmvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
	}


	@Test
	void contextLoads() throws Exception {
		MvcResult result = mockmvc.perform(
			get("/seller/getbyseller/1234").contentType(MediaType.APPLICATION_JSON_VALUE)
			).andExpect(status().isOk()).andReturn();
	
			System.out.println(result);
	}

}
