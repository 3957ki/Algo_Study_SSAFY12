package study20250115;

import java.io.*;
import java.util.*;

public class Main_3980_선발명단 {
	static List<int[]>[] list;
	static int ans;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int C = Integer.parseInt(br.readLine());
		StringTokenizer st;
		while (C-- != 0) {
			list = new ArrayList[12];
			for (int player = 1; player <= 11; player++) {
				list[player] = new ArrayList<>();
				st = new StringTokenizer(br.readLine());
				for (int position = 1; position <= 11; position++) {
					int stat = Integer.parseInt(st.nextToken());
					if (stat > 0) {
						list[player].add(new int[] { position, stat });
					}
				}
			}
			ans = 0;
			solve(1, 0, new boolean[12]);
			System.out.println(ans);
		}
	}

	public static void solve(int cnt, int cur_sum, boolean[] visited) {
		if (cnt == 12) {
			ans = Math.max(ans, cur_sum);
			return;
		}

		for (int[] info : list[cnt]) {
			int position = info[0];
			int stat = info[1];
			if (visited[position])
				continue;
			else {
				visited[position] = true;
				solve(cnt + 1, cur_sum + stat, visited);
				visited[position] = false;
			}
		}
	}
}
