package com.lovo.netCRM.classManager.frame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;

import com.lovo.netCRM.component.LovoAccordion;
import com.lovo.netCRM.component.LovoButton;
import com.lovo.netCRM.component.LovoTable;
import com.lovo.netCRM.component.LovoTitleLabel;
import com.project.Bean.ClassBean;
import com.project.Bean.SchoolBean;
import com.project.service.ICityService;
import com.project.service.IClassService;
import com.project.service.ISchoolService;
import com.project.serviceImpl.CityServiceImpl;
import com.project.serviceImpl.ClassServiceImpl;
import com.project.serviceImpl.SchoolServiceImpl;

/**
 * 
 * �Ĵ�����CRMϵͳ
 * @author �ųɷ�
 * @version 1.0
 * @see  
 * @description �༶�������
 * ��������:2012-10-14
 */
public class ClassManagerPanel extends JPanel{
	/**�༶������*/
	private LovoTable classTable;
	/**�������*/
	private JFrame jf;
	/**�����ַ������*/
	private LovoAccordion cityAccordion;
	/**ѧУid*/
	private int schoolId;
	
	IClassService service=new ClassServiceImpl();
	ICityService cservice=new CityServiceImpl();
	ISchoolService lservice=new SchoolServiceImpl();
	
	public ClassManagerPanel(JFrame jf){
		this.jf = jf;
		this.setLayout(null);
		this.init();
	}
	/**
	 * ��ʼ��
	 *
	 */
	private void init() {
		new LovoTitleLabel("�� �� �� ��",this);
		this.initTable();
		this.initButton();
		this.initData();
		cityAccordion.setBounds(20,90,150,300);
	}
	
	/**
	 * ��ʼ������
	 */
	public void initData(){
		if(schoolId==0){
			if(cityAccordion == null){
				this.initAccordion();
			}
			this.updateAccordion();
		}
		else{
			this.updateClassTable(schoolId);
		}
		
	}
	public void setSchoolId(int schoolId) {
		this.schoolId = schoolId;
	}
	/**
	 * ��ʼ����ť
	 *
	 */
	private void initButton() {
		LovoButton lbadd = new LovoButton("��Ӱ༶",200,500,this);
		lbadd.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
//				if(schoolId == 0){
//					JOptionPane.showMessageDialog(null,"��ѡ��ѧУ");
//					return;
//				}
				
				new ClassAddDialog(jf,schoolId,ClassManagerPanel.this);
			}});
		
		
		LovoButton lbupdate = new LovoButton("�޸İ༶",400,500,this);
		lbupdate.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				int key = classTable.getKey();
//				if(key == -1){
//					JOptionPane.showMessageDialog(null,"��ѡ����");
//					return;
//				}
				
				new ClassUpdateDialog(jf,key,ClassManagerPanel.this);
			}});
	}
	
	//--------------------------
	/**
	 * ����ѧУ����õ�ѧУID
	 * @param schoolObj
	 * @return
	 */
	private int getSchoolId(Object schoolObj){
		
		int id=	((SchoolBean)schoolObj).getId();
		return id;
	}
	
	
	/**
	 * ��ʼ�����
	 */
	private void initTable() {
		classTable = new LovoTable(this,
				new String[]{"�༶����","����ʱ��","�༶����","������ʦ"},
				new String[]{"className","classTime","studentAmount","teacher"},//�༶ʵ������������ new String[]{"className","time"}
				"id");//���������� classId
		classTable.setSizeAndLocation(180, 90, 550, 300);
		
	}
	/**
	 * ��ʼ���ַ������
	 *
	 */
	private void initAccordion() {
		//�ڶ�������Ϊ���м���cityList������������Ϊ��������ѧУ���ϵ�������schoolList
		 cityAccordion = new LovoAccordion(this,cservice.findAll(),"schoolList"){
				
				/**
				 * ѧУ�б�����¼�
				 * @param schoolObj ѧУ����
				 */
			 @Override
				public void clickEvent(Object schoolObj) {
				 	schoolId = getSchoolId(schoolObj);

				 	updateClassTable(schoolId);
				}
			};
	}
	
	/**
	 * �����ַ���
	 */
	private void updateAccordion(){
		this.cityAccordion.updateAccordion(cservice.findAll());
	}
	/**
	 * ���±��
	 * @param schoolId
	 */
	private void updateClassTable(int schoolId){
		//���±��,����List����
		List<ClassBean>list=service.findBySchool(schoolId);
		classTable.updateLovoTable(list);
	}

}
