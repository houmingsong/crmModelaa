package com.project.dao;

import java.sql.Date;
import java.util.List;

import com.project.Bean.SchoolBean;
/**
 * 学校持久层
 * @author Administrator
 *
 */
public interface ISchoolDao {
	
	/**
	 * 根据城市id查询学校集合
	 * @param cityId 城市id
	 * @return 返回学校集合
	 */
	public List<SchoolBean> findByCityId(int cityId);
	
	
	
	/**
	 * 添加学校
	 * @param sb 学校对象
	 */
	public void addschool(SchoolBean sb);
	
	/**
	 * 根据学校id修改学校信息
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
	 * 将指定ID的学校状态修改为“待审”
	 * @param id 学校编号
	 * @param condition 学校状态
	 *  @param applyDate 申请立项时间
	 */
	public void apply(int id,String condition,Date applyDate);
	
	
	/**
	 * 通过id修改审批意见、状态
	 * @param id 学校id
	 * @param info 审批意见
	 * @param condition 学校状态
	 */
	public void back(int id,String info,String condition);
	
	/**
	 * 通过学校id修改审批意见、立项批准时间、状态
	 * @param id 学校id
	 * @param info 审核意见
	 * @param condition 学校状态
	 * @param passDate 立项批准时间
	 */
	public void pass(int id,String info,String condition,Date passDate);
	
	/**
	 * 动态条件查询学校，城市id为固定条件，学校名称和状态为动态条件
	 * @param cityId 城市编号
	 * @param schoolName 传入校名
	 * @param condition 传入状态
	 * @return 学校对象集合
	 */
	public List<SchoolBean> findByItem(int cityId,String schoolName,String condition);
	
	
	/**
	 * 按id查询学校，同时包含所在城市名称和负责部门名称
	 * @param id 学校编号
	 * @return 返回学校对象
	 */
	public SchoolBean findById(int id);
}
