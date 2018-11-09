package com.bangcok_api_server.weather;

import java.io.IOException;
import java.util.Map;

import org.json.simple.parser.ParseException;

public class WeatherWeightCalculator {
	
	public Map<String, Integer> calculateWeight(double mapx, double mapy) throws IOException, ParseException{
		WeatherCalculator weatherCalc = new WeatherCalculator();
		weatherCalc.setLocationToGrid(mapy, mapx);
		weatherCalc.calculateAllWeather();
		return weatherCalc.calculateAllWeatherWeight();
	}
}
