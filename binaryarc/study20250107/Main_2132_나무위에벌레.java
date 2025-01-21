package study20250107;

import java.io.*;
import java.util.*;

public class Main_2132_나무위에벌레 {
	static int n;
	static int[] apples;
	static List<Integer>[] graph;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		apples = new int[n + 1];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= n; i++) {
			apples[i] = Integer.parseInt(st.nextToken());
		}

		graph = new ArrayList[n + 1];
		for (int i = 1; i <= n; i++)
			graph[i] = new ArrayList<>();

		for (int i = 0; i < n - 1; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			graph[a].add(b);
			graph[b].add(a);
		}

		int maxNum = 0;
		List<Integer> ansVertex = new ArrayList<>();
		for (int i = 1; i <= n; i++) {
			int res = chk(i, new boolean[n + 1]);
			if (maxNum < res) {
				ansVertex = new ArrayList<>();
				ansVertex.add(i);
				maxNum = res;
			} else if (maxNum == res) {
				ansVertex.add(i);
			}
		}
		Collections.sort(ansVertex);
		System.out.println(maxNum + " " + ansVertex.get(0));
	}

	public static int chk(int start, boolean[] visited) {
		Queue<int[]> q = new ArrayDeque<>();
		q.offer(new int[] { start, apples[start] });
		visited[start] = true;
		int max = 0;
		while (!q.isEmpty()) {
			int[] cur = q.poll();
			if (max < cur[1]) {
				max = cur[1];
			}
			for (int next : graph[cur[0]]) {
				if (visited[next])
					continue;
				q.offer(new int[] { next, cur[1] + apples[next] });
				visited[next] = true;
			}
		}
		return max;
	}
}
