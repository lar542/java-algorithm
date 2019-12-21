package doit.chap02;

import java.util.Scanner;

public class YMD_02_11 {

	int y;
	int m;
	int d;
	
	public YMD_02_11(int y, int m, int d) {
		this.y = y;
		this.m = m;
		this.d = d;
	}
	
	//각 달의 일수
	static int[][] mdays = {
		{31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31},	//평년
		{31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31}	//윤년
	};
	
	//year년이 윤년인지 평년인지 구분한다 (평년 : 0, 윤년 : 1)
	static int isLeap(int year) {
		return (year % 4 == 0 && year % 100 != 0 || year % 400 == 0) ? 1 : 0;
	}
	
	//n일 후의 날짜를 반환한다
	public YMD_02_11 after(int n) {
		YMD_02_11 tmp = new YMD_02_11(this.y, this.m, this.d);
		
		if(n < 0)
			return (before(-n));
		
		tmp.d += n;
		
		while (tmp.d > mdays[isLeap(tmp.y)][tmp.m - 1]) { //마지막 날짜보다 큰지
			tmp.d -= mdays[isLeap(tmp.y)][tmp.m - 1];
			if (++tmp.d > 12) {
				tmp.y++;
				tmp.m = 1;
			}
		}
		
		return tmp;
	}
	
	//n일 앞의 날짜를 반환한다
	public YMD_02_11 before(int n) {
		YMD_02_11 tmp = new YMD_02_11(this.y, this.m, this.d);
		
		if(n < 0)
			return (after(-n));
		
		tmp.d -= n;
		
		while (tmp.d < 1) {
			if(--tmp.m < 1) {
				tmp.y--;
				tmp.m = 12;
			}
			tmp.d += mdays[isLeap(tmp.y)][tmp.m - 1];
		}
		
		return tmp;
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("날짜를 입력하세요.");
		System.out.print("년：");
		int y = scanner.nextInt();
		System.out.print("월：");
		int m = scanner.nextInt();
		System.out.print("일：");
		int d = scanner.nextInt();
		
		YMD_02_11 date = new YMD_02_11(y, m, d);
		
		System.out.print("몇 일 앞/뒤의 날짜를 구할까요? : ");
		int n = scanner.nextInt();
		
		YMD_02_11 d1 = date.after(n);
		System.out.printf("%d일 뒤의 날짜는 %d년 %d월 %d일 입니다.\n", n, d1.y, d1.m, d1.d);
		
		YMD_02_11 d2 = date.before(n);
		System.out.printf("%d일 앞의 날짜는 %d년 %d월 %d일 입니다.", n, d2.y, d2.m, d2.d);
	}
}
