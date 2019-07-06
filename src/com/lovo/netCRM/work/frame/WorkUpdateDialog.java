package com.lovo.netCRM.work.frame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JDialog;
import javax.swing.JFrame;

import com.lovo.netCRM.component.LovoButton;
import com.lovo.netCRM.component.LovoCheckBox;
import com.lovo.netCRM.component.LovoLabel;
import com.lovo.netCRM.component.LovoTable;
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
 * @description �޸�ְλ�Ի���
 * ��������:2012-10-6
 */
public class WorkUpdateDialog extends JDialog{
	/**ְλ�����*/
	private WorkPanel workPanel;
	/**ְλ�����ı���*/
	private LovoLabel nameLabel = new LovoLabel("ְλ����",50,50,this);
	/**ְλ�����ı���*/
	private LovoTxtArea descriptionTxt = new LovoTxtArea("ְλ����",50,100,300,80,this);
	/**Ȩ�޸�ѡ��*/
	private LovoCheckBox gradeTxt = new LovoCheckBox("Ȩ��",new String[]{
			"���Ϲ���","ѧУ����","�û�����","ͳ����Ϣ"},50,200,this);
	IJobService service=new JobServiceImpl();

	/**ְλid*/
	private int workId;
	public WorkUpdateDialog(JFrame jf,int workId,WorkPanel workPanel){
		super(jf,true);
		this.workPanel = workPanel;
		this.workId = workId;
		
		this.setLayout(null);
		this.setTitle("�޸�ְλ");
		
		this.init();
		
		this.setBounds(350, 150, 550, 400);
		this.setVisible(true);
	}
	/**
	 * ��ʼ��
	 *
	 */
	private void init() {
		descriptionTxt.setEditable(false);
		this.initData(workId);
		LovoButton lbupdate = new LovoButton("�޸�",150,300,this);
		lbupdate.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				updateWork(workId);
				WorkUpdateDialog.this.dispose();
			}});
		
		LovoButton lbcancel = new LovoButton("ȡ��",330,300,this);
		lbcancel.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				WorkUpdateDialog.this.dispose();
			}});
	}
	
	
	//----------------------

	/**
	 * ��ʼ������
	 * @param workId ����ְλID
	 */
	private void initData(int workId) {
		//����ѡ����
		JobBean ba=service.findById(workId);		
		ba.setJob(nameLabel.getText());
		ba.setJobDescribe(descriptionTxt.getText());
		gradeTxt.setItem(new String[]{ba.getIsDataPower(),ba.getIsSchoolPower(),ba.getIsUserPower(),ba.getIsStatisticsPower()});
		
	}
	/**
	 * �޸�ְλ
	 * @param workId ����ְλid
	 */
	private void updateWork(int workId){
		String[] in=gradeTxt.getItem();
		service.update(workId, in[0], in[1], in[2], in[3]);
		
		//���±����ʾ�޸�ְλ���
		this.workPanel.initData();
	}
}
