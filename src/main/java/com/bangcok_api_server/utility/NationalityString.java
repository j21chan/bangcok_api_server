package com.bangcok_api_server.utility;

public class NationalityString {
    	
	public static int changeString(String nationality) {
		int nationcode;

        switch (nationality) {
            case "japan":  
            	nationcode = 1;
                break;
            case "chinese":  
            	nationcode = 2;
                break;
            case "honkong":  
            	nationcode = 3;
                break;
            case "singapore":  
            	nationcode = 4;
                break;
            case "taiwan":  
            	nationcode = 5;
                break;
            case "thailand":  
            	nationcode = 6;
                break;
            case "malaysia":  
            	nationcode = 7;
                break;
            case "australia":  
            	nationcode = 8;
                break;
            case "usa":  
            	nationcode = 9;
                break;
            case "canada":  
            	nationcode = 10;
                break;
            case "england":  
            	nationcode = 11;
                break;
            case "germany":  
            	nationcode = 12;
                break;
            case "france":  
            	nationcode = 13;
                break;
            case "russia":  
            	nationcode = 14;
                break;
            case "middle east":  
            	nationcode = 15;
                break;
            case "india":  
            	nationcode = 16;
                break;
            case "philippines":  
            	nationcode = 17;
                break;
            case "indonesia":  
            	nationcode = 18;
                break;
            case "vietnam":  
            	nationcode = 19;
                break;
            default: 
            	nationcode = 20;
                break;
        }
        return nationcode;
    }
}