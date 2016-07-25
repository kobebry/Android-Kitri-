package com.example.choi.beer_project;

public class BeerDTO {
	String title;
	String score;	
	
	public BeerDTO(String title, String score) {
		super();
		this.title = title;
		this.score = score;
	}
	public BeerDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getScore() {
		return score;
	}
	public void setScore(String score) {
		this.score = score;
	}
	
	
}
