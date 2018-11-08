package com.bangcok_api_server.myapp;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.bangcok_api_server.domain.UserVO;
import com.bangcok_api_server.service.UserService;

@RestController
@RequestMapping(value="/user/*")
public class UserController {
	
	private static final Logger logger = LoggerFactory.getLogger(UserController.class);
	
	@Inject
	UserService service;
	
	@RequestMapping(value="/regist", method=RequestMethod.POST)
	public String regist(HttpServletRequest request) throws Exception {
		UserVO vo = new UserVO(request.getParameter("userid"),
							   request.getParameter("country"),
							   Integer.parseInt(request.getParameter("age")),
							   request.getParameter("gender"),
							   Integer.parseInt(request.getParameter("visitCount")));
		
		logger.info("regist user....");
		service.regist(vo);
		return "regist";
	}
}
