// 관광지 타입별 점수를 이용해 가중치를 계산하는 Class

package com.bangcok_api_server.user_profile;

public class WeightCalculate {

	public static int[] Calcualate(int[] type) {
		
		// input : 관광지 타입별 점수를 저장한 배열
		// output : 가중치를 부여한 관광지 타입별 점수를 저장한 배열
		
		int weightSum = 0;	// 가중치의 합계를 저장할 변수 선언 및 초기화
		
		// for문을 통해 각 관광지 타입을 고른 실제 사람의 수를 구하고 다시 배열에 저장
		// type[0]은 사례수(해당되는 배열(국적/나이/성별/방한횟수)의 설문조사에 참여한 전체 사람의 수)
		for(int i = 1; i < type.length; i++) {
			type[i] = Math.round((type[i] * type[0]) / 100);
		}
		
		int[] rank = {1,1,1,1,1,1}; // 순위를 매기는 배열
		
		// for문을 통해 순위를 매긴다.
        for(int i = 1; i < rank.length; i++){
            for (int j = 1; j < type.length; j++) {                        
                if(type[i] < type[j]){
                    rank[i]++;             
                }              
            }          
        } 
        
        // for문과 switch문을 통해 1순위부터 6순위까지 차례대로 6,5,4,3,2,1를 곱해준다.
        // 순위별로 가중치를 매기는 계산
        for(int i = 1; i < rank.length; i++) {
        	switch(rank[i]) {
        	case 1:
        		type[i] *= 6;
        		break;
        	case 2:
        		type[i] *= 5;
        		break;
        	case 3:
        		type[i] *= 4;
        		break;
        	case 4:
        		type[i] *= 3;
        		break;
        	case 5:
        		type[i] *= 2;
        		break;
        	case 6:
        		type[i] *= 1;
        		break;
        	}
        	weightSum += type[i]; // 가중치의 합계를 구한다.
        }
        
        // for문을 통해 각 배열값에 대한 퍼센트비율 구하기
        for(int i = 1; i < type.length; i++) {
        	type[i] = (int) (((double) type[i] / (double) weightSum) * 100.0);
        }
		return type; // 배열을 리턴
	}
}
