package study20250206;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_22115_창영이와커피 {
	static int N, K;
	static int[] arr;
	static int ans;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		arr = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		int[] dp = new int[K + 1];
		Arrays.fill(dp, Integer.MAX_VALUE);
		dp[0] = 0;

		for (int i = 0; i < N; i++) {
			for (int j = K; j >= 0; j--) {
				if (j - arr[i] >= 0 && dp[j - arr[i]] != Integer.MAX_VALUE) {
					dp[j] = Math.min(dp[j], dp[j - arr[i]] + 1);
				}
			}
		}

		System.out.println(dp[K] == Integer.MAX_VALUE ? -1 : dp[K]);

	}

}
