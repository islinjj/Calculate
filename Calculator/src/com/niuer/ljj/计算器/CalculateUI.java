package com.niuer.ljj.������;

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

	// �������
	private JPanel contentPane;

	// �����������
	CallBack callback;

	// ������ʾ����ı�ǩ
	JLabel lblNewLabel;

	// ָ��ǰ����
	public void setCallBack(CallBack callback) {
		this.callback = callback;
	}

	/**
	 * Create the frame.
	 */
	public CalculateUI() {

		// ���ùرշ�ʽ
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// ���ñ���
		setTitle("������");
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		// ��ʼ������
		initUI();

		setVisible(true);

	}

	public void initUI() {

		// ���ô���ͷ���ı�ǩ������ʾ���
		lblNewLabel = new JLabel("0");
		lblNewLabel.setFont(new Font("����", Font.PLAIN, 21));
		lblNewLabel.setForeground(Color.DARK_GRAY);
		lblNewLabel.setBackground(Color.LIGHT_GRAY);
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		contentPane.add(lblNewLabel, BorderLayout.NORTH);

		// ���ð�ť�����
		JPanel panel = new JPanel();
		panel.setBackground(Color.LIGHT_GRAY);
		contentPane.add(panel, BorderLayout.CENTER);
		// ���ñ����ʽ4*5�����Ϊ4
		panel.setLayout(new GridLayout(4, 5, 4, 4));

		/*
		 * for (int i = 0; i < 20; i++) {
		 * 
		 * //ǰ����λ��ǩ��18��Ϊ��ť if (i < 2) { panel.add(new JLabel()); } else { panel.add(new
		 * JButton(String.valueOf(i))); }
		 * 
		 * }
		 */

		// ��Ҫ��ʾ���ּ����ַ�����
		String[][] s = { { "1", "2", "3", "+"}, { "4", "5", "6", "-"}, { "7", "8", "9", "*" },
				{ ".", "0", "=", "/" } };

		// ��ʼ����ť
		JButton[][] buttons = new JButton[4][4];

		// �½�����������
		BtnListener listener = new BtnListener();

		// ����ť�������
		for (int row = 0; row < s.length; row++) {
			for (int col = 0; col < s.length; col++) {

				// ���ַ��ڰ�ť��
				buttons[row][col] = new JButton(s[row][col]);

				// ����ť�Ӽ�����
				buttons[row][col].addActionListener(listener);

				// ����ť��ӵ������
				panel.add(buttons[row][col]);
			}

		}

	}

	// ������������
	class BtnListener implements ActionListener {

		// ʵ����һ���ַ���������
		StringBuffer str = new StringBuffer();

		// �½��ַ�������ʽ
		String news ="";

		@Override
		public void actionPerformed(ActionEvent e) {

			// �õ��û����°�ť�ϵ��ı�
			String s = ((JButton) e.getSource()).getText();

			if (s != "=") {
				// �����ʽд��news��
				news = String.valueOf(str.append(s));

				lblNewLabel.setText(news);
			} else {
				System.out.println(news);
				callback.setExpression(news);
				
				news = String.valueOf(str.append("=" + callback.getResult()));
				
				lblNewLabel.setText(news);
			}

			// �����ʽд��news��
			/*
			 * news = String.valueOf(str.append(s));
			 * 
			 * //�����ʽͨ���ӿڴ����������Expression���� callback.setExpression(news);
			 */

			/*
			 * if(s == "=") { news = String.valueOf(str.append(callback.getResult())); }
			 */
			// ����������ʾ�ڱ�ǩ��
			// lblNewLabel.setText(news);
		}
	}

	// �ӿڻص�
	public interface CallBack {

		// ���������ֵ,�����ʽ
		void setExpression(String expression);

		// ��ý��
		String getResult();
	}

}
