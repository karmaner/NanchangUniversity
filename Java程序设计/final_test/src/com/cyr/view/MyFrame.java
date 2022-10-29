package com.cyr.view;

/**
 * Package Name:com.cyr.view
 * File Name:MyFrame
 * Author:Mic_D
 * Description:登录窗口登录类
 */

import java.awt.Container;
import java.awt.event.ActionEvent;
import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

//继承Jframe类和实现官方Action接口
public class MyFrame extends JFrame implements Action {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3893302748793621084L;
	//组件声明
	//第一区块
	JLabel firstInputLab;
	JTextField firstInputTxt;
 
	//第二区块
	JLabel secondInputLab;
	JTextField secondInputTxt;
 
	//按钮主键
	JButton btnZhouchang;
	JButton btnMianji;
	JButton btnRest;
 
	//输出区块
	JLabel outputLab;
	public JTextField outputTxt;
	
	//添加按钮区
	Container container;
	
	public  MyFrame() {
		
		//属性设置
		this.setTitle("登录界面");
		this.setSize(450, 350);
		this.setDefaultCloseOperation(3);
		this.setLocationRelativeTo(null);
		container = this.getContentPane();
		container.setLayout(null);
 
		firstInputLab = new JLabel("输入账号:");
		firstInputLab.setBounds(100, 50, 100, 30);
		container.add(firstInputLab);
 
		firstInputTxt = new JTextField();
		firstInputTxt.setBounds(200, 50, 150, 30);
		container.add(firstInputTxt);
 
		firstInputLab = new JLabel("输入密码:");
		firstInputLab.setBounds(100, 100, 100, 30);
		container.add(firstInputLab);
 
		secondInputTxt = new JTextField();
		secondInputTxt.setBounds(200, 100, 150, 30);
		container.add(secondInputTxt);
 
		btnZhouchang = new JButton("登录");
		btnZhouchang.setBounds(50, 150, 80, 30);
		container.add(btnZhouchang);
 
		btnMianji = new JButton("惊喜");
		btnMianji.setBounds(150, 150, 80, 30);
		container.add(btnMianji);
 
		btnRest = new JButton("重置");
		btnRest.setBounds(250, 150, 80, 30);
		container.add(btnRest);
 
		outputTxt = new JTextField();
		outputTxt.setBounds(150, 200, 200, 30);
		container.add(outputTxt);
 
		outputLab = new JLabel("结果输出:");
		outputLab.setBounds(80, 200, 100, 30);
		container.add(outputLab);
 
		btnZhouchang.addActionListener(this);
		btnMianji.addActionListener(this);
		btnRest.addActionListener(this);
 
		this.setVisible(true);
	}
 
	//数据操作
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnZhouchang) {
			// 登录功能
			try {
				// 去掉空格获取文本
				if(firstInputTxt.getText().trim().equals("root") & secondInputTxt.getText().trim().equals("123")) {
					outputTxt.setText("登录成功");
				} else {
					outputTxt.setText("密码或账号错误");
				}
			} catch (NumberFormatException e1) {
				outputTxt.setText("输入有误或未输入");
			}
 
		} else if (e.getSource() == btnMianji) {
 
			// 随机生成古诗
			try {
				
				int input = (int)(1 + Math.random() * (5));
				switch (input) {
				case 1:
					firstInputTxt.setText("博观而约取");
					secondInputTxt.setText("厚积而薄发");
					outputTxt.setText("《杂说送张琥》");
					break;
				case 2:
					firstInputTxt.setText("长风破浪会有时");
					secondInputTxt.setText("直挂云帆济沧海");
					outputTxt.setText("《行路难·其一》");
					break;
				case 3:
					firstInputTxt.setText("不鸣则已");
					secondInputTxt.setText("一鸣惊人");
					outputTxt.setText("《史记·滑稽列传》");
					break;
				case 4:
					firstInputTxt.setText("位卑未敢忘忧国");
					secondInputTxt.setText("事定犹须待盖棺");
					outputTxt.setText("陆游《病起》");
					break;
				case 5:
					firstInputTxt.setText("会挽雕弓如满月");
					secondInputTxt.setText("西北望，射天狼。");
					outputTxt.setText("《江城子》");
					break;
				default:
					firstInputTxt.setText("安得广厦千万间");
					secondInputTxt.setText("大庇天下寒士俱欢颜");
					outputTxt.setText("《茅屋为》");
					break;
				}
				
				
				
				
			} catch (NumberFormatException e1) {
				outputTxt.setText("输入有误或未输入");
			}
 
		} else if (e.getSource() == btnRest) {
			// 重置
			firstInputTxt.setText("");
			secondInputTxt.setText("");
			outputTxt.setText("");
		}
 
	}

	@Override
	public Object getValue(String key) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void putValue(String key, Object value) {
		// TODO Auto-generated method stub
		
	}

		
}
