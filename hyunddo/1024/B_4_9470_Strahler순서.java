package day1024;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class B_4_9470_Strahler순서 {

	static class Node {
		int start;
		int end;

		public Node(int start, int end) {
			super();
			this.start = start;
			this.end = end;
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine().trim());
		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine().trim());
			int K = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			int P = Integer.parseInt(st.nextToken());

			int inter[] = new int[M + 1];
			List<Integer> list[] = new ArrayList[M + 1];
			List<Integer> parents[] = new ArrayList[M + 1];
			for (int i = 1; i <= M; i++) {
				list[i] = new ArrayList<>();
				parents[i] = new ArrayList<>();
			}
			for (int p = 0; p < P; p++) {
				st = new StringTokenizer(br.readLine().trim());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				inter[b] += 1;
				list[a].add(b);
				parents[b].add(a);
			}
//			System.out.println(Arrays.toString(inter));

			Queue<Integer> queue = new ArrayDeque<>();

			for (int i = 1; i <= M; i++) {
				if (inter[i] == 0) {
					queue.add(i);
				}
			}

			int Strahler[] = new int[M + 1];
			while (!queue.isEmpty()) {
				int num = queue.poll();

				if (parents[num].size() == 0) {
					Strahler[num] += 1;
				} else if (parents[num].size() == 1) {
					Strahler[num] = Strahler[parents[num].get(0)];
				} else {
					int max = 0;
					int cnt = 0;
					for (int i = 0; i < parents[num].size(); i++) {
						int tmp = parents[num].get(i);
//						System.out.println("*" + tmp);
						if (max == Strahler[tmp]) {
							cnt++;
						} else if (max < Strahler[tmp]) {
							cnt = 1;
							max = Strahler[tmp];
						}
					}
					if (cnt == 1)
						Strahler[num] = max;
					else {
						Strahler[num] = max + 1;
					}
				}

				// 다음 queue에 넣기
				for (int i = 0; i < list[num].size(); i++) {
					int tmp = list[num].get(i);
					inter[tmp]--;
					if (inter[tmp] == 0)
						queue.add(tmp);
				}
//				System.out.println(num + " " + Arrays.toString(Strahler));
			}

//			System.out.println(Arrays.toString(Strahler));
			int answer = Arrays.stream(Strahler).max().getAsInt();
			sb.append(t).append(" ").append(answer).append("\n");
		}
		System.out.println(sb);
	}
}