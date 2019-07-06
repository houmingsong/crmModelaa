package com.project.dao;

import java.sql.Date;
import java.util.List;

import com.project.Bean.LogBean;
/**
 * ��־�־ò�
 * @author Administrator
 *
 */
public interface ILogDao {
	/**
	 * д��¼��־
	 * @param lb ������־����
	 */
	public void writeLog(LogBean lb);
	
	
	/**
	 * �����ڲ�ѯ��־
	 * @param startTime ��ʼ����
	 * @param endTime ��������
	 * @return ������־����
	 */
	public List<LogBean> findByDate(Date startTime,Date endTime);
}
