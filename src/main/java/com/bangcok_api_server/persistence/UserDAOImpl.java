package com.bangcok_api_server.persistence;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.bangcok_api_server.domain.UserVO;

@Repository
public class UserDAOImpl implements UserDAO {

	@Inject
	private SqlSession sqlSession;
	
	private static final String namespace = "com.bangcok_api_server.mappers.userMapper";
	
	@Override
	public void registUser(UserVO vo) {
		sqlSession.insert(namespace + ".insertUser", vo);
	}

	@Override
	public UserVO getUser(String userid) {
		return sqlSession.selectOne(namespace + ".getUser", userid);
	}
}
