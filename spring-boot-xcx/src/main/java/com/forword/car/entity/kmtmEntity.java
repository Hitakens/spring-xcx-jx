package com.forword.car.entity;

import java.io.Serializable;

import lombok.Data;


public class kmtmEntity implements Serializable{

	private String questionTitle;
	private String questionItems;
	private String questionAnswer;
	private String questionSkills;
	private String answerAnalysis;
	private String questionImg;
	public String getQuestionImg() {
		return questionImg;
	}
	public void setQuestionImg(String questionImg) {
		this.questionImg = questionImg;
	}
	private String tmxzlx;
	private String kmlx;
	private String uuid;
	public String getQuestionTitle() {
		return questionTitle;
	}
	public void setQuestionTitle(String questionTitle) {
		this.questionTitle = questionTitle;
	}
	public String getQuestionItems() {
		return questionItems;
	}
	public void setQuestionItems(String questionItems) {
		this.questionItems = questionItems;
	}
	public String getQuestionAnswer() {
		return questionAnswer;
	}
	public void setQuestionAnswer(String questionAnswer) {
		this.questionAnswer = questionAnswer;
	}
	public String getQuestionSkills() {
		return questionSkills;
	}
	public void setQuestionSkills(String questionSkills) {
		this.questionSkills = questionSkills;
	}
	public String getAnswerAnalysis() {
		return answerAnalysis;
	}
	public void setAnswerAnalysis(String answerAnalysis) {
		this.answerAnalysis = answerAnalysis;
	}
	public String getTmxzlx() {
		return tmxzlx;
	}
	public void setTmxzlx(String tmxzlx) {
		this.tmxzlx = tmxzlx;
	}
	public String getKmlx() {
		return kmlx;
	}
	public void setKmlx(String kmlx) {
		this.kmlx = kmlx;
	}
	public String getUuid() {
		return uuid;
	}
	public void setUuid(String uuid) {
		this.uuid = uuid;
	}
	
	

}
