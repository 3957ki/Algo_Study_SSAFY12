package day1015;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class B_20165_3_인내의도미노장인호석 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine().trim());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());
		int map[][] = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine().trim());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int answer = 0;
		int dy[] = { 0, 0, 1, -1 };
		int dx[] = { 1, -1, 0, 0 };

		int tmpMap[][] = new int[N][M];
		for (int i = 0; i < R; i++) {
			st = new StringTokenizer(br.readLine().trim());
			int attackX = Integer.parseInt(st.nextToken()) - 1;
			int attackY = Integer.parseInt(st.nextToken()) - 1;
			char direct = st.nextToken().charAt(0);
			st = new StringTokenizer(br.readLine().trim());
			int defenseY = Integer.parseInt(st.nextToken()) - 1;
			int defenseX = Integer.parseInt(st.nextToken()) - 1;
			// input end

			// attack start
			int dir = 0;
			if (direct == 'E')
				dir = 0;
			else if (direct == 'W')
				dir = 1;
			else if (direct == 'S')
				dir = 2;
			else if (direct == 'N')
				dir = 3;

			Queue<int[]> queue = new ArrayDeque<>();
			queue.add(new int[] { attackX, attackY });

			while (!queue.isEmpty()) {
				int arr[] = queue.poll();
				int y = arr[0];
				int x = arr[1];
				if (tmpMap[y][x] != 0)
					continue;
				int size = map[y][x];
				tmpMap[y][x] = map[y][x];
				map[y][x] = 0;
				answer++;
				for (int d = 1; d < size; d++) {
					int ny = y + dy[dir] * d;
					int nx = x + dx[dir] * d;
					if (ny < 0 || nx < 0 || ny >= N || nx >= M)
						break;
					if (tmpMap[ny][nx] != 0) // 이미 넘어짐
						continue;
					queue.add(new int[] { ny, nx });
				}
			}
			// attack end
			// defense start
			if (tmpMap[defenseY][defenseX] == 0) // defense fail
				continue;
			else { // defense success
				map[defenseY][defenseX] = tmpMap[defenseY][defenseX];
				tmpMap[defenseY][defenseX] = 0;
			}
			// defense end
//			for (int a = 0; a < N; a++) {
//				for (int b = 0; b < M; b++)
//					System.out.print(map[a][b] + " ");
//				System.out.println();
//			}
//			for (int a = 0; a < N; a++) {
//				for (int b = 0; b < M; b++)
//					System.out.print(tmpMap[a][b] + " ");
//				System.out.println();
//			}
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] != 0) {
					sb.append('S').append(' ');
				} else if (map[i][j] == 0)
					sb.append('F').append(' ');
			}
			sb.append('\n');
		}
		sb.insert(0, '\n');
		sb.insert(0, answer);
		System.out.println(sb);
	}
}
