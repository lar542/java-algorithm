package doit.chap04;

//양방향 대기열(시작과 끝 지점에서 양쪽으로 데이터를 인큐, 디큐) 자료구조
public class IntDeque_04_07 {
	private int max;
	private int num;
	private int front;
	private int rear;
	private int[] que;
	
	public class EmptyIntDequeException extends RuntimeException {
		public EmptyIntDequeException() {
		}
	}

	public class OverflowIntDequeException extends RuntimeException {
		public OverflowIntDequeException() {
		}
	}
	
	public IntDeque_04_07(int capacity) {
		num = front = rear = 0;
		max = capacity;
		try {
			que = new int[max];
		} catch (OutOfMemoryError e) {
			max = 0;
		}
	}
	
	//deck에 데이터를 머리 쪽부터 인큐
	public int enqueFront(int x) throws OverflowIntDequeException {
		if (num >= max)
			throw new OverflowIntDequeException();
		if (--front < 0)
			front = max - 1;
		que[front] = x;
		num++;
		return x;
	}
	
	//deck의 머리부터 데이터를 디큐
	public int dequeFront() throws EmptyIntDequeException {
		if (num <= 0)
			throw new EmptyIntDequeException();
		int x = que[front++];
		num--;
		if (front == max)
			front = 0;
		return x;
	}
	
	//deck에 데이터를 꼬리 쪽부터 인큐
	public int enqueRear(int x) throws OverflowIntDequeException {
		if (num >= max)
			throw new OverflowIntDequeException();
		que[rear++] = x;
		num++;
		if (rear == max)
			rear = 0;
		return x;
	}
	
	//deck의 꼬리부터 데이터를 디큐
	public int dequeRear() throws EmptyIntDequeException {
		if (num <= 0)
			throw new EmptyIntDequeException();
		if (--rear < 0)
			rear = max - 1;
		num--;
		return que[rear];
	}
	
	//deck의 머리부터 데이터를 피크
	public int peekFront() throws EmptyIntDequeException {
		if (num <= 0)
			throw new EmptyIntDequeException();
		return que[front];
	}
	
	//deck의 꼬리부터 데이터를 피크
	public int peekRear() throws EmptyIntDequeException {
		if (num <= 0)
			throw new EmptyIntDequeException();
		return que[rear == 0 ? max - 1 : rear - 1];
	}
	
	//deck에서 x를 검색하여 index를 반환
	public int indexOf(int x) {
		for (int i = 0; i < num; i++)
			if (que[(i + front) % max] == x)
				return i + front;
		return -1;
	}
	
	//deck에서 x를 검색하여 머리부터 몇 번 째인가를 반환
	public int search(int x) {
		for (int i = 0; i < num; i++)
			if (que[(i + front) % max] == x)
				return i + 1;
		return 0;
	}
	
	public void clear() {
		num = front = rear = 0;
	}

	public int capacity() {
		return max;
	}

	public int size() {
		return num;
	}

	public boolean isEmpty() {
		return num <= 0;
	}

	public boolean isFull() {
		return num >= max;
	}

	public void dump() {
		if (num <= 0)
			System.out.println("덱(deck)이 비었습니다.");
		else {
			for (int i = 0; i < num; i++)
				System.out.print(que[(i + front) % max] + " ");
			System.out.println();
		}
	}
}
