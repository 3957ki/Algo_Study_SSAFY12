package day1024;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 누적합
// 슬라이딩 윈도우

public class B_2_14465_소가길을건너간이유5 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine().trim());

		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());

		boolean arr[] = new boolean[N + 1];

		for (int i = 0; i < B; i++) {
			arr[Integer.parseInt(br.readLine().trim())] = true; // 불이 고장났으면 true
		}
		// input end
		
		int answer = Integer.MAX_VALUE;
		for (int i = 1; i <= N - K + 1; i++) {
			int cnt = 0;
			for (int j = i; j < i + K; j++) {
				if (arr[j])
					cnt++;
			}
			answer = Math.min(answer, cnt);
		}
		System.out.println(answer);
	}
}
