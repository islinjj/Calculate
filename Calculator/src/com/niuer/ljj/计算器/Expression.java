package com.niuer.ljj.计算器;

public class Expression {

	Calculate calculate = new Calculate();
	
	// 表达式
	String expression;

	// 第一个数值和第二个数值
	String first;
	String second;

	// 运算符
	char operator;

	// 结果
	String result;

	/*
	 * 设置表达式
	 */
	public void setExpression(String expression) {
		this.expression = expression;
	}

	// 开始计算
	public String CalExpression() {

		first = new String();
		second = new String();
		// 先进行解析
		analysis();

		// 将两个数值传到Calculate
		calculate.setValue(first, second);
		System.out.println("nnnnn");
		//判断运算符，并进行相应的算术
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
	 * 解析表达式
	 */
	private void analysis() {

		int i;

		// 解析出第一个数值
		for (i = 0; i < expression.length(); i++) {

			// c为表达式中的数值或者运算符
			char c = expression.charAt(i);

			// 将数值作为字符串存入first
			if (c != '+' && c != '-' && c != '*' && c != '/') {
				first += String.valueOf(c);
			} else {
				//运算符
				operator = c;
				break;
			}
		}

		// 解析出第二个数值
		for (i = i + 1; i < expression.length(); i++) {

			char c = expression.charAt(i);
			second += String.valueOf(c);
		}
	}

	// 解析数值可以使用java自带的方法
}
