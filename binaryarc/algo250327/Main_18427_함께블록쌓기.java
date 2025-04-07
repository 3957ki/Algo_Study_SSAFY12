package algo250327;

import java.io.*;
import java.util.*;

public class Main_18427_함께블록쌓기 {
	static int N, M, H;
	static List<Integer>[] list;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		list = new ArrayList[N + 1];
		for (int i = 1; i <= N; i++)
			list[i] = new ArrayList<>();
		int[][] dp = new int[N + 1][H + 1];
		dp[0][0] = 1;
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			while (st.hasMoreTokens()) {
				int input = Integer.parseInt(st.nextToken());
				list[i].add(input);
			}
			// 높이가 0인 건 다만들 수 있음
			dp[i][0] = 1;
		}

		for (int curMeber = 1; curMeber <= N; curMeber++) {
			for (int curHigh = 1; curHigh <= H; curHigh++) {
				for (int idx = 0; idx < list[curMeber].size(); idx++) {
					// 지금 선택한 블록으로 선택한 높이가 가능하다면
					if (curHigh >= list[curMeber].get(idx)) {
						dp[curMeber][curHigh] = (dp[curMeber][curHigh]
								// 전까지의 고려했던 경우의수 중에 현재 부족한 높이를 채울 수 있는 경우의수
								+ dp[curMeber - 1][curHigh - list[curMeber].get(idx)]) % 10007;
					}
				}
				// 현재 학생을 골랐을 때의 경우의수 + 고르지 않았을 때의 경우의수
				dp[curMeber][curHigh] = (dp[curMeber][curHigh] + dp[curMeber - 1][curHigh]) % 10007;
			}
		}

		System.out.println(dp[N][H]);

	}
}
