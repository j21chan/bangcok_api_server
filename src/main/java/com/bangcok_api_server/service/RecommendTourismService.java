package com.bangcok_api_server.service;

import java.io.IOException;
import java.util.List;

import org.json.simple.parser.ParseException;

import com.bangcok_api_server.domain.UserVO;

public interface RecommendTourismService {
	public List<Object> recommend() throws IOException, ParseException;
	public List<Object> recommend(UserVO vo, String mapx, String mapy) throws IOException, ParseException;
}
