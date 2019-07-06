package com.project.dao.Impl;

import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.project.Bean.LogBean;
import com.project.dao.ILogDao;
/**
 * 日志持久层实现类
 * @author Administrator
 *
 */
public class LogDaoImpl extends BaseDao implements ILogDao {

	@Override
	public void writeLog(LogBean lb) {
		this.setConnection();
		try {
			ps=con.prepareStatement("insert into t_log(logTime,logDescribe)values(?,?)");
			ps.setDate(1, lb.getLogTime());
			ps.setString(2, lb.getlogDescribe());
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			this.closeConnection();
		}
		
	}

	@Override
	public List<LogBean> findByDate(Date startTime, Date endTime) {
		List<LogBean> list=new ArrayList<LogBean>();
		String sql="select*from t_log where 1=1 ";
		if(startTime!=null) {
			sql+="and logTime>='"+startTime+"' ";
		}
		if(endTime!=null) {
			sql+="and logTime<='"+endTime+"' ";
		}
		this.setConnection();
		try {
			ps=con.prepareStatement(sql);
			rs=ps.executeQuery();
			while(rs.next()) {
				LogBean lb=new LogBean();
				lb.setId(rs.getInt("id"));
				lb.setLogTime(rs.getDate("logTime"));
				lb.setlogDescribe(rs.getString("logDescribe"));
				list.add(lb);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			this.closeConnection();
		}
		
		return list;
	}
	public static void main(String[] args) {
		ILogDao a=new LogDaoImpl();
//		a.writeLog(new LogBean(Date.valueOf("2015-08-08"), "aaaa"));
//		System.out.println(a.findByDate(Date.valueOf("2013-01-01"), null));
	}

}
