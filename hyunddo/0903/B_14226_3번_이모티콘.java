package day0903;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class B_14226_3번_이모티콘 {
//	static void dfs(int clipboard, int print, int depth) {
//		if (print > S)
//			return;
//		if (print == S) {
//			if (min > depth)
//				min = depth;
//			return;
//		}
//		if (visited[clipboard][print])
//			return;
//		// 복사해서 클립보드 저장
//		visited[print][print] = true;
//		dfs(print, print, depth + 1);
//		// 클립보드에 있는 이모티콘 화면에 붙여넣기
//		visited[clipboard][print + clipboard] = true;
//		dfs(clipboard, print + clipboard, depth + 1);
//		// 하나 삭제
//		if (print > 1) {
//			visited[clipboard][print - 1] = true;
//			dfs(clipboard, print - 1, depth + 1);
//		}
//	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int S = Integer.parseInt(br.readLine().trim());
		boolean visited[][] = new boolean[S + 1][S + 1];

		int answer = 0;

		visited[0][1] = true;
		Queue<int[]> q = new ArrayDeque<>();
		q.add(new int[] { 0, 1 });

		while (!q.isEmpty()) {
			int qSize = q.size();
			while (qSize > 0) {
				qSize--;
				int arr[] = q.poll();
				int clip = arr[0]; // 복사
				int print = arr[1]; // 출력
				if (print == S) {
					System.out.println(answer);
					System.exit(0);
				}

				// 복사해서 저장
				if (!visited[print][print]) {
					q.add(new int[] { print, print });
					visited[print][print] = true;
				}

				// 붙여넣기
				if ((clip + print) <= S)
					if (!visited[clip][clip + print]) {
						q.add(new int[] { clip, clip + print });
						visited[clip][clip + print] = true;
					}

				// 삭제
				if (print > 1)
					if (!visited[clip][print - 1]) {
						q.add(new int[] { clip, print - 1 });
						visited[clip][print - 1] = true;
					}

			}
			answer++;
		}

		System.out.println(answer);
	}
}
