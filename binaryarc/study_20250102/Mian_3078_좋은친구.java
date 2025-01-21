package study_20250102;

import java.io.*;
import java.util.*;

public class Mian_3078_좋은친구 {
	static int N, K;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		int[] name_len = new int[N];
		int[] name_len_cnt = new int[21];
		for (int i = 0; i < N; i++) {
			int len = br.readLine().length();
			name_len[i] = len;
			if (i <= K) {
				//초기 슬라이드 값 계산
				name_len_cnt[len]++;
			}
		}

		long cur_cnt = --name_len_cnt[name_len[0]];

		for (int idx = 1; idx < N; idx++) {
			if (idx + K < N) {
				// 슬라이드 이동 후 쌍 수 계산
				name_len_cnt[name_len[idx + K]]++;
			}
			cur_cnt += --name_len_cnt[name_len[idx]];
		}

		System.out.println(cur_cnt);

	}
}
