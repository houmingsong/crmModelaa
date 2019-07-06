package com.project.util;

import java.sql.Date;

public class DateChange {
	
	public static Date getDate(String str){
		if(str!=null&&str.length()!=0){
			if(str.matches("\\d{4}-\\d{2}-\\d{2}")){
				return Date.valueOf(str);
			}
		}
		return null;
	}
}
