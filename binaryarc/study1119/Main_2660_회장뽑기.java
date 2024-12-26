package study1119;

import java.io.*;
import java.util.*;

public class Main_2660_회장뽑기 {
	static int N;
	static List<Integer>[] graph;
	static List<Integer> ans;
	static int[] temp;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		graph = new ArrayList[N+1];
		for (int i = 1; i <= N; i++)
			graph[i] = new ArrayList<>();

		while (true) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			if (a == -1 && b == -1)
				break;
			graph[a].add(b);
			graph[b].add(a);
		}
		temp = new int[N+1];
		ans = new ArrayList<>();
		Arrays.fill(temp, Integer.MAX_VALUE);
		int res = Integer.MAX_VALUE;
		for (int i = 1; i <= N; i++) {
			res = Math.min(res, bfs(i, new boolean[N + 1]));
		}
		
		for(int i=1;i<=N;i++) {
			if(res == temp[i]) {
				ans.add(i);
			}
		}
		Collections.sort(ans);
		System.out.println(res+" "+ans.size());
		for(int n : ans)System.out.print(n+" ");

	}

	static int bfs(int start, boolean[] visited) {
		Queue<int[]> q = new ArrayDeque<>();
		visited[start] = true;
		int cnt = 1;
		for (int n : graph[start]) {
			q.add(new int[] { n, 1 });
			visited[n] = true;
			cnt++;
		}
		int res = 1;
		while (!q.isEmpty()) {
			int[] cur = q.poll();
			for (int next : graph[cur[0]]) {
				if (visited[next])
					continue;
				q.add(new int[] { next, cur[1] + 1 });
				visited[next] = true;
				res = Math.max(cur[1] + 1, res);
				cnt++;
			}
		}
		if (cnt == N)
		{
			temp[start] = res;
			return res;
		}else {
			return 0;
		}
	}
}
