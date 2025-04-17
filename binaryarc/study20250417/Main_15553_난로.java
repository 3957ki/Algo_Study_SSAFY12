package study20250417;

import java.io.*;
import java.util.*;

public class Main_15553_난로 {
	static int N, K;
	static int[] T;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		T = new int[N];
		for (int i = 0; i < N; i++) {
			T[i] = Integer.parseInt(br.readLine());
		}
		Arrays.sort(T);
		List<Integer> gaps = new ArrayList<>();
		int minOn = 1;
		for (int i = 1; i < N; i++) {
			int diff = T[i] - T[i - 1];
			if (diff > 1) {
				minOn++;
				gaps.add(diff - 1);
			}
		}
		Collections.sort(gaps);
		long ans = N;
		if (minOn > K) {
			for (int i = 0; i < minOn - K; i++) {
				ans += gaps.get(i);
			}
		}
		System.out.println(ans);

	}
}
