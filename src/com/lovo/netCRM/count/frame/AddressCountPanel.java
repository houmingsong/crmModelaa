package com.lovo.netCRM.count.frame;


import java.util.List;

import javax.swing.JPanel;

import com.lovo.netCRM.component.LovoTable;
import com.lovo.netCRM.component.LovoTitleLabel;
import com.project.Bean.PlaceNumBean;
import com.project.service.IPlaceNumService;
import com.project.serviceImpl.PlaceNumSerivceImpl;

/**
 * 
 * �Ĵ�����CRMϵͳ
 * @author �ųɷ�
 * @version 1.0
 * @see  
 * @description ����ͳ�����
 * ��������:2012-10-14
 */
public class AddressCountPanel extends JPanel{
	/**����ͳ�Ʊ�����*/
	private LovoTable addressCountTable;
	IPlaceNumService service=new PlaceNumSerivceImpl();
	public AddressCountPanel(){
		this.setLayout(null);
		this.init();
	}
	/**
	 * ��ʼ��
	 *
	 */
	private void init() {
		new LovoTitleLabel("�� �� ͳ ��",this);
		this.initTable();
		this.initData();
	}
	/**
	 * ��������
	 */
	public void initData(){
		this.updateAddressCountTable();
	}

	//--------------------------
	
	/**
	 * ��ʼ�����
	 */
	private void initTable() {
		addressCountTable = new LovoTable(this,
				new String[]{"��������","¼��ѧУ","��Ǣ��ѧУ","����ѧУ","���δͨ��ѧУ","�ƹ㿪չѧУ"},
				new String[]{"city","allSchool","talkingSchool","waitSchool","noPassSchool","passSchool"},//ͳ��ʵ������������ new String[]{"cityName","schoolNumber"}
				"");//���������� countId
		addressCountTable.setSizeAndLocation(20, 90, 700, 300);
		
	}
	/**
	 * ���±������
	 */
	private void updateAddressCountTable(){
		//���±��,�������ͳ��List����
		List<PlaceNumBean>list=service.show();
		addressCountTable.updateLovoTable(list);
	}
}
