package doit.chap02;

public class PrimeNumber2 {

	//소수 구하기
	public static void main(String[] args) {
		int counter = 0;			//나눗셈의 횟수
		int ptr = 0;				//찾은 소수의 개수
		int[] prime = new int[500]; //소수를 저장하는 배열
		
		prime[ptr++] = 2; //2는 소수이므로 추가
		
		//대상은 홀수만, 4 이상의 짝수는 2로 나누어 떨어지므로 소수가 아니기 때문
		for (int n = 3; n <= 1000; n+=2) { 
			
			int i; //1부터 시작. 판단 대상인 n이 홀수이므로
			for (i = 1; i < ptr; i++) {
				counter++;
				if(n % prime[i] == 0) {
					break;
				}
			}
			if(ptr == i) { //안쪽 for문이 중단되면 소수가 아님 = i는 ptr보다 작음
				prime[ptr++] = n;
			}
		}
		
		for (int i = 0; i < ptr; i++) {
			System.out.println(prime[i]);
		}
		System.out.println("나눗셈을 수행한 횟수 : " + counter);
	}
}
