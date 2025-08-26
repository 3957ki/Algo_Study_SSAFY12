package study20250708;

import java.io.*;
import java.util.*;

public class Main_28017_게임을클리어하자 {
	static int N, M;
	static int[][] wp;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		wp = new int[N + 1][M + 1];
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= M; j++) {
				wp[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int[][] dp = new int[N + 1][M + 1];

		for (int i = 1; i <= M; i++)
			dp[1][i] = wp[1][i];
		
		// 2회차 부터 i회차때 j번째 무기 골랐을 때의 최소값 dp 테이블채우기
		for (int i = 2; i <= N; i++) {
			for (int j = 1; j <= M; j++) {
				dp[i][j] = Integer.MAX_VALUE;
				for (int k = 1; k <= M; k++) {
					if(k == j)continue;
					dp[i][j] = Math.min(dp[i][j], dp[i-1][k] + wp[i][j]);
				}
			}
		}
		
		//마지막 최소값 구하기
		int ans = Integer.MAX_VALUE;
		for(int i=1;i<=M;i++) {
			ans = Math.min(ans, dp[N][i]);
		}
		System.out.println(ans);
		
	}
}
