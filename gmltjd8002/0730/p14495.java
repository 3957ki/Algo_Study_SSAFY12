package study0730;

import java.io.*;
import java.util.*;

public class p14495 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		long[] dp = new long[n]; // 1~116의 수를 저장할 배열
		
		if(n<3) {
			System.out.println(1);
			 // 초기값 -> 1
		}
		else {
			dp[0] = 1;
			dp[1] = 1;
			dp[2] = 1;
			for(int i=3;i<n;i++) { // 초기값 이후에 점화식을 이용해 반복
				dp[i] = dp[i-1] + dp[i-3];
			}
			System.out.println(dp[n-1]); // n번째 -> n-1번째 인덱스
		}
		
	}

}
