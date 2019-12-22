package doit.chap03;

import java.util.Scanner;

//이진 검색(binary search)
public class BinSearch {

	//길이가 n인 배열 a에서 key와 같은 요소를 이진 검색합니다
	static int binSearch(int[] a, int n, int key) {
		int low = 0;		//검색 범위의 첫 인덱스
		int high = n - 1;	//검색 범위의 끝 인덱스
		
		while (low <= high) {
			int mid = (low + high) / 2; //중간 인덱스
			if (a[mid] == key) {
				return mid;
			} else if (a[mid] < key) {
				low = mid + 1;
			} else {
				high = mid - 1;
			}
		}
		
		return -1; //검색 실패
	}
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("길이 : ");
		int num = scanner.nextInt();
		int[] x = new int[num];
		
		System.out.println("오름차순으로 입력하세요.");
		
		System.out.print("x[0] : ");
		x[0] = scanner.nextInt();
		
		for (int i = 1; i < num; i++) {
			do {
				System.out.print("x[" + i + "] : ");
				x[i] = scanner.nextInt();
			} while (x[i] < x[i - 1]);
		}
		
		System.out.print("검색할 값 : ");
		int ky = scanner.nextInt();
		
		int idx = binSearch(x, num, ky);
		
		if(idx == -1) {
			System.out.println("그 값의 요소가 없습니다.");
		} else {
			System.out.println(ky + "은(는) x[" + idx + "]에 있습니다.");
		}
	}
}
