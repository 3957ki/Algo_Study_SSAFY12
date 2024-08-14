import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class p3_2636 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[][] arr = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		Queue<Node> queue = new LinkedList<>();
		int[] dx = { 0, 0, 1, -1 };
		int[] dy = { 1, -1, 0, 0 };
//		날짜, 마지막 치즈 크기
		int day = 0;
		int lastSum = 0;
//		BFS
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
//				0이면 탐색
				if (arr[i][j] == 0) {
					int sum = 0;
					queue.add(new Node(i, j));
					boolean[][] visited = new boolean[N][M];
					visited[i][j] = true;
					while (!queue.isEmpty()) {
						Node node = queue.poll();
						for (int d = 0; d < 4; d++) {
							int X = node.x + dx[d];
							int Y = node.y + dy[d];
							if (Y < 0 || Y >= N || X < 0 || X >= M)
								continue;
//							바깥 치즈를 찾았을 때 0으로 바꾸고 방문표시
							if (!visited[Y][X] && arr[Y][X] == 1) {
								visited[Y][X] = true;
								arr[Y][X] = 0;
								sum++;
								continue;
							}

							if (!visited[Y][X] && arr[Y][X] == 0) {
								visited[Y][X] = true;
								queue.add(new Node(Y, X));
							}
						}
					}
//					찾은 치즈가 있다면 날짜 증가 후 치즈크기 저장
					if (sum > 0) {
						day++;
						lastSum = sum;
						continue;
					}
					System.out.println(day);
					System.out.println(lastSum);
					return;
				}
			}
		}
	}

	static class Node {
		int x, y;

		public Node(int y, int x) {
			this.x = x;
			this.y = y;
		}

	}
}
