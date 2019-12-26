package doit.chap05;

import java.util.Scanner;

//메소드 recur3의 비재귀적구현
public class Recur3_05_05 {
	
	//메소드 recur의 비재귀적 구현
	static void recur3(int n) {
		int[] stack1 = new int[100];
		int[] stack2 = new int[100];
		int index = -1;
		int sw = 0;
		
		while (true) {
			if (n > 0) {
				index++;
				stack1[index] = n;
				stack2[index] = sw;
				
				if (sw == 0) {
					n -= 1;
				} else if (sw == 1) {
					n -= 2;
					sw = 0;
				}
				continue;
			}
			do {
				n = stack1[index];
				sw = stack2[index--] + 1;
				
				if(sw == 2) {
					System.out.println(n);
					if (index < 0)
						return;
				}
			} while (sw == 2);
		}
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.print("정수를 입력하세요.：");
		int x = scanner.nextInt();

		recur3(x);
	}
}
