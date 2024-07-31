import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class p3_17141 {
	static int N, M;
	static int result = Integer.MAX_VALUE;
	static int[][] arr;
	static List<Node> virus = new ArrayList<>();
	static List<Node> temp_virus = new ArrayList<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N + 2][N + 2];
//		바이러스 후보를 바이러스 리스트에 추가하기
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if (arr[i][j] == 2) {
					virus.add(new Node(i, j));
				}
			}
		}
//		1로 패딩
		for (int i = 0; i < N + 2; i++) {
			arr[0][i] = 1;
			arr[i][0] = 1;
			arr[N + 1][i] = 1;
			arr[i][N + 1] = 1;
		}
//		바이러스 놓을 자리 탐색
		DFS(0, 1);
//		result 값이 변화가 없다면 조건을 만족하는 경우의 수가 없으므로 -1출력
		System.out.println(result == Integer.MAX_VALUE ? -1 : result);
	}

//	노드 클래스
	static class Node {
		int x;
		int y;

		Node(int y, int x) {
			this.y = y;
			this.x = x;
		}
	}

//	바이러스 위치 조합 DFS
	static void DFS(int start, int depth) {
//		바이러스 M개 조합을 만들었다면 BFS
		if (depth > M) {
			BFS(temp_virus);
			return;
		}
//		가능한 조합을 temp_virus 리스트에 저장
		for (int i = start; i < virus.size() - M + depth; i++) {
			temp_virus.add(virus.get(i));
			DFS(i + 1, depth + 1);
			temp_virus.remove(virus.get(i));
		}
	}

//	BFS
	static void BFS(List<Node> temp_virus) {
		Queue<Node> queue = new LinkedList<>();
		int[][] answer = new int[N + 2][N + 2];
		boolean[][] visited = new boolean[N + 2][N + 2];
		int[] dx = { 1, -1, 0, 0 };
		int[] dy = { 0, 0, 1, -1 };
//		바이러스 조합을 큐에 삽입하고 방문처리하기
		queue.addAll(temp_virus);
		for (Node node : temp_virus) {
			visited[node.y][node.x] = true;
		}
		while (!queue.isEmpty()) {
			Node node = queue.poll();
			int x = node.x;
			int y = node.y;
//			4방 탐색하여 큐에 삽입하고 탐색한 위치의 answer값을 기준위치의 answer값+1로 저장
			for (int d = 0; d < 4; d++) {
				if (!visited[y + dy[d]][x + dx[d]] && arr[y + dy[d]][x + dx[d]] != 1) {
					queue.add(new Node(y + dy[d], x + dx[d]));
					answer[y + dy[d]][x + dx[d]] = answer[y][x] + 1;
					visited[y + dy[d]][x + dx[d]] = true;
				}

			}
		}
//		가장 큰 answer값 저장
		int max = 0;
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
//				탐색하지 못한 빈 공간이 있다면 return
				if ((arr[i][j] == 0 || arr[i][j] == 2) && !visited[i][j]) {
					return;
				}
				max = Math.max(max, answer[i][j]);
			}
		}
//		가능한 조합 중 max값이 가장 작은 값으로 저장
		result = Math.min(result, max);
	}

}
