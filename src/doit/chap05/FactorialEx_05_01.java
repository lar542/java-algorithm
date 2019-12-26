package doit.chap05;

import java.util.Scanner;

//팩토리얼 값을 비재귀적으로 구합니다.
public class FactorialEx_05_01 {

	//양의 정수 n의 팩토리얼 값을 반환
	static int factorical(int n) {
		int fact = 1;
		while (n > 1)
			fact *= n--;
		return fact;
	}
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("정수를 입력하세요. : ");
		int x = scanner.nextInt();
		
		System.out.println(x + "의 팩토리얼은 " + factorical(x) + "입니다.");
	}
}
