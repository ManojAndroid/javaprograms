package org.bridgelab.generalProgram;

import java.util.*;

public class BalancedExpression {
	public static void main(String[] args) {
		Stack stack = new Stack();
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the bracket");
		String bal = scanner.nextLine();

		for (int i = 0; i < bal.length(); i++) {
			char ch = bal.charAt(i);
			if (ch == '(' || ch == '{' || ch == '[') {
				stack.push(i);
			} else if (ch == ')' || ch == '}' || ch == ']')

			{
				stack.pop();
			}
		}
		if (stack.isEmpty())

			System.out.println("Expression is balanced");

		else

			System.out.println("Expression is Not Balanced");

	}

}
