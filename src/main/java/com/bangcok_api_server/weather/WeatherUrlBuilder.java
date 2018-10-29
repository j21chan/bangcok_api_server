package com.bangcok_api_server.weather;

import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Map;

public class WeatherUrlBuilder {
	// 기상청에서 제공하는 ServiceKey
	private final static String serviceKey = "lXD74EVz%2B%2BsN6Umj%2FTEiUwe6SrhDlt6EJDw3EiP%2FaQ37jdWZzn2jcv0uMBf90xaYQU2taH9P2nEyEAiiS5mQrw%3D%3D";
	
	// 기상청에서 반환하는 객체 타입 정하기
	private final static String type = "json";
	
	// 위치기반 (lon, lat)으로 동네 최저, 최고 기온을 구하는 URL
	public String buildLocationTempUrl (Map<String, Object> gridInfo) throws UnsupportedEncodingException {		
		
		// 날짜 가져오는 메소드
		String baseDate = getBaseDate();
		
		// 시간 가져오는 메소드 : base time - 1
		String baseTime = getBaseTime();
		
		// URL 생성
		String url = "http://newsky2.kma.go.kr/service/SecndSrtpdFrcstInfoService2/ForecastSpaceData" + "?ServiceKey=" + serviceKey +
																										"&base_date=" + baseDate + 
																									   	"&base_time=" + baseTime +
																									   	"&nx=" + gridInfo.get("x") +
																									   	"&ny=" + gridInfo.get("y") +
																									   	"&_type=" + type;
		System.out.println(url);
		return url;
	}
	
	private String getBaseDate() {
		Date now = new Date();
		
		SimpleDateFormat dateForm = new SimpleDateFormat("yyyyMMdd");
		String baseDate = dateForm.format(now);

		return baseDate;	
	}
	
	private String getBaseTime() {
		Calendar now = Calendar.getInstance();
		String baseTime = "";
		int amPm = now.get(Calendar.AM_PM);
		int hour = 0;
		
		Date datenow = new Date();
		SimpleDateFormat dateForm = new SimpleDateFormat("HHmm");
		String dateString = dateForm.format(datenow);
		int dateInt = Integer.parseInt(dateString);
		
		// 오후일 때 12시간을 곱해줌
		if(amPm != 0) {
			hour = now.get(Calendar.HOUR_OF_DAY) + 12;
		}
		else {
			hour = now.get(Calendar.HOUR_OF_DAY);
		}
		
		// 동네 예보 시간에 맞게 시간 설정
		if(dateInt > 2310) {
			baseTime = "2300";
		}
		else if(dateInt > 2010) {
			baseTime = "2000";
		}
		else if(dateInt > 1710) {
			baseTime = "1700";
		}
		else if(dateInt > 1410) {
			baseTime = "1400";
		}
		else if(dateInt > 1110) {
			baseTime = "1100";
		}
		else if(dateInt > 810) {
			baseTime = "0800";
		}
		else if(dateInt > 510) {
			baseTime = "0500";
		}
		else if(dateInt > 210) {
			baseTime = "0200";
		}
		else {
			baseTime = "0200";
		}
		
		return baseTime;	
	}
}
