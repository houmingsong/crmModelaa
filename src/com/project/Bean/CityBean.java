package com.project.Bean;
/**
 * 城市类
 * @author Administrator
 *
 */

import java.util.List;

public class CityBean {
	/**城市编号*/
	private int id;
	/**城市名*/
	private String city;
	/**该城市中，状态为推广开展的学校*/
	private List<SchoolBean> schoolList;
	
	
	
	public CityBean() {
		super();
		// TODO Auto-generated constructor stub
	}



	public CityBean(String city, List<SchoolBean> schoolList) {
		super();
		this.city = city;
		this.schoolList = schoolList;
	}



	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public String getCity() {
		return city;
	}



	public void setCity(String city) {
		this.city = city;
	}



	public List<SchoolBean> getSchoolList() {
		return schoolList;
	}



	public void setSchoolList(List<SchoolBean> schoolList) {
		this.schoolList = schoolList;
	}



	@Override
	public String toString() {
		return city;
	}
	
	
}
