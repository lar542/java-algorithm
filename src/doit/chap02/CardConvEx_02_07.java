package doit.chap02;

import java.util.Scanner;

public class CardConvEx_02_07 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int no; //변환하는 정수
		int cd; //진수
		int dno; //변환 후의 자릿수
		int retry; //다시 한 번
		char[] cno = new char[32]; //변환 후 각 자리의 숫자를 넣어두는 문자의 배열
		
		System.out.println("10진수를 기수 변환합니다.");
		do {
			do {
				System.out.print("변환할 양의 정수 : ");
				no = scanner.nextInt();
			} while (no < 0);
			
			do {
				System.out.print("어떤 진수로 변환할까요? (2~36) : ");
				cd = scanner.nextInt();
			} while (cd < 2 || cd > 36);
			
			dno = cardConvEx(no, cd, cno);
			
			System.out.print(cd + "진수로 ");
			for (int i = 0; i < dno; i++) {
				System.out.print(cno[i]);
			}
			System.out.println("입니다.");
			
			System.out.print("한 번 더 할까요? (1.예/0.아니오) : ");
			retry = scanner.nextInt();
		} while(retry == 1);
	}

	private static int cardConvEx(int x, int r, char[] d) {
		int digits = 0;
		String dchar = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		int n = ((Integer) x).toString().length();
		
		System.out.printf("%d | %5d\n", r, x);
		do {
			System.out.print("  +-------\n");
			
			if (x / r != 0) {
				System.out.printf("%d | %5d  ...%d\n", r, x / r, x % r);
			} else {
				System.out.printf("    %5d  ...%d\n", 0, x % r);
			}
			
			d[digits++] = dchar.charAt(x % r);
			x /= r;
		} while (x != 0);
		
		for (int i = 0; i < digits / 2; i++) {
			char tmp = d[i];
			d[i] = d[digits - i - 1];
			d[digits - i - 1] = tmp;
		}
		
		return digits;
	}
}
