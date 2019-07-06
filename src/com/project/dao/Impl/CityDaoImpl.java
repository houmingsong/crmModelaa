package com.project.dao.Impl;

import java.util.ArrayList;
import java.util.List;

import com.project.Bean.CityBean;
import com.project.dao.ICityDao;
/**
 * 城市持久层实现类
 * @author Administrator
 *
 */
public class CityDaoImpl extends BaseDao implements ICityDao{

	@Override
	public List<CityBean> findAll() {
		List<CityBean> list=new ArrayList<CityBean>();
		this.setConnection();
		try {
			ps=con.prepareStatement("select*from t_city ");
			rs=ps.executeQuery();
			while(rs.next()) {
				CityBean cb=new CityBean();
				cb.setId(rs.getInt("id"));
				cb.setCity(rs.getString("city"));
				list.add(cb);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			this.closeConnection();
		}
		return list;
	}
	public static void main(String[] args) {
//		ICityDao a=new CityDaoImpl();
//		System.out.println(a.findAll());
	}
}
