package com.bangcok_api_server.domain;

import java.util.List;

public class AllTourismVO {
	private List<Object> recommend;
	private List<TrendTourismVO> trend;
	
	public AllTourismVO(List<Object> item1, List<TrendTourismVO> item2) {
		this.recommend = item1;
		this.trend = item2;
	}

	public List<Object> getRecommend() {
		return recommend;
	}

	public void setRecommend(List<Object> recommend) {
		this.recommend = recommend;
	}

	public List<TrendTourismVO> getTrend() {
		return trend;
	}

	public void setTrend(List<TrendTourismVO> trend) {
		this.trend = trend;
	}
	
	
}
