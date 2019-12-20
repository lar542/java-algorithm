package doit.chap02;

import java.util.Scanner;

public class SumOf_02_03 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("길이 : ");
		int num = scanner.nextInt();
		
		int[] x = new int[num];
		
		for (int i = 0; i < num; i++) {
			System.out.printf("x[%d] : ", i);
			x[i] = scanner.nextInt();
		}
		
		System.out.printf("전 요소의 합계는 %d입니다.", sumOf(x));
	}

	private static int sumOf(int[] a) {
		int sum = 0;
		
		for (int i = 0; i < a.length; i++) {
			sum += a[i];
		}
		
		return sum;
	}
}
