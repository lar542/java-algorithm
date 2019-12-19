package doit.chap01;

import java.util.Scanner;

public class NumPira_01_17 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n;
		
		System.out.println("피라미드 모양으로 나타냅니다.");
		
		do {
			System.out.print("단수는 : ");
			n = scanner.nextInt();
		} while (n <= 0);
		
		npira(n);
	}

	private static void npira(int n) {
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n - i; j++) {
				System.out.print(" ");
			}
			for (int j = 1; j <= ((i - 1) * 2 + 1); j++) {
				System.out.print(i % 10);
			}
			System.out.println();
		}
	}
}
