package study20250121;

import java.io.*;
import java.util.*;

public class Main_2411_아이템먹기 {
	static int N, M, A, B;
	static int[][] map;
	static int[] dr = { 1, 0 };
	static int[] dc = { 0, 1 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		A = Integer.parseInt(st.nextToken());
		B = Integer.parseInt(st.nextToken());

		map = new int[101][101];
		// 아이템 위치
		for (int i = 0; i < A; i++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			map[r][c] = 1;
		}

		// 장애물 위치
		for (int i = 0; i < B; i++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			map[r][c] = -1;
		}

		Queue<int[]> q = new ArrayDeque<>();
		q.add(new int[] { 1, 1, 0 });

		int ans = 0;
		while (!q.isEmpty()) {
			int cur[] = q.poll();
			int cur_r = cur[0];
			int cur_c = cur[1];
			int cur_cnt = cur[2];
			if (cur_cnt == A) {
				ans++;
				continue;
			}
			for (int d = 0; d < 2; d++) {
				int nr = cur_r + dr[d];
				int nc = cur_c + dc[d];
				if (nr <= 0 || nc <= 0 || nc >= 101 || nr >= 101)
					continue;
				if (map[nr][nc] == -1)
					continue;
				if (map[nr][nc] == 1) {
					q.offer(new int[] { nr, nc, cur_cnt + 1 });
				}else if(map[nr][nc] == 0) {
					q.offer(new int[] { nr, nc, cur_cnt});
				}
			}
		}
		System.out.println(ans);

	}
}
