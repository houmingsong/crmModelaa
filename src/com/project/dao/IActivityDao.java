package com.project.dao;

import java.util.List;

import com.project.Bean.ActivityBean;
/**
 * ��־ò�
 * @author Administrator
 *
 */
public interface IActivityDao {
	/**
	 * ��ӻ��Ϣ
	 * @param ab ��������
	 */
	public void add(ActivityBean ab);
	
	
	/**
	 * ��ʾѧУ���Ϣ������ѧУId�鿴ѧУ���Ϣ
	 * @param schoolld ѧУid
	 * @return ���ػ����
	 */
	public List<ActivityBean> findActivityBySchoolID(int schoolld);
}
