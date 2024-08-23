package algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 백준_벼락치기 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int T = Integer.parseInt(st.nextToken());
		
		int[] days = new int[N];
		int[] costs = new int[N];
		
		int total = 0;
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			days[i] = Integer.parseInt(st.nextToken());
			costs[i] = Integer.parseInt(st.nextToken());
			total += costs[i];
		}
		int[] dp = new int[T+1];
		
		for(int i = 0; i < N; i++) {
			int day = days[i];
			int cost = costs[i];
			for(int j = T; j >= 0; j--) {
				if(day <= j) {
					dp[j] = Math.max(dp[j], dp[j-day]+cost);
				}
			}
		}
		System.out.println(total-dp[T]);
	}
}
