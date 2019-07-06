package com.project.dao.Impl;

import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.project.Bean.CommunicationBean;
import com.project.dao.ICommunicationDao;
/**
 * 沟通记录持久层实现类
 * @author Administrator
 *
 */
public class CommunicationDaoImpl extends BaseDao implements ICommunicationDao{

	@Override
	public List<CommunicationBean> findBySchoolId(int schoolId) {
		List<CommunicationBean> list=new ArrayList<CommunicationBean>();
		this.setConnection();
		try {
			ps=con.prepareStatement("select*from t_communication where schoolId=?");
			ps.setInt(1, schoolId);
			rs=ps.executeQuery();
			while(rs.next()) {
				CommunicationBean cb=new CommunicationBean();
				cb.setId(rs.getInt("id"));
				cb.setSchoolID(rs.getInt("schoolId"));
				cb.setcTime(rs.getDate("cTime"));
				cb.setSchoolLinked(rs.getString("schoolLinked"));
				cb.setjob(rs.getString("job"));
				cb.setEmployeeID(rs.getInt("employeeId"));
				cb.setDetails(rs.getString("details"));
				list.add(cb);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			this.closeConnection();
		}
		
		return list;
	}

	@Override
	public void add(CommunicationBean cb) {
		this.setConnection();
		try {
			ps=con.prepareStatement("insert into t_communication(schoolId,cTime,schoolLinked,job,employeeId,details)values(?,?,?,?,?,?)");
			ps.setInt(1, cb.getSchoolID());
			ps.setDate(2, cb.getcTime());
			ps.setString(3, cb.getSchoolLinked());
			ps.setString(4, cb.getjob());
			ps.setInt(5, cb.getEmployeeID());
			ps.setString(6, cb.getDetails());
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			this.closeConnection();
		}
	}
	public static void main(String[] args) {
		ICommunicationDao a=new CommunicationDaoImpl();
//		System.out.println(a.findBySchoolId(2));
//		a.add(new CommunicationBean(1, Date.valueOf("2018-09-09"), "张三分", "副校长", 3, "aaaa"));
	}
}
