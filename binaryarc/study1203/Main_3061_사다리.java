package study1203;

import java.io.*;
import java.util.*;

public class Main_3061_사다리 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int[] arr;
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			int N = Integer.parseInt(br.readLine());
			arr = new int[N];
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}

			int cnt = 0;
			for (int i = 0; i < N; i++) {
				for (int j = i + 1; j < N; j++) {
					if(arr[j] < arr[i]) {
						int temp = arr[i];
						arr[i] = arr[j];
						arr[j] = temp;
						cnt++;
					}
				}
			}
			System.out.println(cnt);
		}
	}
}
