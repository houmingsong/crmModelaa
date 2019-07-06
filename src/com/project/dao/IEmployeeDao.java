package com.project.dao;

import java.util.List;


import com.project.Bean.EmployeeBean;

/**
 * 员工信息持久层
 * @author Administrator
 *
 */
public interface IEmployeeDao {
	
	/**1
	 * 登录
	 * 登录成功，记录登录日志,同时封装员工的职位对象
	 * @param codeName 账号
	 * @param pwd 密码
	 * @return 返回员工对象，登录失败返回null
	 */
	public EmployeeBean login(String codeName,String pwd); 
	
	/**2
	 * 添加员工
	 * @param em 员工对象
	 */
	public void add(EmployeeBean em);
	
	/**3
	 * 按id删除员工
	 * @param id
	 */
	public void del(int id);
	
	/**4
	 * 按id修改员工信息
	 * @param id 员工id
	 * @param tel 新的电话
	 * @param party 新的政治面貌
	 * @param jobId 新的工作职位id
	 * @param departmentId 新的部门id
	 */
	public void update(int id,String tel,String party,int jobId,int departmentId);
	
	/**5
	 * 按id查看员工信息，同时封装部门名称和职位名称
	 * @param id 员工id
	 * @return
	 */
	public EmployeeBean findById(int id);
	
	
	
	/**6
	 * 动态查询员工,同时封装员工所在部门名称和职位名称
	 * @param ename 员工姓名
	 * @param edu 文化程度
	 * @param department 所在部门
	 * @param job 工作职位
	 * @return 返回员工集合
	 */
	public List<EmployeeBean> findByItem(String ename,String edu,String department,String job); 
	
	/**7
	 * 按id修改密码
	 * @param id 员工id
	 * @param pwd 密码
	 */
	public void changePwd(int id,String pwd);
	
	/**8
	 * 查询指定学校ID负责部门的所有员工
	 * @param schoolId 学校编号
	 * @return 返回员工对象集合
	 */
	public List<EmployeeBean> findBySchool(int schoolId);
	/**9
	 * 按部门id查询员工集合
	 * @param deptId 部门id
	 * @return 返回员工集合
	 */
	public List<EmployeeBean> findByDepartment(int deptId);
}
