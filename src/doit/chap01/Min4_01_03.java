package doit.chap01;

import java.util.Scanner;

public class Min4_01_03 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int a = scanner.nextInt();
		int b = scanner.nextInt();
		int c = scanner.nextInt();
		int d = scanner.nextInt();
		System.out.printf("최솟값은 %s", min4(a, b, c, d));
	}

	/**
	 * 네 값의 최솟값을 구한다
	 * @param a
	 * @param b
	 * @param c
	 * @param d
	 * @return
	 */
	private static int min4(int a, int b, int c, int d) {
		int min = a;
		if (b < min) min = b;
		if (c < min) min = c;
		if (d < min) min = d;
		return min;
	}
}
