package doit.chap04;

//int형 스택
public class IntStack {

	private int max;	//스택 용량 : 스택에 쌓을 수 있는 최대 데이터 수 = 배열 stk의 길이
	private int ptr;	//스택 포인터 : 스택에 쌓여있는 데이터 수, 새로운 데이터를 삽입할 인덱스를 기억하는 용도로 사용하는 변수
	private int[] stk;	//스택 본체
	
	//실행 시 예외 : 스택이 비어 있음
	public class EmptyIntStackException extends RuntimeException {
		public EmptyIntStackException() {}
	}
	
	//실행 시 예외 : 스택이 가득 참
	public class OverflowIntStackException extends RuntimeException {
		public OverflowIntStackException() {}
	}
	
	//생성자
	public IntStack(int capacity) {
		ptr = 0;
		max = capacity;
		try {
			stk = new int[max];		//스택 본체용 배열을 생성
		} catch (OutOfMemoryError e) { //생성할 수 없음
			max = 0; //다른 메서드가 존재하지 않는 배열에 잘못 접근하는 것을 막기 위해
		}
	}
	
	//푸시
	public int push(int x) throws OverflowIntStackException {
		if (ptr >= max) { //스택이 가득참
			throw new OverflowIntStackException();
		}
		return stk[ptr++] = x; //x를 저장한 후의 stk[ptr]의 값 = 푸시한 값 을 반환
	}
	
	//팝
	public int pop() throws EmptyIntStackException {
		if (ptr <= 0) { //스택이 비어있음
			throw new EmptyIntStackException();
		}
		return stk[--ptr];
	}
	
	//피크 : 스택의 꼭대기에 있는 데이터 조회
	public int peek() throws EmptyIntStackException {
		if (ptr <= 0) { //스택이 비어있음
			throw new EmptyIntStackException();
		}
		return stk[ptr - 1];
	}
	
	//스택에서 x를 찾아 인덱스를 반환
	public int indexOf(int x) {
		for (int i = ptr - 1; i >= 0; i--) { //꼭대기 -> 바닥으로 선형검색 (먼저 팝이 되는 데이터를 찾기 위해)
			if (stk[i] == x) 
				return i;
		}
		return -1;
	}
	
	//스택을 비움
	public void clear() {
		ptr = 0;
	}
	
	//스택의 용량을 반환
	public int capacity() {
		return max;
	}
	
	//스택에 쌓여있는 데이터 수를 반환
	public int size() {
		return ptr;
	}
	
	//스택이 비어있는가? 비어있으면 true 아니면 false
	public boolean isEmpty() {
		return ptr <= 0;
	}
	
	//스택이 가득 찼는가? 가득 찼으면 true 아니면 false
	public boolean isFull() {
		return ptr >= max;
	}
	
	//스택 안의 모든 데이터를 바닥 -> 꼭대기 순서로 출력
	public void dump() {
		if (ptr <= 0) {
			System.out.println("스택이 비어 있습니다.");
		} else {
			for (int i = 0; i < ptr; i++) {
				System.out.print(stk[i] + " ");
			}
			System.out.println();
		}
	}
}
