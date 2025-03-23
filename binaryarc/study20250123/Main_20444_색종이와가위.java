package study20250123;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_20444_색종이와가위 {
	static long n, k;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Long.parseLong(st.nextToken());
		k = Long.parseLong(st.nextToken());

		long left = 0;
		long right = n / 2;
		while (left <= right) {
			long col = (left + right) / 2L;
			long row = n - col;
			long res = (col + 1) * (row + 1);

			if (res == k) {
				if (res == k) {
					System.out.println("YES");
					System.exit(0);
				}
			}
			if (res > k) {
				right = col - 1;

			} else {
				left = col + 1;
			}
		}

		System.out.println("NO");

	}
}
