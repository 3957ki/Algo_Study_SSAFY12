package study0730;


//백준 14495
//피보나치 비스무리한 수열
//dp


import java.util.*;
public class b1_14495 {
	 public static void main(String[] args) throws Exception{
		Scanner sc = new Scanner(System.in);
		int n= sc.nextInt();
		if(n<3) {
			System.out.println(1);
		}else {
			long[] dp = new long[n+1];
			
			dp[1] = 1;
			dp[2] = 1;
			dp[3] = 1;
			
			for(int i=4;i<=n;i++) {
				dp[i] = dp[i-1] + dp[i-3];
//				System.out.println(dp[i]);
			}
			System.out.println(dp[n]);
		}
		
		
	}
}
