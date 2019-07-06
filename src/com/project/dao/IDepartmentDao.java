package com.project.dao;

import java.util.List;

import com.project.Bean.DepartmentBean;
/**
 * ���ų־ò�ӿ�
 * @author Administrator
 *
 */
public interface IDepartmentDao {
	
	
	/**
	 * ����²���
	 * @param department ��������
	 * @param dtime ����ʱ��
	 * @param dedepartmentDescribe ��������
	 */
	public void addDepartment(DepartmentBean dept);
	
	/**
	 * �޸Ĳ�����Ϣ
	 * @param id ���ű��
	 * @param departmentDescribe ��������
	 */
	public void updateDepartment(int id,String departmentDescribe);
	
	/**
	 * ��ѯ���в���
	 * @return ���ز��ż���
	 */
	public List<DepartmentBean> findAll();
	
	/**
	 * ��id��ѯ����
	 * @param id ���ű��
	 * @return ���Ŷ���
	 */
	public DepartmentBean findById(int id);

}
