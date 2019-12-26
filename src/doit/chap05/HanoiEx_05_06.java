package doit.chap05;

import java.util.Scanner;

//하노이의 탑(기둥 이름을 문자열로 나타냄)
public class HanoiEx_05_06 {
	
	static String[] name = {"A", "B", "C"};

	//원반을 x기둥에서 y기둥으로 옮김
	static void move(int no, int x, int y) {
		if (no > 1)
			move(no - 1, x, 6 - x - y);
		
		System.out.printf("원반[%d]을 %s 기둥에서 %s 기둥으로 옮김\n", no, name[x - 1], name[y - 1]);
		
		if (no > 1)
			move(no - 1, 6 - x - y, y);
	}
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.println("하노이의 탑");
		System.out.print("원반의 갯수：");
		int n = scanner.nextInt();

		move(n, 1, 3); // 1기둥에 쌓인 n개를 3기둥에 옮김
	}
}
