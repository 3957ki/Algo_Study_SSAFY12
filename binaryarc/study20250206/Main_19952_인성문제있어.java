package study20250206;

import java.io.*;
import java.util.*;

public class Main_19952_인성문제있어 {
	static int H, W, O, F, startR, startC, goalR, goalC;
	static int[][] map;
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int tc = 0; tc < T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			H = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			O = Integer.parseInt(st.nextToken());
			F = Integer.parseInt(st.nextToken());
			startR = Integer.parseInt(st.nextToken());
			startC = Integer.parseInt(st.nextToken());
			goalR = Integer.parseInt(st.nextToken());
			goalC = Integer.parseInt(st.nextToken());
			map = new int[H + 1][W + 1];
			for (int i = 0; i < O; i++) {
				st = new StringTokenizer(br.readLine());
				int y = Integer.parseInt(st.nextToken());
				int x = Integer.parseInt(st.nextToken());
				int L = Integer.parseInt(st.nextToken());
				map[y][x] = L;
			}

			Queue<int[]> q = new ArrayDeque<>();
			q.offer(new int[] { startR, startC, F });
			boolean[][][] visited = new boolean[F+1][H+1][W+1];

			boolean flag = false;
			while (!q.isEmpty()) {
				int[] cur = q.poll();
				int curX = cur[0];
				int curY = cur[1];
				int curF = cur[2];

				if (curX == goalR && curY == goalC) {
					flag = true;
					break;
				}
				
				if (curF <= 0)
					continue;
				
				for (int i = 0; i < 4; i++) {
					int nr = curX + dr[i];
					int nc = curY + dc[i];
					int nf = curF - 1;
					if (nr > H || nr < 1 || nc > W || nc < 1)
						continue;
					
					if(visited[nf][nr][nc])continue;
					
					if (map[nr][nc] > map[curX][curY]) {
						if(curF >= (map[nr][nc] - map[curX][curY])) {
							visited[nf][nr][nc] = true;
							q.offer(new int[] {nr,nc,nf});
						}
					}else {
						
						visited[nf][nr][nc] = true;
						q.offer(new int[] {nr,nc,nf});
					}

				}
			}

			System.out.println(!flag ? "인성 문제있어??" : "잘했어!!");

		}
	}
}
