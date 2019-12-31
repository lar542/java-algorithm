package doit.chap07;

//요소가 항상 오름차순으로 정렬되는 int형 배열
public class IntSortedSet {
	private int max; // 집합의 용량
	private int num; // 집합의 요솟수
	private int[] set; // 집합본체

	public IntSortedSet(int capacity) {
		num = 0;
		max = capacity;
		try {
			set = new int[max]; 		// 집합본체용 배열을 생성
		} catch (OutOfMemoryError e) { 	// 배열의 생성에 실패
			max = 0;
		}
	}
	
	//집합에서 n을 검색하여 index를 반환
	//찾지 못한 경우 (-삽입포인트-1)를 반환
	public int indexOf(int n) {
		int low = 0;
		int high = num - 1;
		
		do {
			int mid = (low + high) / 2;
			if (set[mid] == n) {
				return mid;
			} else if (set[mid] < n) {
				low = mid + 1;
			} else {
				high = mid - 1;
			}
		} while (low <= high);
		
		return -low - 1;
	}
	
	public boolean contains(int n) {
		return (indexOf(n) != -1) ? true : false;
	}
	
	//집합에 n을 추가(오른차순으로 유지)
	public boolean add(int n) {
		int idx;
		
		if (num >= max || (idx = indexOf(n)) >= 0) {	//가득 찼거나 n이 이미 존재
			return false;
		} else {
			idx = -(idx + 1);
			num++;
			for (int i = num - 1; i > idx; i--) {
				set[i] = set[i - 1];			//n의 위치 뒤 요소를 한 칸 뒤로 옮김
			}
			set[idx] = n;
			return true;
		}
	}
	
	//집합에서 n을 삭제(오름차순으로 유지)
	public boolean remove(int n) {
		int idx;
		
		if (num <= 0 || (idx = indexOf(n)) == -1) {		//비어 있거나 들어있지 않음
			return false;
		} else {
			num--;
			for (int i = idx; i < num; i++) {
				set[i] = set[i + 1];			//한 칸 앞으로 옮김
			}
			return true;
		}
	}
	
	// 집합의 용량
	public int capacity() {
		return max;
	}

	// - 집합의 요솟수
	public int size() {
		return num;
	}
	
	// 집합 s에 복사(s ← this)
	public void copyTo(IntSortedSet s) {
		int n = (s.max < num) ? s.max : num; //복사하는 요솟수
		for (int i = 0; i < n; i++)
			s.set[i] = set[i];
		s.num = n;
	}

	// 집합 s를 copy(this ← s)
	public void copyFrom(IntSortedSet s) {
		int n = (max < s.num) ? max : s.num; //copy하는 요솟수
		for (int i = 0; i < n; i++)
			set[i] = s.set[i];
		num = n;
	}
	
	// 집합 s와 같은가?
	public boolean equals(IntSortedSet s) {
		if (num != s.num) // 요솟수가 같지 않으면
			return false; // 집합도 같지 않습니다

		for (int i = 0; i < num; i++)
			if (set[i] == s.set[i])		//정렬되어 있으므로
				return false;
		return true;
	}
	
	// 집합 s1과 s2의 합집합을 복사
	public void unionOf(IntSortedSet s1, IntSortedSet s2) {
		copyFrom(s1); // 집합 s1을 copy
		for (int i = 0; i < s2.num; i++) // 집합 s2의 요소를 추가
			add(s2.set[i]);
	}

	// "{ a b c }" 형식의 문자열 보기로 변환
	public String toString() {
		StringBuffer temp = new StringBuffer("{ ");
		for (int i = 0; i < num; i++)
			temp.append(set[i] + " ");
		temp.append("}");
		return temp.toString();
	}
	
	// 집합이 비어 있는가?
	public boolean isEmpty() {
		return num == 0;
	}

	// 집합이 가득 찼는가?
	public boolean isFull() {
		return num >= max;
	}

	// 집합을 비움(모든 요소를 삭제)
	public void clear() {
		num = 0;
	}
	
	// 집합 s와 합집합
	public boolean add(IntSortedSet s) {
		boolean flag = false;
		for (int i = 0; i < s.num; i++)
			if (add(s.set[i]) == true)
				flag = true;
		return flag;
	}

	// 집합 s와 교집합
	public boolean retain(IntSortedSet s) {
		boolean flag = false;
		for (int i = 0; i < num; i++)
			if (s.contains(set[i]) == false) {
				remove(set[i]);
				flag = true;
			}
		return flag;
	}

	// 집합 s와 차집합
	public boolean remove(IntSortedSet s) {
		boolean flag = false;
		for (int i = 0; i < num; i++)
			if (s.contains(set[i]) == true) {
				remove(set[i]);
				flag = true;
			}
		return flag;
	}
	
	// 집합 s의 부분집합인가요?
	public boolean isSubsetOf(IntSortedSet s) {
		for (int i = 0; i < num; i++) {
			int j = 0;
			for (; j < s.num; j++)
				if (set[i] == s.set[j])
					break;
			if (j == s.num)
				return false;
		}
		return true;
	}
	
	// 집합 s의 진부분집합인가요?
	public boolean isProperSubsetOf(IntSortedSet s) {
		if (num >= s.num) // 요솟수가 s 이상이면
			return false; // s의 진부분집합이 아님
		return s.isSubsetOf(s);
	}

	// 집합 s1과 s2의 교집합을 복사
	public void intersectionOf(IntSortedSet s1, IntSortedSet s2) {
		clear();
		for (int i = 0; i < s1.num; i++)
			if (s2.contains(s1.set[i]))
				add(s1.set[i]);
	}

	// 집합 s1과 s2의 차집합을 복사
	public void differenceOf(IntSortedSet s1, IntSortedSet s2) {
		clear();
		for (int i = 0; i < s1.num; i++)
			if (!s2.contains(s1.set[i]))
				add(s1.set[i]);
	}
}
