package doit.chap03;

import java.util.Scanner;

//선형 검색
public class SeqSearchFor {
	
	//길이가 n인 배열 a에서 key와 같은 요소를 선형 검색하여 그 요소의 인덱스를 반환한다
	private static int seqSearch(int[] a, int n, int key) {
		
			for (int i = 0; i < n; i++) {
				if (a[i] == key)
					return i;
			}
			return -1;
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.print("길이 : ");
		int num = scanner.nextInt();
		int[] x = new int[num];

		for (int i = 0; i < num; i++) {
			System.out.print("x[" + i + "]：");
			x[i] = scanner.nextInt();
		}

		System.out.print("찾는 값 : ");
		int ky = scanner.nextInt();

		int idx = seqSearch(x, num, ky);

		if (idx == -1)
			System.out.println("그 값의 요소가 없습니다.");
		else
			System.out.println("그 값은 x[" + idx + "]에 있습니다.");
	}
}
