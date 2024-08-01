package personal_space;
//백준 2579 계단 오르기
import java.io.*;
import java.util.*;
public class b_2579 {
	public static void main(String[] args) throws Exception{
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] nums = new int[N];
		for(int i=0;i<N;i++) {
			nums[i] = sc.nextInt();
		}
		int[] dp = new int[N];
		if(N>=3) {
			dp[0] = nums[0];
			dp[1] = nums[0] + nums[1];
			dp[2] = Math.max(nums[1] + nums[2], nums[0] + nums[2]);
			for(int i=3;i<N;i++) {
				dp[i] = Math.max(dp[i-3] + nums[i-1] + nums[i], dp[i-2] + nums[i]);
			}
			System.out.println(dp[N-1]);
		}else {
			if(N == 1)System.out.println(nums[0]);
			else if(N==2)System.out.println((nums[0] + nums[1]));
			else System.out.println( Math.max(nums[1] + nums[2], nums[0] + nums[2]));
		}
		
		
	}
}
