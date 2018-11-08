package com.bangcok_api_server.service;

import java.io.IOException;
import java.util.List;

import javax.inject.Inject;

import org.json.simple.parser.ParseException;
import org.springframework.stereotype.Service;

import com.bangcok_api_server.Recommend.TourismRecommender;
import com.bangcok_api_server.domain.UserVO;

@Service
public class RecommendTourismServiceImpl implements RecommendTourismService {
	
	@Inject
	TourismRecommender recommender;
	
	@Override
	public List<Object> recommend() throws IOException, ParseException {
		return recommender.recommend();
	}

	@Override
	public List<Object> recommend(UserVO vo, String mapx, String mapy) throws IOException, ParseException {
		return recommender.recommend(vo, mapx, mapy);
	}
}
