import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p1_2422 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int max = 0;

		boolean[][] B = new boolean[N + 1][N + 1];

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			B[a][b] = true;
			B[b][a] = true;
		}
		for (int i = 1; i <= N; i++) {
			for (int j = i + 1; j <= N; j++) {
				for (int k = j + 1; k <= N; k++) {
					if (B[i][j] || B[j][k] || B[k][i]) {
						continue;
					}
					max++;
				}
			}
		}
		System.out.println(max);
	}

}
