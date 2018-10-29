// 사용자의 데이터에 따른 관광지를 추천하는 모듈

package com.bangcok_api_server.user_profile;

import java.util.HashMap;
import java.util.Map;

public class RecommendUserInfo {
	public Map<String, Integer> calculateWeight(String user_country, String user_gender, int user_age, int user_count) {
//		ArrayList<Content> contentList = new ArrayList<Content>();
		
		Map<String, Integer> contents = new HashMap<String, Integer>();
		
		int[] result = new int[7]; // 국적/성별/나이/방한횟수의 배열들을 더한 값을 저장하는 배열
		
		int[] country = CountryContent.CountryContent(user_country); // 사용자의 국적에 해당되는 관광지 타입별 점수를 가져오는 메소드
		country = WeightCalculate.Calcualate(country); // 관광지 타입별 점수에 가중치를 부여하는 메소드

		int[] gender = GenderContent.GenderContent(user_gender); // 사용자의 성별에 해당되는 관광지 타입별 점수를 가져오는 메소드
		gender = WeightCalculate.Calcualate(gender); // 관광지 타입별 점수에 가중치를 부여하는 메소드
		
		int[] age = AgeContent.AgeContent(user_age); // 사용자의 나이에 해당되는 관광지 타입별 점수를 가져오는 메소드
		age = WeightCalculate.Calcualate(age); // 관광지 타입별 점수에 가중치를 부여하는 메소드

		int[] count = CountContent.CountContent(user_count); // 사용자의 방한횟수에 해당되는 관광지 타입별 점수를 가져오는 메소드
		count = WeightCalculate.Calcualate(count); // 관광지 타입별 점수에 가중치를 부여하는 메소드
		
		// for문을 통해 배열을 합계를 구한다.
		for(int i = 1; i <= 6; i++) {
			result[i] = country[i] + gender[i] + age[i] + count[i];
		}
		
		// 해시테이블에 넣기
		contents.put("tour", result[1]);
		contents.put("food", result[2]);
		contents.put("shopping", result[3]);
		contents.put("culture", result[4]);
		contents.put("festival", result[5]);
		contents.put("reports", result[6]);
		
		// 최종 리턴
        return contents;
	}
}
