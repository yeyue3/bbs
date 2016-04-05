package com.yl.service.inter;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Serializable;
import java.util.List;

import org.apache.struts.upload.FormFile;

import com.yl.domain.Person;
import com.yl.domain.Post;

public interface PersonServiceInter extends BaseInter{
	public Person checkPerson(Person person);
	//ͨ��person��Ż�ȡpost
	public List<Post> getPostByPersonId(Serializable id);
	//�ϴ��ļ�
	public String uploadingPhoto(FormFile myPhoto,String keepPath) throws FileNotFoundException, IOException;
}
