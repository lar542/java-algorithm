package doit.chap11;

//오픈 주소법에 의한 해시
public class OpenHash<K, V> {

	//버킷의 상태
	enum Status {OCCUPIED, EMPTY, DELETED};		//데이터 저장, 비어 있음, 삭제 마침
	
	//버킷
	static class Bucket<K, V> {
		private K key;			//키 값
		private V data;			//데이터
		private Status stat;	//상태
		
		Bucket() {
			stat = Status.EMPTY;
		}
		
		void set(K key, V data, Status stat) {
			this.key = key;
			this.data = data;
			this.stat = stat;
		}

		//상태 설정
		void setStat(Status stat) {
			this.stat = stat;
		}
		
		//키 값 반환
		K getKey() {
			return key;
		}
		
		//데이터 반환
		V getValue() {
			return data;
		}
		
		//키의 해시 값을 반환
		public int hashCode() {
			return key.hashCode();
		}
	}
	
	private int size;					//해시 테이블의 크기
	private Bucket<K, V>[] table;		//해시 테이블
	
	public OpenHash(int size) {
		try {
			table = new Bucket[size];
			this.size = size;
			for (int i = 0; i < size; i++) {
				table[i] = new Bucket<K, V>();
			}
		} catch (OutOfMemoryError e) {
			this.size = 0;
		}
	}
	
	//해시 값을 구한다(해시 함수)
	public int hashValue(Object key) {
		return key.hashCode() % size;
	}
	
	//재해시 값을 구한다
	public int rehashValue(int hash) {
		return (hash + 1) % size;
	}
	
	//키 값 key를 갖는 버킷의 검색
	private Bucket<K, V> searchNode(K key) {
		int hash = hashValue(key);		//해시 값
		Bucket<K, V> p = table[hash];	//버킷
		
		for (int i = 0; p.stat != Status.EMPTY && i < size; i++) {
			if (p.stat == Status.OCCUPIED && p.getKey().equals(key)) {
				return p;
			}
			hash = rehashValue(hash);	//재해시
			p = table[hash];			//버킷
		}
		return null;
	}
	
	//요소 검색(데이터 반환)
	public V search(K key) {
		Bucket<K, V> p =searchNode(key);
		if (p != null) {
			return p.getValue();
		}
		return null;
	}
	
	//요소 추가
	public int add(K key, V data) {
		if (search(key) != null) {		//이미 등록되어 있음
			return 1;
		}
		int hash = hashValue(key);		//해시 값
		Bucket<K, V> p = table[hash];	//버킷
		for (int i = 0; i < size; i++) {
			if (p.stat == Status.EMPTY || p.stat == Status.DELETED) {
				p.set(key, data, Status.OCCUPIED);
				return 0;
			}
			hash = rehashValue(hash);	//재해시
			p = table[hash];			//버킷
		}
		return 2;						//해시 테이블이 가득 참
	}
	
	//요소 삭제
	public int remove(K key) {
		Bucket<K, V> p = searchNode(key);	//선택 버킷
		if (p == null) {					//등록되어 있지 않음
			return 1;
		}
		p.setStat(Status.DELETED);
		return 0;
	}
	
	//해시 테이블의 모든 요소를 출력
	public void dump() {
		for (int i = 0; i < size; i++) {
			System.out.printf("%02 ", i);
			
			switch (table[i].stat) {
			case OCCUPIED:
				System.out.printf("%s (%s)\n", table[i].getKey(), table[i].getValue());
				break;
			case EMPTY:
				System.out.println("-- 미등록 --");
				break;
			case DELETED:
				System.out.println("-- 삭제 마침 --");
				break;
			}
		}
	}
}