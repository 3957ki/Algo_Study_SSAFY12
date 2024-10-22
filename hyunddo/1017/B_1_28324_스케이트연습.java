package day1017;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B_1_28324_스케이트연습 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine().trim());
		long arr[] = new long[N];
		StringTokenizer st = new StringTokenizer(br.readLine().trim());
		for (int i = 0; i < N; i++) {
			arr[i] = Long.parseLong(st.nextToken());
		}
		// input end

		long min = 1;
		for (int i = N - 1; i >= 0; i--) {
			if (arr[i] > min) {
				arr[i] = min;
			} else if (arr[i] < min)
				min = arr[i];
			min++;
		}
		long answer = 0;
		for (int i = 0; i < N; i++)
			answer += arr[i];
		System.out.println(answer);
	}
}
