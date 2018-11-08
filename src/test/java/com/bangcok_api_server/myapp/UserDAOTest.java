package com.bangcok_api_server.myapp;

import javax.inject.Inject;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.bangcok_api_server.domain.UserVO;
import com.bangcok_api_server.service.UserService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/**/root-context.xml"})
public class UserDAOTest {
	
//	@Inject
//	private UserDAO dao;
	
	@Inject
	private UserService service;
	
	@Test
	public void testInsertUser() throws Exception{
		
		UserVO vo = new UserVO();
		vo.setUserid("user00");
		vo.setCountry("user_country");
		vo.setAge(10);
		vo.setGender("남성");
		vo.setVisitCount(1);
		
//		dao.registUser(vo);
		service.regist(vo);
	}
	
	@Test
	@Ignore
	public void testGetUser() throws Exception {
//		dao.getUser("user00");
	}
}
