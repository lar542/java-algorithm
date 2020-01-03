package doit.chap09;

import java.util.Comparator;

//연결 리스트 클래스(배열 커서 버전)
public class AryLinkedList<E> {

	//노드
	class Node<E> {
		private E data;			//데이터
		private int next;		//뒤쪽 포인터(다음 노드)
		private int dnext;		//프리 리스트의 뒤쪽 포인터(프리 리스트의 다음 노드)
		//프리 리스트 : 삭제된 레코드를 관리하기 위한 연결 리스트
		
		void set(E data, int next) {
			this.data = data;
			this.dnext = next;
		}
	}
	
	private Node<E>[] n;					//리스트 본체
	private int size;						//리스트의 용량(가장 큰 데이터 수)
	private int max;						//배열의 가장 꼬리 쪽에 있는 노드의 레코드 번호(사용 중인 꼬리 레코드)
	private int head;						//머리 노드
	private int crnt;						//선택 노드
	private int deleted;					//프리 리스트의 머리 노드
	private static final int NULL = -1;		//다음 노드 없음 / 리스트가 가득 참
	
	
	public AryLinkedList(int capacity) {
		head = crnt = max = deleted = NULL;
		try {
			n = new Node[capacity];
			for (int i = 0; i < capacity; i++) {
				n[i] = new Node<E>();
			}
			size = capacity;
		} catch (OutOfMemoryError e) {
			size = 0;
		}
	}
	
	//노드를 삽입할 때 사용할 인덱스를 반환
	public int getInsertIndex() {
		if (deleted == NULL) {		//삭제된 레코드가 없어 프리 리스트가 비어 있음
			if (max < size) {
				return ++max;		//max를 증가시켜 아직 사용하지 않은 배열 꼬리 쪽 인덱스를 반환
			} else {
				return NULL;		//용량 넘침
			}
		} else {
			int rec = deleted;			//프리 리스트에서
			deleted = n[rec].dnext;		//머리 레코드를 꺼냄
			return rec;
		}
	}
	
	//삭제한 레코드를 프리 리스트에 등록
	public void deleteIndex(int idx) {
		if (deleted == NULL) {		//프리 리스트가 비어 있음
			deleted = idx;
			n[idx].dnext = NULL;
		} else {
			int rec = deleted;		//idx를 프리 리스트의
			deleted = idx;			//머리에 삽입
			n[idx].dnext = rec;
		}
	}
	
	//노드 검색
	public E search(E obj, Comparator<? super E> c) {
		int ptr = head;
		
		while (ptr != NULL) {
			if (c.compare(obj, n[ptr].data) == 0) {
				crnt = ptr;
				return n[ptr].data;			//검색 성공
			}
			ptr = n[ptr].next;				//다음 노드에 주목			
		}
		return null;						//검색 실패
	}
	
	//머리에 노드 삽입
	public void addFirst(E obj) {
		int ptr = head;					//삽입 전 머리 노드
		int rec = getInsertIndex();		//삽입할 인덱스
		if (rec != NULL) {
			head = crnt = rec;
			n[head].set(obj, ptr);
		}
	}
	
	//꼬리에 노드 삽입
	public void addLast(E obj) {
		if (head == NULL) {
			addFirst(obj);
		} else {
			int ptr = head;
			while (n[ptr].next != NULL) {
				ptr = n[ptr].next;
			}
			int rec = getInsertIndex();
			if (rec != NULL) {
				n[ptr].next = crnt = rec;
				n[rec].set(obj, NULL);
			}
		}
	} 
	
	//머리 노드를 삭제
	public void removeFirst() {
		if (head != NULL) {
			int ptr = n[head].next;
			deleteIndex(head);
			head = crnt = ptr;
		}
	}
	
	//꼬리 노드를 삭제
	public void removeLast() {
		if (head != NULL) {
			if (n[head].next == NULL) {
				removeFirst();
			} else {
				int ptr = head;
				int pre = head;
				
				while (n[ptr].next != NULL) {
					pre = ptr;
					ptr = n[ptr].next;
				}
				n[pre].next = NULL;
				deleteIndex(ptr);
				crnt = pre;
			}
		}
	}
	
	//레코드 p를 삭제
	public void remove(int p) {
		if (head != NULL) {
			if (p == head) {
				removeFirst();
			} else {
				int ptr = head;
				
				while (n[ptr].next != p) {
					ptr = n[ptr].next;
					if (ptr == NULL) return;	//리스트에 p가 없음
				}
				n[ptr].next = NULL;
				deleteIndex(p);
				n[ptr].next = n[p].next;
				crnt = ptr;
			}
		}
	}
	
	//선택 노드 삭제
	public void removeCurrentNode() {
		remove(crnt);
	}
	
	//모든 노드 삭제
	public void clear() {
		while (head != NULL) {
			removeFirst();
		}
		crnt = NULL;
	}
	
	//선택 노드를 하나 뒤쪽으로 이동
	public boolean next() {
		if (crnt == NULL || n[crnt].next == NULL) {
			return false;
		}
		crnt = n[crnt].next;
		return true;
	}
	
	//선택 노드를 출력
	public void printCurrentNode() {
		if (crnt == NULL) {
			System.out.println("선택 노드가 없습니다.");
		} else {
			System.out.println(n[crnt].data);
		}
	}
	
	//모든 노드 출력
	public void dump() {
		int ptr = head;
		
		while (ptr != NULL) {
			System.out.println(n[ptr].data);
			ptr = n[ptr].next;
		}
	}
	
	// ------------------------------ 연습9-4 ------------------------------//
	//comparator c에 의해 서로 같다고 보는 노드를 모두 삭제
	public void purge(Comparator<? super E> c) {
		int ptr = head;

		while (ptr != NULL) {
			int count = 0;
			int ptr2 = ptr;
			int pre = ptr;

			while (n[pre].next != NULL) {
				ptr2 = n[pre].next;
				if (c.compare(n[ptr].data, n[ptr2].data) == 0) {
					remove(ptr2);
					count++;
				} else {
					pre = ptr2;
				}
			}
			if (count == 0) {
				ptr = n[ptr].next;
			} else {
				int temp = n[ptr].next;
				remove(ptr);
				ptr = temp;
			}
		}
		crnt = head;
	}
	
	// ------------------------------ 연습9-5 ------------------------------//
	//머리부터 n개 뒤 노드의 데이터에 대한 참조를 반환
	public E retrieve(int n) {
		int ptr = head;

		while (n >= 0 && ptr != NULL) {
			if (n-- == 0) {
				crnt = ptr;
				return this.n[ptr].data; // 검색성공
			}
			ptr = this.n[ptr].next; // 뒤쪽노드에 주목
		}
		return null;
	}
}
