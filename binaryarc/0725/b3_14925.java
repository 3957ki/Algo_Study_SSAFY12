package algostudy0725;

import java.io.*;
import java.util.*;
public class b3_14925 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		int[][] map = new int[M+1][N+1];
		int[][] dp = new int[M+1][N+1];
		for(int i=1;i<=M;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=1;j<=N;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int ans=0;
		for(int i=1;i<=M;i++) {
			for(int j=1;j<=N;j++) {
				if(map[i][j] > 0)continue;
				dp[i][j] = Math.min(dp[i-1][j], dp[i][j-1]);
				dp[i][j] = Math.min(dp[i][j], dp[i-1][j-1])+1;
//				System.out.println(dp[i][j]);
				
				ans = Math.max(ans, dp[i][j]);
			}
		}
		System.out.println(ans);
		
	}

}
