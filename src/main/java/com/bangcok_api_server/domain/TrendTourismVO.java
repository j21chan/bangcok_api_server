package com.bangcok_api_server.domain;

public class TrendTourismVO {
	private String trendName;
	private String productName;
	private String address;
	private String contentName;

	
	public TrendTourismVO() {
		super();
	}
	
	public TrendTourismVO(String trendName, String productName, String address, String contentName) {
		super();
		this.trendName = trendName;
		this.productName = productName;
		this.address = address;
		this.contentName = contentName;
	}
	
	public String getTrendName() {
		return trendName;
	}
	public void setTrendName(String trendName) {
		this.trendName = trendName;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getContentName() {
		return contentName;
	}
	public void setContentName(String contentName) {
		this.contentName = contentName;
	}
	
}
