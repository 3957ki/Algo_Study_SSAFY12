package study20250306;

import java.io.*;
import java.util.*;

public class Main_16168_퍼레이드 {
	static int V, E;
	static int[] parents;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());

		int[] degree = new int[V + 1];
		parents = new int[V + 1];
		Arrays.fill(parents, -1);

		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int v1 = Integer.parseInt(st.nextToken());
			int v2 = Integer.parseInt(st.nextToken());
			degree[v1]++;
			degree[v2]++;
			union(v1, v2);
		}

		int evenCnt = 0;
		int oddCnt = 0;
		int root = 1;
		boolean allConected = true;
		for (int i = 1; i <= V; i++) {
			if (degree[i] % 2 == 0)
				evenCnt++;
			else {
				oddCnt++;
			}
			if (find(i) != root) {
				allConected = false;
				break;
			}
		}

		if (allConected && (evenCnt == V || oddCnt == 2)) {
			System.out.println("YES");
		} else {
			System.out.println("NO");
		}
	}

	private static int find(int a) {
		if (parents[a] < 0)
			return a;
		return parents[a] = find(parents[a]);
	}

	private static void union(int a, int b) {
		int parentA = find(a);
		int parentB = find(b);

		if (parentA == parentB) {
			return;
		}

		if (parentA <= parentB) {
			parents[b] = parentA;
		} else {
			parents[a] = parentB;
		}
	}
}
