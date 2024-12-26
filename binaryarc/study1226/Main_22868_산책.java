package study1226;

import java.io.*;
import java.util.*;

public class Main_22868_산책 {
	static int N, M;
	static int S, E;
	static List<Integer>[] graph;
	static boolean[] visited;
	static int ans;
	static int[] preVisited;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		graph = new ArrayList[N + 1];
		for (int i = 1; i <= N; i++)
			graph[i] = new ArrayList<>();

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			graph[a].add(b);
			graph[b].add(a);
		}

		st = new StringTokenizer(br.readLine());
		S = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		for (int i = 1; i <= N; i++) {
			Collections.sort(graph[i]);
		}
		visited = new boolean[N + 1];
		preVisited = new int[N+1]; // 지나온곳 표시
		ans = 0;
		bfs(S, E);
		
		Arrays.fill(visited, false);
		int v = preVisited[E];
		while(v>0) {
			visited[v]=true;
			v = preVisited[v];
		}
		bfs(S,E);
		System.out.println(ans);

	}

	public static void bfs(int start, int end) {
		Queue<int[]> dq = new ArrayDeque<>();
		dq.add(new int[] { start, 0 });
		visited[start] = true;
		while (!dq.isEmpty()) {
			int[] cur = dq.poll();
			int cur_node = cur[0];
			int cur_dist = cur[1];
			
			// 인접 정점 탐색
			for (int next : graph[cur_node]) {
				if (visited[next])
					continue;
				visited[next] = true;
				preVisited[next] = cur_node;
				dq.add(new int[] {next,cur_dist+1});
				
				// 다음정점이 목표정점일때
				if(next == end) {
					ans += cur_dist+1;
					return;
				}
			}
		}
	}
}
