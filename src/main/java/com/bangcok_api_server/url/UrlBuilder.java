package com.bangcok_api_server.url;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

/*
 * 매개변수: URL을 만드는데 필요한 코드
 * 메소드명: 요청하는 값에 대한 이름
 * 반환값  : JSON 형식인 String
 * 
 * 순서: UrlBuilder -----> UrlRequest ----> JsonParserTest
 */

public class UrlBuilder {
	// TourAPI에서 제공하는 ServiceKey
	private final static String serviceKey = "lXD74EVz%2B%2BsN6Umj%2FTEiUwe6SrhDlt6EJDw3EiP%2FaQ37jdWZzn2jcv0uMBf90xaYQU2taH9P2nEyEAiiS5mQrw%3D%3D";
	
	// TourAPI에서 반환하는 객체 타입 정하기
	private final static String type = "json";
	
	// 모바일 OS 설정
	private final static String mobileOS = "ETC";
	
	// 앱 이름
	private final static String mobileApp = "AppTest";
	
	
	// === 지역 코드 URL ===
	// 지역 코드를 요청하는 URL Build 메소드
	public String areaCodeURLBuild (String numOfRows, String pageNo, String areaCode) throws UnsupportedEncodingException {		
		String url = "http://api.visitkorea.or.kr/openapi/service/rest/KorService/areaCode" + "?ServiceKey=" + serviceKey +
																							  "&numOfRows=" + numOfRows +
																							  "&pageNo=" + pageNo +
																							  "&MobileOS=" + mobileOS +
																							  "&MobileApp=" + mobileApp + 
																							  "&areaCode=" + areaCode +
																							  "&_type=" + type;		
		System.out.println(url);
		return url;
	}
	
	
	// === 서비스 분류 코드 (cat1, cat2, cat3) URL ===
	// 서비스 분류코드 : 관광코드의 타입과 대분류, 중분류에 따라서 소분류 코드를 조회하는 URL Build 메소드
	public String categoryCodeURLBuild (String numOfRows, String pageNo, String contentTypeId, String cat1, String cat2) throws UnsupportedEncodingException {		
		String url = "http://api.visitkorea.or.kr/openapi/service/rest/KorService/categoryCode" + "?ServiceKey=" + serviceKey +
																								  "&numOfRows=" + numOfRows +
																								  "&pageNo=" + pageNo +
																								  "&MobileOS=" + mobileOS + 
																								  "&MobileApp=" + mobileApp +
																								  "&contentTypeId=" + contentTypeId +
																								  "&cat1=" + cat1 +
																								  "&cat2=" + cat2 +
																								  "&_type=" + type;		
		System.out.println(url);
		return url;
	}
	
	
	// === 지역 기반 관광정보 조회 URL  ===
	// 지역기반 관광정보 조회 : 지역코드를 기반으로 관광지 정보를 조회하는 URL Build 메소드
	public String areaBasedListURLBuild (String numOfRows, String pageNo, String arrange, String contentTypeId, String areaCode, String sigunguCode, String cat1, String cat2, String cat3) throws UnsupportedEncodingException {		
		String url = "http://api.visitkorea.or.kr/openapi/service/rest/KorService/areaBasedList" + "?ServiceKey=" + serviceKey +
																								   "&numOfRows=" + numOfRows + 
																								   "&pageNo=" + pageNo + 
																								   "&arrange=" + arrange +
																								   "&listYN=Y" +
																								   "&MobileOS=" + mobileOS +
																								   "&MobileApp=" + mobileApp +
																								   "&contentTypeId=" + contentTypeId +
																								   "&areaCode=" + areaCode +
																								   "&sigunguCode=" + sigunguCode +
																								   "&cat1=" + cat1 + 
																								   "&cat2=" + cat2 + 
																								   "&cat3=" + cat3 +
																								   "&_type=" + type;		
		System.out.println(url);
		return url;
	}
	
	
	// === 위치 기반 관광정보 조회 URL  ===
	// 위치 기반 관광정보 조회 : 위치 기반으로 관광지 정보를 조회하는 URL Build 메소드
	public String locationBasedListURLBuild (String numOfRows, String pageNo, String arrange, String contentTypeId, String mapX, String mapY, String radius) throws UnsupportedEncodingException {		
		String url = "http://api.visitkorea.or.kr/openapi/service/rest/KorService/locationBasedList" + "?ServiceKey=" + serviceKey +
																									   "&numOfRows=" + numOfRows + 
																									   "&pageNo=" + pageNo + 
																									   "&arrange=" + arrange +
																									   "&listYN=Y" +
																									   "&MobileOS=" + mobileOS + 
																									   "&MobileApp=" + mobileApp +
																									   "&contentTypeId=" + contentTypeId +
																									   "&mapX=" + mapX +
																									   "&mapY=" + mapY +
																									   "&radius=" + radius +
																									   "&_type=" + type;		
		System.out.println(url);
		return url;
	}
	
	
	// === 키워드 검색 관광정보 조회 URL  ===
	// 키워드 검색 관광정보 조회 : 키워드 검색으로 관광지 정보를 조회하는 URL Build 메소드
	public String searchKeywordURLBuild (String numOfRows, String pageNo, String arrange, String contentTypeId, String keyword, String areaCode, String sigunguCode, String cat1, String cat2, String cat3) throws UnsupportedEncodingException {				
		String url = "http://api.visitkorea.or.kr/openapi/service/rest/KorService/searchKeyword" + "?ServiceKey=" + serviceKey +
																								   "&numOfRows=" + numOfRows + 
																								   "&pageNo=" + pageNo + 
																								   "&arrange=" + arrange +
																								   "&listYN=Y" +
																								   "&MobileOS=" + mobileOS +  
																								   "&MobileApp=" + mobileApp + 
																								   "&contentTypeId=" + contentTypeId +
																								   "&keyword=" + URLEncoder.encode(keyword, "UTF-8") +
																								   "&areaCode=" + areaCode +
																								   "&sigunguCode=" + sigunguCode +
																								   "&cat1=" + cat1 + 
																								   "&cat2=" + cat2 + 
																								   "&cat3=" + cat3 +
																								   "&_type=" + type;
        
		System.out.println(url);
		return url;
	}
	
	
	// === 행사 검색 관광정보 조회 URL  ===
	// 행사 검색 관광정보 조회 : 날짜를 기반으로 행사 정보를 조회하는 URL Build 메소드
	public String searchFestivalURLBuild (String numOfRows, String pageNo, String arrange, String eventStartDate, String eventEndDate, String areaCode, String sigunguCode) throws UnsupportedEncodingException {				
		String url = "http://api.visitkorea.or.kr/openapi/service/rest/KorService/searchFestival" + "?ServiceKey=" + serviceKey +
																								   "&numOfRows=" + numOfRows + 
																								   "&pageNo=" + pageNo + 
																								   "&arrange=" + arrange +
																								   "&listYN=Y" +
																								   "&MobileOS=" + mobileOS + 
																								   "&MobileApp=" + mobileApp + 
																								   "&eventStartDate=" + eventStartDate +
																								   "&eventEndDate=" + eventEndDate +
																								   "&areaCode=" + areaCode +
																								   "&sigunguCode=" + sigunguCode +
																								   "&_type=" + type;
        
		System.out.println(url);
		return url;
	}
	
