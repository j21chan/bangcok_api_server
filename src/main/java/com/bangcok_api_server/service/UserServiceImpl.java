package com.bangcok_api_server.service;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.bangcok_api_server.domain.UserVO;
import com.bangcok_api_server.persistence.UserDAO;

@Service
public class UserServiceImpl implements UserService {
	
	@Inject
	UserDAO dao;
	
	@Override
	public void regist(UserVO vo) throws Exception {
		dao.registUser(vo);
	}

	@Override
	public UserVO get(String userid) throws Exception {
		return dao.getUser(userid);
	}
}
