package com.project.service;

import java.sql.Date;
import java.util.List;

import com.project.Bean.LogBean;
/**
 * ��־ҵ���
 * @author Administrator
 *
 */
public interface ILogService {
	/**
	 * �����ڲ�ѯ��־
	 * @param startTime ��ʼ����
	 * @param endTime ��������
	 * @return ������־����
	 */
	public List<LogBean> findByDate(Date startTime,Date endTime);
	
	
}
