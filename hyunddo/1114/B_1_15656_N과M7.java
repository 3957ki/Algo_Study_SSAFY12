package day1114;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B_1_15656_N과M7 {

	static int N, M;
	static int arr[], answer[];
	static StringBuilder sb;

	static void DFS(int cnt) {
		if (cnt == M) {
			for (int i = 0; i < M; i++) {
				sb.append(answer[i]).append(' ');
			}
			sb.append('\n');
			return;
		}

		for (int i = 0; i < N; i++) {
			answer[cnt] = arr[i];
			DFS(cnt + 1);
		}

	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine().trim());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine().trim());
		arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr);
		answer = new int[M];
		DFS(0);

		System.out.println(sb);
	}
}
