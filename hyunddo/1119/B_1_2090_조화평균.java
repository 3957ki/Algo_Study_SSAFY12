package day1119;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B_1_2090_조화평균 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine().trim());
		long arr[] = new long[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		long a = arr[0];
		long max = arr[0];
		for (int i = 1; i < N; i++) {
			long b = arr[i];
			if (arr[i] == 1)
				continue;
			while (b != 0) {
				long tmp = b;
				b = a % b;
				a = tmp;
			}
			max = (arr[i] * max) / a;
		}

		long answer = 0;
		for (int i = 0; i < N; i++) {
			answer += max / arr[i];
		}

		long num1 = max;
		long num2 = answer;
		while (num2 != 0) {
			long tmp = num2;
			num2 = num1 % num2;
			num1 = tmp;
		}
		max /= num1;
		answer /= num1;

		System.out.println(max + "/" + answer);
	}
}
