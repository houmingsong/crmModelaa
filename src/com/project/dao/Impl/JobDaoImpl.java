package com.project.dao.Impl;

import java.util.ArrayList;
import java.util.List;

import com.project.Bean.JobBean;
import com.project.dao.IJobDao;

/**
 * 职位持久层实现类
 * 
 * @author Administrator
 *
 */
public class JobDaoImpl extends BaseDao implements IJobDao {

	@Override
	public JobBean findById(int jobId) {
		JobBean jb = null;
		this.setConnection();
		try {
			ps = con.prepareStatement("select*from t_job  where id=?");
			ps.setInt(1, jobId);
			rs = ps.executeQuery();
			if (rs.next()) {
				jb = new JobBean();
				jb.setId(rs.getInt("id"));
				jb.setJob(rs.getString("job"));
				jb.setJobDescribe(rs.getString("jobDescribe"));
				jb.setIsDataPower(rs.getString("isDataPower"));
				jb.setIsSchoolPower(rs.getString("isSchoolPower"));
				jb.setIsStatisticsPower(rs.getString("isStatisticsPower"));
				jb.setIsUserPower(rs.getString("isUserPower"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			this.closeConnection();
		}
		return jb;
	}

	@Override
	public void addJob(JobBean jb) {
		this.setConnection();
		try {
			ps = con.prepareStatement(
					"insert into t_job(job,jobDescribe,isDataPower,isSchoolPower,isUserPower,isStatisticsPower)values(?,?,?,?,?,?)");
			ps.setString(1, jb.getJob());
			ps.setString(2, jb.getJobDescribe());
			ps.setString(3, jb.getIsDataPower());
			ps.setString(4, jb.getIsSchoolPower());
			ps.setString(5, jb.getIsUserPower());
			ps.setString(6, jb.getIsStatisticsPower());
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			this.closeConnection();
		}

	}

	@Override
	public void update(int id, String isDataPower, String isSchoolPower, String isUserPower, String isStatisticsPower) {
		this.setConnection();
		try {
			ps = con.prepareStatement(
					"update  t_job set isDataPower=?,isSchoolPower=?,isUserPower=?,isStatisticsPower=? where id=?");
			ps.setString(1, isDataPower);
			ps.setString(2, isSchoolPower);
			ps.setString(3, isUserPower);
			ps.setString(4, isStatisticsPower);
			ps.setInt(5, id);
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			this.closeConnection();
		}

	}

	@Override
	public List<JobBean> findAll() {
		List<JobBean> list = new ArrayList<JobBean>();
		this.setConnection();
		try {
			ps = con.prepareStatement("select*from t_job ");
			rs = ps.executeQuery();
			while (rs.next()) {
				JobBean jb = new JobBean();
				jb.setId(rs.getInt("id"));
				jb.setJob(rs.getString("job"));
				jb.setJobDescribe(rs.getString("jobDescribe"));
				jb.setIsDataPower(rs.getString("isDataPower"));
				jb.setIsSchoolPower(rs.getString("isSchoolPower"));
				jb.setIsStatisticsPower(rs.getString("isStatisticsPower"));
				jb.setIsUserPower(rs.getString("isUserPower"));
				list.add(jb);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			this.closeConnection();
		}
		return list;
	}

	public static void main(String[] args) {
		IJobDao a = new JobDaoImpl();
//		 System.out.println(a.findById(1));
//		 a.addJob(new JobBean("aaa", "bbbbbb", "是", "是", "是", "是"));
//		 a.update(5, "否", "否", "否", "否");
//		 System.out.println(a.findAll());
	}

}
