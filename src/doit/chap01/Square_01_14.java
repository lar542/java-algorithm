package doit.chap01;

import java.util.Scanner;

public class Square_01_14 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		
		while (n <= 0) {
			System.out.print("정수 값 : ");
			n = scanner.nextInt();
		}
		
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
		
	}
}
