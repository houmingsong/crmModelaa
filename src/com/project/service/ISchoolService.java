package com.project.service;

import java.sql.Date;
import java.util.List;

import com.project.Bean.SchoolBean;
/**
 * ѧУ��Ϣҵ���
 * @author Administrator
 *
 */
public interface ISchoolService {
	
	/**
	 * ���ѧУ
	 * @param sb ѧУ����
	 */
	public void addschool(SchoolBean sb);
	
	/**
	 * ����ѧУid�޸�ѧУ��Ϣ��У����ѧ����������ʦ������IP��ַ���������
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
	 * ��ָ��ID��ѧУ״̬�޸�Ϊ������,�޸���������ʱ��Ϊ��ǰ����
	 * @param id ѧУ���
	 * @return ����ѧУ����������Ϣ
	 */
	public void apply(int id);
	
	/**
	 * ���������ѧУID���޸�����������޸�ѧУ״̬Ϊ�����δͨ����
	 * @param id
	 * @param approveIdea
	 */
	public void back(int id,String approveIdea);
	
	/**
	 * ��׼�����ָ��ID��ѧУ״̬�޸�Ϊ���ƹ㿪չ�����޸�������׼ʱ��Ϊ��ǰ���ڡ�
	 * @param id ѧУid
	 * @param approveIdea ������
	 */
	public void pass(int id,String approveIdea);
	
	/**
	 * ��̬������ѯѧУ������IDΪ�̶�������ѧУ���ƺ�״̬Ϊ��̬����
	 * @param cityId ���б��
	 * @param schoolName ����У��
	 * @param condition ����״̬
	 * @return ѧУ���󼯺�
	 */
	public List<SchoolBean> find(int cityId,String schoolName,String condition);
	
	
	/**
	 * ��id��ѯѧУ��ͬʱ��ѯ��ѧУ�Ĺ�ͨ��¼�����ڳ������ƣ�����������
	 * @param id ѧУ���
	 * @return ����ѧУ����
	 */
	public SchoolBean findById(int id);

}
