package com.bangcok_api_server.url;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


public class MyResponse {
	
	public Map<String, Object> toResponse(ArrayList<Object> data) {
		
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
}
