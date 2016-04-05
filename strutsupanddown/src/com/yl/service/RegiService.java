package com.yl.service;

import cim.yl.utils.SqlHelper;

import com.yl.domain.Regi;

public class RegiService {
	public static boolean add(Regi user){
		boolean res = true;
		String sql = "insert into regi values (?,?,?)";
		String[] parameter = {user.getName(),user.getOldpName(),user.getNewpName()};
		
		try{
			SqlHelper.executeUpdate(sql, parameter);
		}catch(Exception e){
			res = false;
		}
		return res;
		
	}
}
