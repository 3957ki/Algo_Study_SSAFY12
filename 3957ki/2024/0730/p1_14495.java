import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p1_14495 {
	static long[] dp;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		dp = new long[n + 3];
		dp[1] = 1;
		dp[2] = 1;
		dp[3] = 1;
		if (n <= 3) {
			System.out.println(1);
			return;
		}
		DP(n);
		System.out.println(dp[n]);
	}

	static void DP(int n) {
		for (int i = 4; i <= n; i++) {
			dp[i] = dp[i - 1] + dp[i - 3];
		}
	}
}
