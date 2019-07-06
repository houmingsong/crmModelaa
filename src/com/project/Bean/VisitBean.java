package com.project.Bean;

import java.sql.Date;
/**
 * 回访记录类
 * @author Administrator
 *
 */
public class VisitBean {
	/**回访记录编号*/
	private int id;
	/**学生ID*/
	private int studentID;
	/**回访时间*/
	private Date visitTime;
	/**负责人*/
	private String employee;
	/**回访人（学生家长）*/
	private String patriarch;
	/**回访内容*/
	private String details;
	/**回访主题*/
	private String theme;
	
	
	public VisitBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	public VisitBean(int studentID, Date visitTime, String employee, String patriarch, String details, String theme) {
		super();
		this.studentID = studentID;
		this.visitTime = visitTime;
		this.employee = employee;
		this.patriarch = patriarch;
		this.details = details;
		this.theme = theme;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getStudentID() {
		return studentID;
	}
	public void setStudentID(int studentID) {
		this.studentID = studentID;
	}
	public Date getVisitTime() {
		return visitTime;
	}
	public void setVisitTime(Date visitTime) {
		this.visitTime = visitTime;
	}
	public String getEmployee() {
		return employee;
	}
	public void setEmployee(String employee) {
		this.employee = employee;
	}
	public String getPatriarch() {
		return patriarch;
	}
	public void setPatriarch(String patriarch) {
		this.patriarch = patriarch;
	}
	public String getDetails() {
		return details;
	}
	public void setDetails(String details) {
		this.details = details;
	}
	public String getTheme() {
		return theme;
	}
	public void setTheme(String theme) {
		this.theme = theme;
	}
	@Override
	public String toString() {
		return "VisitBean [id=" + id + ", studentID=" + studentID + ", visitTime=" + visitTime + ", employee="
				+ employee + ", patriarch=" + patriarch + ", details=" + details + ", theme=" + theme + "]";
	}
	
	
	
	
	
	
	
	
}
