package doit.chap01;

import java.util.Scanner;

public class Triangle_01_15 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n;
		
		System.out.println("삼각형 모양으로 나타냅니다.");
		
		do {
			System.out.print("단수는 : ");
			n = scanner.nextInt();
		} while (n <= 0);
		
		System.out.println("왼쪽 아래가 직각인 삼각형");
		triangleLB(n);
		
		System.out.println("왼쪽 위가 직각인 삼각형");
		triangleLU(n);
		
		System.out.println("오른쪽 위가 직각인 삼각형");
		triangleRU(n);
		
		System.out.println("오른쪽 아래가 직각인 삼각형");
		triangleRB(n);
	}

	private static void triangleLB(int n) {
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= i; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}
	
	private static void triangleLU(int n) {
		for (int i = n; i >= 1; i--) {
			for (int j = 1; j <= i; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}
	
	private static void triangleRU(int n) {
		for (int i = n; i >= 1; i--) {
			for (int j = 1; j <= (n - i); j++) {
				System.out.print(" ");
			}
			for (int j = 1; j <= i; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}
	
	private static void triangleRB(int n) {
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= (n - i); j++) {
				System.out.print(" ");
			}
			for (int j = 1; j <= i; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}
}
