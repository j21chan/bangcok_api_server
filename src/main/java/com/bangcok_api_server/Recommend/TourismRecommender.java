package com.bangcok_api_server.Recommend;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.json.simple.parser.ParseException;
import org.springframework.stereotype.Repository;

import com.bangcok_api_server.domain.UserVO;
import com.bangcok_api_server.parser.LocationBasedListJsonParser;
import com.bangcok_api_server.tourapi.TourAPI;
import com.bangcok_api_server.tourism.Content;

@Repository
public class TourismRecommender {
	
	public List<Object> recommend(UserVO vo, String mapx, String mapy) throws IOException, ParseException{
		
		// 추천 관광지 리스트
		List<Object> resultList = new ArrayList<Object>();

		// 전체 가중치 리스트
		List<Content> allWeightList = new AllWeightCalculator().calculate(vo, mapx, mapy);
		
		// 위치 기반 관광지 JSON 파서
		LocationBasedListJsonParser parser = new LocationBasedListJsonParser();
		
		// 사용자 현재 위치 하드코딩
//		String mapx = "126.981106";
//		String mapy = "37.568477";
		
		for(Content tempContent : allWeightList) {
			ArrayList<Object> tempList = new ArrayList<Object>();
			String jsonString = null;
			String tourContentType = tempContent.getContentName();
			
			if(tourContentType.equals("tour")) {
				jsonString = new TourAPI().getLocationBasedList("30", "1", "B", "12", mapx, mapy, "2000");
				tempList = parser.parse(jsonString);
			}
			else if(tourContentType.equals("culture")) {
				jsonString = new TourAPI().getLocationBasedList("30", "1", "B", "14", mapx, mapy, "2000");
				tempList = parser.parse(jsonString);
			}
			else if(tourContentType.equals("festival")) {
				jsonString = new TourAPI().getLocationBasedList("30", "1", "B", "15", mapx, mapy, "2000");
				tempList = parser.parse(jsonString);
			}
			else if(tourContentType.equals("reports")) {
				jsonString = new TourAPI().getLocationBasedList("30", "1", "B", "28", mapx, mapy, "2000");
				tempList = parser.parse(jsonString);
			}
			else if(tourContentType.equals("shopping")) {
				jsonString = new TourAPI().getLocationBasedList("30", "1", "B", "38", mapx, mapy, "2000");
				tempList = parser.parse(jsonString);
			}
			else if(tourContentType.equals("food")) {
				jsonString = new TourAPI().getLocationBasedList("30", "1", "B", "39", mapx, mapy, "2000");
				tempList = parser.parse(jsonString);
			}
			
			if(tempList != null) {
				for(Object tempLocation : tempList) {
					resultList.add((Object) tempLocation);
				}
			}
		}
		
		System.out.println(resultList);
		return resultList;
	}
	
	public List<Object> recommend() throws IOException, ParseException{
		
		// 추천 관광지 리스트
		List<Object> resultList = new ArrayList<Object>();

		// 전체 가중치 리스트
		List<Content> allWeightList = new AllWeightCalculator().calculate();
		
		// 위치 기반 관광지 JSON 파서
		LocationBasedListJsonParser parser = new LocationBasedListJsonParser();
		
		// 사용자 현재 위치 하드코딩
		String mapx = "126.981106";
		String mapy = "37.568477";
		
		for(Content tempContent : allWeightList) {
			ArrayList<Object> tempList = new ArrayList<Object>();
			String jsonString = null;
			String tourContentType = tempContent.getContentName();
			
			if(tourContentType.equals("tour")) {
				jsonString = new TourAPI().getLocationBasedList("30", "1", "B", "12", mapx, mapy, "2000");
				tempList = parser.parse(jsonString);
			}
			else if(tourContentType.equals("culture")) {
				jsonString = new TourAPI().getLocationBasedList("30", "1", "B", "14", mapx, mapy, "2000");
				tempList = parser.parse(jsonString);
			}
			else if(tourContentType.equals("festival")) {
				jsonString = new TourAPI().getLocationBasedList("30", "1", "B", "15", mapx, mapy, "2000");
				tempList = parser.parse(jsonString);
			}
			else if(tourContentType.equals("reports")) {
				jsonString = new TourAPI().getLocationBasedList("30", "1", "B", "28", mapx, mapy, "2000");
				tempList = parser.parse(jsonString);
			}
			else if(tourContentType.equals("shopping")) {
				jsonString = new TourAPI().getLocationBasedList("30", "1", "B", "38", mapx, mapy, "2000");
				tempList = parser.parse(jsonString);
			}
			else if(tourContentType.equals("food")) {
				jsonString = new TourAPI().getLocationBasedList("30", "1", "B", "39", mapx, mapy, "2000");
				tempList = parser.parse(jsonString);
			}
			
			if(tempList != null) {
				for(Object tempLocation : tempList) {
					resultList.add((Object) tempLocation);
				}
			}
		}
		
		System.out.println(resultList);
		return resultList;
	}
}
