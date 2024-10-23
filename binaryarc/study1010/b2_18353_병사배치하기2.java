package study1010;

import java.util.*;
import java.io.*;

public class b2_18353_병사배치하기2 {
	static int N;
	static int[] arr;
	static int[] dp;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		arr = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		
		if(N == 1) {
			System.out.println(0);
			System.exit(0);
		}
		
		dp = new int[N];
		Arrays.fill(dp, 1);
		int max = 0;
		
		for(int i = 1 ; i < N; i++) {
			for(int j = 0 ; j < i ; j++) {
				if(arr[i] < arr[j]) {
					dp[i] = Math.max(dp[i], dp[j] + 1);
				}
			}
		}
		
		for(int i=0;i<N;i++) {
			if(max < dp[i])max = dp[i];
		}
		
		System.out.println(N - max);
		
	}
}
