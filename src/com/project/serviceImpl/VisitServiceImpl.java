package com.project.serviceImpl;

import com.project.Bean.VisitBean;
import com.project.dao.IVisitDao;
import com.project.dao.Impl.VisitDaoImpl;
import com.project.service.IVisitService;
/**
 * �طü�¼ҵ���ʵ����
 * @author Administrator
 *
 */
public class VisitServiceImpl implements IVisitService{
	private IVisitDao sDao=new VisitDaoImpl();
	@Override
	public void addVisit(VisitBean vb) {
		sDao.add(vb);
		
	}

}
