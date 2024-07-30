package study0730;
//백준 17216
//가장 큰 감소 부분 수열
import java.io.*;
import java.util.*;

public class b2_17216 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		int[] nums = new int[N+1];
		int[] dp = new int[N+1];
		for(int i=1;i<=N;i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		int ans=0;
		for(int i=1;i<=N;i++) {
			dp[i] = nums[i];
			int idx = i;
			while(--idx>=0) {
				if(nums[i] < nums[idx]) {
					dp[i] = Math.max(dp[i],dp[idx] + nums[i]);
				}
			}
//			System.out.println(nums[i] +" : " +dp[i]);
			ans = Math.max(ans,dp[i]);
		}
		System.out.println(ans);
	}
}
