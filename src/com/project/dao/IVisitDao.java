package com.project.dao;

import java.util.List;

import com.project.Bean.VisitBean;
/**
 * �طü�¼�־ò�
 * @author Administrator
 *
 */
public interface IVisitDao {
	/**
	 * ����ѧ��IDɾ���طü�¼
	 * @param studentId ѧ��ID
	 */
	public void del(int studentId);
		 
	
	
	/**
	 * ��ӻطü�¼
	 * @param vb ���ʼ�¼����
	 */
	public void add(VisitBean vb);
	/**
	 * ͨ��ѧ��id��ѯѧ���طü�¼
	 * @param studentId ѧ��id
	 * @return �طü�¼����
	 */
	public List<VisitBean> findById(int studentId);
}
