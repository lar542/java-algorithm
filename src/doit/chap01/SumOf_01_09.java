package doit.chap01;

import java.util.Scanner;

public class SumOf_01_09 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("a와 b를 포함하여 그 사이의 모든 정수의 합을 구합니다.");
		System.out.print("a의 값 : ");
		int a = scanner.nextInt();
		System.out.print("b의 값 : " );
		int b = scanner.nextInt();
		
		System.out.printf("정수 a, b 사이의 모든 정수의 합은 %d입니다.", sumof(a, b));
	}

	private static int sumof(int a, int b) {
		if (a > b) {
			int tmp = a;
			a = b;
			b = tmp;
		}
		
		int sum = 0;
		
		for (int i = a; i <= b; i++) {
			sum += i;
		}
		
		return sum;
	}
}
