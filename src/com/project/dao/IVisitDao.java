package com.project.dao;

import java.util.List;

import com.project.Bean.VisitBean;
/**
 * 回访记录持久层
 * @author Administrator
 *
 */
public interface IVisitDao {
	/**
	 * 根据学生ID删除回访记录
	 * @param studentId 学生ID
	 */
	public void del(int studentId);
		 
	
	
	/**
	 * 添加回访记录
	 * @param vb 访问记录对象
	 */
	public void add(VisitBean vb);
	/**
	 * 通过学生id查询学生回访记录
	 * @param studentId 学生id
	 * @return 回访记录集合
	 */
	public List<VisitBean> findById(int studentId);
}
