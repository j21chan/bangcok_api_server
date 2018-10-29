package com.bangcok_api_server.tourism;

public class Content implements Comparable<Content> {
	private String contentName;
	private int score;
	
	public Content(String contentName, int score) {
		this.contentName = contentName;
		this.score = score;
	}
	
	public void setContentName(String contentName) {
		this.contentName = contentName;
	}
	
	public void setScore(int score) {
		this.score = score;
	}
	
	public String getContentName() {
		return this.contentName;
	}
	public int getScore() {
		return this.score;
	}
	
	public String toString() {
		return "[" + this.contentName + ", " + this.score + "]";
	}
	
	public int compareTo(Content con) {
		return -Integer.compare(this.score, con.getScore());
	}
}
