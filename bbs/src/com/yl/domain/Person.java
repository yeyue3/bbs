package com.yl.domain;

import java.util.Date;
import java.util.Set;

public class Person {
	private Integer id;
	private String password;
	private String sex;
	private String name;
	private Integer age;
	private String email;
	private Date dateLLastActived;
	private String photoName;
	private Integer postCount;
	private Integer replyCount;
	
	private Set<Board> boardAdministrated;//版主
	private Set<Post> posts;//主题帖
	private Set<Reply> replys;//回帖
	
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
	public Date getDateLLastActived() {
		return dateLLastActived;
	}
	public void setDateLLastActived(Date dateLLastActived) {
		this.dateLLastActived = dateLLastActived;
	}
	public Set<Board> getBoardAdministrated() {
		return boardAdministrated;
	}
	public void setBoardAdministrated(Set<Board> boardAdministrated) {
		this.boardAdministrated = boardAdministrated;
	}
	public Set<Post> getPosts() {
		return posts;
	}
	public void setPosts(Set<Post> posts) {
		this.posts = posts;
	}
	public Set<Reply> getReplys() {
		return replys;
	}
	public void setReplys(Set<Reply> replys) {
		this.replys = replys;
	}
	public String getPhotoName() {
		return photoName;
	}
	public void setPhotoName(String photoName) {
		this.photoName = photoName;
	}
	public Integer getPostCount() {
		return postCount;
	}
	public void setPostCount(Integer postCount) {
		this.postCount = postCount;
	}
	public Integer getReplyCount() {
		return replyCount;
	}
	public void setReplyCount(Integer replyCount) {
		this.replyCount = replyCount;
	}
	
}
