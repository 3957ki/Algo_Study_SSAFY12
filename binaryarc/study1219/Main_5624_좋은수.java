package study1219;

import java.io.*;
import java.util.*;

public class Main_5624_좋은수 {
	static int N;
	static int[] arr;
	static Set<Integer> set;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		arr = new int[N];
		set = new HashSet<>();
		int cnt = 0;
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());

			for (int j = 0; j < i; j++) {
				if (set.contains(arr[i] - arr[j])) {
					cnt++;
					break;
				}
			}

			for (int j = 0; j <= i; j++) {
				set.add( (arr[j] + arr[i]));
			}
		}
		System.out.println(cnt);
		
	}

}
