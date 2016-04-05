package cim.yl.utils;

import java.util.UUID;

public class NameUtils {
			public String changeName(String fileName){
				String randomName = UUID.randomUUID().toString();
				int i = fileName.lastIndexOf(".");
				String str = fileName.substring(i,fileName.length());
				randomName = randomName+str;
				System.out.println(randomName);
				return randomName;
			}
		
	

}
