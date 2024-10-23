package emptyJava;

import java.util.Scanner;


/*
 *	N이 짝수 일 때 dp(N/2) 와 같음..
 * 	N이 홀수 일 때, 중간에 값을 1..N까지 넣고, dp((N-i)/2) 의 값을 모두 합한 것 과 같음
 *  base : dp(1) = 1 , dp(2) = 2 
 */

public class prob2 {
	public static void main(String[] args) {
		//preprocess bottom-up
		int dp[] = new int[1001];
		
		dp[0] = 0; dp[1] = 1; dp[2] = 2;
		for(int i = 3;i <= 1000;i++) {
			if((i&1) == 0) {
				dp[i] = dp[i>>1]; //짝수개의 재귀적인 파티션
				for(int j = 2;j < i;j+=2) { //홀수개의 재귀적인 파티션
					//중간에 j를 배치
					dp[i] += dp[(i-j)>>1];
				}
			}
			else {
				for(int j = 1;j < i; j+=2) { //홀수개의 재귀적인 파티션
					//중간에 j를 배치
					dp[i] += dp[(i-j)>>1];
				}
			}
			dp[i]++; //N자기자신
		}
		
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int t = 1;t <= T;t++) {
			int N = sc.nextInt();
			System.out.println(dp[N]);
		}
	}
}
