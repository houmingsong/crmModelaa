package com.project.dao;

import java.util.List;

import com.project.Bean.CommunicationBean;
/**
 * 沟通记录持久层接口
 * @author Administrator
 *
 */
public interface ICommunicationDao {
	/**
	 * 根据学校id查沟通记录
	 * @param schoolId 学校id
	 * @return 返回沟通记录集合
	 */
	public List<CommunicationBean> findBySchoolId(int schoolId);
	
	
	
	
	/**
	 * 添加沟通记录
	 * @param cb 沟通记录对象
	 */
	public void add(CommunicationBean cb);
	
}
