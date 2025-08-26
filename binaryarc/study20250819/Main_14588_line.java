package study20250819;

import java.io.*;
import java.util.*;

public class Main_14588_line {
	static class Node {
		int n, l, r;

		public Node(int n, int l, int r) {
			this.n = n;
			this.l = l;
			this.r = r;
		}
	}

	static int N, Q;
	static Node[] nodes;
	static List<Node>[] graph;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		StringTokenizer st = null;
		nodes = new Node[N + 1];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int L = Integer.parseInt(st.nextToken());
			int R = Integer.parseInt(st.nextToken());
			nodes[i + 1] = new Node(i + 1, L, R);
		}

		graph = new ArrayList[N + 1];
		for (int i = 1; i <= N; i++) {
			graph[i] = new ArrayList<>();
		}

		for (int i = 1; i <= N; i++) {
			Node cur = nodes[i];
			for (int j = i + 1; j <= N; j++) {
				Node candidate = nodes[j];
				if (isFriend(cur, candidate)) {
					graph[i].add(candidate);
					graph[j].add(cur);
				}
				;
			}
		}

		int[][] ans = new int[N + 1][N + 1];
		for (int i = 0; i <= N; i++) {
			Arrays.fill(ans[i], -1);
		}

		

		for (int i = 1; i <= N; i++) {
			boolean[] visited = new boolean[N + 1];
			if (visited[i] || graph[i].isEmpty())
				continue;

			Queue<Node> q = new ArrayDeque<>();
			visited[i] = true;
			q.add(nodes[i]);
			int depth = 1;
			
			while(!q.isEmpty()) {
				int q_size = q.size();
				for (int s = 0; s < q_size; s++) {
					Node cur = q.poll();
					for (Node next : graph[cur.n]) {
						if (visited[next.n])
							continue;
						ans[i][next.n] = depth;
						ans[next.n][i] = depth;
						q.add(next);
						visited[next.n] = true;
					}
				}
				depth++;
			}
		}

		Q = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < Q; i++) {
			st = new StringTokenizer(br.readLine());
			int q1 = Integer.parseInt(st.nextToken());
			int q2 = Integer.parseInt(st.nextToken());
			sb.append(ans[q1][q2]).append("\n");
		}
		System.out.println(sb);
		
		
//		for(int i=1;i<=N;i++) {
//			System.out.println(Arrays.toString(ans[i]));
//		}

	}

	public static boolean isFriend(Node a, Node b) {
		int l1 = a.l;
		int r1 = a.r;
		int l2 = b.l;
		int r2 = b.r;

		if (l1 > r1) {
			int temp = l1;
			l1 = r1;
			r1 = temp;
		}

		if (l2 > r2) {
			int temp = l2;
			l2 = r2;
			r2 = temp;
		}

		return Math.max(l1, l2) <= Math.min(r1, r2);

	}
}
