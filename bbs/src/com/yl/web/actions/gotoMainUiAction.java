package com.yl.web.actions;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

import com.yl.domain.Board;
import com.yl.domain.Category;
import com.yl.domain.Person;
import com.yl.service.inter.BaseInter;

public class gotoMainUiAction extends DispatchAction {
	BaseInter bsi;

	public void setBsi(BaseInter bsi) {
		this.bsi = bsi;
	}

	public ActionForward gotoMainUi(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		if ("true".equals(request.getParameter("first"))){
			System.out.println("第一次使用");
			Cookie[] cookies = request.getCookies();
			String id = null;
			String password = null;
			for (int i = 0; cookies != null && i < cookies.length; i++) {
				if ("id".equals(cookies[i].getName())) {
					id = cookies[i].getValue();
				} else if ("password".equals(cookies[i].getName())) {
					password = cookies[i].getValue();
				}
			}
			if (id != null && password != null) {
				Person person = (Person) bsi.findById(Person.class, Integer
						.parseInt(id));
				request.getSession().setAttribute("user", person);
			}
		}

		List<Category> cates = bsi.queryAllCate();
		Map<Category,List<Board>> maps = new LinkedHashMap<Category,List<Board>>();
		if(cates!=null && cates.size()>0){
			for(int i=0; i<cates.size(); i++){
				Category cate = cates.get(i);
				int cate_id = cate.getId();
				List<Board> boards = bsi.getBoardByCateId(cate_id);
				maps.put(cate, boards);
			}
		}
		request.setAttribute("cate_board", maps);
		return mapping.findForward("gotoMainUi");
	}
}
