package com.yl.web.actions;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

import com.yl.domain.Board;
import com.yl.domain.Category;
import com.yl.domain.Person;
import com.yl.domain.Post;
import com.yl.domain.Reply;
import com.yl.service.inter.PostServiceInter;
import com.yl.web.forms.PostForm;

public class PostAction extends DispatchAction {
	PostServiceInter psi;

	public void setPsi(PostServiceInter psi) {
		this.psi = psi;
	}

	// 展示某个id的帖子
	public ActionForward gotoShowPostUi(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		String id = request.getParameter("id");
		if(id==null){
			id = request.getAttribute("id").toString();
		}
		Post post = (Post) psi.findById(Post.class, Integer.parseInt(id));
		post.setHit(post.getHit()==null ? 1 : post.getHit()+1);
		
		int pageSize = 10;
		int postCount = post.getReplyCount();
		String pageNows = request.getParameter("pageNow");
		int pageNow = pageNows==null ? 1 : Integer.parseInt(pageNows);
		int pageCount = (postCount-1)/pageSize + 1;
		
		List<Reply> replys =psi.queryReplyByPage(id, pageSize, pageNow);

		request.setAttribute("post", post);
		request.setAttribute("replys", replys);
		request.setAttribute("pageCount", pageCount);
		request.setAttribute("pageNow", pageNow);
		return mapping.findForward("gotoShowPostUi");
	}
	
	public ActionForward showAfterReply(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String post_id = request.getAttribute("post_id").toString();
		String reply_id = request.getAttribute("reply_id").toString();
		Post post = (Post) psi.findById(Post.class, Integer.parseInt(post_id));
		
		int pageSize = 10;
		int postCount = post.getReplyCount();
		int pageCount = (postCount-1)/pageSize + 1;
		int pageNow = pageCount;
		
		List<Reply> replys =psi.queryReplyByPage(post_id, pageSize, pageNow);
		
		request.setAttribute("post", post);
		request.setAttribute("replys", replys);
		request.setAttribute("pageCount", pageCount);
		request.setAttribute("pageNow", pageNow);
		request.setAttribute("new_reply",reply_id );
		return mapping.findForward("showAfterReply");
	}
	
	// 去选择帖子所属category
	public ActionForward gotoCateChooseUi(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		List<Category> categorys = psi.queryAllCate();
		request.setAttribute("categorys", categorys);

		return mapping.findForward("gotoCateChooseUi");
	}

	// 去发帖界面
	public ActionForward gotoAddPostUi(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String id = request.getParameter("cate");
		List<Board> boards = psi.getBoardByCateId(id);
		request.setAttribute("boards", boards);

		return mapping.findForward("gotoAddPostUi");
	}

	// 发帖操作
	public ActionForward addPost(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		PostForm postForm = (PostForm) form;
		Post post = new Post();

		Person person = (Person) request.getSession().getAttribute("user");
		Person sqlperson = (Person) psi.findById(Person.class, person.getId());
		post.setAuthor(sqlperson);
		post.setLastReplied(sqlperson);
		int board_id = postForm.getBoard_id();
		Board sqlboard = (Board) psi.findById(Board.class, board_id);
		post.setBoard(sqlboard);
		post.setContent(postForm.getContent());
		post.setDateLastReplied(new Date());
		post.setHit(0);
		post.setReplyCount(0);
		post.setTitle(postForm.getTitle());
		post.setTopped("0");
		post.setReadonly("0");
		post.setPostTime(new Date());
		try {
			sqlperson.setPostCount(sqlperson.getPostCount()==null ? 1 : sqlperson.getPostCount()+1);
			sqlboard.setLastPost(post);
			sqlboard.setPostCount(sqlboard.getPostCount()==null ? 1 : sqlboard.getPostCount()+1);
			psi.save(post);
		} catch (Exception e) {
			e.printStackTrace();
			return mapping.findForward("err");
		}
		System.out.println(post.getId());
		request.setAttribute("id", post.getId());
		return mapping.findForward("showAfterAddPost");
	}

	// 去修改帖子界面
	public ActionForward gotoChangePostUi(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		String id = request.getParameter("post");
		Post post = (Post) psi.findById(Post.class, Integer.parseInt(id));
		request.setAttribute("post", post);

		return mapping.findForward("gotoChangePostUi");
	}

	// 修改帖子
	public ActionForward change(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		PostForm postForm = (PostForm) form;
		String id = request.getParameter("id");
		Post post = (Post) psi.findById(Post.class, Integer.parseInt(id));
		post.setContent(postForm.getContent());
		post.setTitle(postForm.getTitle());

		try {
			psi.executeUpdate(post);
		} catch (Exception e) {
			e.printStackTrace();
			return mapping.findForward("err");
		}

		return mapping.findForward("ok");
	}
}
