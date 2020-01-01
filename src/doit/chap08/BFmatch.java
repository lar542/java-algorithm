package doit.chap08;

import java.util.Scanner;

//브루트-포스법으로 문자열을 검색하는 프로그램
public class BFmatch {

	//브루트-포스법으로 문자열을 검색하는 메서드(여러 개라면 가장 앞쪽에 있는 인덱스 반환)
	static int bfMatch(String txt, String pat) {
		int pt = 0;			//텍스트를 스캔하는 변수
		int pp = 0;			//패턴을 스캔하는 변수
		
		while (pt != txt.length() && pp != pat.length()) {
			if (txt.charAt(pt) == pat.charAt(pp)) {
				pt++;
				pp++;
			} else {
				pt = pt - pp + 1;
				pp = 0;
			}
		}
		if (pp == pat.length()) {
			return pt - pp;		//검색 성공
		}
		return -1;				//검색 실패
	}
	
	//여러 개라면 가장 뒤쪽에 있는 인덱스 반환
	static int bfMatchLast(String txt, String pat) {
		int pt = txt.length() - 1;
		int pp = pat.length() - 1;
		
		while (pt >= 0 && pp >= 0) {
			if (txt.charAt(pt) == pat.charAt(pp)) {
				pt--;
				pp--;
			} else {
				pt = pt + (pat.length() - pp) - 2;
				pp = pat.length() - 1;
			}
		}
		if (pp < 0) {
			return pt + 1;
		}
		return -1;
	}
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("텍스트 : ");
		String s1 = scanner.next();
		
		System.out.print("패턴 : ");
		String s2 = scanner.next();
		
		int idx = bfMatch(s1, s2);
		
		if (idx == -1) {
			System.out.println("텍스트에 패턴이 없습니다.");
		} else {
			//일치하는 문자 바로 앞까지의 길이를 구한다
			int len = 0;
			for (int i = 0; i < idx; i++) {
				len += s1.substring(i, i + 1).getBytes().length;
			}
			len += s2.length();
			
			System.out.println((idx + 1) + "번째 문자부터 일치합니다.");
			System.out.println("텍스트 : " + s1);
			System.out.printf(String.format("패턴 : %%%ds\n", len), s2);
		}
		
		idx = bfMatchLast(s1, s2);
		
		if (idx == -1) {
			System.out.println("텍스트에 패턴이 없습니다.");
		} else {			
			int len = 0;
			for (int i = 0; i < idx; i++)
				len += s1.substring(i, i + 1).getBytes().length;
			len += s2.length();

			System.out.println((idx + 1) + "번째 문자와 일치합니다.");
			System.out.println("텍스트：" + s1);
			System.out.printf(String.format("패턴：%%%ds\n", len), s2);
		}
	}
}
