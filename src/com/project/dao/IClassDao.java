package com.project.dao;

import java.util.List;

import com.project.Bean.ClassBean;
/**
 * 班级管理持久层
 * @author Administrator
 *
 */
public interface IClassDao {
	
	/**
	 * 添加班级
	 * @param cb 班级对象
	 */
	public void addClass(ClassBean cb);
	
	/**
	 * 按id修改班级老师
	 * @param id 班级id
	 * @param teacher 带班老师
	 */
	public void update(int id,String teacher);
	
	/**
	 * 按学校id查询班级集合,同时统计每个班级的人数
	 * @param schoolId 学校ID
	 * @return 返回班级集合
	 */
	public List<ClassBean> findBySchool(int schoolId);
	
	/**
	 * 根据班级id查询班级对象
	 * @param id 班级id
	 * @return 返回班级
	 */
	public ClassBean findById(int id);

}
