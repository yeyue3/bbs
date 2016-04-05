package com.yl.web.forms;

import org.apache.struts.action.ActionForm;
import org.apache.struts.upload.FormFile;

public class UserForm extends ActionForm{
	private String username;
	private FormFile myPhoto;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public FormFile getMyPhoto() {
		return myPhoto;
	}
	public void setMyPhoto(FormFile myPhoto) {
		this.myPhoto = myPhoto;
	}
	
	
}
