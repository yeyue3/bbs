package com.yl.web.forms;

import java.util.Date;

import org.apache.struts.action.ActionForm;
import org.apache.struts.upload.FormFile;

public class PersonForm extends ActionForm {
	private Integer id;
	private String password;
	private String sex;
	private String name;
	private Integer age;
	private String email;
	private FormFile myPhoto;
	private String rember;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getRember() {
		return rember;
	}
	public void setRember(String rember) {
		this.rember = rember;
	}
	public FormFile getMyPhoto() {
		return myPhoto;
	}
	public void setMyPhoto(FormFile myPhoto) {
		this.myPhoto = myPhoto;
	}
	
	
}
