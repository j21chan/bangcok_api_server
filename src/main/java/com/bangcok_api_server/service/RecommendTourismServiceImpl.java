package com.bangcok_api_server.service;

import java.io.IOException;
import java.util.List;

import javax.inject.Inject;

import org.json.simple.parser.ParseException;
import org.springframework.stereotype.Service;

import com.bangcok_api_server.domain.TrendTourismVO;
import com.bangcok_api_server.domain.UserVO;
import com.bangcok_api_server.persistence.TrendTourismDAO;
import com.bangcok_api_server.recommend.TourismRecommender;

@Service
public class RecommendTourismServiceImpl implements RecommendTourismService {
	
	@Inject
	TourismRecommender tourismRecommender;
	
	@Override
	public List<Object> recommend() throws IOException, ParseException {
		return tourismRecommender.recommend();
	}

	@Override
	public List<Object> recommend(UserVO vo, String mapx, String mapy) throws Exception {
		return tourismRecommender.recommend(vo, mapx, mapy);
	}
}
