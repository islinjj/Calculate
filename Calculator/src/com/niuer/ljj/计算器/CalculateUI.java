package com.niuer.ljj.计算器;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.basic.BasicButtonListener;

import java.awt.Color;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalculateUI extends JFrame {

	// 窗口面板
	private JPanel contentPane;

	// 声明计算对象
	CallBack callback;

	// 声明显示结果的标签
	JLabel lblNewLabel;

	// 指向当前对象
	public void setCallBack(CallBack callback) {
		this.callback = callback;
	}

	/**
	 * Create the frame.
	 */
	public CalculateUI() {

		// 设置关闭方式
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// 设置标题
		setTitle("计算器");
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		// 初始化界面
		initUI();

		setVisible(true);

	}

	public void initUI() {

		// 设置窗口头部的标签用来显示结果
		lblNewLabel = new JLabel("0");
		lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 21));
		lblNewLabel.setForeground(Color.DARK_GRAY);
		lblNewLabel.setBackground(Color.LIGHT_GRAY);
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		contentPane.add(lblNewLabel, BorderLayout.NORTH);

		// 放置按钮的面板
		JPanel panel = new JPanel();
		panel.setBackground(Color.LIGHT_GRAY);
		contentPane.add(panel, BorderLayout.CENTER);
		// 设置表格形式4*5，间隔为4
		panel.setLayout(new GridLayout(4, 5, 4, 4));

		/*
		 * for (int i = 0; i < 20; i++) {
		 * 
		 * //前两个位标签后18个为按钮 if (i < 2) { panel.add(new JLabel()); } else { panel.add(new
		 * JButton(String.valueOf(i))); }
		 * 
		 * }
		 */

		// 将要显示的字加入字符串中
		String[][] s = { { "1", "2", "3", "+"}, { "4", "5", "6", "-"}, { "7", "8", "9", "*" },
				{ ".", "0", "=", "/" } };

		// 初始化按钮
		JButton[][] buttons = new JButton[4][4];

		// 新建监听器对象
		BtnListener listener = new BtnListener();

		// 将按钮加入面板
		for (int row = 0; row < s.length; row++) {
			for (int col = 0; col < s.length; col++) {

				// 将字放在按钮上
				buttons[row][col] = new JButton(s[row][col]);

				// 给按钮加监听器
				buttons[row][col].addActionListener(listener);

				// 将按钮添加到面板中
				panel.add(buttons[row][col]);
			}

		}

	}

	// 创建监听器类
	class BtnListener implements ActionListener {

		// 实例化一个字符串缓冲区
		StringBuffer str = new StringBuffer();

		// 新建字符串存表达式
		String news ="";

		@Override
		public void actionPerformed(ActionEvent e) {

			// 得到用户按下按钮上的文本
			String s = ((JButton) e.getSource()).getText();

			if (s != "=") {
				// 将表达式写入news中
				news = String.valueOf(str.append(s));

				lblNewLabel.setText(news);
			} else {
				System.out.println(news);
				callback.setExpression(news);
				
				news = String.valueOf(str.append("=" + callback.getResult()));
				
				lblNewLabel.setText(news);
			}

			// 将表达式写入news中
			/*
			 * news = String.valueOf(str.append(s));
			 * 
			 * //将表达式通过接口传入运算操作Expression类中 callback.setExpression(news);
			 */

			/*
			 * if(s == "=") { news = String.valueOf(str.append(callback.getResult())); }
			 */
			// 按下数字显示在标签中
			// lblNewLabel.setText(news);
		}
	}

	// 接口回掉
	public interface CallBack {

		// 设置输入的值,传表达式
		void setExpression(String expression);

		// 获得结果
		String getResult();
	}

}
