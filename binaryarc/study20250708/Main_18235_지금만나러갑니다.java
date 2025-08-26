package study20250708;

import java.io.*;
import java.util.*;

public class Main_18235_지금만나러갑니다 {
	static int N, A, B;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		A = Integer.parseInt(st.nextToken());
		B = Integer.parseInt(st.nextToken());

		if (((A - B) & 1) == 1) {
			System.out.println(-1);
			return;
		}

		Queue<Integer> ori, ukri;
		ori = new ArrayDeque<>();
		ukri = new ArrayDeque<>();
		int[] visited = new int[N + 1];

		ori.add(A);
		ukri.add(B);

		int day = 1;
		while (!ori.isEmpty() && day <= 19) {
			int size = ori.size();
			int jump = 1 << (day - 1);
			for (int i = 0; i < size; i++) {
				int now = ori.poll();
				int plus = now + jump;
				int minus = now - jump;
				if (plus <= N) {
					ori.add(plus);
					visited[plus] = day;
				}
				if (minus >= 1) {
					ori.add(minus);
					visited[minus] = day;
				}
			}
			size = ukri.size();
			for (int i = 0; i < size; i++) {
				int now = ukri.poll();
				int plus = now + jump;
				int minus = now - jump;

				if (plus <= N) {
					if (visited[plus] == day) {
						System.out.println(day);
						return;
					}
					ukri.add(plus);
				}
				if (minus >= 1) {
					if (visited[minus] == day) {
						System.out.println(day);
						return;
					}
					ukri.add(minus);
				}
			}
			day++;
		}
		System.out.println(-1);

	}
}
