package study20250121;

import java.io.*;
import java.util.*;

public class Main_14621_나만안되는연애 {
	static int N, M;
	static char[] types;
	static List<int[]>[] graph;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		types = new char[N + 1];

		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			types[i] = st.nextToken().charAt(0);
		}

		graph = new ArrayList[N + 1];
		for (int i = 1; i <= N; i++) {
			graph[i] = new ArrayList<>();
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			if (types[u] != types[v]) {
				graph[u].add(new int[] { v, d });
				graph[v].add(new int[] { u, d });
			}
		}
		System.out.println(getMinDist());

	}

	public static int getMinDist() {
		boolean[] visited = new boolean[N+1];
		Queue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);
		pq.add(new int[] { 1, 0 });
		int total = 0;
		int cnt = 0;
		while (!pq.isEmpty()) {
			int[] cur = pq.poll();
			int cur_node = cur[0];
			int cur_dist = cur[1];
			
			if(visited[cur_node]) continue;
			
			visited[cur_node] = true;
			total += cur_dist;
			cnt++;
			for (int[] next : graph[cur_node]) {
				int next_node = next[0];
				int next_dist = next[1];
				if(!visited[next_node]) {
					pq.add(new int[] {next_node,next_dist});
				}
			}
		}
		if(cnt == N) {
			return total;
		}else {
			return -1;
		}
	}
}
