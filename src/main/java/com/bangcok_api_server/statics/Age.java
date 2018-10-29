package com.bangcok_api_server.statics;

public class Age {
	
	public static int[] AgeContent(int x) {
		
	    int[] Content = new int[6];  
			
		if (x < 15) {
			Content[0] = 0;
			Content[1] = 0;
			Content[2] = 0;
			Content[3] = 0;
			Content[4] = 0;
			Content[5] = 0;
		} else if (x >= 15 && x <= 20) {
			Content[0] = 44;
			Content[1] = 15;
			Content[2] = 15;
			Content[3] = 12;
			Content[4] = 67;
			Content[5] = 54;
		}  else if(x >= 21 && x <= 30) {
			Content[0] = 53;
			Content[1] = 15;
			Content[2] = 15;
			Content[3] = 10;
			Content[4] = 66;
			Content[5] = 54;
		}  else if(x >= 31 && x <= 40) {
			Content[0] = 59;
			Content[1] = 13;
			Content[2] = 13;
			Content[3] = 9;
			Content[4] = 63;
			Content[5] = 51;
		}  else if(x >= 41 && x <= 50) {
			Content[0] = 61;
			Content[1] = 10;
			Content[2] = 10;
			Content[3] = 8;
			Content[4] = 55;
			Content[5] = 53;
		}  else if(x >= 51 && x <= 60) {
			Content[0] = 68;
			Content[1] = 7;
			Content[2] = 7;
			Content[3] = 6;
			Content[4] = 53;
			Content[5] = 51;
		}  else if(x >= 61) {
			Content[0] = 65;
			Content[1] = 6;
			Content[2] = 6;
			Content[3] = 10;
			Content[4] = 42;
			Content[5] = 54;
		}
			
		return Content; 
	}

}
