package com.lovo.netCRM.count.frame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

import com.lovo.netCRM.component.LovoButton;
import com.lovo.netCRM.component.LovoDate;
import com.lovo.netCRM.component.LovoList;
import com.lovo.netCRM.component.LovoTable;
import com.lovo.netCRM.component.LovoTitleLabel;
import com.lovo.netCRM.component.LovoTitlePanel;
import com.project.Bean.CityBean;
import com.project.Bean.SchoolNumBean;
import com.project.service.ICityService;
import com.project.service.ISchoolNumService;
import com.project.serviceImpl.CityServiceImpl;
import com.project.serviceImpl.SchoolNumServiceImpl;
/**
 * 
 * �Ĵ�����CRMϵͳ
 * @author �ųɷ�
 * @version 1.0
 * @see  
 * @description ѧУͳ�����
 * ��������:2012-10-14
 */
public class SchoolCountPanel extends JPanel{
	/**ѧУ������*/
	private LovoTable schoolCountTable;
	/**����id*/
	private int cityId;
	ISchoolNumService service=new SchoolNumServiceImpl();
	ICityService cservice=new CityServiceImpl();
	
	/**�����б��*/
	private LovoList cityList = new LovoList(20,90,150,300,this){
		public void onchange(Object cityObj){
			cityId = getCityId(cityObj);
			showAll(cityId);
		}
	};
	
	public SchoolCountPanel(){
		this.setLayout(null);
		this.init();
	}
	/**
	 * ��ʼ��
	 *
	 */
	private void init() {
		new LovoTitleLabel("ѧ У ͳ ��",this);
		this.initTable();
	
		this.initData();
	}
	
	public void initData(){
		if(cityId==0){
			this.initList();
		}
		else{
			showAll(cityId);
		}
	}
	

	
	//--------------------------
	/**
	 * ��ʼ�����
	 */
	private void initTable() {
		schoolCountTable = new LovoTable(this,
				new String[]{"ѧУ����","�����༶����","��Ա����","�ǻ�Ա����"},
				new String[]{"schoolName","classNum","Vip","notVip"},//ѧУͳ��ʵ������������ new String[]{"schoolName","netClassNumber"}
				"id");//���������� schoolId
		schoolCountTable.setSizeAndLocation(180, 90, 550, 300);
		
		
	}
	/**
	 * ��ʼ�������б��
	 *
	 */
	private void initList() {
		List<CityBean>list=cservice.findAllIncludeSchool();
		
		cityList.setList(list);
	}
	
	/**
	 * ���ݳ��ж��󣬵õ�����id
	 * @param cityObj ���ж���
	 * @return
	 */
	private int getCityId(Object cityObj){
		int id=((CityBean)cityObj).getId();
		
		return id;
	}
	/**
	 * ��ʾ����ѧУ����ͳ����Ϣ
	 * @param cityId ����id
	 */
	private void showAll(int cityId){
		List<SchoolNumBean>list=service.showSchoolNumBean(cityId);
//		���±��,����List����
		schoolCountTable.updateLovoTable(list);
	}
	
}
