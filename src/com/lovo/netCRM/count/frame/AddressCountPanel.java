package com.lovo.netCRM.count.frame;


import java.util.List;

import javax.swing.JPanel;

import com.lovo.netCRM.component.LovoTable;
import com.lovo.netCRM.component.LovoTitleLabel;
import com.project.Bean.PlaceNumBean;
import com.project.service.IPlaceNumService;
import com.project.serviceImpl.PlaceNumSerivceImpl;

/**
 * 
 * 四川网脉CRM系统
 * @author 张成峰
 * @version 1.0
 * @see  
 * @description 地区统计面板
 * 开发日期:2012-10-14
 */
public class AddressCountPanel extends JPanel{
	/**地区统计表格组件*/
	private LovoTable addressCountTable;
	IPlaceNumService service=new PlaceNumSerivceImpl();
	public AddressCountPanel(){
		this.setLayout(null);
		this.init();
	}
	/**
	 * 初始化
	 *
	 */
	private void init() {
		new LovoTitleLabel("地 区 统 计",this);
		this.initTable();
		this.initData();
	}
	/**
	 * 更新数据
	 */
	public void initData(){
		this.updateAddressCountTable();
	}

	//--------------------------
	
	/**
	 * 初始化表格
	 */
	private void initTable() {
		addressCountTable = new LovoTable(this,
				new String[]{"城市名称","录入学校","接洽中学校","待审学校","审核未通过学校","推广开展学校"},
				new String[]{"city","allSchool","talkingSchool","waitSchool","noPassSchool","passSchool"},//统计实体属性名数组 new String[]{"cityName","schoolNumber"}
				"");//主键属性名 countId
		addressCountTable.setSizeAndLocation(20, 90, 700, 300);
		
	}
	/**
	 * 更新表格数据
	 */
	private void updateAddressCountTable(){
		//更新表格,插入地区统计List集合
		List<PlaceNumBean>list=service.show();
		addressCountTable.updateLovoTable(list);
	}
}
