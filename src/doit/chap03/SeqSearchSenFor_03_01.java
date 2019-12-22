package doit.chap03;

import java.util.Scanner;

//선형 검색(보초법) for문으로
public class SeqSearchSenFor_03_01 {

	private static int seqSearchSen(int[] a, int n, int key) {
		int i;
		a[n] = key; //보초를 추가
		
		for (i = 0; a[i] != key; i++)
			;
		
		return i == n ? -1 : i;
	}
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.print("길이：");
		int num = scanner.nextInt();
		int[] x = new int[num + 1]; //보초를 넣을 길이만큼

		for (int i = 0; i < num; i++) {
			System.out.print("x[" + i + "]：");
			x[i] = scanner.nextInt();
		}

		System.out.print("검색할 값：");
		int ky = scanner.nextInt();

		int idx = seqSearchSen(x, num, ky);

		if (idx == -1)
			System.out.println("그 값의 요소가 없습니다.");
		else
			System.out.println(ky+"은(는) x[" + idx + "]에 있습니다.");
	}
}
