package com.bangcok_api_server.persistence;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

@Repository
public class LogDAOImpl implements LogDAO {
	
	@Inject
	SqlSession sqlSession;
	
	private static final String namespace = "com.bangcok_api_server.mappers.logMapper";
	
	@Override
	public void insertTourismLog(List<Object> log) {
		sqlSession.insert(namespace + ".insertLog", log);
	}
}
