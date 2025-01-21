package study20250107;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_3649_로봇프로젝트 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = null;
		while ((input = br.readLine()) != null) {
			int x = Integer.parseInt(input);
			// 10센치 = 10^8 나노
			// 1센치 = 10^7 나노
			x = x * 10000000;
			int n = Integer.parseInt(br.readLine());
			int[] arr = new int[n];
			for (int i = 0; i < n; i++) {
				arr[i] = Integer.parseInt(br.readLine());
			}
			Arrays.sort(arr);

			int left = 0;
			int right = n - 1;
			boolean found = false;
			while (left < right) {
				int len = arr[left] + arr[right];
				if (len == x) {
					System.out.println("yes " + arr[left] + " " + arr[right]);
					found = true;
					break;
				}
				if (len > x) {
					right--;
					continue;
				} else {
					left++;
				}
			}
			if (!found) {
				System.out.println("danger");
			}
		}
	}
}
