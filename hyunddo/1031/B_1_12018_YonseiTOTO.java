package day1031;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B_1_12018_YonseiTOTO {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine().trim());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		int num[] = new int[n];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine().trim());
			int p = Integer.parseInt(st.nextToken());
			int l = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(br.readLine().trim());
			int tmp[] = new int[p];
			for (int j = 0; j < p; j++) {
				tmp[j] = Integer.parseInt(st.nextToken());
			}
			if (p < l)
				num[i] = 1;
			else {
				Arrays.sort(tmp);
				num[i] = tmp[p - l];
			}
		}
		// input end
		Arrays.sort(num);
		int sum = 0;
		int cnt = 0;
		for (int i = 0; i < n; i++) {
			if (sum + num[i] > m) {
				break;
			}
			sum += num[i];
			cnt++;
		}
//		System.out.println(Arrays.toString(num));
		System.out.println(cnt);
	}
}