	// === 베니키아 한옥, 굿스테이 검색 관광정보 조회 URL  ===
	// 베니키아, 한옥, 굿스테이 정보 조회 : 베니키아, 한옥, 굿스테이 조회하는 URL Build 메소드
	public String searchStayURLBuild (String numOfRows, String pageNo, String arrange, String hanOk, String benikia, String goodStay, String areaCode, String sigunguCode) throws UnsupportedEncodingException {				
		String url = "http://api.visitkorea.or.kr/openapi/service/rest/KorService/searchStay" + "?ServiceKey=" + serviceKey +
																								   "&numOfRows=" + numOfRows + 
																								   "&pageNo=" + pageNo + 
																								   "&arrange=" + arrange +
																								   "&listYN=Y" +
																								   "&MobileOS=" + mobileOS + 
																								   "&MobileApp=" + mobileApp + 
																								   "&hanOk=" + hanOk +
																								   "&benikia=" + benikia +
																								   "&goodStay=" + goodStay +
																								   "&areaCode=" + areaCode +
																								   "&sigunguCode=" + sigunguCode +
																								   "&_type=" + type;
        
		System.out.println(url);
		return url;
	}
	
	// === 상세 정보 조회 URL  ===
	// 상세 정보 조회 URL : 공통 정보를 조회하는 URL Build 메소드
	public String detailCommonURLBuild (String contentId, String contentTypeId, String defaultYN, String firstImageYN, String areacodeYN, String catcodeYN, String addrinfoYN, String mapinfoYN, String overviewYN) throws UnsupportedEncodingException {				
		String url = "http://api.visitkorea.or.kr/openapi/service/rest/KorService/detailCommon" +  "?ServiceKey=" + serviceKey +
																								   "&MobileOS="+ mobileOS +
																								   "&MobileApp=" + mobileApp + 
																								   "&contentId=" + contentId +
																								   "&contentTypeId=" + contentTypeId +
																								   "&defaultYN=" + defaultYN +
																								   "&firstImageYN=" + firstImageYN +
																								   "&areacodeYN=" + areacodeYN +
																								   "&catcodeYN=" + catcodeYN +
																								   "&addrinfoYN=" + addrinfoYN +
																								   "&mapinfoYN=" + mapinfoYN +
																								   "&overviewYN=" + overviewYN +
																								   "&_type=" + type;
        
		System.out.println(url);
		return url;
	}
	
