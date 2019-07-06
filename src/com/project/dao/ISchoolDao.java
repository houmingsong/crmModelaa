package com.project.dao;

import java.sql.Date;
import java.util.List;

import com.project.Bean.SchoolBean;
/**
 * ѧУ�־ò�
 * @author Administrator
 *
 */
public interface ISchoolDao {
	
	/**
	 * ���ݳ���id��ѯѧУ����
	 * @param cityId ����id
	 * @return ����ѧУ����
	 */
	public List<SchoolBean> findByCityId(int cityId);
	
	
	
	/**
	 * ���ѧУ
	 * @param sb ѧУ����
	 */
	public void addschool(SchoolBean sb);
	
	/**
	 * ����ѧУid�޸�ѧУ��Ϣ
	 * @param id ѧУ���
	 * @param president У��
	 * @param teacherAmount ��ʦ����
	 * @param studentAmount ѧ������
	 * @param ip IP��ַ
	 * @param traffic �������
	 */
	public void updateSchool(int id,String president,int teacherAmount ,int studentAmount,String ip,String traffic);
	
	/**
	 * ��������
	 * ��ָ��ID��ѧУ״̬�޸�Ϊ������
	 * @param id ѧУ���
	 * @param condition ѧУ״̬
	 *  @param applyDate ��������ʱ��
	 */
	public void apply(int id,String condition,Date applyDate);
	
	
	/**
	 * ͨ��id�޸����������״̬
	 * @param id ѧУid
	 * @param info �������
	 * @param condition ѧУ״̬
	 */
	public void back(int id,String info,String condition);
	
	/**
	 * ͨ��ѧУid�޸����������������׼ʱ�䡢״̬
	 * @param id ѧУid
	 * @param info ������
	 * @param condition ѧУ״̬
	 * @param passDate ������׼ʱ��
	 */
	public void pass(int id,String info,String condition,Date passDate);
	
	/**
	 * ��̬������ѯѧУ������idΪ�̶�������ѧУ���ƺ�״̬Ϊ��̬����
	 * @param cityId ���б��
	 * @param schoolName ����У��
	 * @param condition ����״̬
	 * @return ѧУ���󼯺�
	 */
	public List<SchoolBean> findByItem(int cityId,String schoolName,String condition);
	
	
	/**
	 * ��id��ѯѧУ��ͬʱ�������ڳ������ƺ͸���������
	 * @param id ѧУ���
	 * @return ����ѧУ����
	 */
	public SchoolBean findById(int id);
}
