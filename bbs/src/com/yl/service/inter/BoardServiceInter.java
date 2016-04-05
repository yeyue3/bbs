package com.yl.service.inter;

import java.io.Serializable;
import java.util.List;

import com.yl.domain.Post;


public interface BoardServiceInter extends BaseInter{
	public List<Post> queryPostByPage(Serializable id,int pageSize, int pageNow);
}
