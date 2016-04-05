package com.yl.service.imp;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

import com.yl.domain.Board;
import com.yl.domain.Category;
import com.yl.domain.Post;
import com.yl.domain.Reply;
import com.yl.service.inter.BaseInter;

@Transactional
public class BaseService implements BaseInter{
	//我不知道为什么这里用下面那种方法写调用方法时会报空指针的错，set方法明明进入了，半天都没看出来，暂时这样，回头再看
	//public static final  IDao idao = (IDao) new ClassPathXmlApplicationContext("applicationContext.xml").getBean("hibernateUtil");
	//public static final  SessionFactory sessionFactory = (SessionFactory) new ClassPathXmlApplicationContext("applicationContext.xml").getBean("sessionFactory");
	/*
	 * 终于搞对了，子类对象在被初始化时，由于没指定它具体的parent对象，
	 * 会在初始化时，调用super()构造一个父类对象，而这个父类并没有被set注入，所以会报空。
	 */
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	//通过cate编号获得Board
	public List<Board> getBoardByCateId(Serializable id) {
		String hql = "from Board where cate_id=?";
		String[] parameters = {id+""};
		List<Board> boards = this.excuteQuery(hql, parameters);
		
		return boards;
	}
	//通过board编号获得post
	public List<Post> getPostByBoardId(Serializable id) {
		String hql = "from Post where board=?";
		String[] parameters = {id+""};
		List<Post> posts = this.excuteQuery(hql, parameters);
		
		return posts;
	}
	//通过post编号获得Reply
	public List<Reply> getReplyByPostId(Serializable id) {
		String hql = "from Reply where post_id=?";
		String[] parameters = {id+""};
		List<Reply> posts = this.excuteQuery(hql, parameters);
		
		return posts;
	}
	
	//查询所有的Board
	public List<Board> queryAllBoard(){
		String hql="from Board order by id asc";
		List<Board> lists = this.queryAll(hql);
		
		return lists;
	}
	//查询所有的Category
	public List<Category> queryAllCate(){
		System.out.println("aaaaa");
		String hql="from Category order by id asc";
		List<Category> lists = this.queryAll(hql);
		
		return lists;
	}
	
	
	// 添加对象
	public void save(Object obj) {
		sessionFactory.getCurrentSession().save(obj);
	}
	// 删除对象
	public void delete(Object obj) {
		sessionFactory.getCurrentSession().delete(obj);
	}
	// 根据id删除对象
	public void deleteById(Class clazz, Serializable id) {
		Object obj = this.findById(clazz, id);
		delete(obj);
	}
	//修改对象
	public void executeUpdate(Object obj){
		sessionFactory.getCurrentSession().update(obj);		
	}
	// 根据id查找对象
	public Object findById(Class clazz, Serializable id) {
		Session s = sessionFactory.getCurrentSession();
		Object obj = s.get(clazz, id);
		return obj;
	}	

	// 列出所有对象
	public List queryAll(String hql) {
		Session s = sessionFactory.getCurrentSession();
		List list = s.createQuery(hql).list();
		return list;
	}
	// 通过hql语句查询
	public List excuteQuery(String hql, String[] parameters) {
		Session s = sessionFactory.getCurrentSession();
		Query query = s.createQuery(hql);
		if (parameters != null && parameters.length > 0) {
			for (int i = 0; i < parameters.length; i++) {
				query.setString(i, parameters[i]);
			}
		}
		List list = query.list();
		
		return list;
	}
	//用hql查找单个对象
	public Object excuteQueryUnique(String hql, String[] parameters) {
		Session s = sessionFactory.getCurrentSession();
		Query query = s.createQuery(hql);
		if (parameters != null && parameters.length > 0) {
			for (int i = 0; i < parameters.length; i++) {
				query.setString(i, parameters[i]);
			}
		}
		Object obj = query.uniqueResult();
		
		return obj;
	}
	// 通过hql分页查询
	public List executeQueryByPage(String hql, String[] parameters,
			int pageSize, int pageNow) {

		Session s = sessionFactory.getCurrentSession();
		Query query = s.createQuery(hql);
		if (parameters != null && parameters.length > 0) {
			for (int i = 0; i < parameters.length; i++) {
				query.setString(i, parameters[i]);
			}
		}
		query.setFirstResult((pageNow - 1) * pageSize).setMaxResults(pageSize);

		List list = query.list();

		return list;
	}
}
