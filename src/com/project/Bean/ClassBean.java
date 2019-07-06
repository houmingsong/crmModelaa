package com.project.Bean;

import java.sql.Date;
/**
 * 班级类
 * @author Administrator
 *
 */
public class ClassBean {
	
	/**班级编号*/
	private int id;
	/**班级名称*/
	private String className;
	/**开班时间*/
	private Date classTime=new Date(System.currentTimeMillis());;
	/**带班老师*/
	private String teacher;
	/**班级人数*/
	private int studentAmount;
	/**学校ID*/
	private int schoolId;
	
	public ClassBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getClassName() {
		return className;
	}
	public void setClassName(String className) {
		this.className = className;
	}
	public Date getClassTime() {
		return classTime;
	}
	public void setClassTime(Date classTime) {
		this.classTime = classTime;
	}
	
	public String getTeacher() {
		return teacher;
	}
	public void setTeacher(String teacher) {
		this.teacher = teacher;
	}
	public int getSchoolId() {
		return schoolId;
	}
	public void setSchoolId(int schoolId) {
		this.schoolId = schoolId;
	}
	public ClassBean(String className, Date classTime, String teacher, int schoolId) {
		super();
		this.className = className;
		this.classTime = classTime;
		this.teacher = teacher;
		this.schoolId = schoolId;
	}
	public int getStudentAmount() {
		return studentAmount;
	}
	public void setStudentAmount(int studentAmount) {
		this.studentAmount = studentAmount;
	}
	@Override
	public String toString() {
		return  className;
	}
	

	
	
	
	
}
