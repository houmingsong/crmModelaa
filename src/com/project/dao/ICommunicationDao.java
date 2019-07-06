package com.project.dao;

import java.util.List;

import com.project.Bean.CommunicationBean;
/**
 * ��ͨ��¼�־ò�ӿ�
 * @author Administrator
 *
 */
public interface ICommunicationDao {
	/**
	 * ����ѧУid�鹵ͨ��¼
	 * @param schoolId ѧУid
	 * @return ���ع�ͨ��¼����
	 */
	public List<CommunicationBean> findBySchoolId(int schoolId);
	
	
	
	
	/**
	 * ��ӹ�ͨ��¼
	 * @param cb ��ͨ��¼����
	 */
	public void add(CommunicationBean cb);
	
}
