package com.project.Bean;
/**
 * ������
 * @author Administrator
 *
 */

import java.util.List;

public class CityBean {
	/**���б��*/
	private int id;
	/**������*/
	private String city;
	/**�ó����У�״̬Ϊ�ƹ㿪չ��ѧУ*/
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
