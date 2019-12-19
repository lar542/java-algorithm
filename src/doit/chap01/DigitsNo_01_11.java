package doit.chap01;

import java.util.Scanner;

public class DigitsNo_01_11 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		int n = scanner.nextInt();
		
		while(n <= 0) {
			System.out.print("양의 정수값을 입력하세요 : ");
			n = scanner.nextInt();
		}
		
		System.out.printf("숫자 %d은 %d자리입니다.", n, String.valueOf(n).length());
	}
}
