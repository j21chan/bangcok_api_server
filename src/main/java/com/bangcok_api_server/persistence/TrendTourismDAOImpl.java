package com.bangcok_api_server.persistence;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.bangcok_api_server.domain.TrendTourismVO;

@Repository
public class TrendTourismDAOImpl implements TrendTourismDAO {
	
	@Inject
	SqlSession sqlSession;
	
	private static final String namespace = "com.bangcok_api_server.mappers.trendTourismMapper";
	
	@Override
	public List<TrendTourismVO> listTrendTourism() {
		return sqlSession.selectList(namespace + ".listTrendTourism");
	}
}
