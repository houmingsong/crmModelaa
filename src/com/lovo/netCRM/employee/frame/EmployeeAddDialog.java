package com.lovo.netCRM.employee.frame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.util.ArrayList;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import com.lovo.netCRM.component.LovoButton;
import com.lovo.netCRM.component.LovoComboBox;
import com.lovo.netCRM.component.LovoDate;
import com.lovo.netCRM.component.LovoFileChooser;
import com.lovo.netCRM.component.LovoRadioButton;
import com.lovo.netCRM.component.LovoTable;
import com.lovo.netCRM.component.LovoTxt;
import com.project.Bean.EmployeeBean;
import com.project.Bean.JobBean;
import com.project.Bean.DepartmentBean;
import com.project.service.IDepartmentService;
import com.project.service.IEmployeeService;
import com.project.service.IJobService;
import com.project.serviceImpl.DepartmentServiceImpl;
import com.project.serviceImpl.EmployeeServiceImpl;
import com.project.serviceImpl.JobServiceImpl;
/**
 * 
 * �Ĵ�����CRMϵͳ
 * @author �ųɷ�
 * @version 1.0
 * @see  
 * @description ���Ա���Ի���
 * ��������:2012-10-6
 */
public class EmployeeAddDialog extends JDialog{

	private static final String DepartmentBean = null;
	/**�����ı���*/
	private LovoTxt nameTxt = new LovoTxt("��    ��",40,50,this);
	/**�Ա�ѡť*/
	private LovoRadioButton sexTxt = new LovoRadioButton("��    ��",new String[]{"��","Ů"},320,50,this);
	/**��½���ı���*/
	private LovoTxt loginNameTxt = new LovoTxt("��½��",40,100,this);
	/**��������*/
	private LovoDate birthdayTxt = new LovoDate("��������",40,150,this);
	/**�Ļ��̶�*/
	private LovoComboBox<String> eduTxt = new LovoComboBox<String>("�Ļ��̶�",new String[]{"����","��ר","����","˶ʿ"},320,100,this);
	/**����רҵ�ı���*/
	private LovoTxt specialityTxt = new LovoTxt("����רҵ",40,200,this);
	/**��ϵ��ʽ�ı���*/
	private LovoTxt phoneTxt = new LovoTxt("��ϵ��ʽ",320,150,this);
	/**��ͥסַ�ı���*/
	private LovoTxt addressTxt = new LovoTxt("��ͥסַ",40,250,this);
	/**������ò*/
	private LovoComboBox<String> polityFaceTxt = new LovoComboBox<String>("������ò",new String[]{"��Ա","��Ա","��������","�޵�����ʿ"},320,200,this);
	/**���ڲ���*/
	private LovoComboBox deptTxt;
	/**����ְλ*/
	private LovoComboBox jobTxt;
	/**ͷ��*/
	private LovoFileChooser faceTxt = new LovoFileChooser(this,"face");
	/**Ա�������*/
	private EmployeePanel emPanel;
	IEmployeeService service=new EmployeeServiceImpl();
	IDepartmentService dm=new DepartmentServiceImpl();
	IJobService js=new JobServiceImpl();
	
	public EmployeeAddDialog(JFrame jf,EmployeePanel emPanel){
		super(jf,true);
		this.emPanel = emPanel;
		this.setLayout(null);
		this.setTitle("�����Ա��");
		
		this.init();
		
		this.setBounds(300, 100, 700, 450);
		this.setVisible(true);
	}
	/**
	 * ��ʼ��
	 *
	 */
	private void init(){
		this.initComboBox();
		
		faceTxt.setBounds(580, 70, 100, 150);
		
		LovoButton lbadd = new LovoButton("���",150,360,this);
		lbadd.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				boolean isOk = addEmployee();
				if(isOk){
					EmployeeAddDialog.this.dispose();
				}
			}});
		
		LovoButton lbcancel = new LovoButton("ȡ��",400,360,this);
		lbcancel.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				EmployeeAddDialog.this.dispose();
			}});
	}
	
	//--------------------------------------------
	/**
	 * ��ʼ�����ź�ְλ������
	 *
	 */
	private void initComboBox(){
		//��Ӳ���List����
	this.deptTxt = new LovoComboBox("��������",dm.findAll(),40,300,this);	
		
		//���ְλList����
		this.jobTxt = new LovoComboBox("����ְλ",js.findAll(),320,250,this);
	
	
	}
	/**
	 * ��Ӳ���
	 *
	 */
	private boolean addEmployee(){
		String str = "";
		//��֤����
		if(!this.nameTxt.getText().matches("[a-zA-Z\\u4e00-\\u9fa5]{2,20}")){
			str += "�û�������Ϊ��λ������ĸ����\n";
		}
			
		if(!this.loginNameTxt.getText().matches("[a-zA-Z\\u4e00-\\u9fa5]{2,20}")){
			str+= "��¼������Ϊ��λ������ĸ����\n";
		}
		if(!this.birthdayTxt.getText().matches("\\d{4}-\\d{2}-\\d{2}")){
			str+="����������Ϊ4-2��ʽ";
		}
	   if(!this.phoneTxt.getText().matches("\\d{11}")){
		   str+="��ϵ��ʽΪ11λ��Ч����";
	   }
		
		
		
		if(str.length() != 0){
			JOptionPane.showMessageDialog(null, str);
			return false;
		}
		
		//��װʵ��
		EmployeeBean em=new EmployeeBean();
		em.setEname(nameTxt.getText());
		em.setSex(sexTxt.getItem());
		em.setBirthday(Date.valueOf(birthdayTxt.getText()));
		em.setEdu(eduTxt.getItem());
		em.setTel(phoneTxt.getText());
		
		em.setJobID(((JobBean)jobTxt.getItem()).getId());
		em.setDepartmentId(((DepartmentBean)deptTxt.getItem()).getId());
		
		em.setCodeName(loginNameTxt.getText());
		em.setMajor(specialityTxt.getText());
		em.setParty(polityFaceTxt.getItem());
		em.setAddress(addressTxt.getText());
	   em.setImgPath(faceTxt.getFilePath());
		
		//�����Ӳ���
		service.add(em);
//		��������,��ʾ��ӽ��
		this.emPanel.initData();
		return true;
	}
}
