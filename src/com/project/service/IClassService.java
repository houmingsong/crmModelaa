package com.project.service;

import java.util.List;

import com.project.Bean.ClassBean;
/**
 * �༶����ҵ���
 * @author Administrator
 *
 */
public interface IClassService {
	/**
	 * ��Ӱ༶
	 * @param cb �༶����
	 */
	public void addClass(ClassBean cb);
	/**
	 * ��id��ѯ�༶
	 * @param id �༶���
	 * @return ���ذ༶����
	 */
	public ClassBean findById(int id);
	/**
	 * �޸İ༶
	 * @param id �༶id
	 * @param teacher ������ʦ
	 */
	public void update(int id,String teacher);
	/**
	 * ��ѧУID��ѯ�༶����,ͬʱͳ��ÿ���༶��ѧ������
	 * @param schoolId ѧУID
	 * @return ���ذ༶����
	 */
	public List<ClassBean> findBySchool(int schoolId);



}
