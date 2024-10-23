import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int N, K;
	static int[][] arr;
	static int[][] dp;
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		dp = new int[N+1][K+1];
		for (int i = 0; i < N; i++) {
			Arrays.fill(dp[i], -1);			
		}

		arr = new int[N][2];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int W = Integer.parseInt(st.nextToken());
			int V = Integer.parseInt(st.nextToken());
			
			arr[i][0] = W;
			arr[i][1] = V;
		}
		System.out.println(Arrays.toString(dp));
		System.out.println(topdown(0, 0));
		System.out.println(Arrays.toString(dp));
		
	}
	
	public static int topdown(int cur, int sum) {
		if (sum > K) return Integer.MIN_VALUE;
		if (cur == N) return 0;
		if (dp[cur][sum] != -1) return dp[cur][sum];
		

		int a = topdown(cur + 1, sum + arr[cur][0]) + arr[cur][1];
		int b = topdown(cur + 1, sum);
		dp[cur][sum] = Math.max(a,  b);
		return dp[cur][sum];
	}
}
