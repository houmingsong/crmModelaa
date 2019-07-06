package com.project.dao;

import java.util.List;

import com.project.Bean.ClassBean;
/**
 * �༶����־ò�
 * @author Administrator
 *
 */
public interface IClassDao {
	
	/**
	 * ��Ӱ༶
	 * @param cb �༶����
	 */
	public void addClass(ClassBean cb);
	
	/**
	 * ��id�޸İ༶��ʦ
	 * @param id �༶id
	 * @param teacher ������ʦ
	 */
	public void update(int id,String teacher);
	
	/**
	 * ��ѧУid��ѯ�༶����,ͬʱͳ��ÿ���༶������
	 * @param schoolId ѧУID
	 * @return ���ذ༶����
	 */
	public List<ClassBean> findBySchool(int schoolId);
	
	/**
	 * ���ݰ༶id��ѯ�༶����
	 * @param id �༶id
	 * @return ���ذ༶
	 */
	public ClassBean findById(int id);

}
