package com.project.Bean;

import java.sql.Date;
/**
 * ������
 * @author Administrator
 *
 */
public class DepartmentBean {
	/**���ű��*/
	private int id;
	/**��������*/
	private String department;
	/**���ų���ʱ��*/
	private Date dtime;
	/**��������*/
	private String departmentDescribe;
	
	
	public DepartmentBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	public DepartmentBean(String department, Date dtime, String departmentDescribe) {
		super();
		this.department = department;
		this.dtime = dtime;
		this.departmentDescribe = departmentDescribe;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public Date getDtime() {
		return dtime;
	}
	public void setDtime(Date dtime) {
		this.dtime = dtime;
	}
	public String getDepartmentDescribe() {
		return departmentDescribe;
	}
	public void setDepartmentDescribe(String departmentDescribe) {
		this.departmentDescribe = departmentDescribe;
	}
	@Override
	public String toString() {
		return department;
	
	}
	
	
}
