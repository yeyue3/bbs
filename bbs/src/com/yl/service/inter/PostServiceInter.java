package com.yl.service.inter;

import java.io.Serializable;
import java.util.List;

import com.yl.domain.Reply;


public interface PostServiceInter extends BaseInter{
	public List<Reply> queryReplyByPage(Serializable id,int pageSize, int pageNow);
}
