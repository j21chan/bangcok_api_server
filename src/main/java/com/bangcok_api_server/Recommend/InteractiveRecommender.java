package com.bangcok_api_server.Recommend;

import java.io.IOException;
import java.util.ArrayList;

import com.bangcok_api_server.parser.InteractiveTourJsonParser;
import com.bangcok_api_server.url.UrlBuilder;
import com.bangcok_api_server.url.UrlRequest;

public class InteractiveRecommender {
	public ArrayList<Object> recommend(String contentTypeId, String mapX, String mapY) throws IOException {
		
		// 1. URL 빌드
		String locationUrl = new UrlBuilder().locationBasedListURLBuild("10", "1", "B", contentTypeId, mapX, mapY, "2500");
		
		// 2. URL 요청
		String jsonString = new UrlRequest().urlRequest(locationUrl);
		
		// 3. JSON 파싱
		ArrayList<Object> locBaseList = new InteractiveTourJsonParser().parse(jsonString);
		
		// 4. 리스트 반환
		return locBaseList;
	}
}
