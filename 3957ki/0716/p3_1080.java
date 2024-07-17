import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p3_1080 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[][] arrA = new int[N][M];
		int[][] arrB = new int[N][M];
		int cnt = 0;

		for (int i = 0; i < N; i++) {
			String s = new String(br.readLine());
			for (int j = 0; j < M; j++) {
				arrA[i][j] = Integer.parseInt(s.substring(j, j + 1));
			}
		}
		for (int i = 0; i < N; i++) {
			String s = new String(br.readLine());
			for (int j = 0; j < M; j++) {
				arrB[i][j] = Integer.parseInt(s.substring(j, j + 1));
			}
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (i >= N - 2 || j >= M - 2) {
					if (arrA[i][j] != arrB[i][j]) {
						System.out.println(-1);
						return;
					}
				} else if (arrA[i][j] != arrB[i][j]) {
					for (int k = 0; k < 3; k++) {
						for (int l = 0; l < 3; l++) {
							arrA[i + k][j + l] = (++arrA[i + k][j + l]) % 2;
						}
					}
					cnt++;
					continue;
				}
			}
		}

		System.out.println(cnt);
	}
}
