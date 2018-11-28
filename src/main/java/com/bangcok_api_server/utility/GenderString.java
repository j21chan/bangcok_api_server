package com.bangcok_api_server.utility;

public class GenderString {
    	
	public static int changeString(String gender) {
		int gendercode;

        switch (gender) {
            case "male":  
            	gendercode = 1;
                break;
            case "female":  
            	gendercode = 2;
                break;
            default: 
            	gendercode = 0;
                break;
        }
        return gendercode;
    }
}