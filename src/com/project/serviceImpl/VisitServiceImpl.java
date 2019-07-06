package com.project.serviceImpl;

import com.project.Bean.VisitBean;
import com.project.dao.IVisitDao;
import com.project.dao.Impl.VisitDaoImpl;
import com.project.service.IVisitService;
/**
 * 回访记录业务层实现类
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
