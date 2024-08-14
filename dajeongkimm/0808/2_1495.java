import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int S = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[] arr = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i=0;i<N;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		boolean[][] dp = new boolean[N+1][M+1];
		
		dp[0][S] = true;
		for (int i=1;i<=N;i++) {
			int tmp = arr[i-1];
			for (int j=0;j<=M;j++) {
				if (dp[i-1][j]) {
					if (j+tmp<=M) {
						dp[i][j+tmp] = true;
					}
					if (j-tmp>=0) {
						dp[i][j-tmp] = true;
					}
					
				}
			}
		}
		int answer = -1;
		for (int i=0;i<=M;i++) {
			if (dp[N][i]) {
				if (answer<i) {
					answer = i;
				}
			}
		}
		
		System.out.println(answer);
	}

}
