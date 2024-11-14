package day1112;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Queue;
import java.util.StringTokenizer;

public class B_3_32069_가로등 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine().trim());
		long L = Long.parseLong(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		HashSet<Long> set = new HashSet<>();
		Queue<long[]> dq = new ArrayDeque<>();

		if (N >= K) {
			for (int i = 0; i < K; i++) {
				sb.append(0).append('\n');
			}
			System.out.println(sb);
			System.exit(0);
		}

		st = new StringTokenizer(br.readLine().trim());
		for (int i = 0; i < N; i++) {
			long num = Long.parseLong(st.nextToken());
			set.add(num);
			sb.append(0).append('\n');
			if (num > 0)
				dq.add(new long[] { num - 1, 1 });
			if (num < L)
				dq.add(new long[] { num + 1, 1 });
		}
		// input end

		int added = N;
//		for (int i = N; i < K; i++) {
		while (added < K) {
			long[] arr = dq.poll();
			if (arr == null)
				break;
			long num = arr[0];
			long cnt = arr[1];
			if (set.contains(num)) {
				continue;
			}
			set.add(num);
			sb.append(cnt).append('\n');
			added++;
			if (num > 0 && !set.contains(num - 1))
				dq.add(new long[] { num - 1, cnt + 1L });
			if (num < L && !set.contains(num + 1))
				dq.add(new long[] { num + 1, cnt + 1L });

		}

		System.out.println(sb);
	}
}
