package com.bangcok_api_server.statics;

public class Country {

	public static int[] CountryContent(int x) {
		
	    int[] Content = new int[6];  
			
			if (x == 0) {
				Content[0] = 0;
				Content[1] = 0;
				Content[2] = 0;
				Content[3] = 0;
				Content[4] = 0;
				Content[5] = 0;
			} else if (x == 1) {
				Content[0] = 67;
				Content[1] = 11;
				Content[2] = 11;
				Content[3] = 12;
				Content[4] = 52;
				Content[5] = 49;
			}  else if(x == 2) {
				Content[0] = 50;
				Content[1] = 14;
				Content[2] = 14;
				Content[3] = 8;
				Content[4] = 68;
				Content[5] = 55;
			  }
			
		return Content; 
	}
	
}
