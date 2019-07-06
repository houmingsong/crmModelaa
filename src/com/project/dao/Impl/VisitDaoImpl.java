package com.project.dao.Impl;

import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.project.Bean.VisitBean;
import com.project.dao.IVisitDao;
/**
 * 回访记录持久层实现类
 * @author Administrator
 *
 */
public class VisitDaoImpl extends BaseDao implements IVisitDao{

	@Override
	public void del(int studentId) {
		this.setConnection();
		try {
			ps=con.prepareStatement("delete from t_visit  where id=?");
			ps.setInt(1, studentId);
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			this.closeConnection();
		}
		
	}

	@Override
	public void add(VisitBean vb) {
		this.setConnection();
		try {
			ps=con.prepareStatement("insert into t_visit(studentId,visitTime,employee, patriarch,details,theme)values(?,?,?,?,?,?)");
			ps.setInt(1, vb.getStudentID());
			ps.setDate(2, vb.getVisitTime());
			ps.setString(3, vb.getEmployee());
			ps.setString(4, vb.getPatriarch());
			ps.setString(5, vb.getDetails());
			ps.setString(6, vb.getTheme());
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			this.closeConnection();
		}
		
	}

	@Override
	public List<VisitBean> findById(int studentId) {
		List<VisitBean> list=new ArrayList<VisitBean>();
		this.setConnection();
		try {
			ps=con.prepareStatement("select*from t_visit where studentId=?");
			ps.setInt(1, studentId);
			rs=ps.executeQuery();
			while(rs.next()){
				VisitBean vb=new VisitBean();
				vb.setId(rs.getInt("id"));
				vb.setStudentID(rs.getInt("studentId"));
				vb.setVisitTime(rs.getDate("visitTime"));
				vb.setEmployee(rs.getString("employee"));
				vb.setPatriarch(rs.getString("patriarch"));
				vb.setDetails(rs.getString("details"));
				vb.setTheme(rs.getString("theme"));
				list.add(vb);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			this.closeConnection();
		}
		return list;
	}
   public static void main(String[] args) {
	   VisitDaoImpl x=new VisitDaoImpl();
//	   x.del(5);
//	   x.add(new VisitBean(1,Date.valueOf("1997-01-01"),"1","1","1","1"));
}
}
