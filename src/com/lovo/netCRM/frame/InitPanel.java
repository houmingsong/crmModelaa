package com.lovo.netCRM.frame;

import java.awt.BorderLayout;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
/**
 * 
 * �Ĵ�����CRMϵͳ
 * @author �ųɷ�
 * @version 1.0
 * @see  
 * @description ��ʼ�����
 * ��������:2012-10-5
 */
public class InitPanel extends JPanel{
	public InitPanel(){
		this.setLayout(new BorderLayout());
		Image img = new ImageIcon("image/school.jpg").getImage();
		img = img.getScaledInstance(700, 650, 1);
		this.add(new JLabel(new ImageIcon(img)));
	}
}
