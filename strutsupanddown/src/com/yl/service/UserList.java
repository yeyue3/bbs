package com.yl.service;

import java.util.ArrayList;

import com.yl.domain.Regi;

import cim.yl.utils.SqlHelper;

public class UserList {
	public static ArrayList display(){
		String sql = "select * from regi";
		ArrayList al = SqlHelper.executeQuery2(sql, null);
		ArrayList<Regi> al2 = new ArrayList<Regi>();
		for(int i = 0; i < al.size(); i++){
			Regi user = new Regi();
			Object[] obj = (Object[]) al.get(i);
			user.setName((String) obj[0]);
			user.setOldpName((String) obj[1]);
			user.setNewpName((String) obj[2]);
			
			al2.add(user);
		}
		return al2;
	}
	
	public static Regi getUser(String name){
		String sql = "select * from regi where name=?";
		String[] parameter = {name};
		
		ArrayList al= SqlHelper.executeQuery2(sql, parameter);
		
		Object[] obj = (Object[]) al.get(0);
		Regi user = new Regi();
		
		user.setName((String) obj[0]);
		user.setOldpName((String) obj[1]);
		user.setNewpName((String) obj[2]);
		
		return user;
	}
}
