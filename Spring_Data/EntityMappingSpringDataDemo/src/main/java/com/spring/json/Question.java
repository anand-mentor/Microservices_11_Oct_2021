package com.spring.json;

import java.util.Set;

public class Question {

	private Long qusId;
	
	private String qusDesc;
	
	private Set<Answer> answers;
	
	public Question() {}
	
	public Question(String qusDesc) {
		this.qusDesc = qusDesc;
	}
	public Question(String qusDesc, Set<Answer> answers) {
		this.qusDesc = qusDesc;
		this.answers = answers;
	}

	public Long getQusId() {
		return qusId;
	}

	public void setQusId(Long qusId) {
		this.qusId = qusId;
	}

	public String getQusDesc() {
		return qusDesc;
	}

	public void setQusDesc(String qusDesc) {
		this.qusDesc = qusDesc;
	}

	public Set<Answer> getAnswers() {
		return answers;
	}

	public void setAnswers(Set<Answer> answers) {
		this.answers = answers;
	}
	
	public String toString() {
		return qusId + " - " + qusDesc + " - " + answers;
	}
}
