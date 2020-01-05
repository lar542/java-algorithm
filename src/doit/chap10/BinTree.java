package doit.chap10;

import java.util.Comparator;

//이진검색트리
public class BinTree<K, V> {

	//노드
	static class Node<K, V> {
		private K key;				//키 값
		private V data;				//데이터
		private Node<K, V> left;	//왼쪽 자식 노드(왼쪽 포인터)
		private Node<K, V> right;	//오른쪽 자식 노드(오른쪽 포인터)
		
		Node(K key, V data, Node<K, V> left, Node<K, V> right) {
			this.key = key;
			this.data = data;
			this.left = left;
			this.right = right;
		}
		
		//키 값을 반환
		K getKey() {
			return key;
		}
		
		//데이터를 반환
		V getValue() {
			return data;
		}
		
		//데이터를 출력
		void print() {
			System.out.println(data);
		}
	}
	
	private Node<K, V> root;							//루트
	private Comparator<? super K> comparator = null;	//비교자
	
	//노드의 키 값을 비교할 때 자연 순서에 따라 비교
	//K의 타입이 Comparable 인터페이스를 구현하고 있는 Integer 클래스나 String 클래스 등에 알맞음
	public BinTree() {
		root = null;	//비어 있는 이진검색트리를 생성한다
	}
	
	//노드의 키 값을 비교할 때 전달받은 비교자로 비교
	public BinTree(Comparator<? super K> c) {
		this();
		comparator = c;
	}
	
	//두 키 값을 비교
	private int comp(K key1, K key2) {
		return (comparator == null) ? ((Comparable<K>) key1).compareTo(key2) : comparator.compare(key1, key1);
	}
	
	//키 값으로 검색
	//루트부터 시작해 현재 선택한 노드의 키 값과 목표하는 값을 비교하면서 왼쪽, 오른쪽으로 검색을 진행한다
	public V search(K key) {
		Node<K, V> p = root;		//루트에 주목
		
		while (true) {
			if (p == null) {		//더 이상 진행하지 않으면
				return null;		//검색 실패
			}
			int cond = comp(key, p.getKey());
			if (cond == 0) {
				return p.getValue();
			} else if (cond < 0) {
				p = p.left;
			} else {
				p = p.right;
			}
		}
	}
	
	//node를 루트로하는 서브 트리에 노드<k, V>를 삽입
	private void addNode(Node<K, V> node, K key, V data) {
		int cond = comp(key, node.getKey());
		if (cond == 0) {
			return;					//같은 key가 이진검색트리에 이미 있음
		} else if (cond < 0) {
			if (node.left == null) {
				node.left = new Node<K, V>(key, data, null, null);
			} else {
				addNode(node.left, key, data);		//왼쪽 서브 트리에 주목
			}
		} else {
			if (node.right == null) {
				node.right = new Node<K, V>(key, data, null, null);
			} else {
				addNode(node.right, key, data);		//오른쪽 서브 트리에 주목
			}
		}
	}
	
	//노드를 삽입
	public void add(K key, V data) {
		if (root == null) {
			root = new Node<K, V>(key, data, null, null);
		} else {
			addNode(root, key, data);
		}
	}
	
	//키 값이 key인 노드를 삭제
	public boolean remove(K key) {
		Node<K, V> p = root;			//스캔 중인 노드
		Node<K, V> parent = null;		//스캔 중인 노드의 부모 노드
		boolean isLeftChild = true;		//p는 부모의 왼쪽 자식 노드인가?
		
		//삭제할 키를 검색
		while (true) {
			if (p == null) {
				return false;
			}
			int cond = comp(key, p.getKey());
			if (cond == 0) {
				break;
			} else {
				parent = p;
				if (cond < 0) {
					isLeftChild = true;		//왼쪽 자식으로 내려감
					p = p.left;
				} else {
					isLeftChild = false;	//오른쪽 자식으로 내려감
					p = p.right;
				}
			}
		}
		
		if (p.left == null) {
			if (p == root) {
				root = p.right;
			} else if (isLeftChild) {
				parent.left = p.right;
			} else {
				parent.right = p.right;
			}
		} else if (p.right == null) {
			if (p == root) {
				root = p.left;
			} else if (isLeftChild) {
				parent.left = p.left;
			} else {
				parent.right = p.left;
			}
		} else {
			parent = p;
			Node<K, V> left = p.left;		//왼쪽 서브 트리에서 가장 큰 노드
			isLeftChild = true;
			while (left.right != null) {	//가장 큰 노드 left를 검색	
				parent = left;
				left = left.right;
				isLeftChild = false;
			}
			p.key = left.key;				//left의 키 값을 p로 옮김
			p.data = left.data;				//left의 데이터를 p로 옮김
			if (isLeftChild) {
				parent.left = left.left;
			} else {
				parent.right = left.left;
			}
		}
		return true;
	}
	
	//node를 루트로 하는 서브 트리의 노드를 키 값의 오름차순으로 출력(중위 순회)
	private void printSubTree(Node node) {
		if (node != null) {
			printSubTree(node.left);
			System.out.println(node.key + " " + node.data);
			printSubTree(node.right);
		}
	}
	
	//모든 노드를 키 값의 오름차순으로 출력
	public void print() {
		printSubTree(root);
	}
	
	//----------------------- 연습문제 10-1 --------------------------//
	//node를 뿌리로 하는 서브 트리의 노드를 키 값의 내림차순으로 출력
	private void printSubTreeR(Node node) {
		if (node != null) {
			printSubTreeR(node.right);
			System.out.println(node.key + " " + node.data);
			printSubTreeR(node.left);
		}
	}
	
	//모든 노드를 키 값의 내림차순으로 출력
	public void printReverse() {
		printSubTreeR(root);
	}
	
	//----------------------- 연습문제 10-2 --------------------------//
	//최소 key의 값을 갖는 노드를 반환
	private Node<K, V> getMinNode() {
		if (root == null) {
			return null;
		} else {
			Node<K, V> p = root;
			
			while (p.left != null) {
				p = p.left;
			}
			return p;
		}
	}
	
	//최대 key의 값을 갖는 노드를 반환
	private Node<K, V> getMaxNode() {
		if (root == null) {
			return null;
		} else {
			Node<K, V> p = root;
			
			while (p.right != null) {
				p = p.right;
			}
			return p;
		}
	}
	
	//가장 작은 키 값을 반환
	public K getMinKey() {
		Node<K, V> minNode = getMinNode();
		return minNode == null ? null : minNode.getKey();
	}
	
	//가장 작은 키 값을 갖는 노드의 데이터를 반환
	public V getDataWithMinKey() {
		Node<K, V> minNode = getMinNode();
		return minNode == null ? null : minNode.getValue();
	}
	
	//가장 큰 키 값을 반환
	public K getMaxKey() {
		Node<K, V> maxNode = getMaxNode();
		return maxNode == null ? null : maxNode.getKey();
	}
	
	//가장 큰 키 값을 갖는 노드의 데이터를 반환
	public V getDataWithMaxKey() {
		Node<K, V> maxNode = getMaxNode();
		return maxNode == null ? null : maxNode.getValue();
	}
}
