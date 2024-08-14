package day0808;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class q1495_2 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()); // 곡의 개수
		int S = Integer.parseInt(st.nextToken()); // 시작 볼륨
		int M = Integer.parseInt(st.nextToken()); // 볼륨 최댓값
		int answer = -1;

		int arr[] = new int[N];
		StringTokenizer st2 = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) { // 볼륨의 리스트
			arr[i] = Integer.parseInt(st2.nextToken());
		}

		boolean map[][] = new boolean[N + 1][M + 1];

		if (S + arr[0] <= M) { // 시작 볼륨 + 1번 볼륨이 최댓값보다 작을 경우
			map[1][S + arr[0]] = true;
		}
		if (S - arr[0] >= 0) { // 시작 볼륨 -1번 볼륨이 -보다 클 경우
			map[1][S - arr[0]] = true;
		}
//		System.out.println(Arrays.toString(map[1]));

		for (int i = 2; i <= N; i++) {
			for (int j = 0; j <= M; j++) {
				if (map[i - 1][j] == true) {
					if (j + arr[i - 1] <= M) {
						map[i][j + arr[i - 1]] = true;
					}
					if (j - arr[i - 1] >= 0) {
						map[i][j - arr[i - 1]] = true;
					}
				}
//				}
			}
//			System.out.println(Arrays.toString(map[i]));
//			System.out.println(answer);
		}

		for (int i = 0; i <= M; i++) {
			if (map[N][i] == true)
				if (answer < i)
					answer = i;
		}

		System.out.println(answer);
	}
}
