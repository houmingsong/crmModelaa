package com.lovo.netCRM.frame;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;

import com.lovo.netCRM.classManager.frame.ClassManagerPanel;
import com.lovo.netCRM.component.LovoTree;
import com.lovo.netCRM.component.LovoTreeNode;
import com.lovo.netCRM.count.frame.AddressCountPanel;
import com.lovo.netCRM.count.frame.SchoolCountPanel;
import com.lovo.netCRM.dept.frame.DeptPanel;
import com.lovo.netCRM.employee.frame.EmployeePanel;
import com.lovo.netCRM.school.frame.SchoolPanel;
import com.lovo.netCRM.schoolActive.frame.SchoolActivePanel;
import com.lovo.netCRM.student.frame.StudentPanel;
import com.lovo.netCRM.system.frame.LogPanel;
import com.lovo.netCRM.system.frame.UpdatePwdPanel;
import com.lovo.netCRM.work.frame.WorkPanel;
import com.project.Bean.EmployeeBean;
import com.project.service.IEmployeeService;
import com.project.serviceImpl.EmployeeServiceImpl;


/**
 * 
 * �Ĵ�����CRMϵͳ
 * @author �ųɷ�
 * @version 1.0
 * @see  
 * @description ����������
 * ��������:2012-4-20
 */
