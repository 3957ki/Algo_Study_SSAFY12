package study1226;

import java.io.*;
import java.util.*;

public class Main_15961_회전초밥 {
	static int N, d, k, c;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		d = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());

		int[] susi = new int[N];
		for (int i = 0; i < N; i++) {
			susi[i] = Integer.parseInt(br.readLine());
		}

		int[] isEat = new int[d + 1];
		int cnt = 0;
		for (int i = 0; i < k; i++) {
			if (isEat[susi[i]] == 0) {
				cnt++;
			}
			isEat[susi[i]]++;
		}

		int max_cnt = cnt;
		for (int start = 0; start < N; start++) {
			int end = (start + k) % N;
			isEat[susi[start]]--;
			if (isEat[susi[start]] == 0)
				cnt--;

			if (isEat[susi[end]] == 0) {
				cnt++;
			}
			isEat[susi[end]]++;
			if (isEat[c] == 0) {
				max_cnt = Math.max(max_cnt, cnt + 1);
			} else {
				max_cnt = Math.max(max_cnt, cnt);
			}
		}

		System.out.println(max_cnt);
	}
}
