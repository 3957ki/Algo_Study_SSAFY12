package study1219;

import java.io.*;
import java.util.*;

public class Main_16398_행성연결 {
	static int N;
	static ArrayList<int[]>[] graph;
	static long ans;
	static final int INF = Integer.MAX_VALUE;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		graph = new ArrayList[N];
		for (int i = 0; i < N; i++) {
			graph[i] = new ArrayList<>();
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				int cost = Integer.parseInt(st.nextToken());
				if (i != j) {
					graph[i].add(new int[] { j, cost });
				}
			}
		}
		ans = prim();
		System.out.println(ans);
	}

	public static long prim() {
		boolean[] visited = new boolean[N];
		long total = 0;
		Queue<int[]> pq = new PriorityQueue<>((o1, o2) -> Integer.compare(o1[1], o2[1]));
		pq.add(new int[] {0,0});
		
		while(!pq.isEmpty()) {
			int[] cur = pq.poll();
			int curNode = cur[0];
			if(visited[curNode])continue;
			visited[curNode] = true;
			total += cur[1];
			
			for(int[] next : graph[curNode]) {
				if(!visited[next[0]]) {
					pq.add(next);
				}
			}
		}
		return total;
	}
}
