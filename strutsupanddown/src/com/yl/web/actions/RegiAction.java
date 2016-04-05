package com.yl.web.actions;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.*;
import org.apache.struts.upload.FormFile;

import cim.yl.utils.NameUtils;

import com.yl.domain.Regi;
import com.yl.service.RegiService;
import com.yl.web.forms.UserForm;

public class RegiAction extends Action{
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		UserForm userForm = (UserForm) form;
		
		String name = userForm.getUsername();
		FormFile myPhoto = userForm.getMyPhoto();
		String fileName = myPhoto.getFileName();
		System.out.println(myPhoto.getFileName()+" "+myPhoto.getFileSize());
		
		InputStream is = myPhoto.getInputStream();
		String keepPath = this.getServlet().getServletContext().getRealPath("/file");
		NameUtils nameUtil = new NameUtils();
		String newName = nameUtil.changeName(fileName);
		String realPath = keepPath+"\\"+newName;
		OutputStream os = new FileOutputStream(realPath);
		System.out.println(realPath);
		byte[] bytes = new byte[1024];
		int len;
		try{
			while((len=is.read(bytes))>0){
				os.write(bytes, 0, len);
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			os.close();
			is.close();
			
		}
		Regi user = new Regi();
		user.setName(name);
		user.setOldpName(fileName);
		user.setNewpName(newName);
		if(RegiService.add(user)){
			return mapping.findForward("ok");
		}else{
			return mapping.findForward("err");
		}
	}
}
