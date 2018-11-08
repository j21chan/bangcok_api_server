package com.bangcok_api_server.service;

import com.bangcok_api_server.domain.UserVO;

public interface UserService {
	public void regist(UserVO vo) throws Exception;
	public UserVO get(String userid) throws Exception;
}
