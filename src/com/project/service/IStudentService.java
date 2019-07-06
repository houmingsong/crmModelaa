package com.project.service;

import java.util.List;

import com.project.Bean.StudentBean;
/**
 * 学生业务层
 * @author Administrator
 *
 */
public interface IStudentService {
	/**
	 * 添加学生
	 * @param stub 学生对象
	 */
	public void add(StudentBean stub);
	/**
	 * 根据学生id修改学生信息
	 * @param id 学生id
	 * @param classId 所属班级编号
	 * @param tel 联系电话
	 * @param fatherTel 父亲电话
	 * @param motherTel 母亲电话 
	 * @param commment 备注
	 * @param condition 学生状态
	 */
	public void update(int id,int classId,String tel,String fatherTel,String motherTel,String commment,String condition);
	/**
	 * 根据学生ID删除学生，先删除该学生所有的回访记录，再删除学生
	 * @param id 传入学生id
	 */
	public void del(int id);
    /**
     * 动态查询学生信息，其中学校ID为固定条件，学生姓名，班级名称，学生状态为动态条件,同时查询班级名称
     * @param schoolId 学校ID
     * @param studentName 学生姓名
     * @param className 班级名称
     * @param condition 学生状态
     * @return 学生对象集合
     */
	public List<StudentBean> find(int schoolId,String studentName,String className,String condition);
	
	/**
	 * 按ID查询学生，同时查询该学生的回访记录，以及该学生所在的班级名称
	 * @param id
	 * @return
	 */
	public StudentBean findById(int id);
}
