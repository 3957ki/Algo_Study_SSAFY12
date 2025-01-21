package study_20250102;

import java.io.*;
import java.util.*;

public class Main_20208_진우의민트초코우유 {

	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };
	static int N, M, H;
	static int[][] map;
	static int startR, startC;
	static List<int[]> milk;
	static int ans;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		map = new int[N][N];
		milk = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 1) {
					startR = i;
					startC = j;
				}
				if (map[i][j] == 2) {
					milk.add(new int[] { i, j });
				}
			}
		}
		ans = 0;
		solve(0,new int[milk.size()],new boolean[milk.size()]);
		System.out.println(ans);

	}

	public static void solve(int cnt, int[] point, boolean[] visited) {
		if (cnt == milk.size()) {
			simul(point);
			return;
		}

		for (int i = 0; i < milk.size(); i++) {
			if (visited[i])
				continue;
			visited[i] = true;
			point[cnt] = i;
			solve(cnt + 1, point, visited);
			visited[i] = false;
		}
	}

	public static void simul(int[] point) {
		int cur_cnt = 0;
		int cur_h = M;
		int cur_r = startR;
		int cur_c = startC;

		for (int idx : point) {

			
			int[] milk_pos = milk.get(idx);
			int nr = milk_pos[0];
			int nc = milk_pos[1];
			
			int next_len = Math.abs(nr - cur_r) + Math.abs(nc - cur_c);
			if (next_len <= cur_h) {
				cur_cnt++;
				cur_h += H - next_len;
				cur_r = nr;
				cur_c = nc;
			}
			
			int len = Math.abs(startR - cur_r) + Math.abs(startC - cur_c);
			if (len <= cur_h) {
				ans = Math.max(ans, cur_cnt);
			}

		}
	}
}
