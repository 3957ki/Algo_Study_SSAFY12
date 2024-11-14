package day1112;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class B_1_2992_크면서작은수 {

	static int N, num;
	static int arr[], answerArr[];
	static boolean visited[];
	static int answer;

	static void DFS(int cnt) {
		if (answerArr[0] != 0 && answerArr[0] < arr[0])
			return;

		if (cnt == N) {
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < N; i++) {
				sb.append(answerArr[i]);
			}
			int tmp = Integer.parseInt(sb.toString());
//			System.out.println(tmp);
			if (tmp > num) {
				System.out.println(tmp);
				System.exit(0);
			}
		}

		for (int i = 0; i < N; i++) {
			if (visited[i])
				continue;
			answerArr[cnt] = arr[i];
			visited[i] = true;
			DFS(cnt + 1);
			visited[i] = false;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine().trim();
		N = str.length();
		num = Integer.parseInt(str);
		arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = str.charAt(i) - '0';
		}
		Arrays.sort(arr);
		visited = new boolean[N];
		answerArr = new int[N];
		answer = 0;

		DFS(0);
		System.out.println(0);
	}
}
