package com.project.dao;

import java.util.List;

import com.project.Bean.PlaceNumBean;
/**
 * ����ͳ�Ƴ־ò�
 * @author Administrator
 *
 */
public interface IPlaceNumDao {
	/**
	 * ��ʾ����ͳ����Ϣ
	 * @return ���ص���ͳ�Ƽ���
	 */
	public List<PlaceNumBean> show();
}
