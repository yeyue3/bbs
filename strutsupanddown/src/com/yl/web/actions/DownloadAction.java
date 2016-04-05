package com.yl.web.actions;

import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.yl.domain.Regi;
import com.yl.service.UserList;

public class DownloadAction extends Action {
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		String userName = request.getParameter("user");
		System.out.println(userName);
		Regi user = UserList.getUser(userName);

		String pname = user.getNewpName();
		String photo = java.net.URLEncoder.encode(user.getOldpName(),"utf-8");
		response.setHeader("Content-Disposition", "attachment;filename="+photo);
		String realPath = this.getServlet().getServletContext().getRealPath(
				"file");
		String fullPath = realPath + "\\" + pname;
		InputStream is = new FileInputStream(fullPath);
		OutputStream os = response.getOutputStream();
		try {
			byte[] bytes = new byte[1024];
			int len;
			while ((len = is.read(bytes)) > 0) {
				os.write(bytes, 0, len);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			is.close();
			os.close();
		}
		return null;
	}
}
