package com.project.service;

import java.sql.Date;
import java.util.List;

import com.project.Bean.ActivityBean;
/**
 * ѧУ�ҵ���
 * @author Administrator
 *
 */
public interface IActivityService {
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
