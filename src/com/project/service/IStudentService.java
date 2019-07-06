package com.project.service;

import java.util.List;

import com.project.Bean.StudentBean;
/**
 * ѧ��ҵ���
 * @author Administrator
 *
 */
public interface IStudentService {
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
	 * ����ѧ��IDɾ��ѧ������ɾ����ѧ�����еĻطü�¼����ɾ��ѧ��
	 * @param id ����ѧ��id
	 */
	public void del(int id);
    /**
     * ��̬��ѯѧ����Ϣ������ѧУIDΪ�̶�������ѧ���������༶���ƣ�ѧ��״̬Ϊ��̬����,ͬʱ��ѯ�༶����
     * @param schoolId ѧУID
     * @param studentName ѧ������
     * @param className �༶����
     * @param condition ѧ��״̬
     * @return ѧ�����󼯺�
     */
	public List<StudentBean> find(int schoolId,String studentName,String className,String condition);
	
	/**
	 * ��ID��ѯѧ����ͬʱ��ѯ��ѧ���Ļطü�¼���Լ���ѧ�����ڵİ༶����
	 * @param id
	 * @return
	 */
	public StudentBean findById(int id);
}
