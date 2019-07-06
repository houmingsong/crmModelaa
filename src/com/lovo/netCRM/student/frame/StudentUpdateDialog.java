package com.lovo.netCRM.student.frame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import com.lovo.netCRM.component.LovoButton;
import com.lovo.netCRM.component.LovoComboBox;
import com.lovo.netCRM.component.LovoLabel;
import com.lovo.netCRM.component.LovoRadioButton;
import com.lovo.netCRM.component.LovoTable;
import com.lovo.netCRM.component.LovoTxt;
import com.lovo.netCRM.component.LovoTxtArea;
import com.project.Bean.ClassBean;
import com.project.Bean.StudentBean;
import com.project.service.IClassService;
import com.project.service.IStudentService;
import com.project.serviceImpl.ClassServiceImpl;
import com.project.serviceImpl.StudentServiceImpl;

/**
 * 
 * �Ĵ�����CRMϵͳ
 * @author �ųɷ�
 * @version 1.0
 * @see  
 * @description ѧ����Ϣ�޸ĶԻ���
 * ��������:2012-10-14
 */
public class StudentUpdateDialog extends JDialog{
	/**ѧ�������*/
	private StudentPanel studentPanel;
	/**������ǩ*/
	private LovoLabel nameLabel = new LovoLabel("��    ��",50,50,this);
	/**�Ա��ǩ*/
	private LovoLabel sexLabel = new LovoLabel("��    ��",320,50,this);
	/**�������ڱ�ǩ*/
	private LovoLabel birthdayLabel = new LovoLabel("��������",50,100,this);
	/**�����༶*/
	private LovoComboBox classTxt;
	/**��ͥ��ַ��ǩ*/
	private LovoLabel addressLabel = new LovoLabel("��ͥ��ַ",50,150,this);
	/**��ϵ�绰�ı���*/
	private LovoTxt phoneTxt = new LovoTxt("��ϵ�绰",320,150,this);
	/**���ױ�ǩ*/
	private LovoLabel fatherLabel = new LovoLabel("��    ��",50,200,this);
	/**���׵绰�ı���*/
	private LovoTxt fatherPhoneTxt = new LovoTxt("���׵绰",320,200,this);
	/**ĸ�ױ�ǩ*/
	private LovoLabel mumLabel = new LovoLabel("ĸ    ��",50,250,this);
	/**ĸ�׵绰�ı���*/
	private LovoTxt mumPhoneTxt = new LovoTxt("ĸ�׵绰",320,250,this);
	/**ѧ��״̬������*/
	private LovoComboBox<String> stateTxt = new LovoComboBox<String>("ѧ��״̬",
			new String[]{"��Ա",
			"�ǻ�Ա"},50,300,this);
	/**��ע�ı���*/
	private LovoTxtArea descriptionTxt = new LovoTxtArea("��    ע",320,300,200,120,this);
	/**ѧУid*/
	private int schoolId;
	/**ѧ��id*/
	private int studentId;
	IStudentService sservice=new StudentServiceImpl();
	IClassService cservice=new ClassServiceImpl();

	public StudentUpdateDialog(JFrame jf,int schoolId,int studentId,StudentPanel studentPanel){
		super(jf,true);
		this.studentPanel = studentPanel;
		this.studentId = studentId;
		this.schoolId = schoolId;
		this.setLayout(null);
		this.setTitle("�޸�ѧ����Ϣ");
		
		this.init();
		
		this.setBounds(300, 150, 650, 530);
		this.setVisible(true);
	}
	/**
	 * ��ʼ��
	 *
	 */
	private void init() {
		this.initComboBox(schoolId);
		this.initData(studentId);

		LovoButton lbadd = new LovoButton("�޸�",200,450,this);
		lbadd.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				boolean isOk = updateStudent(studentId);
				if(isOk){
				StudentUpdateDialog.this.dispose();
				}
			}});
		
		LovoButton lbcancel = new LovoButton("ȡ��",400,450,this);
		lbcancel.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				StudentUpdateDialog.this.dispose();
			}});
	}
	
	//----------------------
	/**
	 * ��ʼ���༶������
	 *
	 */
	private void initComboBox(int schoolId){
//		��Ӱ༶����
		this.classTxt = new LovoComboBox("�����༶",new ArrayList(),320,100,this);
	}
	
	/**
	 * ��ʼ������
	 * @param studentId ѧ��ID
	 */
	private void initData(int studentId){
		StudentBean ban=sservice.findById(studentId);
		nameLabel.setText(ban.getStudentName());
		sexLabel.setText(ban.getSex());
		birthdayLabel.setText(ban.getBirthday().toString());
		classTxt.setItem(ban.getClassName());
		addressLabel.setText(ban.getAddress());
		phoneTxt.setText(ban.getTel());
		fatherLabel.setText(ban.getFatherName());
		fatherPhoneTxt.setText(ban.getFatherTel());
		mumLabel.setText(ban.getMotherName());
		mumPhoneTxt.setText(ban.getMotherTel());
		stateTxt.setItem(ban.getScondition());
		descriptionTxt.setText(ban.getScommment());
		
		
		
	}

	/**
	 * �޸�ѧ��
	 * @param studentId ѧ��ID
	 */
	private boolean updateStudent(int studentId){
		//��֤����,��֤ʧ�ܷ���false
		String str = "";
		//��֤����
		if(!this.nameLabel.getText().matches("[a-zA-Z\\u4e00-\\u9fa5]{2,20}")){
			str += "�����Ʊ���Ϊ��λ������ĸ����\n";
		}

		if(str.length() != 0){
			JOptionPane.showMessageDialog(null, str);
			return false;
		}
		//��װʵ��
		
		sservice.update(studentId,((ClassBean)classTxt.getSelectedItem()).getId() ,phoneTxt.getText(), fatherPhoneTxt.getText(), mumPhoneTxt.getText(), stateTxt.getItem(), descriptionTxt.getText());
		
		
		//���±����ʾ�޸Ľ��
		this.studentPanel.initData();
		
		return true;
	}
}
