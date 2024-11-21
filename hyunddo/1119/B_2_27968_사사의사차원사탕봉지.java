package day1119;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B_2_27968_사사의사차원사탕봉지 {
	public static void main(String[] args) throws IOException {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine().trim());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine().trim());
		long arr[] = new long[M];
		for (int i = 0; i < M; i++) {
			arr[i] = Long.parseLong(st.nextToken());
		}
		for (int i = 1; i < M; i++) {
			arr[i] += arr[i - 1];
		}

		for (int i = 0; i < N; i++) {
			long child = Long.parseLong(br.readLine().trim());
			int answer = -1;

			int start = 0;
			int end = M - 1;
			while (start <= end) {
				int mid = (start + end) / 2;

				if (arr[mid] == child) {
					answer = mid;
					break;
				} else if (arr[mid] > child) {
					answer = mid;
					end = mid - 1;
				} else {
					start = mid + 1;
				}
			}
			if (answer == -1) {
				sb.append("Go away!").append("\n");
			} else
				sb.append(answer + 1).append('\n');
		}
		System.out.println(Arrays.toString(arr));
		System.out.println(sb);
	}
}
