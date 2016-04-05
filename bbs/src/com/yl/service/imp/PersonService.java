package com.yl.service.imp;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.util.List;

import org.apache.struts.upload.FormFile;

import com.yl.domain.Person;
import com.yl.domain.Post;
import com.yl.service.inter.PersonServiceInter;
import com.yl.util.NameUtils;


public class PersonService extends BaseService implements PersonServiceInter{

	public Person checkPerson(Person person){
		String hql = "from Person where id=? and password=?";
		String[] parameters = {person.getId()+"",person.getPassword()};
		
		Person personf = (Person) this.excuteQueryUnique(hql, parameters);
		
		if(personf != null){
			return personf;
		}else{
			return null;
		}	
	}
	
	public List<Post> getPostByPersonId(Serializable id) {
		String hql = "from Post where author_id=? order by id desc limit 3";
		String[] parameters = {id+""};
		List<Post> posts = this.excuteQuery(hql, parameters);
		
		return posts;
	}
	
	public String uploadingPhoto(FormFile myPhoto,String keepPath) throws FileNotFoundException, IOException{
		
		String fileName = myPhoto.getFileName();
		InputStream is = myPhoto.getInputStream();
		NameUtils nameUtil = new NameUtils();//改名用的
		String newName = nameUtil.changeName(fileName);
		String realPath = keepPath+"\\"+newName;
		OutputStream os = new FileOutputStream(realPath);
		
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
		return newName;
	}
}
