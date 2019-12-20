package doit.chap02;

public class PrimeNumber3 {

	//소수 구하기
	public static void main(String[] args) {
		int counter = 0;			//나눗셈의 횟수
		int ptr = 0;				//찾은 소수의 개수
		int[] prime = new int[500]; //소수를 저장하는 배열
		
		prime[ptr++] = 2; //2는 소수이므로 추가
		prime[ptr++] = 3; //3은 소수이므로 추가
		
		//정수 n이 n의 제곱근 이하의 어떤 소수로도 나누어떨어지지 않는다면 소수이다.
		//prime[i]가 n의 제곱근 이하인지 = prime[i]의 제곱이 n 이하인지
		
		//대상은 홀수만
		for (int n = 5; n <= 1000; n+=2) {
			boolean flag = false;
			
			for (int i = 1; prime[i] * prime[i] <= n; i++) {
				counter += 2;
				if (n % prime[i] == 0) {
					flag = true;
					break;
				}
			}
			
			//마지막까지 나누어떨어지지 않으면 소수이므로 배열에 저장
			if(!flag) {
				prime[ptr++] = n;
				counter++;
			}
		}
		
		for (int i = 0; i < ptr; i++) {
			System.out.println(prime[i]);
		}
		
		System.out.println("곱셈과 나눗셈을 수행한 횟수 : " + counter);
	}
}
