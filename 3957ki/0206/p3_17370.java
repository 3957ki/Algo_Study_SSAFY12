import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class p3_17370 {

	static int answer, N;
	static boolean[][] visited = new boolean[1000][1000];
	static Map<Integer, int[]> dir = new HashMap<>();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 6가지 방향 미리 매핑 (-1, 0, 1) -> (0, 1, 2)로 변환후 숫자 2개 붙인 것
		dir = new HashMap<>();
		dir.put(21, new int[] {22, 20});
		dir.put(22, new int[] {2, 21});
		dir.put(2, new int[] {1, 22});
		dir.put(1, new int[] {0, 2});
		dir.put(0, new int[] {20, 1});
		dir.put(20, new int[] {0, 21});

		N = Integer.parseInt(br.readLine());

		// 시작 지점과 한번 이동한 지점 방문 처리
		visited[500][500] = true;
		visited[501][501] = true;
		DFS(500, 500, 0, 0);
		System.out.println(answer);

	}

	public static void DFS(int y, int x, int now, int cnt) {

		// N번 꺾어서 왔으면 return
		if (cnt == N)
			return;

		int[] next = dir.get(now);

		// 다음 방향
		for (int d : next) {
			int ny = y + (d / 10) - 1;
			int nx = x + (d % 10) - 1;

			// 방문한 곳인데 N-1번 꺾어서 왔다면 성공
			if (visited[ny][nx] && cnt == N - 1) {
				answer++;
				continue;
			}

			if (visited[ny][nx])
				continue;

			visited[ny][nx] = true;
			DFS(ny, nx, d, cnt + 1);
			visited[ny][nx] = false;
		}
	}
}