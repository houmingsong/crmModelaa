package com.lovo.test.bean;

import java.util.ArrayList;
import java.util.List;

public class CityBean {
	private int id;
	private String cityName;
	private List<SchoolBean> schoolList = new ArrayList<SchoolBean>();
	
	
	public CityBean(int id, String cityName) {
		super();
		this.id = id;
		this.cityName = cityName;
	}
	public CityBean() {
		super();
		// TODO 自动生成构造函数存根
	}
	public String getCityName() {
		return cityName;
	}
	public void setCityName(String cityName) {
		this.cityName = cityName;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public List<SchoolBean> getSchoolList() {
		return schoolList;
	}
	public void setSchoolList(List<SchoolBean> schoolList) {
		this.schoolList = schoolList;
	}
	public String toString(){
		return this.cityName;
	}
}
