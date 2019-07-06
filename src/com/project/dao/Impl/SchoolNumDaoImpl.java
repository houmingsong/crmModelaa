package com.project.dao.Impl;

import java.util.ArrayList;
import java.util.List;

import com.project.Bean.SchoolNumBean;
import com.project.dao.ISchoolNumDao;
/**
 * 学校统计持久层实现类
 * @author Administrator
 *
 */
public class SchoolNumDaoImpl extends BaseDao implements ISchoolNumDao {

	@Override
	public List<SchoolNumBean> showSchoolNumBean(int cityId) {
		List<SchoolNumBean> list=new ArrayList<SchoolNumBean>();
		this.setConnection();
		try {
			ps=con.prepareStatement("SELECT s.school,COUNT(st.studentName) '学生人数',COUNT(DISTINCT cl.id) '班级数',COUNT(CASE WHEN st.scondition='会员' THEN 1 END)'会员',COUNT(CASE WHEN st.scondition='非会员' THEN 1 END) '非会员' FROM t_school s JOIN t_class  cl ON cl.schoolId=s.id LEFT JOIN t_student st ON cl.id=st.classNameId WHERE s.cityId=? GROUP BY s.school");
			ps.setInt(1, cityId);		
			rs=ps.executeQuery();
			while(rs.next()) {
				SchoolNumBean sn=new SchoolNumBean();
				sn.setSchoolName(rs.getString("school"));
				sn.setClassNum(rs.getInt("班级数"));
				sn.setVip(rs.getInt("会员"));
				sn.setNotVip(rs.getInt("非会员"));
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
