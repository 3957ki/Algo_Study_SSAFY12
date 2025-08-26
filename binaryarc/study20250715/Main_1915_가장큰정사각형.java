package study20250715;

import java.io.*;
import java.util.*;

public class Main_1915_가장큰정사각형 {
	static int n, m;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		int[][] dp = new int[n][m];
		int[][] grid = new int[n][m];
		for (int i = 0; i < n; i++) {
			char[] input = br.readLine().trim().toCharArray();
			for (int j = 0; j < m; j++) {
				grid[i][j] = input[j] -'0';
			}
		}

		int max = 0;
		// 첫번째 열 채우기
		for (int i = 0; i < n; i++) {
			dp[i][0] = grid[i][0];
			max = Math.max(max, dp[i][0]);
		}
		
		// 첫번째 행 채우기
		for (int j = 0; j < m; j++) {
			dp[0][j] = grid[0][j];
			max = Math.max(max, dp[0][j]);
		}
		
		
		// 나머지 행 열 채우기
		for (int i = 1; i < n; i++) {
			for (int j = 1; j < m; j++) {
				if(grid[i][j] == 1) {
					dp[i][j] = Math.min(
							Math.min(dp[i-1][j],dp[i][j-1]),dp[i-1][j-1]
							)+1;
					max = Math.max(max,dp[i][j]);
				}
			}
		}
		System.out.println(max * max);

	}
}
