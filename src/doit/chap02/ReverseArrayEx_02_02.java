package doit.chap02;

import java.util.Scanner;

public class ReverseArrayEx_02_02 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("길이 : ");
		int num = scanner.nextInt();
		
		int[] x = new int[num];
		
		for (int i = 0; i < num; i++) {
			System.out.printf("x[%d] : ", i);
			x[i] = scanner.nextInt();
		}
		
		reverse(x);
		
		System.out.println("역순 정렬을 마쳤습니다.");
	}

	private static void reverse(int[] a) {
		for (int i = 0; i < a.length / 2; i++) {
			System.out.printf("a[%d]과(와) a[%d]를 교환합니다.\n", i, a.length - i - 1);
			swap(a, i, a.length - i - 1);
			print(a);
		}
	}
	
	private static void print(int[] a) {
		for (int i = 0; i < a.length; i++) {
			System.out.printf("%d ", a[i]);
		}
		System.out.println();
	}

	private static void swap(int[] a, int idx1, int idx2) {
		int tmp = a[idx1];
		a[idx1] = a[idx2];
		a[idx2] = tmp;
	}
}