	// 소개 정보 조회 URL : 소개 정보를 조회하는 URL Build 메소드
	public String detailIntroURLBuild (String contentId, String contentTypeId, String introYN) throws UnsupportedEncodingException {				
		String url = "http://api.visitkorea.or.kr/openapi/service/rest/KorService/detailIntro" + "?ServiceKey=" + serviceKey +
																								   "&MobileOS=" + mobileOS +
																								   "&MobileApp=" + mobileApp + 
																								   "&contentId=" + contentId +
																								   "&contentTypeId=" + contentTypeId +
																								   "&introYN=" + introYN +
																								   "&_type=" + type;
        
		System.out.println(url);
		return url;
	}
	
	// 반복 정보 조회 URL : 소개 정보를 조회하는 URL Build 메소드
	public String detailInfoURLBuild (String contentId, String contentTypeId, String detailYN) throws UnsupportedEncodingException {				
		String url = "http://api.visitkorea.or.kr/openapi/service/rest/KorService/detailInfo" + "?ServiceKey=" + serviceKey +
																							   	"&MobileOS=" + mobileOS + 
																							   	"&MobileApp=" + mobileApp + 
																							   	"&contentId=" + contentId +
																							   	"&contentTypeId=" + contentTypeId +
																							   	"&detailYN=" + detailYN +
																							   	"&_type=" + type;
        
		System.out.println(url);
		return url;
	}
	
	// 반복 정보 조회 URL : 소개 정보를 조회하는 URL Build 메소드
	public String detailImageURLBuild (String contentId, String contentTypeId, String imageYN) throws UnsupportedEncodingException {				
		String url = "http://api.visitkorea.or.kr/openapi/service/rest/KorService/detailImage" + "?ServiceKey=" + serviceKey +
																							   	 "&MobileOS=" + mobileOS +
																						   	   	 "&MobileApp=" + mobileApp + 
																							   	 "&contentId=" + contentId +
																							   	 "&contentTypeId=" + contentTypeId +
																							   	 "&imageYN=" + imageYN +
																							   	 "&_type=" + type;
        
		System.out.println(url);
		return url;
	}
}