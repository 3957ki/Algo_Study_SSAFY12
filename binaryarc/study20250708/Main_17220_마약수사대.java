package study20250708;

import java.io.*;
import java.util.*;

public class Main_17220_마약수사대 {
	static int N, M;
	static char[] alpha;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		// 마약 공급책의 수
		N = Integer.parseInt(st.nextToken());
		// 마약 공급책의 관계 수
		M = Integer.parseInt(st.nextToken());

		int[] cnt = new int[N];
		List<Integer>[] list = new ArrayList[N];
		for (int i = 0; i < N; i++)
			list[i] = new ArrayList<>();

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int from = st.nextToken().charAt(0) - 'A';
//			System.out.println(from);
			int to = st.nextToken().charAt(0) - 'A';
//			System.out.println(to);
			list[from].add(to);
			cnt[to]++;
//			System.out.println(list[from]);
//			System.out.println(cnt[to]);
		}

		Queue<Integer> dq = new ArrayDeque<>();
		boolean[] deleted = new boolean[N];
		
		st = new StringTokenizer(br.readLine());
		int deleteCount = Integer.parseInt(st.nextToken());
		
		for (int i = 0; i < deleteCount; i++) {
			int target = st.nextToken().charAt(0) - 'A';
			if (deleted[target])
				continue;
			deleted[target] = true;
			dq.add(target);

			while (!dq.isEmpty()) {
				int now = dq.poll();
				for (int next : list[now]) {
					if (deleted[next])continue;
					cnt[next]--;
					if (cnt[next] == 0) {
						dq.add(next);
						deleted[next] = true;
					}
				}
			}
		}

		int remain = 0;
        for (int i = 0; i < N; i++) {
            if (!deleted[i] && cnt[i] > 0){
            	remain++;
            }
        }

        System.out.println(remain);

	}
}
