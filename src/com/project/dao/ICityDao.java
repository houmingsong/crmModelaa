package com.project.dao;

import java.util.List;

import com.project.Bean.CityBean;
/**
 * ��ѯ���г־ò�
 * @author Administrator
 *
 */
public interface ICityDao {
	/**
	 * ��ѯ���г���
	 * @return ���س��м���
	 */
	public List<CityBean> findAll();
	
}
