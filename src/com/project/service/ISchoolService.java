package com.project.service;

import java.sql.Date;
import java.util.List;

import com.project.Bean.SchoolBean;
/**
 * 学校信息业务层
 * @author Administrator
 *
 */
public interface ISchoolService {
	
	/**
	 * 添加学校
	 * @param sb 学校对象
	 */
	public void addschool(SchoolBean sb);
	
	/**
	 * 根据学校id修改学校信息：校长，学生人数，老师人数，IP地址，宽带流量
	 * @param id 学校编号
	 * @param president 校长
	 * @param teacherAmount 老师人数
	 * @param studentAmount 学生人数
	 * @param ip IP地址
	 * @param traffic 宽带流量
	 */
	public void updateSchool(int id,String president,int teacherAmount ,int studentAmount,String ip,String traffic);
	
	/**
	 * 申请立项
	 * 将指定ID的学校状态修改为“待审”,修改申请立项时间为当前日期
	 * @param id 学校编号
	 * @return 返回学校申请立项信息
	 */
	public void apply(int id);
	
	/**
	 * 驳回立项，按学校ID，修改审批意见，修改学校状态为“审核未通过”
	 * @param id
	 * @param approveIdea
	 */
	public void back(int id,String approveIdea);
	
	/**
	 * 批准立项，将指定ID的学校状态修改为“推广开展”，修改立项批准时间为当前日期。
	 * @param id 学校id
	 * @param approveIdea 审核意见
	 */
	public void pass(int id,String approveIdea);
	
	/**
	 * 动态条件查询学校，城市ID为固定条件，学校名称和状态为动态条件
	 * @param cityId 城市编号
	 * @param schoolName 传入校名
	 * @param condition 传入状态
	 * @return 学校对象集合
	 */
	public List<SchoolBean> find(int cityId,String schoolName,String condition);
	
	
	/**
	 * 按id查询学校，同时查询该学校的沟通记录，所在城市名称，负责部门名称
	 * @param id 学校编号
	 * @return 返回学校对象
	 */
	public SchoolBean findById(int id);

}
