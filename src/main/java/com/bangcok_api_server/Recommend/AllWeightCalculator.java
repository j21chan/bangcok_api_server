package com.bangcok_api_server.recommend;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.json.simple.parser.ParseException;

import com.bangcok_api_server.domain.UserVO;
import com.bangcok_api_server.statics.StaticsCalculator;
import com.bangcok_api_server.tourism.Content;
import com.bangcok_api_server.user_profile.RecommendUserInfo;
import com.bangcok_api_server.walk.RecommendWalk;
import com.bangcok_api_server.weather.WeatherWeightCalculator;

public class AllWeightCalculator {
	
	public List<Content> calculate(UserVO vo, String mapx, String mapy) throws IOException, ParseException {
		
		double mapx_d = Double.parseDouble(mapx);
		double mapy_d = Double.parseDouble(mapy);
		System.out.println(mapx_d + " / " + mapy_d);
		
		// 유저 하드코딩
		String user_country = vo.getCountry();
		String user_gender = vo.getGender();
		int user_age = vo.getAge();
		int user_count = vo.getVisitCount();
		
		// 분석 하드코딩
		int user_country1 = 1;
		int user_gender1 = 1;
		int user_age1 = 20;
		int user_count1 = 1;
		
		// 피로도 하드코딩
		int walk_count = 6000;
		
		// 각 요소별로 관광 타입의 가중치를 받는다.
		Map<String, Integer> walkWeight = new RecommendWalk().calculateWeight(walk_count);
		Map<String, Integer> userInfoWeight = new RecommendUserInfo().calculateWeight(user_country, user_gender, user_age, user_count);
		Map<String, Integer> weatherWeight = new WeatherWeightCalculator().calculateWeight(mapx_d, mapy_d);
		Map<String, Integer> staticsWeight = new StaticsCalculator().calculateWeight(user_country1, user_gender1, user_age1, user_count1);
		
		// 최종 컨텐츠 가중치 리스트
		List<Content> totalWeightList = new ArrayList<Content>();
		Content[] contentList = new Content[6];
		
		// 각 가중치 계산
		contentList[0] = new Content("tour", walkWeight.get("tour") + userInfoWeight.get("tour") + weatherWeight.get("tour") + staticsWeight.get("tour"));
		contentList[1] = new Content("food", walkWeight.get("food") + userInfoWeight.get("food") + weatherWeight.get("food") + staticsWeight.get("food"));
		contentList[2] = new Content("shopping", walkWeight.get("shopping") + userInfoWeight.get("shopping") + weatherWeight.get("shopping") + staticsWeight.get("shopping"));
		contentList[3] = new Content("reports", walkWeight.get("reports") + userInfoWeight.get("reports") + weatherWeight.get("reports") + staticsWeight.get("reports"));
		contentList[4] = new Content("culture", walkWeight.get("culture") + userInfoWeight.get("culture") + weatherWeight.get("culture") + staticsWeight.get("culture"));
		contentList[5] = new Content("festival", walkWeight.get("festival") + userInfoWeight.get("festival") + weatherWeight.get("festival") + staticsWeight.get("festival"));
		
		// 최종 컨텐츠 가중치 리스트에 넣기
		for(int i = 0; i < contentList.length; i++) {
			totalWeightList.add(contentList[i]);
		}
		
		Collections.sort(totalWeightList);
		System.out.println(totalWeightList);
		return totalWeightList;
	}
	
	public List<Content> calculate() throws IOException, ParseException {
		
		// 날씨 하드코딩
		double mapx = 36.2944985;
		double mapy = 127.3329295;
		
		// 유저 하드코딩
		String user_country = "japan";
		String user_gender = "남성";
		int user_age = 20;
		int user_count = 1;
		
		// 분석 하드코딩
		int user_country1 = 1;
		int user_gender1 = 1;
		int user_age1 = 20;
		int user_count1 = 1;
		
		// 피로도 하드코딩
		int walk_count = 6000;
		
		// 각 요소별로 관광 타입의 가중치를 받는다.
		Map<String, Integer> walkWeight = new RecommendWalk().calculateWeight(walk_count);
		Map<String, Integer> userInfoWeight = new RecommendUserInfo().calculateWeight(user_country, user_gender, user_age, user_count);
		Map<String, Integer> weatherWeight = new WeatherWeightCalculator().calculateWeight(mapx, mapy);
		Map<String, Integer> staticsWeight = new StaticsCalculator().calculateWeight(user_country1, user_gender1, user_age1, user_count1);
		
		// 최종 컨텐츠 가중치 리스트
		List<Content> totalWeightList = new ArrayList<Content>();
		Content[] contentList = new Content[6];
		
		// 각 가중치 계산
		contentList[0] = new Content("tour", walkWeight.get("tour") + userInfoWeight.get("tour") + weatherWeight.get("tour") + staticsWeight.get("tour"));
		contentList[1] = new Content("food", walkWeight.get("food") + userInfoWeight.get("food") + weatherWeight.get("food") + staticsWeight.get("food"));
		contentList[2] = new Content("shopping", walkWeight.get("shopping") + userInfoWeight.get("shopping") + weatherWeight.get("shopping") + staticsWeight.get("shopping"));
		contentList[3] = new Content("reports", walkWeight.get("reports") + userInfoWeight.get("reports") + weatherWeight.get("reports") + staticsWeight.get("reports"));
		contentList[4] = new Content("culture", walkWeight.get("culture") + userInfoWeight.get("culture") + weatherWeight.get("culture") + staticsWeight.get("culture"));
		contentList[5] = new Content("festival", walkWeight.get("festival") + userInfoWeight.get("festival") + weatherWeight.get("festival") + staticsWeight.get("festival"));
		
		// 최종 컨텐츠 가중치 리스트에 넣기
		for(int i = 0; i < contentList.length; i++) {
			totalWeightList.add(contentList[i]);
		}
		
		Collections.sort(totalWeightList);
		System.out.println(totalWeightList);
		return totalWeightList;
	}
}
