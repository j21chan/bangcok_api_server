package com.bangcok_api_server.myapp;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

import javax.inject.Inject;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.request.RequestPostProcessor;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/**/*.xml"})
public class SampleControllerTest {
	
	private static final Logger logger = LoggerFactory.getLogger(SampleControllerTest.class);
	
	@Inject
	private WebApplicationContext wac;
	
	private MockMvc mockMvc;
	
	@Before
	public void setup()	{
		this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
		logger.info("setup.....");
	}
	
	@Test
	@Ignore
	public void testRecommendTourism() throws Exception{
		mockMvc.perform(MockMvcRequestBuilders.get("/recommend_tourism"));
	}
	
	@Test
	public void testUserSignIn() throws Exception {
		MockHttpServletRequestBuilder request = post("/user/signin")
				.param("userid", "user11")
				.param("country", "korea")
				.param("age", "11")
				.param("gender", "남자");
		
//		request.with(new RequestPostProcessor() {
//
//			@Override
//			public MockHttpServletRequest postProcessRequest(MockHttpServletRequest request) {
//				request.setAttribute("userid", "user11");
//				request.setAttribute("country", "korea");
//				request.setAttribute("age", "11");
//				request.setAttribute("gender", "남자");
//				return request;
//			}
//		});
	}
}
