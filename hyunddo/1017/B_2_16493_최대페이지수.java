package day1017;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B_2_16493_최대페이지수 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine().trim());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		int day[] = new int[M];
		int page[] = new int[M];

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine().trim());
			day[i] = Integer.parseInt(st.nextToken());
			page[i] = Integer.parseInt(st.nextToken());
		}

		int dp[] = new int[N+1];
		for (int i = 0; i < M; i++) {
			for (int j = N; j >= day[i]; j--) {
				dp[j] = Math.max(dp[j], dp[j - day[i]] + page[i]);
			}
		}
		int answer = 0;
		for(int i = 1; i<=N; i++)
			answer = Math.max(answer, dp[i]);
		System.out.println(answer);
	}
}
