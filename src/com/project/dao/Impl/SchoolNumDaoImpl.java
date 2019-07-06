package com.project.dao.Impl;

import java.util.ArrayList;
import java.util.List;

import com.project.Bean.SchoolNumBean;
import com.project.dao.ISchoolNumDao;
/**
 * ѧУͳ�Ƴ־ò�ʵ����
 * @author Administrator
 *
 */
public class SchoolNumDaoImpl extends BaseDao implements ISchoolNumDao {

	@Override
	public List<SchoolNumBean> showSchoolNumBean(int cityId) {
		List<SchoolNumBean> list=new ArrayList<SchoolNumBean>();
		this.setConnection();
		try {
			ps=con.prepareStatement("SELECT s.school,COUNT(st.studentName) 'ѧ������',COUNT(DISTINCT cl.id) '�༶��',COUNT(CASE WHEN st.scondition='��Ա' THEN 1 END)'��Ա',COUNT(CASE WHEN st.scondition='�ǻ�Ա' THEN 1 END) '�ǻ�Ա' FROM t_school s JOIN t_class  cl ON cl.schoolId=s.id LEFT JOIN t_student st ON cl.id=st.classNameId WHERE s.cityId=? GROUP BY s.school");
			ps.setInt(1, cityId);		
			rs=ps.executeQuery();
			while(rs.next()) {
				SchoolNumBean sn=new SchoolNumBean();
				sn.setSchoolName(rs.getString("school"));
				sn.setClassNum(rs.getInt("�༶��"));
				sn.setVip(rs.getInt("��Ա"));
				sn.setNotVip(rs.getInt("�ǻ�Ա"));
				list.add(sn);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			this.closeConnection();
		}
		return list;
	}
	public static void main(String[] args) {
//		ISchoolNumDao s=new SchoolNumDaoImpl();
//		System.out.println(s.showSchoolNumBean(1));
	}
}
