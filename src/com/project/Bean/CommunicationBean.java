package com.project.Bean;

import java.sql.Date;
/**
 * 沟通记录类
 * @author Administrator
 *
 */
public class CommunicationBean {
	/**沟通记录编号*/
	private int id;
	/**学校ID*/
	private int schoolID;
	/**沟通时间*/
	private Date cTime;
	/**学校联系人*/
	private String schoolLinked;
	/**学校联系人职务*/
	private String job;
	/**沟通人（员工）ID*/
	private int employeeID;
	/**沟通内容*/
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
