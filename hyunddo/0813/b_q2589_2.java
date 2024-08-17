package day0813;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class b_q2589_2 {
	public static void main(String[] args) throws IOException {
		// 육지 L, 바다 W
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		char map[][] = new char[n][m];
		for (int i = 0; i < n; i++) {
			String str = br.readLine();
			for (int j = 0; j < m; j++) {
				map[i][j] = str.charAt(j);
			}
		}

		boolean visited[][] = new boolean[n][m];
		int checked[][] = new int[n][m];
		Queue<int[]> queue = new LinkedList<>();

		int y;
		int x;
		int di;
		int dj;

		int dy[] = { -1, 0, 1, 0 };
		int dx[] = { 0, 1, 0, -1 };

		int answer = 0;

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (map[i][j] == 'W')
					continue;
				visited = new boolean[n][m]; // visited 초기화
				checked = new int[n][m]; // checked 초기화
				if (map[i][j] == 'L' && visited[i][j] == false) { // 해당 인덱스의 값이 L일때마다 실행
					visited[i][j] = true;
					checked[i][j] = 0;
					queue.add(new int[] { i, j }); // 큐에 위치 push
					while (!queue.isEmpty()) { // 큐가 비어있지 않으면
						int index[] = queue.poll();
						y = index[0];
						x = index[1];
						for (int d = 0; d < 4; d++) {
							di = y + dy[d];
							dj = x + dx[d];
							if (di >= 0 && di < n && dj >= 0 && dj < m && visited[di][dj] == false
									&& map[di][dj] == 'L') {
								checked[di][dj] = checked[y][x] + 1;
								answer = Math.max(checked[di][dj], answer);
								visited[di][dj] = true;
								queue.add(new int[] { di, dj });
							}
						}
					}
				}
			}
		}
		System.out.println(answer);
	}
}