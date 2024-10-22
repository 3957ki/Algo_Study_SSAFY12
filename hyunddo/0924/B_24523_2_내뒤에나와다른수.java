package day0924;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B_24523_2_내뒤에나와다른수 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine().trim());
		StringTokenizer st = new StringTokenizer(br.readLine().trim());
		int arr[] = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		// input end

		int answer[] = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			if (i >= 2 && arr[i] == arr[i - 1]) {
				answer[i] = answer[i - 1];
				continue;
			}
			boolean flag = false;
			for (int j = i + 1; j <= N; j++) {
				if (arr[i] == arr[j])
					continue;
				else {
					answer[i] = j;
					flag = true;
					break;
				}
			}
			if (!flag)
				answer[i] = -1;
		}
		for(int i =1; i<= N; i++) {
			sb.append(answer[i]).append(' ');
		}
		System.out.println(sb);
	}
}
