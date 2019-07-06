package com.lovo.test;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import com.lovo.netCRM.component.LovoButton;
import com.lovo.netCRM.component.LovoCheckBox;
import com.lovo.netCRM.component.LovoRadioButton;
/**
 * 
 * ���Ե�ѡť,��ѡ��
 * @author �ųɷ�
 * @version 1.0
 * @see  
 * @description 
 * ��������:2012-9-29
 */
public class RadioFrame extends JFrame{
	private LovoRadioButton lr = new LovoRadioButton("�Ա�",new String[]{"��","Ů"},50,50,this);
	private LovoCheckBox lc = new LovoCheckBox("Ȩ��",new String[]{"��ѯ","���","ɾ��","�޸�"},50,100,this);
	
	public RadioFrame(){
		this.setLayout(null);
		
		
		LovoButton lb = new LovoButton("��ʾ",50,80,this);
		
		lb.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null,lr.getItem());
			}
			
		});
		
		LovoButton ls = new LovoButton("����",150,80,this);
		
		ls.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				String value = JOptionPane.showInputDialog(null,"�������õ�ֵ");
				lr.setItem(value);
			}
			
		});
		//--------------
		
		LovoButton lcb = new LovoButton("��ʾѡ��",50,180,this);
		
		lcb.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				String str = "";
//				for(String s : lc.getItem()){
//					str += s+",";
//				}
				
				str = Arrays.toString(lc.getItem());
				
				JOptionPane.showMessageDialog(null,str);
			}
			
		});
		
		
		LovoButton lsb = new LovoButton("����ѡ��",150,180,this);
		
		lsb.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				
				String str = JOptionPane.showInputDialog(null,"������ѡ��,��','�ֿ�");
			
				String[] strs = str.split(",");
				
//				lc.setItem(strs);
				lc.setItem(strs);
			}
			
		});
		
		this.setSize(600,500);
		this.setVisible(true);
		this.setDefaultCloseOperation(3);
		this.setLocationRelativeTo(null);
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		new RadioFrame();
	}

}
