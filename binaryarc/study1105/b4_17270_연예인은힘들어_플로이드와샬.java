package study1105;

import java.io.*;
import java.util.*;

public class b4_17270_연예인은힘들어_플로이드와샬 {
	static int V, E;
	static int[][] graph;
	static int[] minDist_a;
	static int[] minDist_b;
	static int start, end;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		graph = new int[V + 1][V + 1];
		for (int i = 1; i <= V; i++)
			Arrays.fill(graph[i], Integer.MAX_VALUE);

		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			graph[a][b] = Math.min(graph[a][b], cost);
			graph[b][a] = Math.min(graph[b][a], cost);

		}
		st = new StringTokenizer(br.readLine());
		start = Integer.parseInt(st.nextToken());
		end = Integer.parseInt(st.nextToken());
		minDist_a = new int[V + 1];
		minDist_b = new int[V + 1];
		Arrays.fill(minDist_a, Integer.MAX_VALUE);
		Arrays.fill(minDist_b, Integer.MAX_VALUE);
		djk(start, end, minDist_a);
		djk(end, start, minDist_b);

		int res = -1;
		int time = Integer.MAX_VALUE;
		int temp = Integer.MAX_VALUE;
		for (int i = 1; i <= V; i++) {
			if (i == start || i == end || minDist_a[i] == Integer.MAX_VALUE || minDist_b[i] == Integer.MAX_VALUE)
				continue;
			// 조건: 지헌의 최단 거리 합이 성하보다 작거나 같고, 최단 거리의 합이 최소
			if (minDist_a[i] <= minDist_b[i] && time > (minDist_a[i] + minDist_b[i]) && temp > minDist_a[i]) {
				time = (minDist_a[i] + minDist_b[i]);
				temp = minDist_a[i];
				res = i;
			} 
		}

		System.out.println(res);
	}

	static void djk(int start, int end, int[] minDist) {
		minDist[start] = 0;
		PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o[1]));
		pq.offer(new int[] { start, 0 });

		while (!pq.isEmpty()) {
			int[] cur = pq.poll();
			if (cur[0] == end)
				return;
			int curNode = cur[0];
			int curDist = cur[1];

			if (curDist > minDist[curNode])
				continue;

			for (int to = 1; to <= V; to++) {
				if (graph[curNode][to] != Integer.MAX_VALUE) {
					int cost = graph[curNode][to];
					if (minDist[to] > minDist[curNode] + cost) {
						minDist[to] = minDist[curNode] + cost;
						pq.offer(new int[] { to, minDist[to] });
					}
				}
			}
		}
	}
}
