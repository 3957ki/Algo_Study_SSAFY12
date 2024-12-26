package study1119;

import java.io.*;
import java.util.*;

public class Main_27968_사사의사차원사탕봉지 {
	static int N, M;
	static long[] candies;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); // 아이의수
		M = Integer.parseInt(st.nextToken()); // 횟수별 사탕개수
		candies = new long[M + 1];
		st = new StringTokenizer(br.readLine());
		long prev = 0;
		for (int i = 1; i <= M; i++) {
			prev += Integer.parseInt(st.nextToken());
			candies[i] = prev;
		}
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			long wantCandy = Long.parseLong(st.nextToken());
			if (wantCandy > candies[M]) {
				sb.append("Go away!").append('\n');
			} else {
				int left = 1;
				int right = M;
				int res = 0;
				while (left <= right) {
					int mid = (left + right) / 2;
					if(candies[mid] >= wantCandy) {
						res = mid;
						right = mid -1;
					}else {
						left = mid +1;
					}
				}
				sb.append(right+1).append('\n');
			}

		}
		System.out.println(sb);
	}
}
