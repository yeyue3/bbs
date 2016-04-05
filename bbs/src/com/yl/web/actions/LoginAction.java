package com.yl.web.actions;

import java.util.Date;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

import com.yl.domain.Board;
import com.yl.domain.Person;
import com.yl.service.inter.PersonServiceInter;
import com.yl.web.forms.PersonForm;

public class LoginAction extends DispatchAction {
	PersonServiceInter psi;

	public void setPsi(PersonServiceInter psi) {
		this.psi = psi;
	}

	public ActionForward checkLogin(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		if (request.getSession().getAttribute("user") == null) {
			return mapping.findForward("gotoLoginUi");
		} else {
			String operate = request.getParameter("operate");
			if ("post".equals(operate)) {
				String board_id = request.getParameter("board_id");
				if (board_id == null) {
					return mapping.findForward("gotoCateChooseAc");
				} else {
					Board board = (Board) psi.findById(Board.class, Integer.parseInt(board_id));
					request.setAttribute("board", board);
					return mapping.findForward("gotoAddPostUi");
				}
			} else {// 这里reply时也要验证，再想想怎么实现和知行差不多的功能
				String post_id = request.getParameter("post_id");
				request.setAttribute("post_id", post_id);
				return mapping.findForward("gotoaddReply");
			}

		}
	}

	public ActionForward gotoLoginUi(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		return mapping.findForward("gotoLoginUi");
	}

	public ActionForward loginCheck(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		PersonForm personForm = (PersonForm) form;
		Person person = new Person();
		person.setId(personForm.getId());
		person.setPassword(personForm.getPassword());

		Person personf = psi.checkPerson(person);
		if (personf != null) {
			request.getSession().setAttribute("user", personf);
			personf.setDateLLastActived(new Date());
			if ("true".equals(personForm.getRember())) {
				Cookie id = new Cookie("id", personForm.getId() + "");
				id.setMaxAge(3600);
				response.addCookie(id);
				Cookie password = new Cookie("password", personForm
						.getPassword());
				password.setMaxAge(3600);
				response.addCookie(password);
			}
			return mapping.findForward("jumpAfterLogin");
		} else {
			return mapping.findForward("err");
		}
	}

	public ActionForward loginOut(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		request.getSession().invalidate();
		Cookie id = new Cookie("id", "");
		id.setMaxAge(0);
		response.addCookie(id);
		Cookie password = new Cookie("password", "");
		password.setMaxAge(0);
		response.addCookie(password);

		return mapping.findForward("gotoMainUiAc");
	}
}
