package com.project.dao;

import java.util.List;

import com.project.Bean.SchoolNumBean;
/**
 * ͳ��ѧУ�־ò�
 * @author Administrator
 *
 */
public interface ISchoolNumDao {
	/**
	 * ��ʾѧУͳ����Ϣ
	 * @param cityId ���б��
	 * @return ����ѧУͳ�Ƽ���
	 */
	public List<SchoolNumBean> showSchoolNumBean(int cityId);
}
