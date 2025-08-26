package study20250812;

import java.io.*;
import java.util.*;

public class Main_1263_시간관리 {
	public static class Info {
		int t, s;

		public Info(int t, int s) {
			this.t = t;
			this.s = s;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		Info[] infos = new Info[N];

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int T = Integer.parseInt(st.nextToken());
			int S = Integer.parseInt(st.nextToken());
			infos[i] = new Info(T, S);
		}

		Arrays.sort(infos, (o1, o2) -> {
			return o2.s - o1.s;
		});

		int ans = infos[0].s - infos[0].t;

		for (int i = 1; i < N; i++) {
			if (infos[i].s < ans) {
				ans = infos[i].s;
			}
			ans -= infos[i].t;
		}

		System.out.println(ans < 0 ? -1 : ans);

	}
}
