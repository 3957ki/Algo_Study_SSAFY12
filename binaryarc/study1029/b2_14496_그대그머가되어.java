package study1029;

import java.io.*;
import java.util.*;

public class b2_14496_그대그머가되어 {
	static int N, M;
	static int a, b;
	static List<Integer>[] graph;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		a = Integer.parseInt(st.nextToken()); // start
		b = Integer.parseInt(st.nextToken()); // goal
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		graph = new ArrayList[N + 1];
		for (int i = 1; i <= N; i++) {
			graph[i] = new ArrayList<>();
		}
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int c = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			graph[c].add(d);
			graph[d].add(c);
		}
		
		
		boolean[] visited = new boolean[N+1];
		Queue<Integer> q = new ArrayDeque<>();
		q.add(a);
		visited[a] = true;
		int cnt = 0;
		while(!q.isEmpty()) {
			int q_size = q.size();
			for(int i=0;i<q_size;i++) {
				int cur = q.poll();
				if(cur == b) {
					System.out.println(cnt);
					return;
				}
				for(int next : graph[cur]) {
					if(visited[next])continue;
					q.add(next);
					visited[next] = true;
				}
			}
			cnt++;
		}
		
		System.out.println(-1);
	}
}
