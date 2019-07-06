package com.project.service;

import java.util.List;

import com.project.Bean.DepartmentBean;
/**
 * 部门业务层
 * @author Administrator
 *
 */
public interface IDepartmentService {
	/**
	 * 添加新部门
	 * @param department 部门名称
	 * @param dtime 成立时间
	 * @param dedepartmentDescribe 部门描述
	 */
	public void addDepartment(DepartmentBean dept);
	/**
	 * 修改部门信息
	 * @param id 部门编号
	 * @param departmentDescribe 部门描述
	 */
	public void updateDepartment(int id,String departmentDescribe);
	/**
	 * 查询所有部门
	 * @return 返回部门集合
	 */
	public List<DepartmentBean> findAll();
	/**
	 * 按ID查询部门
	 * @param id 部门编号
	 * @return 部门对象
	 */
	public DepartmentBean findById(int id);
}
