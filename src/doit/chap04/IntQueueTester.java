package doit.chap04;

import java.util.Scanner;

public class IntQueueTester {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		IntQueue queue = new IntQueue(64);	// 최대 64개를 인큐할 수 있는 큐

		while (true) {
			System.out.println("현재 데이터 수 : " + queue.size() + " / " + queue.capacity());
			System.out.print("(1)인큐  (2)디큐  (3)피크  (4)덤프  (0)종료 : ");

			int menu = scanner.nextInt();
			if (menu == 0) break;

			int x;
			switch (menu) {
			 case 1: 							// 인큐
				System.out.print("데이터：");
				x = scanner.nextInt();
				try {
					queue.enque(x);
			 	} catch (IntQueue.OverflowIntQueueException e) {
					System.out.println("큐가 가득 찼습니다.");
				}
				break;

			 case 2: 							// 디큐
				try {
			 		x = queue.deque();
					System.out.println("디큐한 데이터는 " + x + "입니다.");
			 	} catch (IntQueue.EmptyIntQueueException e) {
					System.out.println("큐가 비어 있습니다.");
				}
				break;

			 case 3: 							// 피크
				try {
			 		x = queue.peek();
					System.out.println("피크한 데이터는 " + x + "입니다.");
			 	} catch (IntQueue.EmptyIntQueueException e) {
					System.out.println("큐가 비어 있습니다.");
				}
				break;

			 case 4: 							// 덤프
				queue.dump();
				break;
			}
		}
	}
}
