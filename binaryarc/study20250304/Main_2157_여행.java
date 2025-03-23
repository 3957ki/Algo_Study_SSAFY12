package study20250304;

import java.io.*;
import java.util.*;

public class Main_2157_여행 {
	static int N, M, K;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		int[][] arr = new int[N + 1][N + 1];

		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			if (a < b) {
				arr[a][b] = Math.max(arr[a][b], c);
			}
		}

		int[][] dp = new int[N + 1][M + 1];
		for (int i = 0; i <= N; i++)
			Arrays.fill(dp[i], -1);

		dp[1][1] = 0;

		for (int r = 1; r < M; r++) { // r개의 도시를 거침
			for (int i = 1; i <= N; i++) { // 현재 도시
				if (dp[i][r] == -1) // i도시에 r개 경유로 올 수 없는 상태
					continue;

				int curScore = dp[i][r];

				for (int j = i + 1; j<= N; j++) { // 서쪽으로 이동
					if (arr[i][j] == 0)
						continue; // 항로가 없다면 스킵
					int newScore = curScore + arr[i][j];

					// 다음 도시의 dp 테이블 점수 갱신
					if (dp[j][r + 1] < newScore)
						dp[j][r + 1] = newScore;
				}
			}
		}

		int ans = -1;
		for (int i = 2; i <= M; i++) {
			// 꼭 M번을 안가도 최대값이 나올 수 있으니 최대값 찾기
			ans = Math.max(ans, dp[N][i]);
		}

		// 도달 불가능 0
		System.out.println(ans <= 0 ? 0 : ans);
	}
}
