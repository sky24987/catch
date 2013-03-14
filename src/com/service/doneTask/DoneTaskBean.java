package com.service.doneTask;

import java.util.Map;

public class DoneTaskBean {

	private String id;

	private Map comment;
	
	private String content;
	
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Map getComment() {
		return comment;
	}
	public void setComment(Map comment) {
		this.comment = comment;
	}
	
}
