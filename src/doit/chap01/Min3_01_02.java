package doit.chap01;

import java.util.Scanner;

public class Min3_01_02 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int a = scanner.nextInt();
		int b = scanner.nextInt();
		int c = scanner.nextInt();
		System.out.printf("최솟값은 %d", min3(a, b, c));
	}

	/**
	 * 세 값의 최솟값을 구한다
	 * @param a
	 * @param b
	 * @param c
	 * @return
	 */
	private static int min3(int a, int b, int c) {
		int min = a;
		if (b < min) min = b;
		if (c < min) min = c;
		return min;
	}
}
