package study20250722;

import java.io.*;
import java.util.*;

public class Main_18430_무기공학 {
	static int N, M;
	static int[][] grid;
	static int ans;
	static int[][] dr = { { 0, 1 }, { -1, 0 }, { -1, 0 }, { 1, 0 } };
	static int[][] dc = { { -1, 0 }, { 0, -1 }, { 0, 1 }, { 0, 1 } };
	static boolean[][] visited;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		grid = new int[N][M];
		visited = new boolean[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				grid[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		ans = 0;
		dfs(0,0,0);
		System.out.println(ans);
	}

	public static void dfs(int r, int c, int curSum) {
		ans = Math.max(ans, curSum);

		if (c == M) {
			c = 0;
			r++;
		}
		if (r == N)
			return;

		if (!visited[r][c]) {
			for (int i = 0; i < 4; i++) {
				int nr = r + dr[i][0];
				int nc = c + dc[i][0];
				int nrr = r + dr[i][1];
				int ncc = c + dc[i][1];
				
				
				if(nr >= 0 && nr < N && nrr >= 0 && nrr < N 
						&& nc >= 0 && nc <M && ncc >= 0 && ncc < M) {
					if(visited[nr][nc] || visited[nrr][ncc])continue;
					visited[nr][nc] = true;
					visited[nrr][ncc] = true;
					visited[r][c] = true;
					dfs(r,c+1,curSum + (grid[r][c]*2) + grid[nr][nc] + grid[nrr][ncc]);
					visited[nr][nc] = false;
					visited[nrr][ncc] = false;
					visited[r][c] = false;
				}
			}
		}
		dfs(r,c+1,curSum);
	}
}
