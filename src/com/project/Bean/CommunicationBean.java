package com.project.Bean;

import java.sql.Date;
/**
 * ��ͨ��¼��
 * @author Administrator
 *
 */
public class CommunicationBean {
	/**��ͨ��¼���*/
	private int id;
	/**ѧУID*/
	private int schoolID;
	/**��ͨʱ��*/
	private Date cTime;
	/**ѧУ��ϵ��*/
	private String schoolLinked;
	/**ѧУ��ϵ��ְ��*/
	private String job;
	/**��ͨ�ˣ�Ա����ID*/
	private int employeeID;
	/**��ͨ����*/
	private String details;
	
	
	
	public CommunicationBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	public CommunicationBean(int schoolID, Date cTime, String schoolLinked, String job, int employeeID,
			String details) {
		super();
		this.schoolID = schoolID;
		this.cTime = cTime;
		this.schoolLinked = schoolLinked;
		this.job = job;
		this.employeeID = employeeID;
		this.details = details;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getSchoolID() {
		return schoolID;
	}
	public void setSchoolID(int schoolID) {
		this.schoolID = schoolID;
	}
	public Date getcTime() {
		return cTime;
	}
	public void setcTime(Date cTime) {
		this.cTime = cTime;
	}
	public String getSchoolLinked() {
		return schoolLinked;
	}
	public void setSchoolLinked(String schoolLinked) {
		this.schoolLinked = schoolLinked;
	}
	public String getjob() {
		return job;
	}
	public void setjob(String job) {
		this.job = job;
	}
	public int getEmployeeID() {
		return employeeID;
	}
	public void setEmployeeID(int employeeID) {
		this.employeeID = employeeID;
	}
	public String getDetails() {
		return details;
	}
	public void setDetails(String details) {
		this.details = details;
	}
	@Override
	public String toString() {
		return "CommunicationBean [id=" + id + ", schoolID=" + schoolID + ", cTime=" + cTime + ", schoolLinked="
				+ schoolLinked + ", sjob=" + job + ", employeeID=" + employeeID + ", details=" + details + "]";
	}
	
	
	
	
}
