package com.project.dao;

import java.util.List;

import com.project.Bean.JobBean;
/**
 * ְλ�־ò�
 * @author Administrator
 *
 */
public interface IJobDao {
	/**
	 * ����Ա��ְλid  ��ѯְλ����
	 * @param jobId ְλid
	 * @return ����ְλ����
	 */
	public JobBean findById(int jobId);
	
	
	/**
	 * �����ְλ
	 * @param jb ְλ����
	 */
	public void addJob(JobBean jb);
	/**
	 * �޸�ְλ��Ϣ
	 * @param id ְλ���
	 * @param isDatePower �鿴���Ϲ���Ȩ��
	 * @param isSchoolPower �鿴ѧУ����Ȩ��
	 * @param isUserPower �鿴�û�����Ȩ��
	 * @param isStatisticsPower �鿴ͳ����ϢȨ��
	 */
	public void update(int id,String isDatePower,String isSchoolPower,String isUserPower,String isStatisticsPower);
	/**
	 * ��ѯ����ְλ
	 * @return ְλ����
	 */
	public List<JobBean> findAll();
	
}
