package com.lovo.netCRM.schoolActive.frame;

import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import com.lovo.netCRM.component.LovoButton;
import com.lovo.netCRM.component.LovoList;
import com.lovo.netCRM.component.LovoTable;
import com.lovo.netCRM.component.LovoTitleLabel;
import com.project.Bean.CityBean;
import com.project.Bean.SchoolBean;
import com.project.service.IActivityService;
import com.project.service.ICityService;
import com.project.service.ISchoolService;
import com.project.serviceImpl.ActivityServiceImpl;
import com.project.serviceImpl.CityServiceImpl;
import com.project.serviceImpl.SchoolServiceImpl;
/**
 * 
 * 四川网脉CRM系统
 * @author 张成峰
 * @version 1.0
 * @see  
 * @description 学校活动面板
 * 开发日期:2012-10-6
 */
public class SchoolActivePanel extends JPanel{
	/**学校表格组件*/
	private LovoTable schoolTable;
	/**窗体对象*/
	private JFrame jf;
	/**城市id*/
	private  int cityId;
	/**城市列表框*/
	ICityService service=new CityServiceImpl();
	IActivityService ser=new ActivityServiceImpl();
	ISchoolService serce=new SchoolServiceImpl();
	
	private LovoList cityList = new LovoList(20,90,150,300,this){
		public void onchange(Object t){
			cityId = getCityId(t);
			showSchool(cityId);
		}
	};
	public SchoolActivePanel(JFrame jf){
		this.jf = jf;
		this.setLayout(null);
		this.init();
	}
	/**
	 * 初始化
	 *
	 */
	private void init() {
		new LovoTitleLabel("学 校 活 动",this);
		this.initTable();
		this.initButton();
		this.initData();
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
		LovoButton lbadd = new LovoButton("添加新活动",200,500,this);
		lbadd.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				int key = schoolTable.getKey();
				if(key == -1){
				JOptionPane.showMessageDialog(null,"请选择行");
				return;
				}
				new SchoolActiveAddDialog(jf,key);
			}});
		
		
		LovoButton lbshow = new LovoButton("查看活动信息",400,500,this);
		lbshow.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				int key = schoolTable.getKey();
				if(key == -1){
					JOptionPane.showMessageDialog(null,"请选择行");
					return;
				}
				
				new SchoolActiveShowDialog(jf,schoolTable.getSelectColumn(0),key);
			}});
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
				new String[]{"学校名称","校长","录入时间","联系电话"},
				new String[]{"school","president","sTime","tel"},//学校实体属性名数组 new String[]{"schoolName","schoolMaster"}
				"id");//主键属性名 schoolId
		schoolTable.setSizeAndLocation(180, 90, 550, 300);

	}
	/**
	 * 初始化列表框
	 *
	 */
	private void initList() {
		List<CityBean> list=service.findAll();
		cityList.setList(new ArrayList(list));
	}
	/**
	 * 显示城市对应的学校
	 * @param cityObj 城市对象
	 */
	private void showSchool(int cityId){
//		更新表格,插入List集合
		List<SchoolBean>list=serce.find(cityId, null, "推广开展");
		schoolTable.updateLovoTable(list);
	}
}
