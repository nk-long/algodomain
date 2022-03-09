package com.admin.admin_service;

import java.io.File;

import com.admin.admin_service.controller.AdminController;

import org.apache.commons.io.FileUtils;
import org.junit.Assert;
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
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringRunner.class)
@ComponentScan(basePackages = "com.admin.admin_service")
@ContextConfiguration(classes = AdminServiceApplication.class)
@WebMvcTest(AdminController.class)
class AdminServiceApplicationTests {


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

		String data = null;
		data = FileUtils.readFileToString(new File("src/test/java/com/admin/admin_service/resources/api-req/addproduct.json")); 

		boolean res = true;

		MvcResult result = mockmvc.perform(MockMvcRequestBuilders.post("/setdata")
					.header("Content-Type", MediaType.APPLICATION_JSON_VALUE)
					.content(data)
				).andReturn();
		Assert.assertEquals(res, result);


		
	}

}
