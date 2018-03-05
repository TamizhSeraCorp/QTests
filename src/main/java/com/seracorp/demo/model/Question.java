package com.seracorp.demo.model;

public class Question {
	
	public Question(String q_) {
		System.out.println("Creating instance:: " + q_);
		this.question = q_;
	}
private String question;

public String getQuestion() {
	return question;
}

public void setQuestion(String question) {
	this.question = question;
}
}
