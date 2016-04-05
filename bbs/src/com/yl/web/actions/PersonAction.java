package com.yl.web.actions;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;
import org.apache.struts.upload.FormFile;

import com.yl.domain.Person;
import com.yl.domain.Post;
import com.yl.service.inter.PersonServiceInter;
import com.yl.web.forms.PersonForm;

public class PersonAction extends DispatchAction {
	PersonServiceInter psi;

	public void setPsi(PersonServiceInter psi) {
		this.psi = psi;
	}

	public ActionForward gotoRegisterUi(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		return mapping.findForward("gotoRegisterUi");
	}

	public ActionForward register(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		PersonForm personForm = (PersonForm) form;
		Person person = new Person();
		person.setName(personForm.getName());
		person.setEmail(personForm.getEmail());
		person.setPassword(personForm.getPassword());
		person.setDateLLastActived(new Date());

		try {
			psi.save(person);
		} catch (Exception e) {
			e.printStackTrace();
			return mapping.findForward("err");
		}
		request.getSession().setAttribute("user", person);
		return mapping.findForward("ok");
	}

	public ActionForward gotoShowUserUi(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String idget = request.getParameter("userid");
		Person user = (Person) request.getSession().getAttribute("user");
		Integer id = user.getId();
		if (idget != null && !idget.equals(id+"")){
			Person person = (Person) psi.findById(Person.class, Integer.parseInt(idget));
			request.setAttribute("person", person);
			request.setAttribute("isSelf", "false");
			List<Post> posts = psi.getPostByPersonId(idget);
			request.setAttribute("posts", posts);
			} else {
				request.setAttribute("person", user);
				request.setAttribute("isSelf", "true");
				List<Post> posts = psi.getPostByPersonId(id);
				request.setAttribute("posts", posts);
			}
		

		return mapping.findForward("gotoShowUserUi");
	}


	public ActionForward gotoChangeUserUi(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		return mapping.findForward("gotoChangeUserUi");
	}

	public ActionForward change(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		PersonForm personForm = (PersonForm) form;
		Person oldPerson = (Person) request.getSession().getAttribute("user");
		Integer id = oldPerson.getId();
		Person newPerson = (Person) psi.findById(Person.class, id);
		newPerson.setAge(personForm.getAge());
		newPerson.setEmail(personForm.getEmail());
		newPerson.setSex(personForm.getSex());

		if (personForm.getMyPhoto() != null
				&& personForm.getMyPhoto().getFileSize() != 0) {// 注意如果未上传头像该怎么做
			FormFile myPhoto = personForm.getMyPhoto();
			String keepPath = request.getSession().getServletContext()
					.getRealPath("/photo");
			try {
				String newName = psi.uploadingPhoto(myPhoto, keepPath);
				newPerson.setPhotoName(newName);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		try {
			psi.executeUpdate(newPerson);
			request.getSession().setAttribute("user", newPerson);
		} catch (Exception e) {
			e.printStackTrace();
			return mapping.findForward("err");
		}

		return mapping.findForward("ok");
	}
}
