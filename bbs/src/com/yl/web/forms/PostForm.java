package com.yl.web.forms;

import org.apache.struts.action.ActionForm;

public class PostForm extends ActionForm {
	private String title;
	private String content;
	private Integer board_id;
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Integer getBoard_id() {
		return board_id;
	}
	public void setBoard_id(Integer board_id) {
		this.board_id = board_id;
	}
	
	
}
