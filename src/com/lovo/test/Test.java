package com.lovo.test;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import com.lovo.netCRM.component.LovoAccordion;
import com.lovo.netCRM.component.LovoButton;
import com.lovo.netCRM.component.LovoFileChooser;
import com.lovo.netCRM.component.LovoList;
import com.lovo.netCRM.component.LovoTable;
import com.lovo.test.bean.CityBean;
import com.lovo.test.bean.ManBean;
import com.lovo.test.bean.SchoolBean;

public class Test extends JFrame{
	
	 LovoList<ManBean> lovoList = new LovoList<ManBean>(400, 100, 100, 200,this){

		@Override
		public void onchange(ManBean t) {
			ManBean m = (ManBean)t;
			System.out.println(m.getUserName());
		}
		
};
	public Test(){
		this.setLayout(null);
		
		
		final LovoTable table = new LovoTable(
				this,new String[]{"����","����","���г�"},
				new String[]{"userName","birthday","bike.type"},"id");
		
		//���ñ���С��λ��
		table.setSizeAndLocation(50, 50, 300, 100);
		
		List<ManBean> list = new ArrayList<ManBean>();
		list.add(new ManBean(1,"����","��",Date.valueOf("1990-01-01"),"������"));
		list.add(new ManBean(2,"����","Ů",Date.valueOf("1996-07-21"),"�����"));
		list.add(new ManBean(3,"����","Ů",Date.valueOf("1992-11-11"),"��ʿ��"));
		list.add(new ManBean(4,"����","��",Date.valueOf("1987-12-09"),"Сţ��"));
		list.add(new ManBean(5,"����","��",Date.valueOf("1993-05-06"),"�����"));
		
		//�����ϵ�������ʾ�ڱ��
		table.updateLovoTable(list);
		
	
		
		LovoButton showKeyButton = new LovoButton("��ʾ����",150,200,this);
		showKeyButton.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				//�õ�����ֵ
				int id = table.getKey();
				JOptionPane.showMessageDialog(null,id);
			}});
		
		LovoButton delButton = new LovoButton("ɾ��",50,200,this);
		delButton.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				//��ʾѡ����ָ���е�����
				JOptionPane.showMessageDialog(null, table.getSelectColumn(0));
				//ɾ��
				table.removeRow();
			}});
		
	
		//�б�����
//		LovoList<ManBean> lovoList = new LovoList<ManBean>(list){
//			public void onchange(ManBean t){
//				System.out.println(t.getUserName());
//			}
//		};
//		lovoList.setBounds(400, 100, 100, 200);
//		this.add(lovoList);
		
		
		
		lovoList.setList(list);
		
		final LovoFileChooser fc = new LovoFileChooser(this,"face");
		fc.setBounds(400, 300, 200, 150);
		
		LovoButton showButton = new LovoButton("��ʾ·��",600,300,this);
		showButton.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, fc.getFilePath());
				System.out.println(fc.getFilePath());
			}});
		final List<CityBean> cityList = new ArrayList<CityBean>();
		CityBean c1 = new CityBean(1,"�ɶ���");
		CityBean c2 = new CityBean(2,"������");
		CityBean c3 = new CityBean(3,"��ɽ��");
		
		c1.getSchoolList().add(new SchoolBean(1,"�ɶ������ѧУ"));
		c1.getSchoolList().add(new SchoolBean(2,"�ɶ�ʮ����"));
		c2.getSchoolList().add(new SchoolBean(3,"���������ѧУ"));
		c2.getSchoolList().add(new SchoolBean(4,"������ѧ"));
		c3.getSchoolList().add(new SchoolBean(5,"��ɽ�����ѧУ"));
		c3.getSchoolList().add(new SchoolBean(6,"��ɽ��һ��ѧ"));
		
		cityList.add(c1);
		cityList.add(c2);
		cityList.add(c3);
		
		//�����ַ������
		final LovoAccordion ac = new LovoAccordion(this,cityList,"schoolList"){

			@Override
			public void clickEvent(Object obj) {
				SchoolBean bean = (SchoolBean)obj;
				System.out.println(bean.getId()+"  "+bean.getSchoolName());
			}
			
		};
		ac.setBounds(20, 300, 100, 200);
		
		LovoButton lb = new LovoButton("���",20,550,this);
		lb.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				CityBean c = new CityBean(3,"������");
				
				c.getSchoolList().add(new SchoolBean(1,"���������ѧУ"));
				c.getSchoolList().add(new SchoolBean(2,"����ʮ����"));
				
				cityList.add(c);
				
				ac.updateAccordion(cityList);
			}});
		
		this.setSize(800,600);
		this.setVisible(true);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(3);
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Test t = new Test();
	}

}
