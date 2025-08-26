package study20250812;

import java.io.*;
import java.util.*;

public class Main_2651_자동차경주대회 {
	static int maxDist;
	static int N;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		maxDist = Integer.parseInt(br.readLine());
		N = Integer.parseInt(br.readLine());

		long[] dist = new long[N + 2];
		long[] time = new long[N + 2];
		int[] prev = new int[N + 2];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N + 1; i++) {
			dist[i] = Long.parseLong(st.nextToken()) + dist[i-1];
		}

		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			time[i] = Long.parseLong(st.nextToken());
		}

		long[] dp = new long[N + 2];
		
		for(int i=1;i<=N+1;i++) {
			dp[i] = Long.MAX_VALUE;
		}
		
		
		for (int i = 1; i <= N + 1; i++) {
			for (int j = i - 1; j >= 0; j--) {
				if(dist[i] - dist[j] > maxDist)break;
				if(dp[j] != Long.MAX_VALUE && dp[i] > dp[j] + time[j]) {
					dp[i] = dp[j] + time[j];
					prev[i] = j;
				}
			}
		}
		
		System.out.println(dp[N+1]);
		List<Integer> picks = new ArrayList<>();
		int cur = N + 1;
		while (prev[cur] != 0) {
		    picks.add(prev[cur]);
		    cur = prev[cur];
		}
		Collections.reverse(picks);

		System.out.println(picks.size());
		if (!picks.isEmpty()) {
		    StringBuilder sb = new StringBuilder();
		    for (int i = 0; i < picks.size(); i++) {
		        if (i > 0) sb.append(' ');
		        sb.append(picks.get(i));
		    }
		    System.out.println(sb.toString());
		}

	}
}
