package day1001;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B_2705_2_팰린드롬파티션 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine().trim());

		int dp[] = new int[1001];

		dp[1] = 1; // 1
		dp[2] = 2; // 1+1, 2
		dp[3] = 2; // 1+1+1, 3
		dp[4] = dp[1] + dp[2] + 1;
		for (int i = 5; i < 1001; i++) {
			for (int j = 0; j < i - 1; j++) {
				if ((i - j) % 2 != 0)
					continue;
				dp[i] += dp[(i - j) / 2];
			}
			dp[i]++;
		}

		for (int i = 0; i < T; i++) {
			int N = Integer.parseInt(br.readLine().trim());
			sb.append(dp[N]).append("\n");
		}
		System.out.println(sb);
	}
}
