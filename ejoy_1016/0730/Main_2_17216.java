package algo;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;


public class Main_2_17216 {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int A = sc.nextInt();
		
		int [] arr = new int[A+1];
		int [] dp = new int[A+1];
		
		for (int i = 1; i<=A; i++) {
			arr[i] = sc.nextInt();
			dp[i] = arr[i];
		}
		
		int maxNum = 1;
		for (int i = 1; i<=A; i++) {
			for (int j = 1; j < i; j++) {
				if (arr[i] < arr[j]) {
					dp[i] = Math.max(dp[i], dp[j] + arr[i]);
				}
			}
			maxNum = Math.max(maxNum, dp[i]);
		}
		
		System.out.println(maxNum);
		
		
	}
	
}
