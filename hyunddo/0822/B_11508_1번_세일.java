package day0822;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class B_11508_1번_세일 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(br.readLine().trim());
		int arr[] = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(br.readLine().trim());
		}
		// 입력끝
		int answer = 0;

		Arrays.sort(arr);
		int tmp[] = new int[N];
		for (int i = N - 1; i >= 0; i--) {
			tmp[i] = arr[N-i-1];
		}
		for(int i = 0; i<N; i++) {
			if(i%3 !=2) {
				answer += tmp[i];
			}
		}
		sb.append(answer);
		System.out.println(sb);
	}
}
