package com.bangcok_api_server.walk;

import java.util.HashMap;
import java.util.Map;

public class RecommendWalk {
	private int[] working = new int[6];
	  
    private int [] WorkingCalculate(int x) {
    	
    	if(x>5000 && x<10000) {
			 working[1] += 10;
		  } else if(x>=10000 && x<15000) {
		      working[1] += 20;
		  } else if(x>=15000 && x<20000) {
				 working[1] += 30;
		  } else if(x>=20000 && x<25000) {
				 working[1] += 40;
		  } else if(x>=25000 && x< 30000) {
				 working[1] += 50;
		  } else if(x>=30000) {
				 working[1] += 60;		 
        }	
    	return working;	
    }
    
	public Map<String, Integer> calculateWeight(int walkCount) {
		Map<String, Integer> contents = new HashMap<String, Integer>();
		
		WorkingCalculate(walkCount);
		
		contents.put("tour", working[0]);
		contents.put("food", working[1]);
		contents.put("shopping", working[2]);
		contents.put("culture", working[3]);
		contents.put("festival", working[4]);
		contents.put("reports", working[5]);

		// 최종 리턴
		return contents;
	}

}
