package com.project.serviceImpl;

import java.util.List;

import com.project.Bean.PlaceNumBean;
import com.project.dao.IPlaceNumDao;
import com.project.dao.Impl.PlaceNumDaoImpl;
import com.project.service.IPlaceNumService;
/**
 * ����ͳ��ҵ���ʵ����
 */
public class PlaceNumSerivceImpl implements IPlaceNumService {
	private IPlaceNumDao pDao=new PlaceNumDaoImpl();
	@Override
	public List<PlaceNumBean> show() {
		// TODO Auto-generated method stub
		return pDao.show();
	}

}
