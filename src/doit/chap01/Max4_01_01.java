package doit.chap01;

import java.util.Scanner;

public class Max4_01_01 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int i = scanner.nextInt();
		int j = scanner.nextInt();
		int k = scanner.nextInt();
		int l = scanner.nextInt();
		System.out.printf("최댓값은 %d", max4(i, j, k, l));
	}

	/**
	 * 네 값의 최댓값을 구한다
	 * @param i
	 * @param j
	 * @param k
	 * @param l
	 * @return
	 */
	private static int max4(int i, int j, int k, int l) {
		int max = i;
		if (j > max) max = j;
		if (k > max) max = j;
		if (l > max) max = l;
		return max;
	}
}
