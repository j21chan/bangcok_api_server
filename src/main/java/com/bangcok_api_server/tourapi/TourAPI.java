package com.bangcok_api_server.tourapi;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import com.bangcok_api_server.url.UrlBuilder;
import com.bangcok_api_server.url.UrlRequest;

public class TourAPI {
	private UrlBuilder urlBuilder;
	private UrlRequest urlRequest;
	
	public TourAPI() {
		this.urlBuilder = new UrlBuilder();
		this.urlRequest = new UrlRequest();
	}
	
	// 사용자 위치 기반으로 관광지를 가져오는 메소드
	public String getLocationBasedList(String numOfRows, 	 String pageNo, String arrange,
									   String contentTypeId, String mapX, 	String mapY, String radius)
											   throws UnsupportedEncodingException, IOException {

		return urlRequest.urlRequest(urlBuilder.locationBasedListURLBuild(numOfRows, pageNo, arrange,
																		  contentTypeId, mapX, mapY, radius));
	}
}
