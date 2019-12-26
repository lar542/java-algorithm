package doit.chap05;

import java.util.Scanner;

import doit.chap04.IntStack;

//재귀 알고리즘의 비재귀적 표현
public class RecurX2 {
	
	//재귀 함수
	/*
	static void recur(int n) {
		if (n > 0) {
			recur(n - 1);
			System.out.println(n);
			recur(n - 2);
		}
	}
	*/

	static void recur(int n) {
		IntStack stack = new IntStack(n);
		
		while (true) {
			if (n > 0) {
				stack.push(n);
				n -= 1;
				continue;
			}
			if (stack.isEmpty() != true) {
				n = stack.pop();
				System.out.println(n);
				n -= 2;
				continue;
			}
			break;
		}
	}
	
	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);

		System.out.print("정수를 입력하세요.：");
		int x = stdIn.nextInt();

		recur(x);
	}
}
