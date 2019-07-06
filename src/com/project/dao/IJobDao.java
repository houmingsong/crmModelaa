package com.project.dao;

import java.util.List;

import com.project.Bean.JobBean;
/**
 * 职位持久层
 * @author Administrator
 *
 */
public interface IJobDao {
	/**
	 * 根据员工职位id  查询职位对象
	 * @param jobId 职位id
	 * @return 返回职位对象
	 */
	public JobBean findById(int jobId);
	
	
	/**
	 * 添加新职位
	 * @param jb 职位对象
	 */
	public void addJob(JobBean jb);
	/**
	 * 修改职位信息
	 * @param id 职位编号
	 * @param isDatePower 查看资料管理权限
	 * @param isSchoolPower 查看学校管理权限
	 * @param isUserPower 查看用户管理权限
	 * @param isStatisticsPower 查看统计信息权限
	 */
	public void update(int id,String isDatePower,String isSchoolPower,String isUserPower,String isStatisticsPower);
	/**
	 * 查询所有职位
	 * @return 职位集合
	 */
	public List<JobBean> findAll();
	
}
