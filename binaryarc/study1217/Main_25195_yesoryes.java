package study1217;

import java.io.*;
import java.util.*;

public class Main_25195_yesoryes {
	static int N, M;
	static List<Integer>[] graph;
	static int S;
	static List<Integer> point;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		graph = new ArrayList[N + 1];
		for (int i = 1; i <= N; i++) {
			graph[i] = new ArrayList<>();
		}
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			graph[u].add(v);
		}

		point = new ArrayList<>();
		S = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < S; i++) {
			point.add(Integer.parseInt(st.nextToken()));
		}

		Queue<Integer> q = new ArrayDeque<>();
		if(!point.contains(1)) {
			q.offer(1);
		}
		
		
		while(!q.isEmpty()) {
			int cur = q.poll();
			
			if(graph[cur].size()==0) {
				System.out.println("yes");
				return;
			}
			
			for(int next : graph[cur]) {
				if(!point.contains(next)) {
					q.offer(next);
				}
			}
		}
		
		System.out.println("Yes");

	}
}
