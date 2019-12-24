package doit.chap04;

//int형 큐(링 버퍼(ring buffer)를 사용하지 않음)
public class IntAryQueue_04_04 {

	private int max;		//큐 용량
	private int num;		//현재 데이터 수
	private int[] que;		//큐 본체
	
	// 실행할 때 예외：큐가 비어 있음
	public class EmptyIntAryQueueException extends RuntimeException {
		public EmptyIntAryQueueException() {
		}
	}

	// 실행할 때 예외：큐가 가득 참
	public class OverflowIntAryQueueException extends RuntimeException {
		public OverflowIntAryQueueException() {
		}
	}

	public IntAryQueue_04_04(int capacity) {
		num = 0;
		max = capacity;
		try {
			que = new int[max];				//큐 본체용 배열을 생성
		} catch (OutOfMemoryError e) {
			max = 0;
		}
	}
	
	//큐에 데이터를 인큐
	public int enque(int x) throws OverflowIntAryQueueException {
		if (num >= max)
			throw new OverflowIntAryQueueException();
		return que[num++] = x;
	}
	
	//큐에서 데이터를 디큐
	public int deque() throws EmptyIntAryQueueException {
		if (num <= 0)
			throw new EmptyIntAryQueueException();
		int x = que[0];
		for (int i = 0; i < num - 1; i++) {		//두 번째 이후의 요소를 모두 맨 앞으로 옮김, 복잡도는 O(n)
			que[i] = que[i + 1];
		}
		num--;
		return x;
	}
	
	//큐에서 데이터를 피크
	public int peek() throws EmptyIntAryQueueException {
		if (num <= 0)
			throw new EmptyIntAryQueueException();
		return que[num - 1];
	}
	
	//큐에서 x를 검색하여 인덱스를 반환
	public int indexOf(int x) {
		for (int i = 0; i < num; i++) {
			if (que[i] == x)
				return i;
		}
		return -1;
	}
	
	//큐를 비움
	public void clear() {
		num = 0;
	}
	
	//큐의 용량을 반환
	public int capacity() {
		return max;
	}
	
	//큐에 쌓인 데이터 수 반환
	public int size() {
		return num;
	}
	
	//큐가 비어있는가?
	public boolean isEmpty() {
		return num <= 0;
	}
	
	//큐가 가득찼는가?
	public boolean isFull() {
		return num >= max;
	}
	
	public void dump() {
		if (num <= 0) {
			System.out.println("큐가 비었습니다.");
		} else {
			for (int i = 0; i < num; i++) {
				System.out.print(que[i] + " ");
			}
			System.out.println();
		}
	}
}
