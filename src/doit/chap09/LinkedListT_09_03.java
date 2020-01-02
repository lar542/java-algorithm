package doit.chap09;

import java.util.Comparator;

public class LinkedListT_09_03<E> {

	// 노드
	class Node<E> {
		private E data; // 데이터
		private Node<E> next; // 뒤쪽포인터(다음 노드에 대한 참조)

		// 생성자
		Node(E data, Node<E> next) {
			this.data = data;
			this.next = next;
		}
	}
	
	private Node<E> head; // 머리 노드
	private Node<E> tail; // 꼬리 노드
	private Node<E> crnt; // 선택 노드
	
	//생성자
	public LinkedListT_09_03() {
		head = tail = crnt = null;
	}
	
	//노드 검색
	public E search(E obj, Comparator<? super E> c) {
		Node<E> ptr = head;			//현재 스캔 중인 노드
		
		while (ptr != null) {
			if (c.compare(obj, ptr.data) == 0) {
				crnt = ptr;
				return ptr.data;
			}
			ptr = ptr.next;			//다음 노드를 선택
		}
		return null;				//검색 실패
	}
	
	//머리에 노드 삽입
	public void addFirst(E o) {
		boolean empty = (tail == null);		//노드 존재 여부
		Node<E> ptr = head;
		head = crnt = new Node<E>(o, ptr);
		if (empty)		//노드가 하나인 경우, head == tail
			tail = crnt;
	}
	
	//꼬리에 노드를 삽입
	public void addLast(E o) {
		if (head == null) {
			addFirst(o);
		} else {
			tail.next = crnt = new Node<E>(o, null);
			tail = crnt;
		}
	}
	
	//머리 노드 삭제
	public void removeFirst() {
		if (head != null) {
			head = crnt = head.next;
			if (head == null) {
				tail = null;
			}
		}
	}
	
	//꼬리 노드 삭제
	public void removeLast() {
		if (head != null) {
			if (head.next == null) {	//노드가 하나만 있으면
				removeFirst();          //머리 노드를 삭제하는 것과 같음
			} else {
				Node<E> ptr = head;		//스캔 중인 노드
				Node<E> pre = head;		//스캔 중인 노드의 앞쪽 노드
				
				while (ptr.next != null) {
					pre = ptr;
					ptr = ptr.next;
				}
				
				pre.next = null;		//삭제 후의 꼬리 노드
				tail = crnt = pre;
			}
		}
	}
	
	//노드 p를 삭제
	public void remove(Node p) {
		if (head != null) {
			if (p == head) {		//p가 머리 노드면
				removeFirst();		
			} else if (p == tail) {	//p가 꼬리 노드면
				removeLast();
			} else {
				Node<E> ptr = head;		//p의 앞쪽 노드
				
				while (ptr.next != p) {
					ptr = ptr.next;
					if (ptr == null) return;	//p가 리스트에 없음
				}
				ptr.next = p.next;
				crnt = ptr;
			}
		}
	}
	
	//현재 선택한 노드 삭제
	public void removeCurrentNode() {
		remove(crnt);
	}
	
	//모든 노드를 삭제
	public void clear() {
		while (head != null) {		//노드에 아무것도 없을 때까지
			removeFirst();			//머리 노드를 삭제
		}
		crnt = null;
	}
	
	//선택 노드를 하나 뒤쪽으로 이동
	public boolean next() {
		if (crnt == null || crnt.next == null) {
			return false;
		}
		crnt = crnt.next;
		return true;
	}
	
	//선택 노드를 출력
	public void printCurrentNode() {
		if (crnt == null) {
			System.out.println("선택한 노드가 없습니다.");
		} else {
			System.out.println(crnt.data);
		}
	}
	
	//모든 노드를 출력
	public void dump() {
		Node<E> ptr = head;
		
		while (ptr != null) {
			System.out.println(ptr.data);
			ptr = ptr.next;
		}
	}
	
	//comparator c에 의해 서로 같다고 보는 노드를 모두 삭제
	public void purge(Comparator<? super E> c) {
		Node<E> ptr = head;
		
		while (ptr != null) {
			int count = 0;
			Node<E> ptr2 = ptr;
			Node<E> pre = ptr;
			
			while (pre.next != null) {
				ptr2 = pre.next;
				if (c.compare(ptr.data, ptr2.data) == 0) {
					pre.next = ptr2.next;
					count++;
				} else {
					pre = ptr2;
				}
			}
			if (count == 0) {
				pre = ptr.next;
			} else {
				Node<E> temp = ptr;
				remove(ptr);
				ptr = temp.next;
			}
		}
		crnt = head;
	}
	
	//머리부터 n개 뒤 노드의 데이터에 대한 참조를 반환
	public E retrieve(int n) {
		Node<E> ptr = head;
		
		while (n >= 0 && ptr != null) {
			if (n-- == 0) {
				crnt = ptr;
				return ptr.data;
			}
			ptr = ptr.next;
		}
		return null;
	}
}