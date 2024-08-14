import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_1_14495 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		long[] dp = new long[n+1];
		switch (n){
		case 3:
			dp[3] = 1;
		case 2:
			dp[2] = 1;
		case 1:
			dp[1] = 1;
			break;
		default :
			dp[3] = dp[2] = dp[1] = 1;
			for(int i = 4; i <= n; i++) {
				dp[i] = dp[i-1] + dp[i-3];
			}
		}
		
		System.out.println(dp[n]);
		
	}

}
