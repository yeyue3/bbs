package com.yl.domain;

import java.util.Set;

public class Board {
	private Integer id;
	private Category category;//��������,ManyToOne
	private String name;
	private String description;
	private Integer postCount;
	private Integer replyCount;
	
	private Reply lastReply;//����������һ��һ�ɣ�����˵�������һ���������ڲ�ͬ�İ����ϣ���һ��һ�ɡ��Ժ󻹿���Ūһ�����ʮ���ģ�����ʮ���ģ���֪����������ͷ��˵��
	private Post lastPost;//��󷢱�,ͬ��
	private Set<Person> administrators;//������
	private Set<Post> posts;//���е�����
	
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
