package com.project.service;

import java.util.List;

import com.project.Bean.EmployeeBean;
/**
 * Ա��ҵ���
 * @author Administrator
 *
 */
public interface IEmployeeService {
	/**
	 * ��¼
	 * ��¼�ɹ�����¼��¼��־,ͬʱ��װԱ����ְλ����
	 * @param codeName �˺�
	 * @param pwd ����
	 * @return ����Ա�����󣬵�¼ʧ�ܷ��ؿ�
	 */
	public EmployeeBean login(String codeName,String pwd); 
	/**
	 * ���Ա��
	 * @param em Ա������
	 */
	public void add(EmployeeBean em);
	/**
	 * ��IDɾ��Ա��
	 * @param id
	 */
	public void del(int id);
	/**
	 * ��ID�޸�Ա����Ϣ
	 * @param id Ա��id
	 * @param Tel �µĵ绰
	 * @param Party �µ�������ò
	 * @param JobID �µĹ���ְλid
	 * @param DepartmentID �µĲ���id
	 */
	public void update(int id,String Tel,String Party,int JobID,int DepartmentID);
	/**
	 * ��id�鿴Ա����Ϣ,��װ�������ƺ�ְλ����
	 * @param id Ա��id
	 * @return
	 */
	public EmployeeBean findById(int id);
	/**
	 * ��̬��ѯԱ����ͬʱ��װԱ�����ڲ������ƺ�ְλ����
	 * @param ename Ա������
	 * @param edu �Ļ��̶�
	 * @param department ���ڲ���
	 * @param job ����ְλ
	 * @return ����Ա������
	 */
	public List<EmployeeBean> findByItem(String ename,String edu,String department,String job); 
	/**
	 * ��ID�޸�����
	 * @param id Ա��ID
	 * @param pwd ����
	 */
	public void changePwd(int id,String pwd);
	/**
	 * ��ѯָ��ѧУID�����ŵ�����Ա��
	 * @param schoolId ѧУ���
	 * @return ����Ա�����󼯺�
	 */
	public List<EmployeeBean> findBySchool(int schoolId);
	/**
	 * ������ID��ѯԱ������
	 * @param deptId ����ID
	 * @return ����Ա������
	 */
	public List<EmployeeBean> findByDepartment(int deptId);
	
}
