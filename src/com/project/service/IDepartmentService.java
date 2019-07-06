package com.project.service;

import java.util.List;

import com.project.Bean.DepartmentBean;
/**
 * ����ҵ���
 * @author Administrator
 *
 */
public interface IDepartmentService {
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
	 * ��ID��ѯ����
	 * @param id ���ű��
	 * @return ���Ŷ���
	 */
	public DepartmentBean findById(int id);
}
