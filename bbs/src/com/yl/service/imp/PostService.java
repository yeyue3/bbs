package com.yl.service.imp;

import java.io.Serializable;
import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.yl.domain.Reply;
import com.yl.service.inter.PostServiceInter;
@Transactional
public class PostService extends BaseService implements PostServiceInter{
	
	public List<Reply> queryReplyByPage(Serializable id,int pageSize, int pageNow){
		String hql = "from Reply where post_id = ?";
		String[] parameters = {id+""};
		List<Reply> replys = this.executeQueryByPage(hql, parameters, pageSize, pageNow);
		return replys;
	}
	
}
