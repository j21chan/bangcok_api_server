package com.bangcok_api_server.myapp;

import java.io.IOException;

import org.json.simple.parser.ParseException;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bangcok_api_server.Recommend.InteractiveRecommender;
import com.bangcok_api_server.Recommend.TourismRecommender;
import com.bangcok_api_server.weather.WeatherCalculator;

@RestController
public class HomeController {
	
	// 관광지 추천 API
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String recommendTour(@RequestParam("numOfRows") 		String numOfRows,
								 @RequestParam("pageNo") 		String pageNo,
								 @RequestParam("arrange") 		String arrange,
								 @RequestParam("contentTypeId") String contentTypeId,
								 @RequestParam("mapX") 			String mapX,
								 @RequestParam("mapY") 			String mapY,
								 @RequestParam("radius") 		String radius) {
		return "test";
	}
	
	// 날씨 테스트
	@RequestMapping(value = "/weather", method = RequestMethod.GET)
	public String weather() throws IOException, ParseException {
		WeatherCalculator wCalc = new WeatherCalculator();
		wCalc.setLocationToGrid(36.2944985, 127.3329295);
		wCalc.calculateAllWeather();
		wCalc.calculateAllWeatherWeight();
		
		return "weathertest";
	}
	
	// 관광지 추천 테스트
	@RequestMapping(value = "/test", method = RequestMethod.GET)
	public String recommendTest() throws IOException, ParseException {
		
		new TourismRecommender().recommend();
		
		return "test";
	}
	
	// 인터렉티브 관광지 추천
	@RequestMapping(value = "/interRecommend", method = RequestMethod.GET)
	public String interRecommend(@RequestParam("contentTypeId") String contentTypeId,
							     @RequestParam("mapX") 		    String mapX,
							     @RequestParam("mapY") 		    String mapY) throws IOException {
		mapX = "126.981106";
		mapY = "37.568477";
		
		System.out.println(new InteractiveRecommender().recommend(contentTypeId, mapX, mapY));
		
		return "test";
	}
}
