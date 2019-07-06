package com.lovo.netCRM.student.frame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import com.lovo.netCRM.component.LovoAccordion;
import com.lovo.netCRM.component.LovoButton;
import com.lovo.netCRM.component.LovoComboBox;
import com.lovo.netCRM.component.LovoTable;
import com.lovo.netCRM.component.LovoTitleLabel;
import com.lovo.netCRM.component.LovoTitlePanel;
import com.lovo.netCRM.component.LovoTxt;
import com.project.Bean.SchoolBean;
import com.project.Bean.StudentBean;
import com.project.service.ICityService;
import com.project.service.ISchoolService;
import com.project.service.IStudentService;
import com.project.serviceImpl.CityServiceImpl;
import com.project.serviceImpl.SchoolServiceImpl;
import com.project.serviceImpl.StudentServiceImpl;

/**
 * 
 * �Ĵ�����CRMϵͳ
 * @author �ųɷ�
 * @version 1.0
 * @see  
 * @description ѧ�����
 * ��������:2012-10-14
 */
public class StudentPanel extends JPanel{
	/**ѧ��������*/
	private LovoTable studentTable;
	/**�������*/
	private JFrame jf;
	/**�����ַ������*/
	private LovoAccordion cityAccordion;
	/**���е�ѧУid*/
	private int schoolId;
	/**ѧ�������ı���*/
	private LovoTxt nameTxt;
	/**�༶�ı���*/
	private LovoTxt classTxt;
	/**ѧУ״̬������*/
	private LovoComboBox statusBox;
	
	
	IStudentService sservice=new StudentServiceImpl();
	ICityService service=new CityServiceImpl();
	ISchoolService lservice=new SchoolServiceImpl();
	IStudentService stu = new StudentServiceImpl();
	public StudentPanel(JFrame jf){
		this.jf = jf;
		this.setLayout(null);
		this.init();
	}
	/**
	 * ��ʼ��
	 *
	 */
	private void init() {
		new LovoTitleLabel("ѧ �� �� ��",this);
		this.initTable();
		this.initButton();
		this.initData();
		cityAccordion.setBounds(20,90,150,300);
		this.initFindPanel();
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
			this.updateStudentTable(schoolId);
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
		
		LovoButton lbadd = new LovoButton("���ѧ��",50,500,this);
		lbadd.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				if(schoolId == 0){
					JOptionPane.showMessageDialog(null,"��ѡ��ѧУ");
					return;
				}
				
				new StudentAddDialog(jf,schoolId,StudentPanel.this);
			}});
		
		LovoButton lbshow = new LovoButton("�鿴ѧ����Ϣ",170,500,this);
		lbshow.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				int key = studentTable.getKey();
				if(key == -1){
					JOptionPane.showMessageDialog(null,"��ѡ����");
					return;
				}
				
				new StudentShowDialog(jf,key);
			}});
		
		
		LovoButton lbdel = new LovoButton("ɾ��ѧ��",290,500,this);
		lbdel.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				int key = studentTable.getKey();
				if(key == -1){
					JOptionPane.showMessageDialog(null,"��ѡ����");
					return;
				}
				
				delEmployee(key);
			}});
		
		
		LovoButton lbupdate = new LovoButton("�޸�ѧ����Ϣ",50,570,this);
		lbupdate.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				int key = studentTable.getKey();
				if(key == -1){
					JOptionPane.showMessageDialog(null,"��ѡ����");
					return;
				}
				
				new StudentUpdateDialog(jf,schoolId,key,StudentPanel.this);
			}});
		
		LovoButton lbAddBack = new LovoButton("��ӻط���¼",170,570,this);
		lbAddBack.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				int key = studentTable.getKey();
				if(key == -1){
					JOptionPane.showMessageDialog(null,"��ѡ����");
					return;
				}
				
				new StudentVisitAddialog(jf,key,schoolId);
			}});
	}
	/**
	 * ��ʼ����ѯ��ť
	 *
	 */
	private void initFindPanel(){
		LovoTitlePanel jp = new LovoTitlePanel("��ѯѧ��",400, 400, 320, 250,this);
	
		nameTxt = new LovoTxt("ѧ������",30,50,jp);
		classTxt = new LovoTxt("�༶",30,100,jp);
		this.statusBox = new LovoComboBox<String>("״̬",new String[]{"ȫ��","��Ա","�ǻ�Ա"},30,150,jp);
		
		LovoButton lb = new LovoButton("����",180,200,jp);
		lb.setSize(60, 20);
		
		lb.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				if(schoolId == 0){
				JOptionPane.showMessageDialog(null,"��ѡ��ѧУ");
					return;
				}
				findStudent(schoolId);
				
			}});
		
	}

	
	//--------------------------
	/**
	 * ����ѧУ����õ�ѧУID
	 * @param schoolObj ѧУ����
	 * @return
	 */
	private int getSchoolId(Object schoolObj){
	int id=	((SchoolBean)schoolObj).getId();
		
		
		return id;
	}
	/**
	 * �����ַ���
	 */
	private void updateAccordion(){
		this.cityAccordion.updateAccordion(service.findAll());
	}
	/**
	 * ���±��
	 * @param schoolId ѧУID
	 */
	private void updateStudentTable(int schoolId){
		List<StudentBean>list=stu.find(schoolId, null, null, null);
				
		
		//���±��,����List����
		studentTable.updateLovoTable(list);
	}
	
	/**
	 * ��ʼ�����
	 */
	private void initTable() {
		studentTable = new LovoTable(this,
				new String[]{"ѧ������","�Ա�","�༶","״̬","��ϵ�绰"},
							  
				new String[]{"studentName","sex","className","scondition","tel"},//ѧ��ʵ������������ new String[]{"studentName","sex"}
				"id");//���������� studentId
		studentTable.setSizeAndLocation(180, 90, 550, 300);
		
	}

	/**
	 * ��ʼ���ַ������
	 *
	 */
	private void initAccordion() {
		//�ڶ�������Ϊ���м���cityList������������Ϊ��������ѧУ���ϵ�������schoolList
		 cityAccordion = new LovoAccordion(this,service.findAll(),"schoolList"){
				
				/**
				 * ѧУ�б�����¼�
				 * @param schoolObj ѧУ����
				 */
			 @Override
				public void clickEvent(Object schoolObj) {
				 
				 //��¼����ѧУid
				 schoolId = getSchoolId(schoolObj);

					//��ʾ����ѧУѧ��
				 updateStudentTable(schoolId);
				}
			};
	}
	
	/**
	 * ɾ��ѧ��
	 * @param studentId ѧ��ID
	 */
	private void delEmployee(int studentId){
		sservice.del(studentId);
		
//		��ʾɾ�����
		updateStudentTable(schoolId);
	}
	/**
	 * ����ѧ��
	 * @param schoolId ѧУid
	 */
	private void findStudent(int schoolId){
		String str = statusBox.getItem().toString();
		if(statusBox.getItem().toString().equals("ȫ��")){
			 str = null;
		}
		List<StudentBean> list=sservice.find(schoolId, nameTxt.getText(), classTxt.getText(), str);
		

//		���±��,��ʾ��ѯ���
		studentTable.updateLovoTable(list);

	}

}
