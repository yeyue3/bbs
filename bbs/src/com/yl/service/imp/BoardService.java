package com.yl.service.imp;


import java.io.Serializable;
import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.yl.domain.Post;
import com.yl.service.inter.BoardServiceInter;

@Transactional
public class BoardService extends BaseService implements BoardServiceInter{
	
	public List<Post> queryPostByPage(Serializable id,int pageSize, int pageNow){
		String hql = "from Post where board_id = ?";
		String[] parameters = {id+""};
		List<Post> posts = this.executeQueryByPage(hql, parameters, pageSize, pageNow);
		return posts;
	}
	
	
}
