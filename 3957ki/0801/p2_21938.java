import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class p2_21938 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[][] arr = new int[N + 2][M + 2];
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= M; j++) {
//				RGB 평균값 넣기
				int R = Integer.parseInt(st.nextToken());
				int G = Integer.parseInt(st.nextToken());
				int B = Integer.parseInt(st.nextToken());
				arr[i][j] = (R + G + B) / 3;
			}
		}
		int T = Integer.parseInt(br.readLine());
//		T를 기준으로 1이나 0 넣기
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= M; j++) {
				arr[i][j] = (arr[i][j] >= T) ? 1 : 0;
			}
		}
//		BFS
		Queue<Node> queue = new LinkedList<>();
		boolean[][] visited = new boolean[N + 2][M + 2];
		int[] dx = { 1, -1, 0, 0 };
		int[] dy = { 0, 0, 1, -1 };
		int answer = 0;
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= M; j++) {
				if (!visited[i][j] && arr[i][j] == 1) {
//					새로운 개체 찾으면 +1
					answer++;
					queue.add(new Node(i, j));
					visited[i][j] = true;
					while (!queue.isEmpty()) {
						Node node = queue.poll();
						int x = node.x;
						int y = node.y;
						for (int d = 0; d < 4; d++) {
							if (!visited[y + dy[d]][x + dx[d]] && arr[y + dy[d]][x + dx[d]] == 1) {
								queue.add(new Node(y + dy[d], x + dx[d]));
								visited[y + dy[d]][x + dx[d]] = true;
							}
						}
					}
				}
			}
		}
		System.out.println(answer);

	}

	static class Node {
		int x, y;

		public Node(int y, int x) {
			this.x = x;
			this.y = y;
		}

	}
}
