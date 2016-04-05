package com.yl.web.actions;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

import com.yl.domain.Board;
import com.yl.domain.Category;
import com.yl.service.inter.CategoryServiceInter;

public class CategoryAction extends DispatchAction {
	private CategoryServiceInter csi;

	public void setCsi(CategoryServiceInter csi) {
		this.csi = csi;
	}
	
	public ActionForward gotoShowCateUi(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		Integer id = Integer.parseInt(request.getParameter("id"));
		Category cate = (Category) csi.findById(Category.class, id);
		List<Board> boards = csi.getBoardByCateId(cate.getId());
		
		request.setAttribute("cate", cate);
		request.setAttribute("boards", boards);
		return mapping.findForward("gotoShowCateUi");
	}
}
