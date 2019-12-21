package doit.chap02;

import java.util.Scanner;

//한 해의 경과 일 수를 계산한다
public class DayOfYear {

	//각 달의 일수
	static int[][] mdays = {
		{31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31},	//평년
		{31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31}	//윤년
	};
	
	//year년이 윤년인지 평년인지 구분한다 (평년 : 0, 윤년 : 1)
	static int isLeap(int year) {
		return (year % 4 == 0 && year % 100 != 0 || year % 400 == 0) ? 1 : 0;
	}
	
	//y년 m월 d일의 그 해 경과 일 수를 구한다
	static int dayOfYear(int y, int m, int d) {
		int days = d;
		
		for (int i = 1; i < m; i++) {
			days += mdays[isLeap(y)][i - 1];
		}
		
		return days;
	}
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		int retry;
		
		System.out.println("그 해의 경과 일수를 구합니다.");
		
		do {
			System.out.print("년 : ");
			int year = scanner.nextInt();
			System.out.print("월 : ");
			int month = scanner.nextInt();
			System.out.print("일 : ");
			int day = scanner.nextInt();
			
			System.out.printf("그 해 %d일째입니다.\n", dayOfYear(year, month, day));
			
			System.out.println("한 번 더 할까요? (1.예/0.아니오) : ");
			retry = scanner.nextInt();
		} while (retry == 1);
	}
}
