package doit.chap05;

import java.util.Scanner;

//하노이의 탑
public class Hanoi {

	//no개의 원반을 x번 기둥에서 y번 기둥으로 옮긴다
	static void move(int no, int x, int y) {
		if (no > 1)
			move(no - 1, x, 6 - x - y);
		//기둥 번호의 합이 6이므로 시작/목표 기둥이 어느 기둥이더라도 중간 기둥은 6 - x - y로 구할 수 있다
		
		System.out.printf("원반[%d]을 %d번 기둥에서 %d번 기둥으로 옮김\n", no, x, y);
		
		if (no > 1)
			move(no - 1, 6 - x - y, y);
	}
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.println("하노이의 탑");
		System.out.print("원반 개수：");
		int n = scanner.nextInt();

		move(n, 1, 3);
	}
}
