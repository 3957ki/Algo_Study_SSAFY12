package study1105;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class b3_3019_테트리스 {
	static int C, P;
	static int[] arr;
	static int cnt;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		C = Integer.parseInt(st.nextToken());
		P = Integer.parseInt(st.nextToken());
		arr = new int[C];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < C; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		cnt = 0;
		solve();
		System.out.println(cnt);
	}

	public static void solve() {
		if (P == 1) {
			cnt += C; // 세로로 놓는 경우 C개
			for (int i = 0; i <= C - 4; i++) {
				if (arr[i] == arr[i + 1] && arr[i + 1] == arr[i + 2] && arr[i + 2] == arr[i + 3]) {
					cnt++;
				}
			}
			return;
		}

		if (P == 2) {
			for (int i = 0; i <= C - 2; i++) {
				if (arr[i] == arr[i + 1]) {
					cnt++;
				}
			}
			return;
		}

		if (P == 3) {
			for (int i = 0; i <= C - 2; i++) {
				if (arr[i] - 1 == arr[i + 1])
					cnt++; // 세로 배치
			}
			for (int i = 0; i <= C - 3; i++) {
				if (arr[i] == arr[i + 1] && arr[i + 1] == arr[i + 2] - 1)
					cnt++; // 가로 배치
			}
			return;
		}

		if (P == 4) {
			for (int i = 0; i <= C - 2; i++) {
				if (arr[i] == arr[i + 1] - 1)
					cnt++; // 세로 배치
			}
			for (int i = 0; i <= C - 3; i++) {
				if (arr[i] - 1 == arr[i + 1] && arr[i + 1] == arr[i + 2])
					cnt++; // 가로 배치
			}
			return;
		}

		if (P == 5) {
			for (int i = 0; i <= C - 3; i++) {
				if (arr[i] == arr[i + 1] && arr[i + 1] == arr[i + 2])
					cnt++;
			}
			for (int i = 0; i <= C - 3; i++) {
				if (arr[i] == arr[i + 2] && arr[i + 1] == arr[i + 2] - 1)
					cnt++;
			}
			for (int i = 0; i <= C - 2; i++) {
				if (arr[i] == arr[i + 1] - 1 || arr[i] - 1 == arr[i + 1])
					cnt++;
			}
			return;
		}

		if (P == 6) {
			for (int i = 0; i <= C - 2; i++) {
				if (arr[i] == arr[i + 1] || arr[i] == arr[i + 1] - 2)
					cnt++;
			}
			for (int i = 0; i <= C - 3; i++) {
				if (arr[i] == arr[i + 1] && arr[i + 1] == arr[i + 2])
					cnt++;
				if (arr[i] == arr[i + 1] - 1 && arr[i + 1] == arr[i + 2])
					cnt++;
			}
			return;
		}

		if (P == 7) {
			for (int i = 0; i <= C - 2; i++) {
				if (arr[i] == arr[i + 1] || arr[i] == arr[i + 1] - 2)
					cnt++;
			}
			for (int i = 0; i <= C - 3; i++) {
				if (arr[i] == arr[i + 1] && arr[i + 1] == arr[i + 2])
					cnt++;
				if (arr[i] == arr[i + 1] && arr[i + 1]-1 == arr[i + 2] )
					cnt++;
			}
		}
	}
}
