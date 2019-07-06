package com.lovo.netCRM.employee.frame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.lovo.netCRM.component.LovoButton;
import com.lovo.netCRM.component.LovoTable;
import com.lovo.netCRM.component.LovoTitleLabel;
import com.lovo.netCRM.component.LovoTitlePanel;
import com.lovo.netCRM.component.LovoTxt;
import com.project.Bean.EmployeeBean;
import com.project.service.IEmployeeService;
import com.project.serviceImpl.EmployeeServiceImpl;
/**
 * 
 * 四川网脉CRM系统
 * @author 张成峰
 * @version 1.0
 * @see  
 * @description 员工管理面板
 * 开发日期:2012-10-5
 */
public class EmployeePanel extends JPanel{
	/**员工表格组件*/
	private LovoTable employeeTable;
	/**窗体组件*/
	private JFrame jf;
	/**员工姓名文本框*/
	private LovoTxt nameTxt;
	/**文化程度文本框*/
	private LovoTxt eduTxt;
	/**部门文本框*/
	private LovoTxt deptTxt;
	/**职位文本框*/
	private LovoTxt jobTxt;
	IEmployeeService service=new EmployeeServiceImpl();

	
	
	public EmployeePanel(JFrame jf){
		this.jf = jf;
		this.setLayout(null);
		this.init();
	}
	/**
	 * 初始化
	 *
	 */
	private void init() {
		new LovoTitleLabel("员 工 管 理",this);
		this.initTable();
		this.initButton();
		this.initFindPanel();
		this.initData();
	}
	/**
	 * 初始化数据
	 */
	public void initData(){
		this.updateEmployeeTable();
	}
	/**
	 * 初始化按钮
	 *
	 */
	private void initButton() {
		LovoButton lbadd = new LovoButton("添加新员工",50,500,this);
		lbadd.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				new EmployeeAddDialog(jf,EmployeePanel.this);
			}});
		
		LovoButton lbdel = new LovoButton("删除员工",250,500,this);
		lbdel.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				int key = employeeTable.getKey();
				if(key == -1){
					JOptionPane.showMessageDialog(null,"请选择行");
					return;
				}
				
				delEmployee(key);
			}});
		
		
		LovoButton lbupdate = new LovoButton("修改员工信息",50,570,this);
		lbupdate.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				int key = employeeTable.getKey();
				if(key == -1){
					JOptionPane.showMessageDialog(null,"请选择行");
					return;
				}
				
				new EmployeeUpdateDialog(jf,key,EmployeePanel.this);
			}});
		
		
		LovoButton lbshow = new LovoButton("查看员工信息",250,570,this);
		lbshow.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				int key = employeeTable.getKey();
				if(key == -1){
					JOptionPane.showMessageDialog(null,"请选择行");
					return;
				}
				
				new EmployeeShowDialog(jf,key);
			}});
	}
	/**
	 * 初始化查询按钮
	 *
	 */
	private void initFindPanel(){

		LovoTitlePanel jp = new LovoTitlePanel("查询员工",400, 400, 320, 250,this);
		this.nameTxt = new LovoTxt("员工姓名",30,30,jp);
		this.eduTxt = new LovoTxt("文化程度",30,70,jp);
		this.deptTxt = new LovoTxt("所在部门",30,110,jp);
		this.jobTxt = new LovoTxt("工作职位",30,150,jp);
		
		LovoButton lb = new LovoButton("查找",180,200,jp);
		lb.setSize(60, 20);
		
		lb.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				findEmployee();
				
			}});
		
	}

	
	//-------------------------------------------------
	/**
	 * 初始化表格
	 *
	 */
	private void initTable() {
		employeeTable = new LovoTable(this,
				new String[]{"姓名","性别","出生日期","文化程度","联系方式","所在部门", "工作职位"},
				new String[]{"ename","sex","birthday","edu","tel","department","job"},//员工实体属性名数组 new String[]{"employeeName","sex"}
				"id");//主键属性名 employeeId
		employeeTable.setSizeAndLocation(20, 90, 700, 300);
		
	}
	/**
	 * 更新表格数据
	 */
	private void updateEmployeeTable(){
		List<EmployeeBean> list=service.findByItem(null, null, null, null);
		//更新表格,插入所有员工List集合
		employeeTable.updateLovoTable(list);
	}
	

	/**
	 * 删除员工
	 * @param id 员工ID
	 */
	private void delEmployee(int employeeId){
		
		service.del(employeeId);
		
		//更新表格,显示删除结果
		this.updateEmployeeTable();
	}
	/**
	 * 查找员工
	 */
	private void findEmployee(){
		List<EmployeeBean> list=service.findByItem(nameTxt.getText(), eduTxt.getText(), eduTxt.getText(), jobTxt.getText());

		
		//更新表格,显示查询结果
		employeeTable.updateLovoTable(list);
	}
}
