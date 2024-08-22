package study0820;

import java.util.Arrays;
import java.util.Scanner;

/* 묶음으로 판매시 중앙값을 품질로 친다
 * 묶음이 짝수인경우 : (묶음 개수/2 + 1)번째 호반우를 중앙값 1 2 3 4 5 -> 1,5 묵으면 10에 판매
 * 홀수인경우 : (묶음 개수+1 / 2)번째 호반우를 중앙값 1 2 4 5 -> 1,3,5 묶으면 9에 판매
 * 어떻게 묶어야 최대의 이익이 되는지 계산
 */
public class b2_20117_호반우상인의이상한품질계산법 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(); // 호반우 개수
		
		int[] hoban = new int[N];
		for(int i=0;i<N;i++) {
			hoban[i] = sc.nextInt();
		}
		Arrays.sort(hoban);
		int sum=0;
		if(N%2 != 0) {
			sum+= hoban[(int)(N/2)];
		}
		int j = N-1;
		for(int i=0;i<N/2;i++) {
			sum += hoban[j]*2; 
			j--;
		}
		System.out.println(sum);
		
	}

}
