package day1017;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

/*
 * 클래스 산책로 배열 만들기
 * x축 기준으로 정렬 후 반복문 사용해서 y축 같은 곳부터 ~
1. x값 증가, y값 같음
=> 그대로 직진
2. y값 같음, x값 이동
3. x값 증가, y값 다름
=> x값이 같을때 y 값 같은 곳 찾기
 */

public class B_3_11067_모노톤길 {

	static class Cafe implements Comparable<Cafe> {
		int x;
		int y;

		public Cafe(int x, int y) {
			this.x = x;
			this.y = y;
		}

		@Override
		public int compareTo(Cafe o) {
			int xCompariosn = Integer.compare(this.x, o.x);
			if (xCompariosn != 0)
				return xCompariosn;
			return Integer.compare(this.y, o.y);
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine().trim());
		for (int t = 1; t <= T; t++) {
			int n = Integer.parseInt(br.readLine().trim());
			Cafe cafe[] = new Cafe[n];
			for (int i = 0; i < n; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine().trim());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				cafe[i] = new Cafe(x, y);
			}
			// input end

			Arrays.sort(cafe);

			Cafe answer[] = new Cafe[n];
			int by = 0;
			int bx = 0;
			int zero = 0;
			if (cafe[0].y == 0)
				answer[0] = cafe[0];
			else if (cafe[0].y != 0) {
				while (true) {
					if (cafe[zero].x != 0)
						break;

					zero++;
				}
				for (int i = 0; i < zero; i++)
					answer[i] = cafe[zero - 1 - i];
				by = cafe[0].y;
				bx = cafe[0].x;
			}
			int cnt = 0;
			for (int i = zero; i < n; i++) {
//				System.out.println(bx + " " + by + " " + cafe[i].x + " " + cafe[i].y);
				if (cafe[i].y == by && cafe[i].x >= bx) { // y값은 그대로 x값은 커짐 (x값이 같을 때 y값이 제일 작음)
					if (cnt == 0) {
//						System.out.println("같은 가로 : " + cnt + " " + cafe[i].x + " " + cafe[i].y);
						answer[i] = cafe[i];
						by = cafe[i].y;
						bx = cafe[i].x;
					} else {
//						System.out.println("우회전 " + i);
						for (int c = 0; c <= cnt; c++) {
							answer[i - c] = cafe[i - cnt + c];
							by = cafe[i - c].y;
							bx = cafe[i - c].x;
						}
						cnt = 0;
					}
				} else if (cafe[i].x == bx && cafe[i].y > by) { // 이전 좌표값보다 y값이 더 큼
//					System.out.println("같은 세로 이동");
					answer[i] = cafe[i];
					by = cafe[i].y;
					bx = cafe[i].x;
				} else {
					cnt++;
				}
			}

//			int number = 0;
//			for (Cafe c : answer) {
//				System.out.println(number++ + " : " + c.x + " " + c.y);
//			}

			StringTokenizer st = new StringTokenizer(br.readLine().trim());
			int m = Integer.parseInt(st.nextToken());
			for (int i = 0; i < m; i++) {
				int num = Integer.parseInt(st.nextToken()) - 1;
				sb.append(answer[num].x).append(' ').append(answer[num].y).append('\n');
			}
		}
		System.out.println(sb);
	}
}