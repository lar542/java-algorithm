package doit.chap11;

//체인법에 의한 해시
public class ChainHash<K, V> {

	//해시를 구성하는 노드(개별 버킷)
	class Node<K, V> {
		private K key;				//키 값
		private V data;				//데이터
		private Node<K, V> next;	//다음 노드에 대한 참조
		
		Node(K key, V data, Node<K, V> next) {
			this.key = key;
			this.data = data;
			this.next = next;
		}
		
		//키 값을 반환
		K getKey() {
			return key;
		}
		
		//데이터를 반환
		V getValue() {
			return data;
		}
		
		//키의 해시 값을 반환
		public int hashCode() {
			return key.hashCode();
		}
	}
	
	private int size;				//해시 테이블의 크기
	private Node<K, V>[] table;		//해시 테이블
	
	public ChainHash(int capacity) {
		try {
			table = new Node[capacity];
			this.size = capacity;
		} catch (OutOfMemoryError e) {
			this.size = 0;
		}
	}
	
	//해시 값을 구한다(해시 함수)
	public int hashValue(Object key) {
		return key.hashCode() % size;
	}
	
	//키 값으로 요소 검색(데이터를 반환)
	public V search(K key) {
		int hash = hashValue(key);		//키 값에 대한 해시 값을 구함
		Node<K, V> p = table[hash];		//해시 값을 인덱스로하는 버킷
		
		while (p != null) {
			if (p.getKey().equals(key)) {
				return p.getValue();
			}
			p = p.next;
		}
		return null;
	}
	
	//요소 추가
	public int add(K key, V data) {
		int hash = hashValue(key);		//키 값에 대한 해시 값을 구함
		Node<K, V> p = table[hash];		//해시 값을 인덱스로하는 버킷
		
		while (p != null) {
			if (p.getKey().equals(key)) {	//이미 등록되어 있는 키값
				return 1;
			}
			p = p.next;
		}
		//리스트의 맨 앞에 노드 삽입
		Node<K, V> temp = new Node<K, V>(key, data, table[hash]);
		table[hash] = temp;
		return 0;
	}
	
	//요소 삭제
	public int remove(K key) {
		int hash = hashValue(key);		//해시 값
		Node<K, V> p = table[hash];		//버킷
		Node<K, V> pp = null;			//바로 앞의 선택 노드
		
		while (p != null) {
			if (p.getKey().equals(key)) {
				if (pp == null) {		//연결 리스트의 맨 앞이라면
					table[hash] = p.next;
				} else {
					pp.next = p.next;
				}
				return 0;
			}
			pp = p;
			p = p.next;					//다음 노드를 가리킨다
		}
		return 1;						
	}
	
	//해시 테이블의 모든 요소를 출력
	public void dump() {
		for (int i = 0; i < size; i++) {
			Node<K, V> p = table[i];
			System.out.printf("%02d  ", i);
			
			while (p != null) {
				System.out.printf("→ %s (%s)  ", p.getKey(), p.getValue());
				p = p.next;
			}
			System.out.println();
		}
	}
}