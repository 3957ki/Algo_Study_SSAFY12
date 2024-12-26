import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 캠프준비 {
	static int N, L, R, X, A[], ans;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken()); 
		R = Integer.parseInt(st.nextToken()); 
		X = Integer.parseInt(st.nextToken()); 

		A = new int[N];

		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}
		
		ans = 0;
		for(int i = 2; i <= N; i++) {
			dfs(0, 0, i, 0, Integer.MIN_VALUE, Integer.MAX_VALUE);
		}
		System.out.println(ans);
	}
	static void dfs(int cnt, int start, int C, int sum, int max, int min) {
		if(cnt == C) {
			if( (max-min)>=X && sum>=L && sum<=R) {
				ans++;
			}
			return;
		}

		for(int i = start; i < N; i++) {
			dfs(cnt+1, i+1, C, sum+A[i], Math.max(max, A[i]), Math.min(min, A[i]));
		}

	}
}
