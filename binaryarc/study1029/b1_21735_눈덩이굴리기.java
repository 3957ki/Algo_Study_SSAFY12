package study1029;

import java.io.*;
import java.util.*;

public class b1_21735_눈덩이굴리기 {
	static int N, M;
	static int arr[];
	static long ans;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N + 10];
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		ans = 0;
		dfs(0,0,1);
		System.out.println(ans);
	}

	public static void dfs(int len, int cur_time, long cur_size) {
		if (len > N || cur_time == M) {
			ans = Math.max(ans, cur_size);
			return;
		}

		dfs(len + 2, cur_time + 1, (cur_size/2) + arr[len + 2]);
		dfs(len + 1, cur_time + 1, cur_size + arr[len + 1]);
	}

}
