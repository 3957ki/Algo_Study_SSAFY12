import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class p2_13565 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[][] arr = new int[N + 2][M+2];

		for (int i = 0; i <= M + 1; i++) {
			arr[0][i] = 1;
			arr[N + 1][i] = 1;
		}

		for (int i = 0; i <= N + 1; i++) {
			arr[i][0] = 1;
			arr[i][M + 1] = 1;
		}
		for (int i = 1; i <= N; i++) {
			String s = new String(br.readLine());
			for (int j = 1; j <= M; j++) {
				arr[i][j] = Integer.parseInt(Character.toString(s.charAt(j - 1)));
			}
		}
		int[] dx = { 1, -1, 0, 0 };
		int[] dy = { 0, 0, 1, -1 };

		Queue<Node> queue = new LinkedList<>();

		for (int i = 1; i <= M; i++) {
			if (arr[1][i] == 0) {
				arr[1][i] = 1;
				queue.add(new Node(i, 1));
				while (!queue.isEmpty()) {
					Node node = queue.poll();
					int cx = node.x;
					int cy = node.y;
					
					if (cy == N) {
						System.out.println("YES");
						return;
					}
					for (int d = 0; d <= 3; d++) {
						if (arr[cy + dy[d]][cx + dx[d]] == 0) {
							queue.add(new Node(cx + dx[d], cy + dy[d]));
							arr[cy + dy[d]][cx + dx[d]] = 1;
						}
					}
				}
			}
		}
		System.out.println("NO");
	}

	static class Node {
		int x = 0;
		int y = 0;

		Node(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

}
