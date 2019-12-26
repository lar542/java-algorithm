package doit.chap05;

import java.util.Scanner;

//팩토리얼을 재귀적으로 구현
public class Factorial {

	//양의 정수 n의 팩토리얼을 반환한다
	static int factorical(int n) {
		if (n > 0)
			return n * factorical(n - 1);
		else 
			return 1;
	}
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("정수를 입력하세요. : ");
		int x = scanner.nextInt();
		
		System.out.println(x + "의 팩토리얼은 " + factorical(x) + "입니다.");
	}
}
