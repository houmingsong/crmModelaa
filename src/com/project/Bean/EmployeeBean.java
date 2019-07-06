package com.project.Bean;

import java.sql.Date;
/**
 * 员工类
 * @author Administrator
 *
 */
public class EmployeeBean {
	/**员工编号*/
	private int id;
	/**员工姓名*/
	private String ename;
	/**员工性别*/
	private String sex;
	/**员工生日*/
	private Date birthday;
	/**员工学历*/
	private String edu;
	/**员工电话*/
	private String tel;
	/**员工所属部门*/
	private String department;
	/**员工部门id*/
	private int departmentId;
	/**员工职位*/
	private String job;
	/**员工职位id*/
	private int jobID;
	/**员工登录名*/
	private String codeName;
	/**员工密码*/
	private String pwd="666";
	/**员工所属专业*/
	private String major;
	/**员工政治面貌*/
	private String party;
	/**员工家庭住址*/
	private String address;
	/**员工入职时间*/
	private Date jobTime=new Date(System.currentTimeMillis());
	/**员工头像地址*/
	private String imgPath;
	/**员工职位对象*/
	private JobBean jb;
	
	
	
	
	public EmployeeBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	public EmployeeBean(String ename, String sex, Date birthday, String edu, String tel,
			int departmentId, int jobID, String codeName, String pwd, String major, String party,
			String address, Date jobTime, String imgPath) {
		super();
		this.ename = ename;
		this.sex = sex;
		this.birthday = birthday;
		this.edu = edu;
		this.tel = tel;
		this.departmentId = departmentId;
		this.jobID = jobID;
		this.codeName = codeName;
		this.pwd = pwd;
		this.major = major;
		this.party = party;
		this.address = address;
		this.jobTime = jobTime;
		this.imgPath = imgPath;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public String getEdu() {
		return edu;
	}
	public void setEdu(String edu) {
		this.edu = edu;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public int getDepartmentId() {
		return departmentId;
	}
	public void setDepartmentId(int departmentId) {
		this.departmentId = departmentId;
	}
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}
	public int getJobID() {
		return jobID;
	}
	public void setJobID(int jobID) {
		this.jobID = jobID;
	}
	public String getCodeName() {
		return codeName;
	}
	public void setCodeName(String codeName) {
		this.codeName = codeName;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getMajor() {
		return major;
	}
	public void setMajor(String major) {
		this.major = major;
	}
	public String getParty() {
		return party;
	}
	public void setParty(String party) {
		this.party = party;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Date getJobTime() {
		return jobTime;
	}
	public void setJobTime(Date jobTime) {
		this.jobTime = jobTime;
	}
	public String getImgPath() {
		return imgPath;
	}
	public void setImgPath(String imgPath) {
		this.imgPath = imgPath;
	}
	public JobBean getJb() {
		return jb;
	}
	public void setJb(JobBean jb) {
		this.jb = jb;
	}
	@Override
	public String toString() {
		return ename;
	}

}
