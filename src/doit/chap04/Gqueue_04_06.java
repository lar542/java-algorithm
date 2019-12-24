package doit.chap04;

//임의의 객체형 데이터를 쌓아 놓을 수 있는 제네릭 큐
public class Gqueue_04_06<E> {

	private int max;
	private int num;
	private int front;
	private int rear;
	private E[] que;
	
	public static class EmptyGqueueException extends RuntimeException {
		public EmptyGqueueException() {
		}
	}

	public static class OverflowGqueueException extends RuntimeException {
		public OverflowGqueueException() {
		}
	}
	
	public Gqueue_04_06(int capacity) {
		num = front = rear = 0;
		max = capacity;
		try {
			que = (E[]) new Object[max];
		} catch (OutOfMemoryError e) {
			max = 0;
		}
	}
	
	public E enque(E x) throws OverflowGqueueException {
		if (num >= max)
			throw new OverflowGqueueException();
		que[rear++] = x;
		num++;
		if (rear == max)
			rear = 0;
		return x;
	}
	
	public E deque() throws EmptyGqueueException {
		if (num <= 0)
			throw new EmptyGqueueException();
		E x = que[front++];
		num--;
		if (front == max)
			front = 0;
		return x;
	}
	
	public E peek() throws EmptyGqueueException {
		if (num <= 0)
			throw new EmptyGqueueException();
		return que[front];
	}
	
	//쿠에서 x를 검색하여 인덱스를 반환
	public int indexOf(E x) {
		for (int i = 0; i < num; i++) {
			if (que[(i + front) % max] == x)
				return i + front;
		}
		return -1;
	}
	
	//큐에서 x를 검색하여 머리부터 몇 번째인가
	public int search(E x) {
		for (int i = 0; i < num; i++) {
			if (que[(i + front) % max].equals(x))
				return i + 1;
		}
		return -1;
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
			System.out.println("큐가 비었습니다.");
		else {
			for (int i = 0; i < num; i++)
				System.out.print(que[(i + front) % max].toString() + " ");
			System.out.println();
		}
	}
}
