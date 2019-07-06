package com.project.service;
import com.project.Bean.CommunicationBean;
/**
 * 沟通记录业务层
 * @author Administrator
 *
 */
public interface ICommunicationService {
	/**
	 * 添加沟通记录
	 * @param cb 沟通记录对象
	 */
	public void add(CommunicationBean cb);
}
