package com.project.Bean;
/**
 * 职位类
 * @author Administrator
 *
 */
public class JobBean {
	/**职位编号*/
	private int id;
	/**工作岗位*/
	private String job;
	/**岗位描述*/
	private String jobDescribe;
	/**查看资料管理权限*/
	private String isDataPower;
	/**查看学校管理权限*/
	private String isSchoolPower;
	/**查看用户管理权限*/
	private String isUserPower;
	/**查看统计信息权限*/
	private String isStatisticsPower;
	
	
	
	public JobBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	public JobBean(String job, String jobDescribe, String isDataPower, String isSchoolPower, String isUserPower,
			String isStatisticsPower) {
		super();
		this.job = job;
		this.jobDescribe = jobDescribe;
		this.isDataPower = isDataPower;
		this.isSchoolPower = isSchoolPower;
		this.isUserPower = isUserPower;
		this.isStatisticsPower = isStatisticsPower;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}
	public String getJobDescribe() {
		return jobDescribe;
	}
	public void setJobDescribe(String jobDescribe) {
		this.jobDescribe = jobDescribe;
	}
	public String getIsDataPower() {
		return isDataPower;
	}
	public void setIsDataPower(String isDataPower) {
		this.isDataPower = isDataPower;
	}
	public String getIsSchoolPower() {
		return isSchoolPower;
	}
	public void setIsSchoolPower(String isSchoolPower) {
		this.isSchoolPower = isSchoolPower;
	}
	public String getIsUserPower() {
		return isUserPower;
	}
	public void setIsUserPower(String isUserPower) {
		this.isUserPower = isUserPower;
	}
	public String getIsStatisticsPower() {
		return isStatisticsPower;
	}
	public void setIsStatisticsPower(String isStatisticsPower) {
		this.isStatisticsPower = isStatisticsPower;
	}
	@Override
	public String toString() {
		return job;
	}
	
	
	
	
}
