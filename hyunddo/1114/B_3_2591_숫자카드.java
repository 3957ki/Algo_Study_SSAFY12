package day1114;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class B_3_2591_숫자카드 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine().trim();

		int arr[] = new int[str.length()];
		for (int i = 0; i < str.length(); i++) {
			arr[i] = str.charAt(i) - '0';
		}
		// input end

		int dp[] = new int[str.length()];
		dp[0] = 1;

		for (int i = 1; i < str.length(); i++) {
			int tmp = arr[i];
			if (tmp >= 1) {
				dp[i] += dp[i - 1];
			}
			int tmp2 = arr[i - 1] * 10 + arr[i];
			if (tmp2 >= 10 && tmp2 <= 34) {
				if (i >= 2)
					dp[i] += dp[i - 2];
				else
					dp[i] += 1;
			}
		}
		System.out.println(dp[str.length()-1]);
	}
}
