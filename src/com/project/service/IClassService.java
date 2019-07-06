package com.project.service;

import java.util.List;

import com.project.Bean.ClassBean;
/**
 * 班级管理业务层
 * @author Administrator
 *
 */
public interface IClassService {
	/**
	 * 添加班级
	 * @param cb 班级对象
	 */
	public void addClass(ClassBean cb);
	/**
	 * 按id查询班级
	 * @param id 班级编号
	 * @return 返回班级对象
	 */
	public ClassBean findById(int id);
	/**
	 * 修改班级
	 * @param id 班级id
	 * @param teacher 带班老师
	 */
	public void update(int id,String teacher);
	/**
	 * 按学校ID查询班级集合,同时统计每个班级的学生人数
	 * @param schoolId 学校ID
	 * @return 返回班级集合
	 */
	public List<ClassBean> findBySchool(int schoolId);



}
