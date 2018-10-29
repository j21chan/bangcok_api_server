package com.bangcok_api_server.parser;

import java.util.ArrayList;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.bangcok_api_server.tourism.LocationBasedList;

public class InteractiveTourJsonParser implements JsonParser {
	
	@Override
	public ArrayList<Object> parse(String jsonString) {
		
		// 객체 생성을 위한 선언 및 초기화
		String addr1 = null;
		String addr2 = null;
		String areacode = null;
		String booktour = null;
		String cat1 = null;
		String cat2 = null;
		String cat3 = null;
		String contentid = null;
		String contenttypeid = null;
		String createdtime = null;
		double dist = 0;
		String firstimage = null;
		String firstimage2 = null;
		double mapx = 0;
		double mapy = 0;
		String mlevel = null;
		String modifiedtime = null;
		int readcount = 0;
		String sigungucode = null;
		String tel = null;
		String title = null;
		ArrayList<Object> dtos = new ArrayList<Object>();
		
        // JSON 객체 출력
//        System.out.println("******** Tour API에서 받아온 JSON ********");
//        System.out.println(jsonString + "\n");
   
        // JSON Parser 객체 만들기
        JSONParser parser = new JSONParser();
        
        // TourAPI에서 받은 Json 파일을 obj로 받기
        Object obj = null;
		try {
			obj = parser.parse(jsonString);
		} catch (ParseException e) {
			e.printStackTrace();
		}
                
        // Object에서 JSON으로 Type Casting
        JSONObject jsonObj = (JSONObject) obj;
                
        // Json response value
        JSONObject jsonResponse = (JSONObject) jsonObj.get("response");
                
        // json body value
        JSONObject jsonBody = (JSONObject) jsonResponse.get("body");
        
        // num Of rows
        int numOfRows = Integer.parseInt(jsonBody.get("numOfRows").toString());
        
        // pageNo
        int pageNo = Integer.parseInt(jsonBody.get("pageNo").toString());
        
//        System.out.println("관광지 개수 : " + numOfRows + " 개");
//        System.out.println("페이지 : " + pageNo + "\n");
        
		// json items value null 값 확인
        if (jsonBody.get("items").toString().equals("")) {
			
			// items가 없을 때
			dtos = null;
		} else {
				
			// items가 있을 때
	        // json items value
	        JSONObject jsonItems = (JSONObject) jsonBody.get("items");
	        
	        // jsonArray item value
	        JSONArray jsonItemArray = (JSONArray) jsonItems.get("item");

	        // items json array에 담긴 각 json 오브젝트를 빼오는 작업
//	        System.out.println("******** JSON Parser를 이용해서 파싱 ********" + "\n");
	        for (int i = 0; i < 10; i++) {
	        	
	        	// 임시 json 객체
	        	int randomIndex = (int) (Math.random() * jsonItemArray.size());
	        	
	        	JSONObject temp = (JSONObject) jsonItemArray.get(randomIndex);
	        	jsonItemArray.remove(randomIndex);	        	
	        	
	        	// 1. 각 JSON 객체의 Key 값이 있는지 검사
	        	// 2. 값이 있으면 파싱해서 데이터를 넣음
	        	// 3. 데이터 값 출력
//	        	System.out.println("------------ " + (i + 1) + "번째 인덱스 값 ------------");
	        	
	        	// 변수 초기화
	    		addr1 = null;
	    		addr2 = null;
	    		areacode = null;
	    		booktour = null;
	    		cat1 = null;
	    		cat2 = null;
	    		cat3 = null;
	    		contentid = null;
	    		contenttypeid = null;
	    		createdtime = null;
	    		dist = 0;
	    		firstimage = null;
	    		firstimage2 = null;
	    		mapx = 0;
	    		mapy = 0;
	    		mlevel = null;
	    		modifiedtime = null;
	    		readcount = 0;
	    		sigungucode = null;
	    		tel = null;
	    		title = null;
	        	
	        	if(temp.containsKey("addr1")) {
	        		addr1 = temp.get("addr1").toString();
//	            	System.out.println("addr1 : " + addr1);
	        	}
	        	
	        	if(temp.containsKey("addr2")) {
	        		addr2 = temp.get("addr2").toString();
//	            	System.out.println("addr2 : " + addr2);
	        	}
	        	
	        	if(temp.containsKey("areacode")) {
	        		areacode = temp.get("areacode").toString();
//	            	System.out.println("areacode : " + areacode);
	        	}
	        	
	        	if(temp.containsKey("cat1")) {
	        		cat1 = temp.get("cat1").toString();
//	            	System.out.println("cat1 : " + cat1);
	        	}
	        	
	        	if(temp.containsKey("cat2")) {
	        		cat2 = temp.get("cat2").toString();
//	            	System.out.println("cat2 : " + cat2);
	        	}
	        	
	        	if(temp.containsKey("cat3")) {
	        		cat3 = temp.get("cat3").toString();
//	            	System.out.println("cat3 : " + cat3);
	        	}
	        	
	        	if(temp.containsKey("contentid")) {
	        		contentid = temp.get("contentid").toString();
//	            	System.out.println("contentid : " + contentid);
	        	}
	        	
	        	if(temp.containsKey("contenttypeid")) {
	        		contenttypeid = temp.get("contenttypeid").toString();
//	            	System.out.println("contenttypeid : " + contenttypeid);
	        	}
	        	
	        	if(temp.containsKey("createdtime")) {
	        		createdtime = temp.get("createdtime").toString();
//	            	System.out.println("createdtime : " + createdtime);
	        	}
	
	        	if(temp.containsKey("dist")) {
	        		dist = Double.parseDouble(temp.get("dist").toString());
//	            	System.out.println("dist : " + dist);
	        	}
	        	
	        	if(temp.containsKey("firstimage")) {
	        		firstimage = temp.get("firstimage").toString();
//	            	System.out.println("firstimage : " + firstimage);
	        	}
	        	
	        	if(temp.containsKey("firstimage2")) {
	        		firstimage2 = temp.get("firstimage2").toString();
//	            	System.out.println("firstimage2 : " + firstimage2);
	        	}
	        	
	        	if(temp.containsKey("mapx")) {
	        		mapx = Double.parseDouble(temp.get("mapx").toString());
//	            	System.out.println("mapx : " + mapx);
	        	}
	        	
	        	if(temp.containsKey("mapy")) {
	        		mapy = Double.parseDouble(temp.get("mapy").toString());
//	            	System.out.println("mapy : " + mapy);
	        	}
	        	
	        	if(temp.containsKey("mlevel")) {
	            	mlevel = temp.get("mlevel").toString();
//	            	System.out.println("mlevel : " + mlevel);
	        	}
	        	
	        	if(temp.containsKey("modifiedtime")) {
	            	modifiedtime = temp.get("modifiedtime").toString();
//	            	System.out.println("modifiedtime : " + modifiedtime);
	        	}
	        	
	        	if(temp.containsKey("readcount")) {
	        		readcount = Integer.parseInt(temp.get("readcount").toString());
//	            	System.out.println("readcount : " + readcount);
	        	}
	        	
	        	if (temp.containsKey("sigungucode")) {
	        		sigungucode = temp.get("sigungucode").toString();
//	        		System.out.println("sigungucode : " + sigungucode);
	        	}
	        	
	        	if(temp.containsKey("tel")) {
	        		tel = temp.get("tel").toString();
//	            	System.out.println("tel : " + tel);
	        	}
	        	
	        	if(temp.containsKey("title")) {
	        		title = temp.get("title").toString();
//	            	System.out.println("title : " + title);
	        	}
	        	
//	        	System.out.println("");
	        	
	        	// List에 넣기
	        	LocationBasedList locationBasedList = new LocationBasedList(addr1, addr2, areacode, booktour, cat1, cat2, cat3, contentid, contenttypeid, createdtime, dist, firstimage, firstimage2, mapx, mapy, mlevel, modifiedtime, readcount, sigungucode, tel, title);
	        
	        	dtos.add(locationBasedList);
	        }
        }
        
		return dtos;
	}
}
