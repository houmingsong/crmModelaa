package com.lovo.netCRM.work.frame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import com.lovo.netCRM.component.LovoButton;
import com.lovo.netCRM.component.LovoTable;
import com.lovo.netCRM.component.LovoTitleLabel;
import com.project.Bean.JobBean;
import com.project.service.IJobService;
import com.project.serviceImpl.JobServiceImpl;

/**
 * 
 * �Ĵ�����CRMϵͳ
 * @author �ųɷ�
 * @version 1.0
 * @see  
 * @description ְλ�������
 * ��������:2012-10-6
 */
public class WorkPanel  extends JPanel{
	/**ְλ������*/
	private LovoTable workTable;
	/**�������*/
	private JFrame jf;
	IJobService service=new JobServiceImpl();

	public WorkPanel(JFrame jf){
		this.jf = jf;
		this.setLayout(null);
		this.init();
	}
	/**
	 * ��ʼ��
	 *
	 */
	private void init() {
		new LovoTitleLabel("ְ λ �� ��",this);
		this.initTable();
		this.initButton();
		this.initData();
	}
	/**
	 * ��ʼ������
	 */
	public void initData(){
		this.updateWorkTable();
	}
	/**
	 * ��ʼ����ť
	 *
	 */
	private void initButton() {
		LovoButton lbadd = new LovoButton("�����ְλ",200,500,this);
		lbadd.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				
				new WorkAddDialog(jf,WorkPanel.this);
			}});
		
		
		LovoButton lbupdate = new LovoButton("�޸�ְλȨ��",400,500,this);
		lbupdate.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				int key = workTable.getKey();
				if(key == -1){
					JOptionPane.showMessageDialog(null,"��ѡ����");
					return;
				}
				
				new WorkUpdateDialog(jf,key,WorkPanel.this);
			}});
	}
	
	//--------------------------
	
	/**
	 * ��ʼ�����
	 */
	private void initTable() {
		workTable = new LovoTable(this,
				new String[]{"ְλ����","ְλ����","���Ϲ���","ѧУ����","�û�����","ͳ����Ϣ"},
				new String[]{"job","jobDescribe","isDataPower","isSchoolPower","isUserPower","isStatisticsPower"},//ְλʵ������������ new String[]{"workName","description"}
				"id");//���������� workId
		workTable.setSizeAndLocation(20, 90, 700, 300);
		
	}
	/**
	 * ���±������
	 */
	private void updateWorkTable(){
		//���±��,����ְλList����
		List<JobBean> list=service.findAll();
		workTable.updateLovoTable(list);
	}
}
