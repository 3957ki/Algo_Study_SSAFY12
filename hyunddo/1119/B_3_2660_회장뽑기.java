package day1119;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B_3_2660_회장뽑기 {
	public static void main(String[] args) throws IOException {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine().trim());
		int map[][] = new int[N + 1][N + 1];
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				if (i == j)
					continue;
				map[i][j] = 100;
			}
		}
		while (true) {
			StringTokenizer st = new StringTokenizer(br.readLine().trim());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			if (a == -1 && b == -1)
				break;
			map[a][b] = 1;
			map[b][a] = 1;
		}

		for (int t = 1; t <= N; t++) {
			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= N; j++) {
					map[i][j] = Math.min(map[i][j], map[i][t] + map[t][j]);
				}
			}
		}

//		for (int i = 0; i <= N; i++) {
//			for (int j = 0; j <= N; j++) {
//				System.out.print(map[i][j]+" ");
//			}	
//			System.out.println();
//		}

		int arr[] = new int[N + 1];
		arr[0] = Integer.MAX_VALUE;
		for (int i = 1; i <= N; i++) {
			int tmp = 0;
			for (int j = 1; j <= N; j++) {
				tmp = Math.max(tmp, map[i][j]);
			}
			arr[i] = tmp;
		}

		int min = Arrays.stream(arr).min().getAsInt();

		int cnt = 0;
		for (int i = 0; i <= N; i++) {
			if (arr[i] == min) {
				sb.append(i).append(' ');
				cnt++;
			}
		}
		System.out.println(min + " " + cnt);
		System.out.println(sb);
	}
}
