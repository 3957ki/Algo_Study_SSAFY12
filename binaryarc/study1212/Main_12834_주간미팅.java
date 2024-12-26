package study1212;

import java.io.*;
import java.util.*;

public class Main_12834_주간미팅 {

	static int N, V, E;
	static int kist, food;
	static List<Integer> homes;
	static List<int[]>[] edges;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		kist = Integer.parseInt(st.nextToken());
		food = Integer.parseInt(st.nextToken());

		homes = new ArrayList<>();
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			homes.add(Integer.parseInt(st.nextToken()));
		}

		edges = new ArrayList[V + 1];
		for (int i = 1; i <= V; i++)
			edges[i] = new ArrayList<>();

		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			edges[a].add(new int[] { b, cost });
			edges[b].add(new int[] { a, cost });
		}

		int sum = 0;
		for (int start : homes) {
			sum += (djik(start, kist) + djik(start, food));
		}
		System.out.println(sum);
	}

	public static int djik(int start, int end) {
		int[] minDist = new int[V + 1];
		Arrays.fill(minDist, 987654321);
		minDist[start] = 0;
		Queue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);
		pq.add(new int[] { start, 0 });

		while (!pq.isEmpty()) {
			int[] cur = pq.poll();
			int curNode = cur[0];
			int curCost = cur[1];

			if (minDist[curNode] < curCost)
				continue;
			if(curNode == end)break;

			for (int[] next : edges[curNode]) {
				int nextNode = next[0];
				int nextCost = next[1];
				if (minDist[nextNode] > (curCost + nextCost)) {
					minDist[nextNode] = curCost + nextCost;
					pq.add(new int[] { nextNode, minDist[nextNode] });
				}
			}
		}

		if (minDist[end] == 987654321)
			return -1;
		else
			return minDist[end];
	}
}
