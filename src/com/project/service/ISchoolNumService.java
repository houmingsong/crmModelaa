package com.project.service;

import java.util.List;

import com.project.Bean.SchoolNumBean;
/**
 * ͳ��ѧУҵ���
 * @author Administrator
 *
 */
public interface ISchoolNumService {
	/**
	 * ��ʾѧУͳ����Ϣ
	 * @param cityId ���б��
	 * @return ����ѧУͳ�Ƽ���
	 */
	public List<SchoolNumBean> showSchoolNumBean(int cityId);
}
