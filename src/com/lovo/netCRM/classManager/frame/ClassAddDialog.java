package com.lovo.netCRM.classManager.frame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JDialog;
import javax.swing.JFrame;

import com.lovo.netCRM.component.LovoButton;
import com.lovo.netCRM.component.LovoTable;
import com.lovo.netCRM.component.LovoTxt;
import com.project.Bean.ClassBean;
import com.project.service.IClassService;
import com.project.serviceImpl.ClassServiceImpl;

/**
 * 
 * �Ĵ�����CRMϵͳ
 * @author �ųɷ�
 * @version 1.0
 * @see  
 * @description ��Ӱ༶�Ի���
 * ��������:2012-10-14
 */
public class ClassAddDialog extends JDialog{
	/**�༶���*/
	private LovoTable classTable;
	/**�༶�����ı���*/
	private LovoTxt nameTxt = new LovoTxt("�༶����",50,60,this);
	/**������ʦ�ı���*/
	private LovoTxt teacherTxt = new LovoTxt("������ʦ",50,140,this);
	/**ѧУid*/
	private int schoolId;
	/**�༶���*/
	private ClassManagerPanel classManagerPanel;
	IClassService service=new ClassServiceImpl();
	
	public ClassAddDialog(JFrame jf,int schoolId,ClassManagerPanel classManagerPanel){
		super(jf,true);
		this.schoolId = schoolId;
		this.classManagerPanel = classManagerPanel;
		this.setLayout(null);
		this.setTitle("��Ӱ༶");
		
		this.init();
		
		this.setBounds(400, 200, 350, 300);
		this.setVisible(true);
	}
	
	/**
	 * ��ʼ��
	 *
	 */
	private void init() {
		
		LovoButton lbadd = new LovoButton("���",60,220,this);
		lbadd.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				boolean isOk = addClass(schoolId);
				if(isOk){
				ClassAddDialog.this.dispose();
				}
			}});
		
		LovoButton lbcancel = new LovoButton("ȡ��",200,220,this);
		lbcancel.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				ClassAddDialog.this.dispose();
			}});
	}
	
	//---------------------
	/**
	 * ��Ӱ༶
	 * @param schoolId ѧУid
	 */
	private boolean addClass(int  schoolId){
		
		//��֤���ݣ���֤ʧ�ܣ�����false
		
		ClassBean cb=new ClassBean();
		cb.setClassName(nameTxt.getText());
		cb.setTeacher(teacherTxt.getText());
		cb.setSchoolId(schoolId);
		service.addClass(cb);
		
//		���±����ʾ��ӽ��
		this.classManagerPanel.initData();
		
		return true;
	}
}
