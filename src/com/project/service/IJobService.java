package com.project.service;

import java.util.List;

import com.project.Bean.JobBean;
/**
 * ְλҵ���
 * @author Administrator
 *
 */
public interface IJobService {
	/**
	 * �����ְλ
	 * @param jb ְλ����
	 */
	public void addJob(JobBean jb);
	/**
	 * �޸�ְλ��Ϣ
	 * @param id ְλ���
	 * @param isDataPower �鿴���Ϲ���Ȩ��
	 * @param isSchoolPower �鿴ѧУ����Ȩ��
	 * @param isUserPower �鿴�û�����Ȩ��
	 * @param isStatisticsPower �鿴ͳ����ϢȨ��
	 */
	public void update(int id,String isDataPower,String isSchoolPower,String isUserPower,String isStatisticsPower);
	/**
	 * ��ѯ����ְλ
	 * @return ְλ����
	 */
	public List<JobBean> findAll();
	/**
	 * ��ID��ѯְλ
	 * @param id ְλ���
	 * @return ����ְλ����
	 */
	public JobBean findById(int id);
}
