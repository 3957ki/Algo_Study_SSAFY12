package day0910;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class B_1699_1_제곱수의합 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine().trim());

		int arr[] = new int[N + 1];
		arr[1] = 1;
		if (N >= 2)
			arr[2] = 2;
		for (int i = 3; i <= N; i++) {
			int num = Integer.MAX_VALUE;
			if (Math.sqrt(i) % 1 == 0) {
				arr[i] = 1;
				continue;
			}
			for (int j = 1; j <= i / 2; j++) {
				num = Math.min(num, arr[j] + arr[i - j]);
			}
			arr[i] = num;
		}
//		System.out.println(Arrays.toString(arr));
		System.out.println(arr[N]);
	}
}
