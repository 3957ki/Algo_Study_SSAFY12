import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
/*
 * 메모리 : kb
 * 시간 : ms
 * 전략
 * 
 */
public class 최대페이지수 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());	//남은 기간
		int M = Integer.parseInt(st.nextToken());	//챕터의 수
		
		int dp[] = new int[N+1];
		int input[][] = new int[M][2];
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			input[i][0] = Integer.parseInt(st.nextToken());
			input[i][1] = Integer.parseInt(st.nextToken());
		}
		
		for(int i = 0; i < M; i++) {
			for(int j = N; j >= 0; j--) {
				if(j-input[i][0] < 0) break;
				dp[j] = Math.max(dp[j], dp[j-input[i][0]] + input[i][1]);
			}
		}
		System.out.println(dp[N]);
	}
}
