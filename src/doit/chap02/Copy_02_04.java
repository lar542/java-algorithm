package doit.chap02;

import java.util.Scanner;

public class Copy_02_04 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("배열 a의 길이 : ");
		int numa = scanner.nextInt();
		int[] a = new int[numa];
		
		for (int i = 0; i < numa; i++) {
			System.out.printf("a[%d] : ", i);
			a[i] = scanner.nextInt();
		}
		
		System.out.print("배열 b의 길이 : ");
		int numb = scanner.nextInt();
		int[] b = new int[numb];
		
		for (int i = 0; i < numb; i++) {
			System.out.printf("a[%d] : ", i);
			b[i] = scanner.nextInt();
		}
		
		copy(a, b);
		
		System.out.println("배열 b의 모든 요소를 배열 a에 복사했습니다.");
		for (int i = 0; i < numa; i++) {
			System.out.printf("a[%d] = %d\n", i, a[i]);
		}
	}

	private static void copy(int[] a, int[] b) {
		int num = a.length <= b.length ? a.length : b.length;
		
		for (int i = 0; i < num; i++) {
			a[i] = b[i];
		}
	}
}
