package doit.chap03;

import java.util.Scanner;

//선형 검색(검색과정을 상세히 나타냄)
public class SeqSearchEx_03_02 {
	
	private static int seqSearchEx(int[] a, int n, int key) {
		System.out.print("   |");
		for (int i = 0; i < n; i++) {
			System.out.printf("%4d", i);
		}
		System.out.println();
		
		System.out.print("---+");
		for (int i = 0; i < n * 4; i++) {
			System.out.print("-");
		}
		System.out.println();
		
		for (int i = 0; i < n; i++) {
			System.out.print("   |");
			System.out.printf(String.format("%%%ds*\n", i * 4 + 3), "");
			System.out.printf("%3d|", i);
			for (int j = 0; j < n; j++) {
				System.out.printf("%4d", a[j]);
			}
			System.out.println("\n   |");
			
			if (a[i] == key)
				return i;
		}
		return -1;
	}

	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);

		System.out.print("길이 : ");
		int num = stdIn.nextInt();
		int[] x = new int[num];

		for (int i = 0; i < num; i++) {
			System.out.print("x[" + i + "]：");
			x[i] = stdIn.nextInt();
		}

		System.out.print("찾는 값：");
		int ky = stdIn.nextInt();

		int idx = seqSearchEx(x, num, ky);

		if (idx == -1)
			System.out.println("그 값의 요소가 없습니다.");
		else
			System.out.println(ky + "은 " + "x[" + idx + "]에 있습니다.");
	}
}
