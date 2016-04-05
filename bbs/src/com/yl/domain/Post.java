package com.yl.domain;

import java.util.Date;
import java.util.Set;

public class Post {
	private Integer id;
	private String title;
	private String content;
	private Integer hit;
	private Date dateLastReplied;
	private String readonly;
	private String topped;
	private Integer replyCount;
	private Date postTime;
	
	private Board board;//所属版面
	private Person author;//发帖人
	private Person lastReplied;
	private Set<Reply> replys;//回帖
	
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
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
	public Integer getHit() {
		return hit;
	}
	public void setHit(Integer hit) {
		this.hit = hit;
	}
	public Date getDateLastReplied() {
		return dateLastReplied;
	}
	public void setDateLastReplied(Date dateLastReplied) {
		this.dateLastReplied = dateLastReplied;
	}
	
	
	public String getReadonly() {
		return readonly;
	}
	public void setReadonly(String readonly) {
		this.readonly = readonly;
	}
	public String getTopped() {
		return topped;
	}
	public void setTopped(String topped) {
		this.topped = topped;
	}
	public Integer getReplyCount() {
		return replyCount;
	}
	public void setReplyCount(Integer replyCount) {
		this.replyCount = replyCount;
	}
	public Board getBoard() {
		return board;
	}
	public void setBoard(Board board) {
		this.board = board;
	}
	public Person getAuthor() {
		return author;
	}
	public void setAuthor(Person author) {
		this.author = author;
	}
	public Person getLastReplied() {
		return lastReplied;
	}
	public void setLastReplied(Person lastReplied) {
		this.lastReplied = lastReplied;
	}
	public Set<Reply> getReplys() {
		return replys;
	}
	public void setReplys(Set<Reply> replys) {
		this.replys = replys;
	}
	public Date getPostTime() {
		return postTime;
	}
	public void setPostTime(Date postTime) {
		this.postTime = postTime;
	}
	
}
