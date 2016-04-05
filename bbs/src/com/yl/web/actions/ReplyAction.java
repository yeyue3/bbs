package com.yl.web.actions;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

import com.yl.domain.Board;
import com.yl.domain.Person;
import com.yl.domain.Post;
import com.yl.domain.Reply;
import com.yl.service.inter.ReplyServiceInter;
import com.yl.web.forms.ReplyForm;

public class ReplyAction extends DispatchAction {
	ReplyServiceInter rsi;

	public void setRsi(ReplyServiceInter rsi) {
		this.rsi = rsi;
	}
	
	public ActionForward addReply(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		ReplyForm replyForm = (ReplyForm) form;
		Reply reply = new Reply();
		Person person = (Person) request.getSession().getAttribute("user");
		Person sqlperson = (Person) rsi.findById(Person.class,person.getId());
		reply.setAuthor(sqlperson);
		reply.setContent(replyForm.getContent());
		
		String id = request.getAttribute("post_id").toString();
		Post sqlpost = (Post) rsi.findById(Post.class, Integer.parseInt(id));
		Integer oldFloor = sqlpost.getReplyCount();
		//设置几楼和回复数
		if(oldFloor == null){
			sqlpost.setReplyCount(1);
			reply.setFloor(2);
		}else{
			sqlpost.setReplyCount(++oldFloor);
			reply.setFloor(oldFloor+1);
		}	
		reply.setPost(sqlpost);
		
		try{
			//设置因回复改变的别的东西
			sqlpost.setLastReplied(sqlperson);
	
			sqlperson.setReplyCount(sqlperson.getReplyCount()==null ? 1:sqlperson.getReplyCount()+1);
			//board
			Board sqlboard = (Board) rsi.findById(Board.class, sqlpost.getBoard().getId());
			sqlboard.setReplyCount(sqlboard.getReplyCount()==null ? 1 :sqlboard.getReplyCount()+1);
			sqlboard.setLastReply(reply);
			rsi.save(reply);
			
		}catch(Exception e){
			e.printStackTrace();
			return mapping.findForward("err");
		}
		request.setAttribute("reply_id", reply.getId());
		request.setAttribute("post_id", id);
		return mapping.findForward("showAfterReply");
	}
	
	public ActionForward gotoChangReplyUi(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String id = request.getParameter("reply");
		Reply reply =(Reply) rsi.findById(Reply.class, Integer.parseInt(id));
		request.setAttribute("reply", reply);
		System.out.println("here"+reply.getContent());
		return mapping.findForward("gotoChangeReplyUi");
	}
	
	public ActionForward change(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		ReplyForm replyForm = (ReplyForm) form;
		String id = request.getParameter("id");
		Reply reply =  (Reply) rsi.findById(Reply.class, Integer.parseInt(id));
		reply.setContent(replyForm.getContent());
		
		try{
			rsi.executeUpdate(reply);
		}catch(Exception e){
			e.printStackTrace();
			return mapping.findForward("err");
		}
		
		return mapping.findForward("ok");
	}
}
