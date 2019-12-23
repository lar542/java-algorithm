package doit.chap03;

import java.util.Scanner;

//이진 검색(검색과정을 자세히 출력)
public class BinSearchEx_03_04 {

	static int binSearchEx(int[] a, int n, int key) {
		System.out.print("   |");
		for (int i = 0; i < n; i++) {
			System.out.printf("%4d", i);
		}
		System.out.println();
		
		System.out.print("---+");
		for (int i = 0; i < n * 4 + 2; i++) {
			System.out.print("-");
		}
		System.out.println();
		
		int low = 0;
		int hight = n - 1;
		
		while (low <= hight) {
			int mid = (low + hight) / 2;
			
			System.out.print("   |");
			if(low != mid) {
				System.out.printf(String.format("%%%ds<-%%%ds+", low + 2, (mid - low) * 4 - 1), "", "");
			} else {
				System.out.printf(String.format("%%%ds<-+", mid * 4 + 1), "");
			}
			
			if(mid != hight) {
				System.out.printf(String.format("%%%ds->\n", (hight - mid) * 4 - 2), "");
			} else {
				System.out.println("->");
			}
			
			System.out.printf("%3d|", mid);
			for (int i = 0; i < n; i++) {
				System.out.printf("%4d", a[i]);
			}
			System.out.print("\n   |\n");
			
			if (a[mid] == key) {
				return mid;
			} else if(a[mid] < key) {
				low = mid + 1;
			} else {
				hight = mid - 1;
			}
		}
		
		return -1;
	}
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.print("길이 : ");
		int num = scanner.nextInt();
		int[] x = new int[num]; // 요솟수 num인 배열

		System.out.println("오름차순으로 입력하세요.");

		System.out.print("x[0] : "); // 맨 앞 요소를 읽어 들임
		x[0] = scanner.nextInt();

		for (int i = 1; i < num; i++) {
			do {
				System.out.print("x[" + i + "]：");
				x[i] = scanner.nextInt();
			} while (x[i] < x[i - 1]); // 하나 앞의 요소보다 작으면 다시 입력
		}

		System.out.print("찾는 값 : "); // 키 값을 입력 받음
		int ky = scanner.nextInt();

		int idx = binSearchEx(x, num, ky); // 배열 x에서 값이 ky인 요소를 검색

		if (idx == -1)
			System.out.println("그 값의 요소가 없습니다.");
		else
			System.out.println(ky + "은 x[" + idx + "]에 있습니다.");
	}
}
