package com.yl.domain;

import java.util.Set;

public class Board {
	private Integer id;
	private Category category;//所属版面,ManyToOne
	private String name;
	private String description;
	private Integer postCount;
	private Integer replyCount;
	
	private Reply lastReply;//最后回帖，是一对一吧，还是说他打算把一个东西发在不同的版面上，先一对一吧。以后还可以弄一个最后十个的，最热十个的，像知行那样，回头再说把
	private Post lastPost;//最后发表,同上
	private Set<Person> administrators;//版主们
	private Set<Post> posts;//所有的帖子
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
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
	public Reply getLastReply() {
		return lastReply;
	}
	public void setLastReply(Reply lastReply) {
		this.lastReply = lastReply;
	}
	public Post getLastPost() {
		return lastPost;
	}
	public void setLastPost(Post lastPost) {
		this.lastPost = lastPost;
	}
	public Set<Person> getAdministrators() {
		return administrators;
	}
	public void setAdministrators(Set<Person> administrators) {
		this.administrators = administrators;
	}
	public Set<Post> getPosts() {
		return posts;
	}
	public void setPosts(Set<Post> posts) {
		this.posts = posts;
	}
	
	
}
