package study1031;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class b1_12018_Yonsei_TOTO {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		Queue<Integer> pq = new PriorityQueue<>((o1,o2)->o1-o2);
		Integer[] arr_p;
		
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			int P = Integer.parseInt(st.nextToken());
			int L = Integer.parseInt(st.nextToken());
			if(P < L) {
				pq.add(1);
				st = new StringTokenizer(br.readLine());
				continue;
			}
			arr_p = new Integer[P > L ? P : L];
			Arrays.fill(arr_p, 0);
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < P; j++) {
				arr_p[j] = Integer.parseInt(st.nextToken());
			}
			Arrays.sort(arr_p,Collections.reverseOrder());
//			System.out.println(Arrays.toString(arr_p));
			pq.add(arr_p[L-1]);
		}
		int cnt =0;
		while(!pq.isEmpty() && m >= 0) {
			int cur = pq.poll();
//			System.out.println(cur);
			if(cur <= m) {
				cnt++;
				m -= cur;
			}
		}
		System.out.println(cnt);
	}
}
