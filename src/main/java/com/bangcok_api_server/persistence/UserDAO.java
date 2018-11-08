package com.bangcok_api_server.persistence;

import com.bangcok_api_server.domain.UserVO;

public interface UserDAO {
	public void registUser(UserVO vo);
	public UserVO getUser(String userid);
}
