package com.yl.service.inter;

import java.io.Serializable;
import java.util.List;

import com.yl.domain.Board;
import com.yl.domain.Category;
import com.yl.domain.Post;
import com.yl.domain.Reply;

public interface BaseInter {
	//通过cate编号获得Board
	public List<Board> getBoardByCateId(Serializable id);
	//通过board编号获得post
	public List<Post> getPostByBoardId(Serializable id);
	//通过post编号获得Reply
	public List<Reply> getReplyByPostId(Serializable id);
	
	
	//查询所有的Board
	public List<Board> queryAllBoard();	
	//查询所有的Category
	public List<Category> queryAllCate();
	
	
	// 添加对象
	public void save(Object obj);
	// 删除对象
	public void delete(Object obj);
	// 根据id删除对象
	public void deleteById(Class clazz, Serializable id);
	//修改对象
	public void executeUpdate(Object obj);
	// 根据id查找对象
	public Object findById(Class clazz, Serializable id);
	// 列出所有对象
	public List queryAll(String hql);
	// 通过hql语句查询
	public List excuteQuery(String hql, String[] parameters);
	//用hql查找单个对象
	public Object excuteQueryUnique(String hql, String[] parameters);
	// 通过hql分页查询
	public List executeQueryByPage(String hql, String[] parameters,int pageSize, int pageNow);
	
}
