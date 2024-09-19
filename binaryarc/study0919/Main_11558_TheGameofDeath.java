package study0919;

import java.io.*;
import java.util.*;

public class Main_11558_TheGameofDeath {
	static int T,N;
	static int[] arr;
	static boolean[] visited;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		T = Integer.parseInt(st.nextToken());
		while(--T >= 0) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			
			arr = new int[N+1];
			visited = new boolean[N+1];
			
			for(int i=1;i<=N;i++) {
				st = new StringTokenizer(br.readLine());
				arr[i] = Integer.parseInt(st.nextToken());
			}
			
			boolean find = false;
			int count = 0;
			int cur = 1;
			while(true) {
				int next = arr[cur];
				if(visited[next])break;
				if(next == N) {
					find = true;
					count++;
					break;
				}else {
					count++;
					visited[cur] = true;
					cur = next;
				}
			}
			if(find) {
				System.out.println(count);
			}else {
				System.out.println(0);
			}
			
			
		}
	}
}
