package com.project.dao;

import java.util.List;


import com.project.Bean.EmployeeBean;

/**
 * Ա����Ϣ�־ò�
 * @author Administrator
 *
 */
public interface IEmployeeDao {
	
	/**1
	 * ��¼
	 * ��¼�ɹ�����¼��¼��־,ͬʱ��װԱ����ְλ����
	 * @param codeName �˺�
	 * @param pwd ����
	 * @return ����Ա�����󣬵�¼ʧ�ܷ���null
	 */
	public EmployeeBean login(String codeName,String pwd); 
	
	/**2
	 * ���Ա��
	 * @param em Ա������
	 */
	public void add(EmployeeBean em);
	
	/**3
	 * ��idɾ��Ա��
	 * @param id
	 */
	public void del(int id);
	
	/**4
	 * ��id�޸�Ա����Ϣ
	 * @param id Ա��id
	 * @param tel �µĵ绰
	 * @param party �µ�������ò
	 * @param jobId �µĹ���ְλid
	 * @param departmentId �µĲ���id
	 */
	public void update(int id,String tel,String party,int jobId,int departmentId);
	
	/**5
	 * ��id�鿴Ա����Ϣ��ͬʱ��װ�������ƺ�ְλ����
	 * @param id Ա��id
	 * @return
	 */
	public EmployeeBean findById(int id);
	
	
	
	/**6
	 * ��̬��ѯԱ��,ͬʱ��װԱ�����ڲ������ƺ�ְλ����
	 * @param ename Ա������
	 * @param edu �Ļ��̶�
	 * @param department ���ڲ���
	 * @param job ����ְλ
	 * @return ����Ա������
	 */
	public List<EmployeeBean> findByItem(String ename,String edu,String department,String job); 
	
	/**7
	 * ��id�޸�����
	 * @param id Ա��id
	 * @param pwd ����
	 */
	public void changePwd(int id,String pwd);
	
	/**8
	 * ��ѯָ��ѧУID�����ŵ�����Ա��
	 * @param schoolId ѧУ���
	 * @return ����Ա�����󼯺�
	 */
	public List<EmployeeBean> findBySchool(int schoolId);
	/**9
	 * ������id��ѯԱ������
	 * @param deptId ����id
	 * @return ����Ա������
	 */
	public List<EmployeeBean> findByDepartment(int deptId);
}
