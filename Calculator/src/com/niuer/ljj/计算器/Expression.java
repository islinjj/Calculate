package com.niuer.ljj.������;

public class Expression {

	Calculate calculate = new Calculate();
	
	// ���ʽ
	String expression;

	// ��һ����ֵ�͵ڶ�����ֵ
	String first;
	String second;

	// �����
	char operator;

	// ���
	String result;

	/*
	 * ���ñ��ʽ
	 */
	public void setExpression(String expression) {
		this.expression = expression;
	}

	// ��ʼ����
	public String CalExpression() {

		first = new String();
		second = new String();
		// �Ƚ��н���
		analysis();

		// ��������ֵ����Calculate
		calculate.setValue(first, second);
		System.out.println("nnnnn");
		//�ж����������������Ӧ������
		if (operator == '+') {
			result = calculate.add();
		} else if (operator == '-') {
			result = calculate.sub();
		} else if (operator == '*') {
			result = calculate.mul();
		} else if(operator == '/'){
			result = calculate.div();
		}

		return result;
		
	}

	/*
	 * �������ʽ
	 */
	private void analysis() {

		int i;

		// ��������һ����ֵ
		for (i = 0; i < expression.length(); i++) {

			// cΪ���ʽ�е���ֵ���������
			char c = expression.charAt(i);

			// ����ֵ��Ϊ�ַ�������first
			if (c != '+' && c != '-' && c != '*' && c != '/') {
				first += String.valueOf(c);
			} else {
				//�����
				operator = c;
				break;
			}
		}

		// �������ڶ�����ֵ
		for (i = i + 1; i < expression.length(); i++) {

			char c = expression.charAt(i);
			second += String.valueOf(c);
		}
	}

	// ������ֵ����ʹ��java�Դ��ķ���
}
