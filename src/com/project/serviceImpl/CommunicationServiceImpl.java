package com.project.serviceImpl;

import com.project.Bean.CommunicationBean;
import com.project.dao.ICommunicationDao;
import com.project.dao.Impl.CommunicationDaoImpl;
import com.project.service.ICommunicationService;
/**
 * ��ͨ��¼ҵ���ʵ����
 * @author Administrator
 *
 */
public class CommunicationServiceImpl implements ICommunicationService {
	private ICommunicationDao cDao=new CommunicationDaoImpl();
	@Override
	public void add(CommunicationBean cb) {
		cDao.add(cb);
		
	}

}
