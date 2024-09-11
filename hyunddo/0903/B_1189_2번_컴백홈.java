package day0903;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/* 
 * dfs 가 아닐 까나~~요
 * 왼쪽 아래에서부터
 * 감 ?
 */

public class B_1189_2번_컴백홈 {

	static int N, M, K;
	static char map[][];
	static int answer;
	static boolean visited[][];
	static int dy[] = { -1, 0, 1, 0 };
	static int dx[] = { 0, 1, 0, -1 };

	static void dfs(int y, int x, int depth) {
		if (y == 0 && x == M - 1) {
//			for (int i = 0; i < N; i++) {
//				for (int j = 0; j < M; j++) {
//					System.out.print(visited[i][j] + " ");
//				}
//				System.out.println();
//			}
//			System.out.println(depth);
			if (depth == K)
				answer++;
			return;
		}

		if (depth > K)
			return;

		for (int d = 0; d < 4; d++) {
			int ny = y + dy[d];
			int nx = x + dx[d];
			if (ny < 0 || ny >= N || nx < 0 || nx >= M)
				continue;
			if (visited[ny][nx] || map[ny][nx] == 'T')
				continue;
			visited[ny][nx] = true;
			dfs(ny, nx, depth + 1);
			visited[ny][nx] = false;
		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine().trim());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		map = new char[N][M];
		for (int i = 0; i < N; i++) {
			String str = br.readLine().trim();
			for (int j = 0; j < M; j++) {
				map[i][j] = str.charAt(j);
			}
		}
		// input end

		answer = 0;
		visited = new boolean[N][M];
		visited[N - 1][0] = true; // 출발점

		dfs(N - 1, 0, 1);

		System.out.println(answer);

	}
}
