package com.bangcok_api_server.weather;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.bangcok_api_server.tourism.Content;
import com.bangcok_api_server.url.UrlRequest;

public class WeatherCalculator {
	
	// GPS 위치 정보
	private double mapx;
	private double mapy;
	
	// 그리드 정보
	private Map<String, Object> gridInfo;
	
	// 현재 날씨 정보
	private double currentTemp;
	private int currentWeather;
	
	// 현재 가중치 정보
	private Map<String, Integer> weatherWeight;
	
	public WeatherCalculator() {
		
	}
	
	// 현재 위치를 API에서 이용하는 위치에 맞게 세팅
	// v1 = lat
	// v2 = lon
    public void setLocationToGrid(double v1, double v2) {
    	this.mapx = v2;
    	this.mapy = v1;
    	
        double RE = 6371.00877; // 지구 반경(km)
        double GRID = 5.0; // 격자 간격(km)
        double SLAT1 = 30.0; // 투영 위도1(degree)
        double SLAT2 = 60.0; // 투영 위도2(degree)
        double OLON = 126.0; // 기준점 경도(degree)
        double OLAT = 38.0; // 기준점 위도(degree)
        double XO = 210/GRID; // 기준점 X좌표(GRID)
        double YO = 675/GRID; // 기1준점 Y좌표(GRID)
        double DEGRAD = Math.PI / 180.0;
        // double RADDEG = 180.0 / Math.PI;
 
        double re = RE / GRID;
        double slat1 = SLAT1 * DEGRAD;
        double slat2 = SLAT2 * DEGRAD;
        double olon = OLON * DEGRAD;
        double olat = OLAT * DEGRAD;
 
        double sn = Math.tan(Math.PI * 0.25 + slat2 * 0.5) / Math.tan(Math.PI * 0.25 + slat1 * 0.5);
        sn = Math.log(Math.cos(slat1) / Math.cos(slat2)) / Math.log(sn);
        double sf = Math.tan(Math.PI * 0.25 + slat1 * 0.5);
        sf = Math.pow(sf, sn) * Math.cos(slat1) / sn;
        double ro = Math.tan(Math.PI * 0.25 + olat * 0.5);
        ro = re * sf / Math.pow(ro, sn);
        Map<String, Object> map = new HashMap<String, Object>();
       
        double ra = Math.tan(Math.PI * 0.25 + (v1) * DEGRAD * 0.5);
        ra = re * sf / Math.pow(ra, sn);
        double theta = v2 * DEGRAD - olon;
        if (theta > Math.PI)
            theta -= 2.0 * Math.PI;
        if (theta < -Math.PI)
            theta += 2.0 * Math.PI;
        theta *= sn;
        
        map.put("lat", v1);
        map.put("lng", v2);
        map.put("x", (int)Math.round(ra * Math.sin(theta) + XO + 0.5));
        map.put("y", (int)Math.round(ro - ra * Math.cos(theta) + YO + 0.5));
        System.out.println(map);
        this.gridInfo = map;
    }
	
	
	// 현재 날씨 계산
	public void calculateAllWeather() throws IOException, ParseException {
		
		// URL 요청
		WeatherUrlBuilder urlBuilder = new WeatherUrlBuilder();
		String requestURL = urlBuilder.buildLocationTempUrl(this.gridInfo);
		String jsonString = new UrlRequest().urlRequest(requestURL);
		
		// JSON 출력
		System.out.println(jsonString);
		
		// 날씨 정보
		double currentTemp = 0;
		int currentWeather = 0;
		
		// JSON 파싱
        JSONParser parser = new JSONParser();
        Object obj = parser.parse(jsonString);
		JSONObject jsonObj = (JSONObject) obj;
        JSONArray jsonItemArray = (JSONArray) ((JSONObject)((JSONObject)((JSONObject) jsonObj.get("response")).get("body")).get("items")).get("item");
        
        // 낮 최고 기온을 찾아서 저장
        for(int i = 0; i < jsonItemArray.size(); i++) {
        	JSONObject tempObj = (JSONObject) jsonItemArray.get(i);
        	
        	// 현재 온도 정보
        	if(tempObj.get("category").equals("T3H")) {
        		currentTemp = Double.parseDouble(tempObj.get("fcstValue").toString());
        	}
        	// 현재 날씨 정보
        	else if(tempObj.get("category").equals("PTY")) {
        		currentWeather = Integer.parseInt(tempObj.get("fcstValue").toString());
        	}
        }
        
        this.currentTemp = currentTemp;
        this.currentWeather = currentWeather;
	}
	
	
	// 현재 온도에 따른 가중치 계산
	private int caculateTempWeight() {
		int weight = 0;
		
		// 체감 더위
		// 매우 위험
		if(this.currentTemp >= 31) {
			System.out.println("영상 : 매우 위험");
			weight = 5;
		}
		// 위험
		else if(this.currentTemp >= 28) {
			System.out.println("영상 : 위험");
			weight = 4;
		}
		// 경고
		else if(this.currentTemp >= 25) {
			System.out.println("영상 : 경고");
			weight = 3;
		}
		// 주의
		else if(this.currentTemp >= 21) {
			System.out.println("영상 : 주의");
			weight = 2;
		}
		
		// 체감 추위
		// 위험
		else if(this.currentTemp < -15.4) {
			System.out.println("영하 : 위험");
			weight = 4;
		}
		// 경고
		else if(this.currentTemp < -10.4) {
			System.out.println("영하 : 경고");
			weight = 3;
		}
		// 주의
		else if(this.currentTemp < -3.2) {
			System.out.println("영하 : 주의");
			weight = 2;
		}
		
		// 일반 상황
		else {
			System.out.println("일반 온도");
			weight = 0;
		}
		
		return weight;
	}
	
	
	// 현재 날씨에 따른 가중치 계산
	private int getWeatherWeight() {
		int weight = 0;
		
		// 없음 
		if(this.currentWeather == 0) {
			System.out.println("날씨 : 맑음");
			weight = 0;
		}
		// 비
		else if(this.currentWeather == 1) {
			System.out.println("날씨 : 비");
			weight = 3;
		}
		// 비, 눈
		else if(this.currentWeather == 2) {
			System.out.println("날씨 : 비/눈");
			weight = 3;
		}
		// 눈
		else if(this.currentWeather == 3) {
			System.out.println("날씨 : 눈");
			weight = 2;
		}
		
		return weight;
	}
	
	// 현재 날씨 기반으로 관광지 가중치 계산 
	public Map<String, Integer> calculateAllWeatherWeight() {
		
		// tour, food, shopping, reports, culture, festival
		
		// 컨텐츠 리스트
		this.weatherWeight = new HashMap<String, Integer>();
		
		// 총 합계 가중치 : 온도 + 날씨
		int totalWeight = caculateTempWeight() + getWeatherWeight();
		int totalScore = totalWeight * 10;
		
		this.weatherWeight.put("tour", 0);
		this.weatherWeight.put("food", totalScore);
		this.weatherWeight.put("shopping", totalScore);
		this.weatherWeight.put("reports", 0);
		this.weatherWeight.put("culture", totalScore);
		this.weatherWeight.put("festival", 0);

		System.out.println(this.weatherWeight);
		
		return this.weatherWeight;
	}
}