package com.yl.web.actions;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

import com.yl.domain.Board;
import com.yl.domain.Category;
import com.yl.domain.Post;
import com.yl.service.inter.BoardServiceInter;

public class BoardAction extends DispatchAction{
	
	BoardServiceInter bsi;
	
	public void setBsi(BoardServiceInter bsi) {
		this.bsi = bsi;
	}
	
	public ActionForward gotoShowBoardUi(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String id = request.getParameter("id");
		Board board = (Board) bsi.findById(Board.class, Integer.parseInt(id));

		
		int pageSize = 2;
		int postCount = board.getPostCount();
		String pageNows = request.getParameter("pageNow");
		int pageNow = pageNows==null ? 1 : Integer.parseInt(pageNows);
		int pageCount = (postCount-1)/pageSize + 1;
		
		List<Post> posts = bsi.queryPostByPage(id, pageSize, pageNow);
		
		request.setAttribute("board",board);
		request.setAttribute("posts",posts);
		request.setAttribute("pageCount",pageCount);
		request.setAttribute("pageNow",pageNow);
		
		return mapping.findForward("gotoShowBoardUi");
	}
	
}
