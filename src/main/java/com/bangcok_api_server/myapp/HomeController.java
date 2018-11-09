package com.bangcok_api_server.myapp;

import java.io.IOException;
import java.util.Map;

import javax.inject.Inject;

import org.json.simple.parser.ParseException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bangcok_api_server.recommend.InteractiveRecommender;
import com.bangcok_api_server.recommend.TourismRecommender;
import com.bangcok_api_server.service.RecommendTourismService;
import com.bangcok_api_server.service.TrendTourismService;
import com.bangcok_api_server.service.UserService;
import com.bangcok_api_server.utility.MyResponse;
import com.bangcok_api_server.weather.WeatherCalculator;

@RestController
@RequestMapping(value="/tourism/*")
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@Inject
	UserService userService;
	
	@Inject
	RecommendTourismService recommendTourismService;
	
	@Inject
	TrendTourismService trendTourismService;
	
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
	public Map<String, Object> recommendTest() throws IOException, ParseException {
		
		return MyResponse.toResponse(new TourismRecommender().recommend());
	}
	
	// 인터렉티브 관광지 추천
	@RequestMapping(value = "/interactive", method = RequestMethod.GET)
	public Map<String, Object> interRecommend(@RequestParam("contentTypeId") String contentTypeId,
										      @RequestParam("mapX") 		    String mapX,
										      @RequestParam("mapY") 		    String mapY) throws IOException {
		mapX = "126.981106";
		mapY = "37.568477";
		logger.info("interactive Tourism .....");
		return MyResponse.toResponse(new InteractiveRecommender().recommend(contentTypeId, mapX, mapY));
	}
	
	// 유저 정보 & 현재 위치
	@RequestMapping(value="/recommend", method=RequestMethod.GET)
	public Map<String, Object> recommendTourism(@RequestParam("mapX") String mapX,
												@RequestParam("mapY") String mapY,
												@RequestParam("userid") String userid) throws Exception {
		
		logger.info("recommend Tourism .....");
		return MyResponse.toResponse(recommendTourismService.recommend(userService.get(userid), mapX, mapY),
									 trendTourismService.listTrendTourism());
	}
}
