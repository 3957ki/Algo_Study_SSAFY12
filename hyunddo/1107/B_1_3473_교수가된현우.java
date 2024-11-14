package day1107;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B_1_3473_교수가된현우 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine().trim());
		for (int t = 0; t < T; t++) {
			long N = Long.parseLong(br.readLine().trim());

			int pow = 0;
			for (int i = 0; i <= 13; i++) {
				if (N < Math.pow(5, i)) {
					pow = i - 1;
					break;
				}
			}
//			System.out.println(pow);
			int cnt = 0;
			for (int i = 1; i <= pow; i++) {
				cnt += N / Math.pow(5, i);
			}
			sb.append(cnt).append('\n');
		}
		System.out.println(sb);
	}
}
