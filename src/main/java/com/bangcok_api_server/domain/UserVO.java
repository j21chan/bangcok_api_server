package com.bangcok_api_server.domain;

public class UserVO {
	private String userid;
	private String country;
	private int age;
	private String gender;
	private int visitCount;
	
	public UserVO() {
		
	}

	public UserVO(String userid, String country, int age, String gender, int visitCount) {
		super();
		this.userid = userid;
		this.country = country;
		this.age = age;
		this.gender = gender;
		this.visitCount = visitCount;
	}

	public String getUserid() {
		return userid;
	}
	public int getVisitCount() {
		return visitCount;
	}

	public void setVisitCount(int visitCount) {
		this.visitCount = visitCount;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	
}
