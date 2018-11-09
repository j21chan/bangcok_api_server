package com.bangcok_api_server.utility;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.bangcok_api_server.domain.AllTourismVO;
import com.bangcok_api_server.domain.TrendTourismVO;

public class MyResponse {
	
	public static Map<String, Object> toResponse(List<Object> data) {
		
		String resultCode;
		String resultMsg;
		
		if(data == null) {
			resultCode = "9999";
			resultMsg = "data null Error!";
		} else {
			resultCode = "0000";
			resultMsg = "Success!";
		}
		
		Header header = new Header(resultCode, resultMsg);
		Map<String, Object> response = new HashMap<String, Object>();

		response.put("header", header);
		response.put("body", data);
		
		return response;
	}
	
	public static Map<String, Object> toResponse(List<Object> data1, List<TrendTourismVO> data2) {
		
		String resultCode;
		String resultMsg;
		
		if(data1 == null && data2 == null) {
			resultCode = "9999";
			resultMsg = "data null Error!";
		} else {
			resultCode = "0000";
			resultMsg = "Success!";
		}
		
		Header header = new Header(resultCode, resultMsg);
		Map<String, Object> response = new HashMap<String, Object>();
//		Map<String, Object> item1 = new HashMap<String, Object>();
//		Map<String, Object> item2 = new HashMap<String, Object>();
//		
//		item1.put("recommend", data1);
//		item2.put("trend", data2);
		
		response.put("header", header);
		response.put("body", (Object) new AllTourismVO(data1, data2));
		
		return response;
	}
}
