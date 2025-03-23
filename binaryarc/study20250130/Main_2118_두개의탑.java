package study20250130;

import java.io.*;
import java.util.*;

public class Main_2118_두개의탑 {
	static int N;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		int[] sum = new int[N + 1];
		int[] arr = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
			sum[i] = sum[i - 1] + arr[i];
		}
		int ans = 0;
		for (int i = 1; i <= N / 2 + 1; i++) {
			for (int j = i+1; j <= N; j++) {
				ans = Math.max(ans, Math.min(sum[j - 1] - sum[i - 1], sum[N] - sum[j - 1] + sum[i - 1]));
			}
		}
		System.out.println(ans);
	}
}
