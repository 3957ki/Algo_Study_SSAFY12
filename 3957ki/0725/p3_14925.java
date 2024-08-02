import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p3_14925 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		int[][] arr = new int[M][N];
		int[][] dp = new int[M][N];
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if(i == 0 || j == 0) {
					if(arr[i][j] == 0) {
						dp[i][j] = 1;
					}
					else{
						dp[i][j] = 0;
					}
				}
			}
		}
		int answer = 0;
		if(M == 1 || N == 1) {
			for(int i = 0; i < M; i++) {
				for(int j = 0; j < N; j++) {
					if(dp[i][j] == 1) {
						System.out.println(1);
						return;
					}
				}
			}
			System.out.println(0);
			return;
		}
		
		for(int i = 1; i < M; i++) {
			for(int j = 1; j < N; j++) {
				if(arr[i][j] == 0) {
					dp[i][j] = Math.min(Math.min(dp[i-1][j], dp[i][j-1]), dp[i-1][j-1])+1;
					answer = Math.max(answer, dp[i][j]);
				}
			}
		}
		System.out.println(answer);
	}
}

