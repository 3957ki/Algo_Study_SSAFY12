package day0919;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B_11558_1_TheGameOfDeath {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine().trim());

		for (int t = 1; t <= T; t++) {
			int N = Integer.parseInt(br.readLine().trim());
			int arr[] = new int[N + 1];
			for (int i = 1; i <= N; i++) {
				arr[i] = Integer.parseInt(br.readLine().trim());
			}
			// input end

			boolean flag = false;
			int check = 1;
			for (int i = 1; i <= N; i++) {
				check = arr[check];
				if (check == N)
					flag = true;
			}

			if (!flag) {
				sb.append(0).append('\n');
			} else {
				int cnt = 0;
				int start = 1;
				while (true) {
					int next = arr[start];
					cnt++;
					if (next == N)
						break;
					start = next;
				}
				sb.append(cnt).append('\n');
			}

//			boolean visited[] = new boolean[N + 1];
//			int cnt = 0;
//			int start = 1;
//			visited[start] = true;
//			while (true) {
//				int next = arr[start];
//				start = next;
//				cnt++;
//				if (next == N || visited[start]) {
//					break;
//				}
//				visited[next] = true;
//			}
//			if (start == N)
//				sb.append(cnt).append('\n');
//			else {
//				sb.append(0).append('\n');
//			}
		}
		System.out.println(sb);
	}
}
