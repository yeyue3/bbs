package com.yl.service.inter;

import java.io.Serializable;
import java.util.List;

import com.yl.domain.Board;
import com.yl.domain.Category;
import com.yl.domain.Post;
import com.yl.domain.Reply;

public interface BaseInter {
	//ͨ��cate��Ż��Board
	public List<Board> getBoardByCateId(Serializable id);
	//ͨ��board��Ż��post
	public List<Post> getPostByBoardId(Serializable id);
	//ͨ��post��Ż��Reply
	public List<Reply> getReplyByPostId(Serializable id);
	
	
	//��ѯ���е�Board
	public List<Board> queryAllBoard();	
	//��ѯ���е�Category
	public List<Category> queryAllCate();
	
	
	// ��Ӷ���
	public void save(Object obj);
	// ɾ������
	public void delete(Object obj);
	// ����idɾ������
	public void deleteById(Class clazz, Serializable id);
	//�޸Ķ���
	public void executeUpdate(Object obj);
	// ����id���Ҷ���
	public Object findById(Class clazz, Serializable id);
	// �г����ж���
	public List queryAll(String hql);
	// ͨ��hql����ѯ
	public List excuteQuery(String hql, String[] parameters);
	//��hql���ҵ�������
	public Object excuteQueryUnique(String hql, String[] parameters);
	// ͨ��hql��ҳ��ѯ
	public List executeQueryByPage(String hql, String[] parameters,int pageSize, int pageNow);
	
}
