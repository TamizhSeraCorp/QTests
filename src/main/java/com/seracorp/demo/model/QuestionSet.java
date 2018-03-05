package com.seracorp.demo.model;

import java.util.List;

import com.seracorp.demo.util.StringUtils;

public class QuestionSet {
	
	public QuestionSet(String questions) {
		StringUtils.splitAndList(questions, ",").forEach(q -> { this.list.add(new Question(q));});
	}
	
	private List<Question> list;
	
	public List<Question> getList() {
		return list;
	}

	public void setList(List<Question> list) {
		this.list = list;
	}
}
