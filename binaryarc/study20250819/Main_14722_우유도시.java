package study20250819;

import java.io.*;
import java.util.*;

public class Main_14722_우유도시 {
	static int N;
	static int[][] map;
	static int[][][] dp;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		dp = new int[3][N + 1][N + 1];
		int[] prevFavor = { 2, 0, 1 };

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				for (int k = 0; k < 3; k++) {
					// prev는 각맛의 직전 맛을 매핑
					int prev = prevFavor[k];
					
					// 현재칸에서 우유 안마실 경우
					// 직전칸의 값을 이어감
					int keep = 0;
					if(i > 0)keep = Math.max(keep, dp[k][i-1][j]);
					if(j > 0)keep = Math.max(keep, dp[k][i][j-1]);
					dp[k][i][j] = Math.max(dp[k][i][j], keep);
					
					// 현재칸에서 우유 마실 때
					// 직전칸의 직전맛의 값을 이어감
					int prevCnt = 0;
					if(i > 0)prevCnt = Math.max(prevCnt, dp[prev][i-1][j]);
					if(j > 0)prevCnt = Math.max(prevCnt, dp[prev][i][j-1]);
					
					if(map[i][j] == k) {
						//현재칸이 딸기맛이라면 
						if(k == 0) {
							// 새로 시작하거나, 이어가거나
							int start = 1;
							int extend = prevCnt + 1;
							dp[k][i][j] = Math.max(dp[k][i][j], Math.max(start,extend));
						}else if(prevCnt > 0) {
							//현재칸이 딸기맛이 아니라면 직전칸에서 이어 마시기
							dp[k][i][j] = Math.max(dp[k][i][j], prevCnt +1);
						}
					}
				}
			}
		}
		int ans = Math.max(dp[0][N-1][N-1],Math.max(dp[1][N-1][N-1],dp[2][N-1][N-1]));
		System.out.println(ans);
	}
}
