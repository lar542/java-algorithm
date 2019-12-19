package doit.chap01;

import java.util.Scanner;

public class SumWhileEx_01_06 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("1부터 n까지의 합을 구합니다.");
		System.out.print("n의 값 : ");
		int n = scanner.nextInt();
		
		int sum = 0;
		int i = 1;
		
		while(i <= n) {
			sum += 1;
			i++;
		}
		System.out.println("1부터 " + n + "까지의 합은 " + sum + "입니다.");
		System.out.println("i 값은 " + i);
	}
}
