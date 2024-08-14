import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class q3187_3 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int R = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());

		int sheep = 0;
		int wolf = 0;

		int answer1 = 0;
		int answer2 = 0;

		char arr[][] = new char[R][C];
		for (int i = 0; i < R; i++) {
			String str = br.readLine();
			for (int j = 0; j < C; j++) {
				arr[i][j] = str.charAt(j);
			}
		}

		int dx[] = { 0, 0, -1, 1 };
		int dy[] = { -1, 1, 0, 0 };
		ArrayList<int[]> queue = new ArrayList<>();

		int a = 0;
		int b = 0;
		int di = 0;
		int dj = 0;

		boolean visited[][] = new boolean[R][C];
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (!visited[i][j] && (arr[i][j] == 'k' || arr[i][j] == 'v')) {
					visited[i][j] = true; // 방문처리
					if (arr[i][j] == 'k') {
						sheep++;
					}
					if (arr[i][j] == 'v') {
						wolf++;
					}
					queue.add(new int[] { i, j }); // 큐에 위치 push
					while (!queue.isEmpty()) {
						int index[] = queue.get(0);
						a = index[0];
						b = index[1];
						queue.remove(0);
						for (int x = 0; x < 4; x++) {
							di = a + dx[x];
							dj = b + dy[x];
							if (!visited[di][dj]) {
								if (arr[di][dj] != '#') {
									visited[di][dj] = true; // 방문처리
									if (arr[di][dj] == 'k') {
										sheep++;
									}
									if (arr[di][dj] == 'v') {
										wolf++;
									}
									queue.add(new int[] { di, dj });
//									System.out.println(di + " " + dj);
								}
							}
						}
					}
//					System.out.println("***"+i+" "+j);
//					System.out.println("-----"+sheep+" "+wolf);
					if (wolf >= sheep)
						answer2 += wolf;
					if (wolf < sheep)
						answer1 += sheep;
					wolf = 0;
					sheep = 0;
				}
			}
		}
		System.out.println(answer1 + " " + answer2);
	}
}
