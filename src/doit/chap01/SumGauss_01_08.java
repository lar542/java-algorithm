package doit.chap01;

import java.util.Scanner;

public class SumGauss_01_08 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("1부터 n까지의 합을 구합니다.");
		System.out.println("n의 값 : ");
		int n = scanner.nextInt();
		
		//가우스의 덧셈 : n이 홀수인 경우에는 성립하지 않으므로 뒤에 추가로 더해줌
		int sum = (1 + n) * (n / 2) + (n % 2 == 0 ? 0 : (n + 1) / 2); 
		
		System.out.println("1부터 " + n + "까지의 합은 " + sum + "입니다.");
	}
}
