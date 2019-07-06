package com.lovo.netCRM.dept.frame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import com.lovo.netCRM.component.LovoButton;
import com.lovo.netCRM.component.LovoDate;
import com.lovo.netCRM.component.LovoTable;
import com.lovo.netCRM.component.LovoTxt;
import com.lovo.netCRM.component.LovoTxtArea;
import com.project.Bean.DepartmentBean;
import com.project.service.IDepartmentService;
import com.project.serviceImpl.DepartmentServiceImpl;
/**
 * 
 * �Ĵ�����CRMϵͳ
 * @author �ųɷ�
 * @version 1.0
 * @see  
 * @description ������ӶԻ���
 * ��������:2012-10-6
 */
public class DeptAddDialog extends JDialog{
	/**���������*/
	private DeptPanel deptPanel;
	/**���������ı���*/
	private LovoTxt nameTxt = new LovoTxt("��������",50,50,this);
	/**����ʱ���ı���*/
	private LovoDate timeTxt = new LovoDate("����ʱ��",50,100,this);
	/**���������ı���*/
	private LovoTxtArea descriptionTxt = new LovoTxtArea("��������",50,150,120,60,this);
	IDepartmentService service=new DepartmentServiceImpl();
	public DeptAddDialog(JFrame jf,DeptPanel deptPanel){
		super(jf,true);
		this.deptPanel = deptPanel;
		this.setLayout(null);
		this.setTitle("����²���");
		
		this.init();
		
		this.setBounds(400, 150, 350, 350);
		this.setVisible(true);
	}
	/**
	 * ��ʼ��
	 *
	 */
	private void init() {
		LovoButton lbadd = new LovoButton("���",50,250,this);
		lbadd.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				boolean isOk = addDept();
				if(isOk){
					DeptAddDialog.this.dispose();
				}
			}});
		
		LovoButton lbcancel = new LovoButton("ȡ��",180,250,this);
		lbcancel.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				DeptAddDialog.this.dispose();
			}});
	}
	
	//----------------------
	/**
	 * ��Ӳ���
	 */
	private boolean addDept(){
		

			
		//��֤���ݣ�������֤ʧ�ܷ���false
		String str = "";
		//��֤����
		if(!this.nameTxt.getText().matches("[a-zA-Z\\u4e00-\\u9fa5]{2,20}")){
			str += "�������Ʊ���Ϊ��λ������ĸ����\n";
		}

		if(str.length() != 0){
			JOptionPane.showMessageDialog(null, str);
			return false;
		}
		//��װʵ��
		DepartmentBean db=new DepartmentBean();
		db.setDepartment(nameTxt.getText());
		db.setDtime(Date.valueOf(timeTxt.getText()));
		db.setDepartmentDescribe(descriptionTxt.getText());
		service.addDepartment(db);
		
		//���±����ʾ��Ӳ��Ž��
		deptPanel.initData();
		return true;
	}
}
