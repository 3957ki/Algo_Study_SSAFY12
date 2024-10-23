package study1010;

import java.util.*;
import java.io.*;

public class b2_18353_병사배치하기 {
	static int N;
	static int[] arr;
	static int remain_cnt;
	static int del_cnt;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		arr = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		remain_cnt = 0;
		del_cnt = 0;
		dfs(0,0,10000001);
		System.out.println(del_cnt);
	}
	private static void dfs(int cnt, int cur_cnt,int cur_num) {
		
		if(cnt == N) {
			if(remain_cnt < cur_cnt) {
				remain_cnt = cur_cnt;
				del_cnt = N - cur_cnt - 1;
			}
			return;
		}
		
		if(arr[cnt] < cur_num) {
			dfs(cnt+1, cur_cnt + 1 ,arr[cnt]);
		}else {
			dfs(cnt+1, 1, arr[cnt]);
			dfs(cnt+1, cur_cnt, cur_num);
		}
	}
}
