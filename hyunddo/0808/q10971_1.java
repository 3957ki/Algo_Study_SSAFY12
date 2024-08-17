package day0808;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class q10971_1 {
	static int N;
	static int answer = -1;
	static boolean visited[] = new boolean[10];
	static int cost[][] = new int[10][10];
	static int cur_cost = 0;

	static void dfs(int cur) {
		boolean flag = true;
		for (int i = 0; i < N; i++)
			if (!visited[i])
				flag = false;
		if (flag) {
			if (cost[cur][0] != 0) {
				int new_cost = cur_cost + cost[cur][0];
				if (answer == -1 || new_cost < answer)
					answer = new_cost;
			}
			return;
		}

		for (int next = 0; next < N; next++) {
			if (visited[next])
				continue;
			if (cost[cur][next] == 0)
				continue;

			visited[next] = true;
			cur_cost += cost[cur][next];

			dfs(next);

			visited[next] = false;
			cur_cost -= cost[cur][next];

		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				cost[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		visited[0] = true;
		dfs(0);
		System.out.println(answer);
	}
}
