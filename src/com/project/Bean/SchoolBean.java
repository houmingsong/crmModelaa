package com.project.Bean;

import java.sql.Date;
/**
 * 学校类
 * @author Administrator
 *
 */
import java.util.List;
public class SchoolBean {
	/**学校编号*/
	private int id;
	/**学校名称*/
	private String school;
	/**校长*/
	private String president;
	/**录入时间*/
	private Date sTime=new Date(System.currentTimeMillis());
	/**状态*/
	private String conditions="接洽中";
	/**电话*/
	private String tel;
	/**所在城市ID号*/
	private int cityId;
	/**所属城市*/
	private String city;
	/**老师人数*/
	private int teacherAmount;
	/**学校地址*/
	private String address;
	/**学生人数*/
	private int studentAmount;
	/**学校说明*/
	private String schoolDescribe;
	/**IP地址*/
	private String ip;
	/**宽带流量*/
	private String traffic;
	/**审批意见*/
	private String approveIdea;
	/**负责部门ID*/
	private int departmentId;
	/**部门名称*/
	private String department;
	/**申请立项时间*/
	private Date applyDate;
	/**立项批准时间*/
	private Date passDate;
	/**该学校沟通记录集合*/
	private List<CommunicationBean> commuunicationList;
	
	
	
	public SchoolBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	public SchoolBean(String school, String president, Date sTime, String conditions, String tel, int cityId,
			String city, int teacherAmount, String address, int studentAmount, String schoolDescribe, String ip,
			String traffic, String approveIdea, int departmentId, String department, Date applyDate, Date passDate) {
		super();
		this.school = school;
		this.president = president;
		this.sTime = sTime;
		this.conditions = conditions;
		this.tel = tel;
		this.cityId = cityId;
		this.city = city;
		this.teacherAmount = teacherAmount;
		this.address = address;
		this.studentAmount = studentAmount;
		this.schoolDescribe = schoolDescribe;
		this.ip = ip;
		this.traffic = traffic;
		this.approveIdea = approveIdea;
		this.departmentId = departmentId;
		this.department = department;
		this.applyDate = applyDate;
		this.passDate = passDate;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getSchool() {
		return school;
	}
	public void setSchool(String school) {
		this.school = school;
	}
	public String getPresident() {
		return president;
	}
	public void setPresident(String president) {
		this.president = president;
	}
	public Date getsTime() {
		return sTime;
	}
	public void setsTime(Date sTime) {
		this.sTime = sTime;
	}
	public String getConditions() {
		return conditions;
	}
	public void setConditions(String conditions) {
		this.conditions = conditions;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public int getCityId() {
		return cityId;
	}
	public void setCityId(int cityId) {
		this.cityId = cityId;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public int getTeacherAmount() {
		return teacherAmount;
	}
	public void setTeacherAmount(int teacherAmount) {
		this.teacherAmount = teacherAmount;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int getStudentAmount() {
		return studentAmount;
	}
	public void setStudentAmount(int studentAmount) {
		this.studentAmount = studentAmount;
	}
	public String getSchoolDescribe() {
		return schoolDescribe;
	}
	public void setSchoolDescribe(String schoolDescribe) {
		this.schoolDescribe = schoolDescribe;
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public String getTraffic() {
		return traffic;
	}
	public void setTraffic(String traffic) {
		this.traffic = traffic;
	}
	public String getApproveIdea() {
		return approveIdea;
	}
	public void setApproveIdea(String approveIdea) {
		this.approveIdea = approveIdea;
	}
	public int getDepartmentId() {
		return departmentId;
	}
	public void setDepartmentId(int departmentId) {
		this.departmentId = departmentId;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public Date getApplyDate() {
		return applyDate;
	}
	public void setApplyDate(Date applyDate) {
		this.applyDate = applyDate;
	}
	public Date getPassDate() {
		return passDate;
	}
	public void setPassDate(Date passDate) {
		this.passDate = passDate;
	}
	public List<CommunicationBean> getCommuunicationList() {
		return commuunicationList;
	}
	public void setCommuunicationList(List<CommunicationBean> commuunicationList) {
		this.commuunicationList = commuunicationList;
	}
	@Override
	public String toString() {
		return school;
	}
	
	
	
}
