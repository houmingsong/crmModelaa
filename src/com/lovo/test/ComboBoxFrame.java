package com.lovo.test;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import com.lovo.netCRM.component.LovoButton;
import com.lovo.netCRM.component.LovoComboBox;
import com.lovo.test.bean.ManBean;
import com.lovo.test.bean.SexBean;
/**
 * 
 * �Ĵ�����CRMϵͳ
 * @author �ųɷ�
 * @version 1.0
 * @see  
 * @description ������
 * ��������:2012-11-1
 */
public class ComboBoxFrame extends JFrame{
	private LovoComboBox<ManBean> combox;
	
	private LovoComboBox<SexBean> sexBox;
	
	private LovoComboBox<ManBean> manBox;
	
	
	public ComboBoxFrame(){
		this.setLayout(null);
		
		List<ManBean> list = new ArrayList<ManBean>();
		list.add(new ManBean(1,"����","��",Date.valueOf("1988-02-02"),"������"));
		list.add(new ManBean(2,"����","Ů",Date.valueOf("1990-12-12"),"С����"));
		list.add(new ManBean(3,"����","��",Date.valueOf("1993-09-09"),"������"));
		list.add(new ManBean(4,"�����Ӷ�","Ů",Date.valueOf("1987-11-02"),"ù����"));
		
		//����������ʾ������ΪList������Ԫ�ص�toString()����ֵ
		combox = new LovoComboBox<ManBean>("Ա��",list,50,50,this);
		
		LovoButton showButton = new LovoButton("��ʾѡ����",50,80,this);
		showButton.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				//�õ�ѡ����Ķ���
				ManBean bean = combox.getItem();
				JOptionPane.showMessageDialog(null,
						"��ѡ�����:"+bean.getId()+"   "+bean.getUserName());
			}
		});
		
		LovoButton setButton = new LovoButton("����ѡ����",150,80,this);
		setButton.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				String value = JOptionPane.showInputDialog(null,"������ѡ��ID");
				combox.setItem(Integer.parseInt(value), "id");
			}
		});
		//--------------
		
		final List<ManBean> manlist = new ArrayList<ManBean>();
		manlist.add(new ManBean(1,"����","��",Date.valueOf("1988-02-02"),"������"));
		manlist.add(new ManBean(2,"����","��",Date.valueOf("1990-12-12"),"С����"));
		
		final List<ManBean> womanlist = new ArrayList<ManBean>();
		womanlist.add(new ManBean(3,"����","Ů",Date.valueOf("1988-11-10"),"������"));
		womanlist.add(new ManBean(4,"����","Ů",Date.valueOf("1990-09-12"),"С����"));
		
		//-----------------------
		List<SexBean> sexList = new ArrayList<SexBean>();
		sexList.add(null);
		sexList.add(new SexBean("��"));
		sexList.add(new SexBean("Ů"));
		sexBox = new LovoComboBox("�Ա�",sexList,50,200,this){

			@Override
			public void onchange(Object t) {
				SexBean bean = (SexBean)t;
				
				if(bean.getSex().equals("��")){
					manBox.setList(manlist);
				}
				else{
					manBox.setList(womanlist);
				}
			}
			
		};
		
		//-----------
		
		manBox = new LovoComboBox("Ա��",new ArrayList(),300,200,this);
		
		
		this.setSize(600,500);
		this.setVisible(true);
		this.setDefaultCloseOperation(3);
		this.setLocationRelativeTo(null);
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		new ComboBoxFrame();
	}

}
