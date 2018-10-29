package com.bangcok_api_server.statics;

import java.util.HashMap;
import java.util.Map;

public class StaticsCalculator {
	
	// 국적, 성별, 나이 방한횟수
	public Map<String, Integer> calculateWeight(int user_country, int user_gender, int user_age, int user_count) {
		
		Map<String, Integer> staticsWeight = new HashMap<String, Integer>();
		
		int[] result = new int[6]; 
		
//		System.out.println("If you want skip, then press 0 !!");
//		System.out.println("All answers are number !!");
//		System.out.println();
//		
//		System.out.println("Nationality (1.Japan  2.Chinese  3.Honkong  4.Singapore  5.Taiwan ");
//		System.out.println("           6.Thailand  7.Malaysia  8.Australia   9.USA   10.Canada ");
//		System.out.println("           11.England  12.Germany  13.France  14.Russia  15.Middle East");
//		System.out.print("           16.India  17.Philippines  18.Indonesia  19.Vietnam  20.Else)  :  ");
		int[] country = Country.CountryContent(user_country); 
		
//		System.out.print("Gender (1.Male  2.Female)  :  ");
		int[] gender = Gender.GenderContent(user_gender); 
		
//		System.out.print("Age  :  ");
		int[] age = Age.AgeContent(user_age); 
		
//		System.out.print("Number of visits  :  ");
		int[] count = Count.CountContent(user_count); 
		
		for(int i = 0; i <= 5; i++) {
			result[i] = country[i] + gender[i] + age[i] + count[i];
		}
//		System.out.println();
		
		staticsWeight.put("tour", result[0]);
		staticsWeight.put("culture", result[1]);
		staticsWeight.put("festival", result[2]);
		staticsWeight.put("reports", result[3]);
		staticsWeight.put("shopping", result[4]);
		staticsWeight.put("food", result[5]);
		
        System.out.println(staticsWeight);
        
        return staticsWeight;
	}
}
