package com.bangcok_api_server.url;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class UrlRequest {
	
	public UrlRequest() {
		
	}
	
	public String urlRequest (String stringURL) throws IOException {
		
		// TourAPI로 보낼 URL
        URL url = new URL(stringURL);
		
        // HttpURLConnection 연결
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        
        // http 연결 설정을 GET 방식으로 하고 json으로 가져옴
        conn.setRequestMethod("GET");
        conn.setRequestProperty("Content-type", "application/json");
        
        // Response 코드 출력
        System.out.println("Response code: " + conn.getResponseCode() + "\n");
        
        // BufferReader 객체 생성
        BufferedReader rd;
        
        // Response 코드가 200 이상이거나 300 이하일 때
        if(conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
            rd = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));
        } else {
            rd = new BufferedReader(new InputStreamReader(conn.getErrorStream(), "UTF-8"));
        }
        
        
        // String Builder 객체 생성
        StringBuilder sb = new StringBuilder();
        String line;
        
        // 데이터를 읽어와서 붙힘
        while ((line = rd.readLine()) != null) {
            sb.append(line);
        }
        
        
        // 사용한 객체들 자원 반납
        rd.close();
        conn.disconnect();
        
        // URL로 요청된 객체 반환
		return sb.toString();
	}
}
