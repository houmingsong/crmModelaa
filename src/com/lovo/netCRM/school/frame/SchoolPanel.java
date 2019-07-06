package com.lovo.netCRM.school.frame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import com.lovo.netCRM.component.LovoButton;
import com.lovo.netCRM.component.LovoComboBox;
import com.lovo.netCRM.component.LovoList;
import com.lovo.netCRM.component.LovoTable;
import com.lovo.netCRM.component.LovoTitleLabel;
import com.lovo.netCRM.component.LovoTitlePanel;
import com.lovo.netCRM.component.LovoTxt;
import com.project.Bean.CityBean;
import com.project.Bean.SchoolBean;
import com.project.service.ICityService;
import com.project.service.ISchoolService;
import com.project.serviceImpl.CityServiceImpl;
import com.project.serviceImpl.SchoolServiceImpl;

/**
 * 
 * �Ĵ�����CRMϵͳ
 * @author �ųɷ�
 * @version 1.0
 * @see  
 * @description ѧУ��ʾ���
 * ��������:2012-10-11
 */
public class SchoolPanel extends JPanel{
	/**ѧУ������*/
	private LovoTable schoolTable;
	/**�������*/
	private JFrame jf;
	/**����id*/
	private  int cityId;
	/**ѧУ�����ı���*/
	private LovoTxt nameTxt;
	/**ѧУ״̬������*/
	private LovoComboBox statusBox;
	
	ISchoolService service=new SchoolServiceImpl();
	ICityService cer=new CityServiceImpl();
	
	/**�����б��*/
	private LovoList cityList = new LovoList(20,90,150,300,this){
		public void onchange(Object t){
			cityId = getCityId(t);
			showSchool(cityId);
		}
	};
	public SchoolPanel(JFrame jf){
		this.jf = jf;
		this.setLayout(null);
		this.init();
	}
	/**
	 * ��ʼ��
	 *
	 */
	private void init() {
		new LovoTitleLabel("ѧ У �� ��",this);
		this.initTable();
		this.initButton();
		this.initData();
		this.initFindPanel();
	}
	/**
	 * ��ʼ������
	 */
	public void initData(){
		if(cityId==0){
			this.initList();
		}
		else{
			showSchool(cityId);
		}
	}
	
	/**
	 * ��ʼ����ť
	 *
	 */
	private void initButton() {
		LovoButton lbadd = new LovoButton("¼����ѧУ",50,500,this);
		lbadd.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				if(cityId == 0){
					JOptionPane.showMessageDialog(null, "��ѡ�����");
					return;
				}
				new SchoolAddDialog(jf,SchoolPanel.this,cityId);
			}});
		
		
		LovoButton lbshow = new LovoButton("�鿴ѧУ��Ϣ",170,500,this);
		lbshow.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				int key = schoolTable.getKey();
				if(key == -1){
					JOptionPane.showMessageDialog(null,"��ѡ����");
					return;
				}
				
				new SchoolShowDialog(jf,key);
			}});
		
		LovoButton lbupdate = new LovoButton("�޸�ѧУ��Ϣ",290,500,this);
		lbupdate.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				int key = schoolTable.getKey();
				if(key == -1){
					JOptionPane.showMessageDialog(null,"��ѡ����");
					return;
				}
				
				new SchoolUpdateDialog(jf,key,SchoolPanel.this);
			}});
		
		
		LovoButton lbask = new LovoButton("��������",50,580,this);
		lbask.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				int key = schoolTable.getKey();
				if(key == -1){
					JOptionPane.showMessageDialog(null,"��ѡ����");
					return;
				}
				
				apply(key,schoolTable.getSelectColumn(3));
			}});
		
		LovoButton lbcheck = new LovoButton("���",170,580,this);
		lbcheck.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				int key = schoolTable.getKey();
				if(key == -1){
					JOptionPane.showMessageDialog(null,"��ѡ����");
					return;
				}
				
				checkSchool(key,schoolTable.getSelectColumn(3));
			}});
		
		LovoButton lbAddSpeak = new LovoButton("��ӹ�ͨ��¼",290,580,this);
		lbAddSpeak.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				int key = schoolTable.getKey();
				if(key == -1){
					JOptionPane.showMessageDialog(null,"��ѡ����");
					return;
				}
				
				new SchoolCommunicateAddDialog(jf,key);
			}});
	}
	/**
	 * ��ʼ����ѯ��ť
	 *
	 */
	private void initFindPanel(){
		LovoTitlePanel jp = new LovoTitlePanel("��ѯѧУ",400, 400, 320, 250,this);
	
		nameTxt = new LovoTxt("ѧУ����",30,50,jp);
		this.statusBox = new LovoComboBox<String>("״̬",new String[]{"ȫ��","��Ǣ��","����","���δͨ��","�ƹ㿪չ"},30,130,jp);
		
		LovoButton lb = new LovoButton("����",180,200,jp);
		lb.setSize(60, 20);
		
		lb.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				if(cityId == 0){
				JOptionPane.showMessageDialog(null,"��ѡ�����");
					return;
				}
				findSchool(cityId);
				
			}

			});
		
	}
	
	//--------------------------
	/**
	 * ���ݳ��ж��󣬵õ�����id
	 * @param cityObj ���ж���
	 * @return
	 */
	private int getCityId(Object cityObj){
		
		int id=((CityBean)cityObj).getId();
		
		return id;
	}
	/**
	 * ��ʼ�����
	 */
	private void initTable() {
		schoolTable = new LovoTable(this,
				new String[]{"ѧУ����","У��","¼��ʱ��","״̬"},
				new String[]{"school","president","sTime","conditions"},//ѧУʵ������������ new String[]{"schoolName","schoolMaster"}
				"id");//���������� schoolId
		schoolTable.setSizeAndLocation(180, 90, 550, 300);
	
	}
	/**
	 * ��ʼ���б��
	 *
	 */
	private void initList() {
		List<SchoolBean> sb=new ArrayList<SchoolBean>();
			
		
		cityList.setList(cer.findAll());
	}
	/**
	 * ��ʾ���ж�Ӧ��ѧУ
	 * @param cityObj ���ж���
	 */
	private void showSchool(int cityId){
		
//		���±��,����List����
		schoolTable.updateLovoTable(service.find(cityId, null, null));
	}
	/**
	 * ��������
	 * @param schoolId ѧУID
	 * @param schoolState ѧУ״̬
	 * @param cityObj�����ж���
	 */
	private void apply(int schoolId,String schoolState){
		//��֤״̬�Ƿ�Ϊ����Ǣ�С������δͨ����
		if("��Ǣ��".equals(schoolState)||"���δͨ��".equals(schoolState)){
			service.apply(schoolId);
		}
		
		//��ʾ����������
		this.initData();
	}
	/**
	 * ���
	 * @param schoolId ѧУID
	 * @param schoolState ѧУ״̬
	 * @param cityObj ���ж���
	 */
	private void checkSchool(int schoolId,String schoolState){
//		��֤״̬�Ƿ�Ϊ������
		if("����".equals( schoolState)){
			return;
		}
		new SchoolCheckDialog(jf,schoolId,this);
	}
	/**
	 * ��������̬��ѯѧУ
	 * @param cityId ����ID
	 */
	private void findSchool(int cityId) {
		// TODO Auto-generated method stub
		String str = (String)statusBox.getItem();
		if("ȫ��".equals(str)){
			str=null;
		}
		//���±��
		schoolTable.updateLovoTable(service.find(cityId, nameTxt.getText(), str));
	}
}
