package com.bangcok_api_server.myapp;

import java.util.Map;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestBody;
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
	public String regist(@RequestBody Map<String, Object> user) throws Exception {
		logger.info("regist user....");
		UserVO vo = new UserVO();
		vo.setUserid(user.get("userid").toString());
		vo.setAge(Integer.parseInt(user.get("age").toString()));
		vo.setCountry(user.get("country").toString());
		vo.setGender(user.get("gender").toString());
		vo.setVisitCount(Integer.parseInt(user.get("visitCount").toString()));
		
		service.regist(vo);
		return "regist";
	}
	
}
