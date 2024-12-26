package day1107;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B_2_17827_달팽이리스트 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine().trim());
		int N = Integer.parseInt(st.nextToken()); // 노드의 개수
		int M = Integer.parseInt(st.nextToken()); // 질문의 횟수
		int V = Integer.parseInt(st.nextToken()); // 노드의 번호

		st = new StringTokenizer(br.readLine().trim());
		int node[] = new int[N];
		for (int i = 0; i < N; i++) {
			node[i] = Integer.parseInt(st.nextToken());
		}

		int arr[] = new int[N - V + 1];
		for (int i = 0; i <= N - V; i++) {
			arr[i] = node[i + V - 1];
		}

		for (int i = 0; i < M; i++) {
			int m = Integer.parseInt(br.readLine().trim());
			if (m < N)
				sb.append(node[m]).append('\n');
			else
				sb.append(arr[(m - V + 1) % (N - V + 1)]).append('\n');
		}
		System.out.println(sb);
	}
}
