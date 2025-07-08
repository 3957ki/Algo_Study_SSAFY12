import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class p3_3187 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int R = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		char[][] arr = new char[R][C];
		for (int i = 0; i < R; i++) {
			String s = br.readLine();
			for (int j = 0; j < C; j++) {
				arr[i][j] = s.charAt(j);
			}
		}
//		델타
		int[] dx = { 0, 0, -1, 1 };
		int[] dy = { 1, -1, 0, 0 };
		
		Queue<Node> queue = new LinkedList<>();
		boolean[][] visited = new boolean[R][C];
		int answerK = 0;
		int answerV = 0;
//		순회
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
//				방문했거나 .이거나 #이면 패스
				if (visited[i][j] || arr[i][j] == '.' || arr[i][j] == '#') {
					continue;
				}
//				양과 늑대 개수
				int kNum = 0;
				int vNum = 0;
//				양이라면
				if (arr[i][j] == 'k') {
					kNum++;
				}
//				늑대라면
				if (arr[i][j] == 'v') {
					vNum++;
				}
//				방문 표시 후 큐에 삽입
				visited[i][j] = true;
				queue.add(new Node(i, j));
				while (!queue.isEmpty()) {
					Node node = queue.poll();
					int y = node.y;
					int x = node.x;
//					4방탐색
					for (int d = 0; d < 4; d++) {
//						방문하지 않았다면
						if (!visited[y + dy[d]][x + dx[d]]) {
							visited[y + dy[d]][x + dx[d]] = true;
//							양이라면
							if (arr[y + dy[d]][x + dx[d]] == 'k') {
								kNum++;
								queue.add(new Node(y + dy[d], x + dx[d]));
							} 
//							늑대라면
							else if (arr[y + dy[d]][x + dx[d]] == 'v') {
								vNum++;
								queue.add(new Node(y + dy[d], x + dx[d]));
							} 
//							.이라면
							else if (arr[y + dy[d]][x + dx[d]] == '.') {
								queue.add(new Node(y + dy[d], x + dx[d]));
							}
						}
					}
				}
//				크기 비교 후 이긴 동물 개수 더하기
				if (kNum > vNum) {
					answerK += kNum;
				} else {
					answerV += vNum;
				}
			}
		}
		System.out.println(answerK + " " + answerV);
	}
//	노드 클래스
	static class Node {
		int x = 0;
		int y = 0;

		Node(int y, int x) {
			this.x = x;
			this.y = y;
		}
	}
}
