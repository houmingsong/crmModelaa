package com.lovo.netCRM.schoolActive.frame;

import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import com.lovo.netCRM.component.LovoButton;
import com.lovo.netCRM.component.LovoList;
import com.lovo.netCRM.component.LovoTable;
import com.lovo.netCRM.component.LovoTitleLabel;
import com.project.Bean.CityBean;
import com.project.Bean.SchoolBean;
import com.project.service.IActivityService;
import com.project.service.ICityService;
import com.project.service.ISchoolService;
import com.project.serviceImpl.ActivityServiceImpl;
import com.project.serviceImpl.CityServiceImpl;
import com.project.serviceImpl.SchoolServiceImpl;
/**
 * 
 * �Ĵ�����CRMϵͳ
 * @author �ųɷ�
 * @version 1.0
 * @see  
 * @description ѧУ����
 * ��������:2012-10-6
 */
public class SchoolActivePanel extends JPanel{
	/**ѧУ������*/
	private LovoTable schoolTable;
	/**�������*/
	private JFrame jf;
	/**����id*/
	private  int cityId;
	/**�����б��*/
	ICityService service=new CityServiceImpl();
	IActivityService ser=new ActivityServiceImpl();
	ISchoolService serce=new SchoolServiceImpl();
	
	private LovoList cityList = new LovoList(20,90,150,300,this){
		public void onchange(Object t){
			cityId = getCityId(t);
			showSchool(cityId);
		}
	};
	public SchoolActivePanel(JFrame jf){
		this.jf = jf;
		this.setLayout(null);
		this.init();
	}
	/**
	 * ��ʼ��
	 *
	 */
	private void init() {
		new LovoTitleLabel("ѧ У �� ��",this);
		this.initTable();
		this.initButton();
		this.initData();
	}
	/**
	 * ��ʼ������
	 */
	public void initData(){
		if(cityId==0){
			this.initList();
		}
		else{
			showSchool(cityId);
		}
	}
	
	/**
	 * ��ʼ����ť
	 *
	 */
	private void initButton() {
		LovoButton lbadd = new LovoButton("����»",200,500,this);
		lbadd.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				int key = schoolTable.getKey();
				if(key == -1){
				JOptionPane.showMessageDialog(null,"��ѡ����");
				return;
				}
				new SchoolActiveAddDialog(jf,key);
			}});
		
		
		LovoButton lbshow = new LovoButton("�鿴���Ϣ",400,500,this);
		lbshow.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				int key = schoolTable.getKey();
				if(key == -1){
					JOptionPane.showMessageDialog(null,"��ѡ����");
					return;
				}
				
				new SchoolActiveShowDialog(jf,schoolTable.getSelectColumn(0),key);
			}});
	}
	
	//--------------------------
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
	 * ��ʼ�����
	 */
	private void initTable() {
		schoolTable = new LovoTable(this,
				new String[]{"ѧУ����","У��","¼��ʱ��","��ϵ�绰"},
				new String[]{"school","president","sTime","tel"},//ѧУʵ������������ new String[]{"schoolName","schoolMaster"}
				"id");//���������� schoolId
		schoolTable.setSizeAndLocation(180, 90, 550, 300);

	}
	/**
	 * ��ʼ���б��
	 *
	 */
	private void initList() {
		List<CityBean> list=service.findAll();
		cityList.setList(new ArrayList(list));
	}
	/**
	 * ��ʾ���ж�Ӧ��ѧУ
	 * @param cityObj ���ж���
	 */
	private void showSchool(int cityId){
//		���±��,����List����
		List<SchoolBean>list=serce.find(cityId, null, "�ƹ㿪չ");
		schoolTable.updateLovoTable(list);
	}
}
