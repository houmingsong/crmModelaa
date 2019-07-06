package com.project.Bean;

import java.sql.Date;
/**
 * 活动类
 * @author Administrator
 *
 */
public class ActivityBean {
	/**活动编号*/
	private int id;
	/**学校id*/
	private int schoolId;
	/**活动*/
	private String activity;
	/**时间*/
	private Date activityTime;
	/**地点*/
	private String place;
	/**主题*/
	private String theme;
	/**负责部门*/
	private String department;
	/**负责人*/
	private String employee;
	
	
	
	public ActivityBean(int schoolId, String activity, Date activityTime, String place, String theme, String department,
			String employee) {
		super();
		this.schoolId = schoolId;
		this.activity = activity;
		this.activityTime = activityTime;
		this.place = place;
		this.theme = theme;
		this.department = department;
		this.employee = employee;
	}
	public ActivityBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getSchoolId() {
		return schoolId;
	}
	public void setSchoolId(int schoolId) {
		this.schoolId = schoolId;
	}
	public String getActivity() {
		return activity;
	}
	public void setActivity(String activity) {
		this.activity = activity;
	}
	public Date getActivityTime() {
		return activityTime;
	}
	public void setActivityTime(Date activityTime) {
		this.activityTime = activityTime;
	}
	public String getPlace() {
		return place;
	}
	public void setPlace(String place) {
		this.place = place;
	}
	public String getTheme() {
		return theme;
	}
	public void setTheme(String theme) {
		this.theme = theme;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public String getEmployee() {
		return employee;
	}
	public void setEmployee(String employee) {
		this.employee = employee;
	}
	@Override
	public String toString() {
		return "ActivityBean [id=" + id + ", schoolId=" + schoolId + ", activity=" + activity + ", activityTime="
				+ activityTime + ", place=" + place + ", theme=" + theme + ", department=" + department + ", employee="
				+ employee + "]";
	}
	
	
}
