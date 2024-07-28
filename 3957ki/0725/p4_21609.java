import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class p4_21609 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

//		격자 생성
		int[][] arr = new int[N + 2][N + 2];
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
//		테두리 -1로 패딩
		for (int i = 0; i < N + 2; i++) {
			arr[0][i] = -1;
			arr[N + 1][i] = -1;
			arr[i][0] = -1;
			arr[i][N + 1] = -1;
		}

		Queue<Node> queue = new LinkedList<>();
		boolean[][] visited = new boolean[N + 2][N + 2];
		int[] dx = { -1, 1, 0, 0 };
		int[] dy = { 0, 0, 1, -1 };
		int answer = 0;

//		게임 시작
		while (true) {
			int maxBlockSize = 0;
			int maxRainbowCnt = 0;
			int maxColor = 0;
			Node maxNode = new Node(0, 0);

//			기준블럭 탐색
			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= N; j++) {
//					일반 블럭이 아니거나 이미 방문한 일반블럭이면 패스
					if (visited[i][j] || arr[i][j] <= 0) {
						continue;
					}
//					큐 방문배열
					boolean[][] Qvisited = new boolean[N + 2][N + 2];
					Node standardNode = new Node(i, j); // 기준노드
					int color = arr[i][j]; // 색깔
					int blockSize = 1; // 블럭 크기
					int rainbowCnt = 0; // 무지개 블럭 개수
					
//					큐에 기준블럭 삽입하고 BFS 시작
					queue.add(standardNode);
					Qvisited[i][j] = true;
					visited[i][j] = true;
					while (!queue.isEmpty()) {
						Node node = queue.poll();
						int x = node.x;
						int y = node.y;
						for (int d = 0; d < 4; d++) {
//							방문하지 않았고, 무지개이거나 같은색깔 블럭이면 삽입
							if (!Qvisited[y + dy[d]][x + dx[d]]
									&& (arr[y + dy[d]][x + dx[d]] == 0 || arr[y + dy[d]][x + dx[d]] == color)) {
								queue.add(new Node(y + dy[d], x + dx[d]));
								Qvisited[y + dy[d]][x + dx[d]] = true;
								blockSize++;
//								무지개 블럭 개수 카운트
								if (arr[y + dy[d]][x + dx[d]] == 0) {
									rainbowCnt++;
								}
//								일반 블럭 방문표시
								else {
									visited[y + dy[d]][x + dx[d]] = true;
								}
							}
						}
					}
//					max그룹과 비교 후 업데이트
					if (maxBlockSize < blockSize) {
						maxBlockSize = blockSize;
						maxRainbowCnt = rainbowCnt;
						maxNode = standardNode;
						maxColor = color;
					} else if (maxBlockSize == blockSize) {
						if (maxRainbowCnt <= rainbowCnt) {
							maxBlockSize = blockSize;
							maxRainbowCnt = rainbowCnt;
							maxNode = standardNode;
							maxColor = color;
						}
					}
				}
			}
//			max그룹의 블럭 크기가 2보다 작으면 끝내기
			if (maxBlockSize < 2) {
				System.out.println(answer);
				break;
			}
//			answer에 점수 더하고, 방문배열 초기화
			answer += maxBlockSize * maxBlockSize;
			visited = new boolean[N + 2][N + 2];
			
//			BFS를 통해 max그룹의 블럭들을 -2로 변경하여 빈 공간 만들기
			queue.add(maxNode);
			visited[maxNode.y][maxNode.x] = true;
			arr[maxNode.y][maxNode.x] = -2;
			while (!queue.isEmpty()) {
				Node node = queue.poll();
				int x = node.x;
				int y = node.y;
				for (int d = 0; d < 4; d++) {
					if (!visited[y + dy[d]][x + dx[d]]
							&& (arr[y + dy[d]][x + dx[d]] == 0 || arr[y + dy[d]][x + dx[d]] == maxColor)) {
						queue.add(new Node(y + dy[d], x + dx[d]));
						visited[y + dy[d]][x + dx[d]] = true;
						arr[y + dy[d]][x + dx[d]] = -2;
					}
				}
			}
//			중력 작용
			for (int i = N; i >= 1; i--) {
				for (int j = N; j >= 1; j--) {
//					검은색 블럭이나 빈 공간이면 패스
					if (arr[i][j] < 0) {
						continue;
					}
//					블럭 아래가 빈 공간이면 블럭 1씩 이동 반복
					int k = 0;
					while (arr[i + 1 + k][j] == -2) {
						arr[i + 1 + k][j] = arr[i + k][j];
						arr[i + k][j] = -2;
						k++;
					}
				}
			}
//			격자 회전
			int[][] temp = new int[N + 2][N + 2];
			for (int i = 0; i < N + 2; i++) {
				for (int j = 0; j < N + 2; j++) {
					temp[i][j] = arr[j][N + 1 - i];
				}
			}
			arr = temp;
//			중력 작용
			for (int i = N; i >= 1; i--) {
				for (int j = N; j >= 1; j--) {
					if (arr[i][j] < 0) {
						continue;
					}
					int k = 0;
					while (arr[i + 1 + k][j] == -2) {
						arr[i + 1 + k][j] = arr[i + k][j];
						arr[i + k][j] = -2;
						k++;
					}
				}
			}
//			방문 배열 초기화
			visited = new boolean[N + 2][N + 2];
		}
	}

//	노드 클래스
	static class Node {
		int x, y;

		Node(int y, int x) {
			this.x = x;
			this.y = y;
		}
	}
}
