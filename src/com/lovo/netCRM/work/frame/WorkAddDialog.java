package com.lovo.netCRM.work.frame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import com.lovo.netCRM.component.LovoButton;
import com.lovo.netCRM.component.LovoCheckBox;
import com.lovo.netCRM.component.LovoTable;
import com.lovo.netCRM.component.LovoTxt;
import com.lovo.netCRM.component.LovoTxtArea;
import com.project.Bean.JobBean;
import com.project.service.IJobService;
import com.project.serviceImpl.JobServiceImpl;
/**
 * 
 * �Ĵ�����CRMϵͳ
 * @author �ųɷ�
 * @version 1.0
 * @see  
 * @description ���ְλ�Ի���
 * ��������:2012-10-6
 */
public class WorkAddDialog extends JDialog{
	/**ְλ�����*/
	private WorkPanel workPanel;
	/**ְλ�����ı���*/
	private LovoTxt nameTxt = new LovoTxt("ְλ����",50,50,this);
	/**ְλ�����ı���*/
	private LovoTxtArea descriptionTxt = new LovoTxtArea("ְλ����",50,100,300,80,this);
	IJobService service=new JobServiceImpl();
	/**Ȩ�޸�ѡ��*/
	private LovoCheckBox gradeTxt = new LovoCheckBox("Ȩ��",
			new String[]{"���Ϲ���","ѧУ����","�û�����","ͳ����Ϣ"},50,200,this);
	
	public WorkAddDialog(JFrame jf,WorkPanel workPanel){
		super(jf,true);
		this.workPanel = workPanel;
		this.setLayout(null);
		this.setTitle("�����ְλ");
		
		this.init();
		
		this.setBounds(350, 150, 550, 400);
		this.setVisible(true);
	}
	/**
	 * ��ʼ��
	 *
	 */
	private void init() {
		LovoButton lbadd = new LovoButton("���",150,300,this);
		lbadd.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				boolean isOk = addWork();
				if(isOk){
					WorkAddDialog.this.dispose();
				}
			}});
		
		LovoButton lbcancel = new LovoButton("ȡ��",330,300,this);
		lbcancel.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				WorkAddDialog.this.dispose();
			}});
	}
	
	//----------------------
	/**
	 * ���ְλ
	 */
	private boolean addWork(){
		//��֤���ݣ�������֤ʧ�ܷ���false
		String str = "";
		//��֤����
		if(!this.nameTxt.getText().matches("[a-zA-Z\\u4e00-\\u9fa5]{2,20}")){
			str += "ְλ���Ʊ���Ϊ��λ������ĸ����\n";
		}

		if(str.length() != 0){
			JOptionPane.showMessageDialog(null, str);
			return false;
		}
		//��װʵ��
		JobBean ba=new JobBean();
		ba.setJob(nameTxt.getText());
		ba.setJobDescribe(descriptionTxt.getText());		 		 						
		//�õ�ѡ��������
		String[] items = gradeTxt.getItem();
		ba.setIsDataPower(items[0]);
		ba.setIsSchoolPower(items[1]);
		ba.setIsUserPower(items[2]);
		ba.setIsStatisticsPower(items[3]);				
		service.addJob(ba);
		//���±����ʾ���ְλ���
		workPanel.initData();
		return true;
	}
}
