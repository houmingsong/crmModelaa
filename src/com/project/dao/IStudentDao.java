package com.project.dao;

import java.util.List;

import com.project.Bean.StudentBean;
/**
 * ѧ����Ϣ�־ò�
 * @author Administrator
 *
 */
public interface IStudentDao {
	/**
	 * ���ѧ��
	 * @param stub ѧ������
	 */
	public void add(StudentBean stub);
	/**
	 * ����ѧ��id�޸�ѧ����Ϣ
	 * @param id ѧ��id
	 * @param classId �����༶���
	 * @param tel ��ϵ�绰
	 * @param fatherTel ���׵绰
	 * @param motherTel ĸ�׵绰 
	 * @param commment ��ע
	 * @param condition ѧ��״̬
	 */
	public void update(int id,int classId,String tel,String fatherTel,String motherTel,String commment,String condition);
	/**
	 * ����ѧ��idɾ��ѧ��
	 * @param id ����ѧ��id
	 */
	public void del(int id);
    /**
     * ��̬��ѯѧ����Ϣ������ѧУidΪ�̶�������ѧ���������༶���ƣ�ѧ��״̬Ϊ��̬����
     * @param schoolId ѧУid
     * @param studentName ѧ������
     * @param className �༶����
     * @param condition ѧ��״̬
     * @return ѧ�����󼯺�
     */
	public List<StudentBean> find(int schoolId,String studentName,String className,String condition);
	
	/**
	 * ��id��ѯѧ��,ͬʱ��װ�༶����
	 * @param id ѧ��id
	 * @return
	 */
	public StudentBean findById(int id);
	
	
	
	
	
	
	

}
