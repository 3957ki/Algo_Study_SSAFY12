package study20250115;

import java.io.*;
import java.util.*;

public class Main_9694_무엇을아느냐 {
	static int N, M;
	static List<int[]>[] graph;
	static Deque<Integer>[] path;
	static StringBuilder sb;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st = null;
		sb = new StringBuilder();
		for(int tc=1;tc<=T;tc++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			graph = new ArrayList[M];
			path = new ArrayDeque[M];
			for (int i = 0; i < M; i++) {
				graph[i] = new ArrayList<>();
				path[i] = new ArrayDeque<>();
			}
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				int z = Integer.parseInt(st.nextToken());
				graph[x].add(new int[] { y, z });
				graph[y].add(new int[] { x, z });
			}
			getMinDist(0, M - 1, tc);
		}
		System.out.println(sb);
	}

	public static void getMinDist(int start, int end, int tc) {
		int[] dist = new int[M];
		int[] parent = new int[M]; // 이전 노드 저장
        Arrays.fill(dist, Integer.MAX_VALUE);
        Arrays.fill(parent, -1);

		Queue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);
		pq.add(new int[] { start, 0 });
		dist[start] = 0;
		
		while (!pq.isEmpty()) {
			int[] cur = pq.poll();
            int curNode = cur[0];
            int curDist = cur[1];

            if (curDist > dist[curNode]) continue;
			
			
            for (int[] next : graph[curNode]) {
                int nextNode = next[0];
                int nextCost = curDist + next[1];
                if (dist[nextNode] > nextCost) {
                    dist[nextNode] = nextCost;
                    parent[nextNode] = curNode; // 이전 노드 기록
                    pq.add(new int[] { nextNode, nextCost });
                }
            }

		}
		
		if (dist[end] == Integer.MAX_VALUE) {
            sb.append("Case #").append(tc).append(": ").append(-1).append("\n");
        } else {
            List<Integer> resultPath = new ArrayList<>();
            for (int cur = end; cur != -1; cur = parent[cur]) {
                resultPath.add(cur);
            }
            Collections.reverse(resultPath);
            sb.append("Case #").append(tc).append(": ");
            for (int node : resultPath) {
                sb.append(node).append(" ");
            }
            sb.append("\n");
        }

	}
}
