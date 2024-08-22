package study0820;

import java.util.Arrays;
import java.util.Scanner;

/*
 * 난이도별 문제 N개
 * T일의 제출기간
 * 최소한의 벌금 내기
 */
public class b3_29704_벼락치기_dp {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int T = sc.nextInt();
		int[][] arr = new int[N+1][2];
		int[] dp = new int[1000+1];
		int cost=0;
		for(int i=0;i<N;i++) {
			arr[i+1][0] = sc.nextInt();
			arr[i+1][1] = sc.nextInt();
			//dp[시간] 에 저장된 값보다 크면 갱신
			if(dp[arr[i][0]] < arr[i][1])dp[arr[i][0]] = arr[i][1];
		}
		
		for(int i=1;i<=T;i++) {
			
		}
		//4일이주어지면 > 8000
		//3일주어지면 > 
		//2 5000
		//1 2000
		//1 1000
		//현재 문제난이도가 시간에 맞는다면
		//dp[i] = max(dp[i-1] + dp[i] ,dp[i-1] + 현재 난이도의 벌금);
		

		System.out.println(cost);
	}
}
