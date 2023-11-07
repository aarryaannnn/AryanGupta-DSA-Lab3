package com.aryan.balancingBracket.main;

import com.aryan.balancingBracket.fun.BalancingBracketFun;
import java.util.Scanner;

public class BalancingBracketMain {
	public static void main(String args[]) {

		System.out.println("Please enter the string which only contains brackets");

		Scanner sc = new Scanner(System.in);
		String bracketExpression = sc.nextLine();

		BalancingBracketFun blancingBracketFun = new BalancingBracketFun();

		boolean result = blancingBracketFun.isBracketIsBalanced(bracketExpression);
		if (result == true) {
			System.out.println("The entered String has Balanced Brackets");
		} else
			System.out.println("The entered String doen't have  Balanced Brackets");

		sc.close();
	}
}
