package com.project.service;

import java.util.List;

import com.project.Bean.CityBean;
/**
 * ����ҵ��ӿ�
 * @author Administrator
 *
 */
public interface ICityService {
	/**
	 * ��ѯ���г���
	 * @return ���س��м���
	 */
	public List<CityBean> findAll();
	/**
	 * ��ѯ���г��У�ͬʱ��ѯÿ��������״̬Ϊ���ƹ㿪չ����ѧУ
	 * @return ���س��ж��󼯺�
	 */
	public List<CityBean> findAllIncludeSchool();
}
