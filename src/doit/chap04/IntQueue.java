package doit.chap04;

//int형 큐
public class IntQueue {

	private int max;		//큐의 용량
	private int front;		//첫 번째 요소 인덱스
	private int rear;		//마지막 요소의 하나 뒤의 인덱스
	private int num;		//현재 데이터 수(front와 rear의 값이 같은 경우 큐가 비었는지, 가득 찼는지 구별할 수 없는 상황을 피하기 위해 필요)
	private int[] que;		//큐 본체
	
	//실행 시 예외：큐가 비어 있음
	public class EmptyIntQueueException extends RuntimeException {
		public EmptyIntQueueException() { }
	}

	//실행 시 예외：큐가 가득 참
	public class OverflowIntQueueException extends RuntimeException {
		public OverflowIntQueueException() { }
	}
	
	public IntQueue(int capacity) {
		num = front = rear = 0;
		max = capacity;
		try {
			que = new int[max];			//큐 본체용 배열을 생성
		} catch (OutOfMemoryError e) {
			max = 0;
		}
	}
	
	//큐에 데이터를 인큐
	public int enque(int x) throws OverflowIntQueueException {
		if (num >= max)
			throw new OverflowIntQueueException();
		que[rear++] = x;
		num++;
		if (rear == max)
			rear = 0;
		return x;
	}
	
	//큐에 데이터를 디큐
	public int deque() throws EmptyIntQueueException {
		if (num <= 0)
			throw new EmptyIntQueueException();
		int x = que[front++];
		num--;
		if (front == max)
			front = 0;
		return x;
	}
	
	//큐에서 데이터를 피크
	public int peek() throws EmptyIntQueueException {
		if (num <= 0)
			throw new EmptyIntQueueException();
		return que[front];
	}
	
	//큐에서 x를 검색하여 인덱스를 반환
	public int indexOf(int x) {
		for (int i = 0; i < num; i++) {		//프런트 -> 리어 순으로 선형검색
			int idx = (i + front) % max;
			if (que[idx] == x)
				return idx;
		}
		return -1;
	}
	
	//큐를 비움
	public void clear() {
		num = front = rear = 0;
	}
	
	//큐의 용량을 반환
	public int capacity() {
		return max;
	}
	
	//큐에 쌓여있는 데이터 수를 반환
	public int size() {
		return num;
	}
	
	//큐가 비어있는가?
	public boolean isEmpty() {
		return num <= 0;
	}
	
	//큐가 가득 찼는가?
	public boolean isFull() {
		return num >= max;
	}
	
	//큐 안의 모든 데이터를 프런트 -> 리어 순으로 출력
	public void dump() {
		if (num <= 0) {
			System.out.println("큐가 비어 있습니다.");
		} else {
			for (int i = 0; i < num; i++) {
				System.out.print(que[(i + front) % max] + " ");
			}
			System.out.println();
		}
	}
}
