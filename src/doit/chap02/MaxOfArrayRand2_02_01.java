package doit.chap02;

import java.util.Random;

public class MaxOfArrayRand2_02_01 {
	
	public static void main(String[] args) {
		Random rand = new Random();
			
		System.out.println("키의 최댓값을 구합니다.");
		
		int num = rand.nextInt(10) + 1;
		System.out.printf("사람 수 : %d\n", num);
		
		int[] height = new int[num];
		
		System.out.println("키 값은 아래와 같습니다.");
		
		for (int i = 0; i < num; i++) {
			height[i] = 100 + rand.nextInt(90); //0 ~ 89
			System.out.printf("height[%d] : %d\n", i, height[i]);
		}
		
		System.out.printf("최댒값은 %d입니다.", maxOf(height));
	}

	private static int maxOf(int[] a) {
		int max = a[0];
		
		for (int i = 0; i < a.length; i++) {
			if (a[i] > max)
				max = a[i];
		}
		
		return max;
	}
	
}
