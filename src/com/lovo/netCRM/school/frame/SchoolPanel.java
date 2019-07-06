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
 * 四川网脉CRM系统
 * @author 张成峰
 * @version 1.0
 * @see  
 * @description 学校显示面板
 * 开发日期:2012-10-11
 */
public class SchoolPanel extends JPanel{
	/**学校表格组件*/
	private LovoTable schoolTable;
	/**窗体对象*/
	private JFrame jf;
	/**城市id*/
	private  int cityId;
	/**学校名称文本框*/
	private LovoTxt nameTxt;
	/**学校状态下拉框*/
	private LovoComboBox statusBox;
	
	ISchoolService service=new SchoolServiceImpl();
	ICityService cer=new CityServiceImpl();
	
	/**城市列表框*/
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
	 * 初始化
	 *
	 */
	private void init() {
		new LovoTitleLabel("学 校 管 理",this);
		this.initTable();
		this.initButton();
		this.initData();
		this.initFindPanel();
	}
	/**
	 * 初始化数据
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
	 * 初始化按钮
	 *
	 */
	private void initButton() {
		LovoButton lbadd = new LovoButton("录入新学校",50,500,this);
		lbadd.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				if(cityId == 0){
					JOptionPane.showMessageDialog(null, "请选择城市");
					return;
				}
				new SchoolAddDialog(jf,SchoolPanel.this,cityId);
			}});
		
		
		LovoButton lbshow = new LovoButton("查看学校信息",170,500,this);
		lbshow.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				int key = schoolTable.getKey();
				if(key == -1){
					JOptionPane.showMessageDialog(null,"请选择行");
					return;
				}
				
				new SchoolShowDialog(jf,key);
			}});
		
		LovoButton lbupdate = new LovoButton("修改学校信息",290,500,this);
		lbupdate.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				int key = schoolTable.getKey();
				if(key == -1){
					JOptionPane.showMessageDialog(null,"请选择行");
					return;
				}
				
				new SchoolUpdateDialog(jf,key,SchoolPanel.this);
			}});
		
		
		LovoButton lbask = new LovoButton("申请立项",50,580,this);
		lbask.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				int key = schoolTable.getKey();
				if(key == -1){
					JOptionPane.showMessageDialog(null,"请选择行");
					return;
				}
				
				apply(key,schoolTable.getSelectColumn(3));
			}});
		
		LovoButton lbcheck = new LovoButton("审核",170,580,this);
		lbcheck.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				int key = schoolTable.getKey();
				if(key == -1){
					JOptionPane.showMessageDialog(null,"请选择行");
					return;
				}
				
				checkSchool(key,schoolTable.getSelectColumn(3));
			}});
		
		LovoButton lbAddSpeak = new LovoButton("添加沟通记录",290,580,this);
		lbAddSpeak.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				int key = schoolTable.getKey();
				if(key == -1){
					JOptionPane.showMessageDialog(null,"请选择行");
					return;
				}
				
				new SchoolCommunicateAddDialog(jf,key);
			}});
	}
	/**
	 * 初始化查询按钮
	 *
	 */
	private void initFindPanel(){
		LovoTitlePanel jp = new LovoTitlePanel("查询学校",400, 400, 320, 250,this);
	
		nameTxt = new LovoTxt("学校名称",30,50,jp);
		this.statusBox = new LovoComboBox<String>("状态",new String[]{"全部","接洽中","待审","审核未通过","推广开展"},30,130,jp);
		
		LovoButton lb = new LovoButton("查找",180,200,jp);
		lb.setSize(60, 20);
		
		lb.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				if(cityId == 0){
				JOptionPane.showMessageDialog(null,"请选择城市");
					return;
				}
				findSchool(cityId);
				
			}

			});
		
	}
	
	//--------------------------
	/**
	 * 根据城市对象，得到城市id
	 * @param cityObj 城市对象
	 * @return
	 */
	private int getCityId(Object cityObj){
		
		int id=((CityBean)cityObj).getId();
		
		return id;
	}
	/**
	 * 初始化表格
	 */
	private void initTable() {
		schoolTable = new LovoTable(this,
				new String[]{"学校名称","校长","录入时间","状态"},
				new String[]{"school","president","sTime","conditions"},//学校实体属性名数组 new String[]{"schoolName","schoolMaster"}
				"id");//主键属性名 schoolId
		schoolTable.setSizeAndLocation(180, 90, 550, 300);
	
	}
	/**
	 * 初始化列表框
	 *
	 */
	private void initList() {
		List<SchoolBean> sb=new ArrayList<SchoolBean>();
			
		
		cityList.setList(cer.findAll());
	}
	/**
	 * 显示城市对应的学校
	 * @param cityObj 城市对象
	 */
	private void showSchool(int cityId){
		
//		更新表格,插入List集合
		schoolTable.updateLovoTable(service.find(cityId, null, null));
	}
	/**
	 * 申请立项
	 * @param schoolId 学校ID
	 * @param schoolState 学校状态
	 * @param cityObj　城市对象
	 */
	private void apply(int schoolId,String schoolState){
		//验证状态是否为“接洽中”或“审核未通过”
		if("接洽中".equals(schoolState)||"审核未通过".equals(schoolState)){
			service.apply(schoolId);
		}
		
		//显示申请立项结果
		this.initData();
	}
	/**
	 * 审核
	 * @param schoolId 学校ID
	 * @param schoolState 学校状态
	 * @param cityObj 城市对象
	 */
	private void checkSchool(int schoolId,String schoolState){
//		验证状态是否为“待审”
		if("待审".equals( schoolState)){
			return;
		}
		new SchoolCheckDialog(jf,schoolId,this);
	}
	/**
	 * 按条件动态查询学校
	 * @param cityId 城市ID
	 */
	private void findSchool(int cityId) {
		// TODO Auto-generated method stub
		String str = (String)statusBox.getItem();
		if("全部".equals(str)){
			str=null;
		}
		//更新表格
		schoolTable.updateLovoTable(service.find(cityId, nameTxt.getText(), str));
	}
}
