package com.lovo.test;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import com.lovo.netCRM.component.LovoButton;
import com.lovo.netCRM.component.LovoDate;
import com.lovo.netCRM.component.LovoFileChooser;
/**
 * 
 * �Ĵ�����CRMϵͳ
 * @author �ųɷ�
 * @version 1.0
 * @see  
 * @description �ļ�ѡ������������
 * ��������:2012-11-1
 */
public class HeadFrame extends JFrame{
	//�����ļ�ѡ�������,��һ������Ϊ������������,
	//�ڶ�������Ϊ�û�ѡ���ļ���,�ļ���ŵ�Ŀ¼��
	private LovoFileChooser fc = new LovoFileChooser(this,"face");
	//���������������
	private LovoDate date = new LovoDate("����",50,200,this);
	
	public HeadFrame(){
		this.setLayout(null);
		//��������Ĵ�С��λ��
		fc.setBounds(50, 50, 100, 150);
		
		LovoButton show = new LovoButton("��ʾ",180,50,this);
		
		show.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				//�õ������������µ��ļ���
				String path = fc.getFilePath();
				JOptionPane.showMessageDialog(null,path);
			}});
		
		
		LovoButton showDate = new LovoButton("��ʾ����",180,100,this);
		
		showDate.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				//date.getText()�û�ѡ�������
				JOptionPane.showMessageDialog(null,"ѡ���������:"+date.getText());
			}});
		
	
		
		this.setSize(600,500);
		this.setVisible(true);
		this.setDefaultCloseOperation(3);
		this.setLocationRelativeTo(null);
	}
	
	public static void main(String[] args) {
		HeadFrame h = new HeadFrame();
	}
}
