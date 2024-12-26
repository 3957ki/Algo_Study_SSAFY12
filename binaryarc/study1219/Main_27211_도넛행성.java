package study1219;

import java.io.*;
import java.util.*;

public class Main_27211_도넛행성 {
	static int[][] map;
	static boolean[][] visited;
	static int cnt;
	static int N, M;
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		visited = new boolean[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		cnt = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == 0 && !visited[i][j]) {
					chk(i, j);
					cnt++;
				}
			}
		}
		System.out.println(cnt);
	}

	public static void chk(int i, int j) {
		Queue<int[]> q = new ArrayDeque<>();
		q.offer(new int[] { i, j });
		visited[i][j] = true;

		while (!q.isEmpty()) {
			int[] cur = q.poll();

			for (int d = 0; d < 4; d++) {
				int nr = cur[0] + dr[d];
				int nc = cur[1] + dc[d];
				if (nr < 0) {
					nr = N - 1;
				}
				if (nc < 0) {
					nc = M - 1;
				}
				if (nr >= N) {
					nr = 0;
				}
				if (nc >= M) {
					nc = 0;
				}
				if (visited[nr][nc] || map[nr][nc] == 1)
					continue;
				visited[nr][nc] = true;
				q.offer(new int[] { nr, nc });
			}
		}
	}
}
