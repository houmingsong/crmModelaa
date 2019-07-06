package com.lovo.netCRM.school.frame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JDialog;
import javax.swing.JFrame;

import com.lovo.netCRM.component.LovoButton;
import com.lovo.netCRM.component.LovoComboBox;

import com.lovo.netCRM.component.LovoTable;
import com.lovo.netCRM.component.LovoTxt;
import com.lovo.netCRM.component.LovoTxtArea;
import com.project.Bean.SchoolBean;
import com.project.service.IDepartmentService;
import com.project.service.ISchoolService;
import com.project.serviceImpl.DepartmentServiceImpl;
import com.project.serviceImpl.SchoolServiceImpl;


/**
 * 
 * �Ĵ�����CRMϵͳ
 * @author �ųɷ�
 * @version 1.0
 * @see  
 * @description ���ѧУ�Ի���
 * ��������:2012-10-11
 */
public class SchoolAddDialog extends JDialog{
	/**ѧУ�����*/
	private SchoolPanel schoolPanel;
	/**ѧУ�����ı���*/
	private LovoTxt nameTxt = new LovoTxt("ѧУ����",50,50,this);
	/**��ַ�ı���*/
	private LovoTxt addressTxt = new LovoTxt("ѧУ��ַ",50,100,this);
	/**У���ı���*/
	private LovoTxt masterTxt = new LovoTxt("У��",320,50,this);
	/**��ϵ�绰�ı���*/
	private LovoTxt phoneTxt = new LovoTxt("��ϵ�绰",50,150,this);
	/**ѧ�������ı���*/
	private LovoTxt studentNumberTxt = new LovoTxt("ѧ������",320,100,this);
	/**��ʦ�����ı���*/
	private LovoTxt teacherNumberTxt = new LovoTxt("��ʦ����",50,200,this);
	/**ip��ַ�ı���*/
	private LovoTxt ipTxt = new LovoTxt("ip��ַ",320,150,this);
	/**��������ı���*/
	private LovoTxt netFluxTxt = new LovoTxt("�������",50,250,this);
	
	/**������*/
	private LovoComboBox deptTxt;
	
	/**˵���ı���*/
	private LovoTxtArea descriptionTxt = new LovoTxtArea("˵��",320,200,200,120,this);
	/**����ID*/
	private int cityId;
	ISchoolService service=new SchoolServiceImpl();
	IDepartmentService dm=new DepartmentServiceImpl();

	
	public SchoolAddDialog(JFrame jf,SchoolPanel schoolPanel,int cityId){
		super(jf,true);
		this.schoolPanel = schoolPanel;
		this.cityId = cityId;

		this.setLayout(null);
		this.setTitle("¼����ѧУ");
		
		this.init();
		
		this.setBounds(300, 150, 650, 500);
		this.setVisible(true);
	}
	/**
	 * ��ʼ��
	 *
	 */
	private void init() {
		this.initComboBox();
		
		LovoButton lbadd = new LovoButton("���",200,400,this);
		lbadd.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				boolean isOk = addSchool(cityId);
				if(isOk){
					SchoolAddDialog.this.dispose();
				}
			}});
		
		LovoButton lbcancel = new LovoButton("ȡ��",400,400,this);
		lbcancel.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				SchoolAddDialog.this.dispose();
			}});
	}
	
	//----------------------
	
	/**
	 * ��ʼ��������������
	 *
	 */
	private void initComboBox(){
		//��Ӳ���List����
		this.deptTxt = new LovoComboBox("������",dm.findAll(),50,300,this);
		
	}
	
	/**
	 * ���ѧУ
	 */
	private boolean addSchool(int cityId){
		//��֤���ݣ���֤ʧ�ܷ���false
		String str = "";
		//��֤����
		if(!this.nameTxt.getText().matches("[a-zA-Z\\u4e00-\\u9fa5]{2,20}")){
			str += "ѧУ��������Ϊ��λ������ĸ����\n";
		}
		 if(!this.phoneTxt.getText().matches("\\d{11}")){
			   str+="��ϵ��ʽΪ11λ��Ч����";
		   }
		 if(!this.ipTxt.getText().matches("[1-9]{2,3}.[1-9]{2,3}.[1-9]{2,3}")){
			 str+="ip��ַ����61.120.56,55 ��ʽ";
		 }
		
		//��װʵ��
			 SchoolBean s=service.findById(cityId);
			 s.setSchool(nameTxt.getText());
			 s.setPresident(masterTxt.getText());
		     s.setAddress(addressTxt.getText());
		     s.setTel(phoneTxt.getText());
		     s.setStudentAmount(Integer.parseInt(studentNumberTxt.getText()));
		     s.setTeacherAmount(Integer.parseInt(teacherNumberTxt.getText()));
		     s.setIp(ipTxt.getText());
		     s.setTraffic(netFluxTxt.getText());
		     s.setDepartment(deptTxt.getSelectedItem().toString());
		     s.setSchoolDescribe(descriptionTxt.getText());
		 service.addschool(s);
		//���±����ʾ��ӽ��
		this.schoolPanel.initData();
		
		return true;
	}
}
