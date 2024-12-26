package study1031;

import java.io.*;
import java.util.*;

public class b3_17088_등차수열변환 {
	static int[] arr;
	static int N;
	static int ans;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		arr = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		ans = 0;
	}
	static void dfs(int idx,int cur_cal_cnt) {
		if(cur_cal_cnt >= ans)return;
		if(idx == N) {
			Math.min(ans , cur_cal_cnt);
			return;
		}
	}
}
