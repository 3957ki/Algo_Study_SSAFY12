package algo;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution_1_5650 {

	static int N;
	static int[][] stage;
	static int maxScore = 0;

	// 상 하 좌 우
	static int[] del_X = { 0, 0, -1, 1 };
	static int[] del_Y = { -1, 1, 0, 0 };

	// 1 : 좌 -> 상, 하 -> 우
	// 2 : 좌 -> 하, 상 -> 우
	// 3 : 우 -> 하, 상 -> 좌
	// 4 : 우 -> 상, 하 -> 좌

	static int[][] blockDir = {{},
			// 1이랑 부딪히고 현재 방향이 상 하 좌 우
			{ 1, 3, 0, 2 },
			// 2랑 부딪히고 현재 방향이 상 하 좌 우
			{ 3, 0, 1, 2 },
			// 3이랑 부딪히고 현재 방향이 상 하 좌 우
			{ 2, 0, 3, 1 },
			// 4랑 부딪히고 현재 방향이 상 하 좌 우
			{ 1, 2, 3, 0 },
			// 5랑 부딪히고 현재 방향이 상 하 좌 우 -> 반대
			{ 1, 0, 3, 2 } };

	static List<Point>[] warm;
	
	
	

	static void game(int startX, int startY, int dir) {

		int score = 0;

		int nowX = startX;
		int nowY = startY;

		while (true) {

			nowX = nowX + del_X[dir];
			nowY = nowY + del_Y[dir];

			// 종료 조건 : 제자리, 블랙홀
			if (nowX == startX && nowY == startY) {
				maxScore = Math.max(maxScore, score);
				break;
			}

			if (isIn(nowX) && isIn(nowY) && stage[nowY][nowX] == -1) {
				maxScore = Math.max(maxScore, score);
				break;
			}
			// 종료 조건 끝

			// 벽에 부딪히면 (범위를 벗어나면) -> 반대방향으로
			if (!isIn(nowX) || !isIn(nowY)) {

				if (dir == 0)
					dir = 1;
				else if (dir == 1)
					dir = 0;
				else if (dir == 2)
					dir = 3;
				else
					dir = 2;

				score++;
				continue;
			}

			int value = stage[nowY][nowX];

			// 1 : 좌 -> 상, 하 -> 우
			// 2 : 좌 -> 하, 상 -> 우
			// 3 : 우 -> 하, 상 -> 좌
			// 4 : 우 -> 상, 하 -> 좌
			// 5 : 반대
			if (value >= 1 && value <= 5) {
				dir = blockDir[value][dir];
				score++;
			}
			// 웜홀 만났을
			else if (value >= 6 && value <= 10) {
				
				int tmpx = warm[value].get(0).x;
				int tmpy = warm[value].get(0).y;
				
				if (nowX == tmpx && nowY == tmpy) {
					nowX = warm[value].get(1).x;
					nowY = warm[value].get(1).y;
				} else {
					nowX = tmpx;
					nowY = tmpy;
				}
			}
		}
	}

	static boolean isIn(int num) {

		if (num >= 0 && num < N) {
			return true;
		} else {
			return false;
		}

	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine().trim());
		
		
		
		// 테스트케이스 시작 
		for (int t = 1; t <= T; t++) {
			
			maxScore = 0;
			warm = new ArrayList[11];
			
			// 입력 받기
			N = Integer.parseInt(br.readLine().trim());
			
			for (int i = 6; i <= 10; i++) {
				warm[i] = new ArrayList<>();
			}

			stage = new int[N][N];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					stage[i][j] = Integer.parseInt(st.nextToken());

					if (stage[i][j] >= 6) {
						warm[stage[i][j]].add(new Point(j, i));
					}
				}
			}

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {

					if (stage[i][j] != 0)
						continue;

					// 0 이면 함수 호출
					// 방향별로
					for (int d = 0; d < 4; d++) {

						game(j, i, d);

					}
				}
			}

			//sb.append('#').append(t).append(' ').append(maxScore).append('\n');
			System.out.println("#" + t + " " + maxScore);

		} // testcase for end
		//System.out.println(sb);
	} // main end
} // class end
