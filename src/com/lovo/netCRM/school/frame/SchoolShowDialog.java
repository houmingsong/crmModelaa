package com.lovo.netCRM.school.frame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;

import com.lovo.netCRM.component.LovoButton;
import com.lovo.netCRM.component.LovoLabel;
import com.lovo.netCRM.component.LovoTable;
import com.lovo.netCRM.component.LovoTitlePanel;
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
 * @description ѧУ��Ϣ��ǩ
 * ��������:2012-10-11
 */
public class SchoolShowDialog extends JDialog{

	/**ѧУid*/
	private int schoolId;
	/**ѧУ��ͨ��¼���*/
	private LovoTable communicateTable;
	/**ѧУ���Ʊ�ǩ*/
	private LovoLabel nameLabel = new LovoLabel("ѧУ����",50,40,this);
	/**��������*/
	private LovoLabel cityLabel = new LovoLabel("��������",320,40,this);;
	/**��ַ��ǩ*/
	private LovoLabel addressLabel = new LovoLabel("ѧУ��ַ",50,80,this);
	/**У����ǩ*/
	private LovoLabel masterLabel = new LovoLabel("У��",320,80,this);
	/**��ϵ�绰��ǩ*/
	private LovoLabel phoneLabel = new LovoLabel("��ϵ�绰",50,120,this);
	/**ѧ��������ǩ*/
	private LovoLabel studentNumberLabel = new LovoLabel("ѧ������",320,120,this);
	/**��ʦ������ǩ*/
	private LovoLabel teacherNumberLabel = new LovoLabel("��ʦ����",50,160,this);
	/**ip��ַ��ǩ*/
	private LovoLabel ipLabel = new LovoLabel("ip��ַ",320,160,this);
	/**���������ǩ*/
	private LovoLabel netFluxLabel = new LovoLabel("�������",50,200,this);
	/**״̬��ǩ*/
	private LovoLabel stateLabel = new LovoLabel("״̬",320,200,this);
	
	/**�����ű�ǩ*/
	private LovoLabel deptLabel = new LovoLabel("������",50,240,this);
	/**¼��ʱ��*/
	private LovoLabel enterTimeLabel = new LovoLabel("¼��ʱ��",320,240,this);
	/**��������ʱ��*/
	private LovoLabel applyTimeLabel = new LovoLabel("��������ʱ��",50,280,this);
	/**������׼ʱ��*/
	private LovoLabel passTimeLabel = new LovoLabel("������׼ʱ��",320,280,this);
	/**˵���ı���*/
	private LovoTxtArea descriptionTxt = new LovoTxtArea("˵��",50,320,150,100,this);
	/**��������ı���*/
	private LovoTxtArea mindTxt = new LovoTxtArea("�������",320,320,150,100,this);
	ISchoolService service=new SchoolServiceImpl();
	
	IDepartmentService dervice=new DepartmentServiceImpl();
	
	public SchoolShowDialog(JFrame jf,int schoolId){
		super(jf,true);
		this.schoolId = schoolId;
		
		this.setLayout(null);
		this.setTitle("ѧУ��Ϣһ��");
		
		this.init();
		
		this.setBounds(300, 10, 650, 700);
		this.setVisible(true);
	}
	/**
	 * ��ʼ��
	 *
	 */
	private void init() {
		this.initData(this.schoolId);
		this.descriptionTxt.setEditable(false);
		this.mindTxt.setEditable(false);
		
		/*��ͨ��¼����*/
		LovoTitlePanel jp = new LovoTitlePanel("��ͨ��¼",80, 420, 500, 200,this);
		
		this.initTable(this.schoolId,jp);
		
		LovoButton lbcancel = new LovoButton("ȷ��",280,640,this);
		lbcancel.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				SchoolShowDialog.this.dispose();
			}});
	}
	
	//----------------------
	
	/**
	 * ��ʼ����ǩ����
	 * @param schoolId ѧУID
	 */
	private void initData(int schoolId){
		SchoolBean ban=service.findById(schoolId);
		System.out.println(schoolId+" "+ban);
		nameLabel.setText(ban.getSchool());
		cityLabel.setText(ban.getCity());
		addressLabel.setText(ban.getAddress());
		masterLabel.setText(ban.getPresident());
		phoneLabel.setText(ban.getTel());
		studentNumberLabel.setText(ban.getStudentAmount()+"");
		teacherNumberLabel.setText(ban.getTeacherAmount()+"");
		ipLabel.setText(ban.getIp());
		netFluxLabel.setText(ban.getTraffic());
		stateLabel.setText(ban.getConditions());
		deptLabel.setText(ban.getDepartment());
		enterTimeLabel.setText(ban.getsTime().toString());
		applyTimeLabel.setText(ban.getApplyDate().toString());		
		passTimeLabel.setText(ban.getPassDate().toString());
		descriptionTxt.setText(ban.getSchoolDescribe());
		mindTxt.setText(ban.getApproveIdea());
		
		
		
		
		
	}
	/**
	 * ��ʼ�����
	 * @param schoolId ѧУID
	 */
	private void initTable(int schoolId,JPanel jp){
		communicateTable = new LovoTable(jp,
				new String[]{"ʱ��","У����ϵ��","ְ��","��ͨ��","��ͨ����"},
				new String[]{"cTime","schoolLinked","job","employeeID","details"},//ѧУʵ������������ new String[]{"time","schoolConnector"}
				"id");//���������� schoolId
		communicateTable.setSizeAndLocation(10, 20, 480, 170);
		
		//���±��,����List����
		communicateTable.updateLovoTable(service.findById(schoolId).getCommuunicationList());
	}
	

}
