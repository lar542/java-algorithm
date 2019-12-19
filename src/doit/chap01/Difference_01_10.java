package doit.chap01;

import java.util.Scanner;

public class Difference_01_10 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("a의 값 : ");
		int a = scanner.nextInt();
		
		System.out.print("b의 값 : ");
		int b = scanner.nextInt();
		
		
		while(a >= b) {
			System.out.println("a보다 큰 값을 입력하세요!");
			b = scanner.nextInt();
		}
		
		System.out.printf("b - a는 %d입니다.", b - a);
	}
}