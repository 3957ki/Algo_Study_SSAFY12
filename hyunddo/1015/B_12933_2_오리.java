package day1015;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class B_12933_2_오리 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine().trim();
		int arr[] = new int[5];
		int duck = 0;

		int check = 0;
		for (int i = 0; i < str.length(); i++) {
			char a = str.charAt(i);
			if (a == 'q') {
				arr[0] += 1;
				check++;
				duck = Math.max(duck, arr[0]);
			} else if (a == 'u' && arr[0] > arr[1]) {
				arr[1] += 1;
				check++;
			} else if (a == 'a' && arr[1] > arr[2]) {
				arr[2] += 1;
				check++;
			} else if (a == 'c' && arr[2] > arr[3]) {
				arr[3] += 1;
				check++;
			} else if (a == 'k' && arr[3] > arr[4]) {
				arr[4] += 1;
				check++;
				for (int j = 0; j < 5; j++)
					arr[j] -= 1;
			}
		}
		for (int i = 0; i < 5; i++) {
			if (arr[i] != 0 || check != str.length()) {
				System.out.println(-1);
				System.exit(0);
			}
		}
		System.out.println(duck);
	}
}