public class MainFrame extends JFrame{
	/**���β˵�*/
	private LovoTree tree;
	/**�ұߵ��������*/
	private JPanel mainPanel = new JPanel();
	/**��Ƭ����*/
	private CardLayout card = new CardLayout();
	/**��½�û�ʵ��*/
	private Object userObj;
	/**Ա�������*/
	private EmployeePanel emPanel = new EmployeePanel(this);
	/**���������*/
	private DeptPanel deptPanel = new DeptPanel(this);
	/**ְλ�����*/
	private WorkPanel workPanel = new WorkPanel(this);
	/**ѧУ������*/
	private SchoolActivePanel schoolActivePanel =  new SchoolActivePanel(this);
	/**ѧУ���������*/
	private SchoolPanel schoolPanel = new SchoolPanel(this);
	/**�༶���������*/
	private ClassManagerPanel classManagerPanel = new ClassManagerPanel(this);
	/**ѧ�������*/
	private StudentPanel studentPanel = new StudentPanel(this);
	/**����ͳ�������*/
	private AddressCountPanel addressCountPanel = new AddressCountPanel();
	/**ѧУͳ�������*/
	private SchoolCountPanel schoolCountPanel = new SchoolCountPanel();
	/**�޸��������*/
	private UpdatePwdPanel updatePwdPanel;
	/**��־���*/
	private LogPanel logPanel = new LogPanel();
	public MainFrame(Object userObj){
		super("�Ĵ�����CRMϵͳ");
		this.userObj = userObj;
		updatePwdPanel = new UpdatePwdPanel(userObj);
		this.initTree();
		this.initPanel();
		
		
		this.setSize(1000,700);
		this.setVisible(true);
		this.setDefaultCloseOperation(3);
		this.setLocationRelativeTo(null);
	}
	/**
	 * ��ʼ�����������
	 *
	 */
	private void initPanel() {
		//���������Ĳ��ֹ�����Ϊ��Ƭ����
		mainPanel.setLayout(this.card);
		this.add(mainPanel);
		
		//�������ֵ����������壬ÿ����һ����壬�ɵڶ������������ȡ��
		mainPanel.add(new InitPanel(),"init");
		mainPanel.add(emPanel,"employee");
		mainPanel.add(deptPanel,"dept");
		mainPanel.add(workPanel,"work");
		mainPanel.add(schoolActivePanel,"active");
		mainPanel.add(schoolPanel,"school");
		mainPanel.add(classManagerPanel,"class");
		mainPanel.add(studentPanel,"student");
		mainPanel.add(addressCountPanel,"addressCount");
		mainPanel.add(schoolCountPanel,"schoolCount");
		mainPanel.add(updatePwdPanel,"updatePwd");
		mainPanel.add(logPanel,"log");
	}
	
	
	/**
	 * �������β˵�
	 *
	 */
	private void initTree() {
		//���ڵ�
		LovoTreeNode rootNode = new LovoTreeNode("�Ĵ�����CRMϵͳ");
		
		//֦�ڵ�
		LovoTreeNode sorceNode = new LovoTreeNode("���Ϲ���");
		LovoTreeNode schoolNode = new LovoTreeNode("ѧУ����");
		LovoTreeNode userNode = new LovoTreeNode("�û�����");
		LovoTreeNode countNode = new LovoTreeNode("ͳ����Ϣ");
		LovoTreeNode systemNode = new LovoTreeNode("ϵͳ����");
		
		//Ҷ�ڵ�
		LovoTreeNode employeeNode = new LovoTreeNode("Ա������"){
			
			public void addListener(){
				//�л���"employee"��ǩָ�������
				card.show(mainPanel, "employee");
			}
		};
		
		
		LovoTreeNode deptNode = new LovoTreeNode("���Ź���"){
			
			public void addListener(){
				card.show(mainPanel, "dept");
			}
		};
		
		LovoTreeNode workNode = new LovoTreeNode("ְλ����"){
			
			public void addListener(){
				card.show(mainPanel, "work");
			}
		};
		
		LovoTreeNode activeNode = new LovoTreeNode("ѧУ�"){
			public void addListener(){
				schoolActivePanel.initData();
				card.show(mainPanel, "active");
			}
		};
		LovoTreeNode smNode = new LovoTreeNode("ѧУ����"){
			public void addListener(){
				schoolPanel.initData();
				card.show(mainPanel, "school");
			}
		};
		
		LovoTreeNode studentNode = new LovoTreeNode("ѧ������"){
			public void addListener(){
				studentPanel.setSchoolId(0);
				studentPanel.initData();
				card.show(mainPanel, "student");
			}
		};
		
		LovoTreeNode classNode = new LovoTreeNode("�༶����"){
			public void addListener(){
				studentPanel.setSchoolId(0);
				classManagerPanel.initData();
				card.show(mainPanel, "class");
			}
		};
		
		
		LovoTreeNode areaNode = new LovoTreeNode("����ͳ��"){
			public void addListener(){
				addressCountPanel.initData();
				card.show(mainPanel, "addressCount");
			}
		};
		
		LovoTreeNode scNode = new LovoTreeNode("ѧУͳ��"){
			public void addListener(){
				schoolCountPanel.initData();
				card.show(mainPanel, "schoolCount");
			}
		};
		
		LovoTreeNode upNode = new LovoTreeNode("�޸�����"){
			public void addListener(){
				card.show(mainPanel, "updatePwd");
			}
		};
		
		LovoTreeNode logNode = new LovoTreeNode("��־һ��"){
			public void addListener(){
				card.show(mainPanel, "log");
			}
		};
		
		//��Ҷ�ڵ����֦�ڵ�
		sorceNode.add(employeeNode);
		sorceNode.add(deptNode);
		sorceNode.add(workNode);
		
		schoolNode.add(activeNode);
		schoolNode.add(smNode);
		
		userNode.add(studentNode);
		userNode.add(classNode);
		
		countNode.add(areaNode);
		countNode.add(scNode);
		
		systemNode.add(upNode);
		systemNode.add(logNode);
		
		initNode(rootNode,sorceNode,schoolNode,userNode,countNode,systemNode);
		
		
		//�������β˵�
		this.tree = new LovoTree(rootNode);
		//�������β˵�������
		this.tree.setFont(new Font("�����п�",Font.BOLD,25));
		
		//�����β˵����봰��
		this.add(this.tree,BorderLayout.WEST);
	}
	
	//--------------------
	/**
	 * ��֦�ڵ������ڵ㡣������ӵĽڵ�Ҫ���ݵ�½�û��ĵȼ�����
	 */
	private void initNode(LovoTreeNode rootNode,LovoTreeNode sorceNode,
			LovoTreeNode schoolNode,LovoTreeNode userNode,
			LovoTreeNode countNode,LovoTreeNode systemNode){
		//EmployeBean employee = (EmployeeBean)userObj;
		
		//if(employee.getSource().equals("��")){
		//�������Ϲ���ڵ�
		rootNode.add(sorceNode);
		//}
		//����ѧУ����ڵ�
		rootNode.add(schoolNode);
		//�����û���Ϣ�ڵ�
		rootNode.add(userNode);
		//����ͳ����Ϣ�ڵ�
		rootNode.add(countNode);
		//����ϵͳ����ڵ�
		rootNode.add(systemNode);
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		IEmployeeService  service=new EmployeeServiceImpl();
		EmployeeBean em=service.login("ccc", "222");
		MainFrame frame = new MainFrame(em);
	}

}
