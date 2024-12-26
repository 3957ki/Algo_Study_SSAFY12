package study1226;

import java.io.*;
import java.util.*;

public class Main_2410_2의멱수의합 {
	static int N;
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		int[] dp = new int[1000001];
		dp[1] = 1;
		dp[2] = 2;
		for(int i=3;i<=N;i++) {
			if(i%2==1)dp[i]=dp[i-1];
			else dp[i]=(dp[i-1]+dp[i/2])% 1000000000;
		}
		System.out.println(dp[N]);
	}
}
