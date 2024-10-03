package d1003;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class prob3 {
	static int r2;
	static int c2;
	static int map[][];

	public static void main(String[] args) {
		// 10*9
		// 직선 움직임
		int sdy[] = { -1, 0, 1, 0 };
		int sdx[] = { 0, 1, 0, -1 };

		// 대각선 움직임
		int ddy[] = { -1, -1, 1, 1 };
		int ddx[] = { -1, 1, 1, -1 };

		map = new int[10][9];
		Scanner sc = new Scanner(System.in);
		int r1 = sc.nextInt();
		int c1 = sc.nextInt();
		Queue<int[]> q = new ArrayDeque<>();
		map[r1][c1] = 1;
		q.add(new int[] { r1, c1 });
		r2 = sc.nextInt();
		c2 = sc.nextInt();

		// bfs
		while (!q.isEmpty()) {
			int[] cur = q.poll();
			int cury = cur[0];
			int curx = cur[1];
			int curdist = map[cury][curx];
			// move
			for (int d = 0; d < 4; d++) {
				// 직선 방향 움직임 : d_s
				int newy = cury + sdy[d];
				int newx = curx + sdx[d];
				if (!isValid(newy, newx) || isGoal(newy, newx))
					continue;
				// 왼쪽 대각 방향
				{
					int y1 = newy + ddy[d];
					int x1 = newx + ddx[d];
					if (isValid(y1, x1) && !isGoal(y1, x1)) {
						y1 += ddy[d];
						x1 += ddx[d];
						if (isGoal(y1, x1)) {
							//printMap();
							System.out.println(curdist);
							return;
						}
						if (isValid(y1, x1) && map[y1][x1] == 0) {
							map[y1][x1] = curdist + 1;
							q.add(new int[] { y1, x1 });
						}
					}
				}
				// 오른쪽 대각 방향
				{
					int y1 = newy + ddy[(d+1)%4];
					int x1 = newx + ddx[(d+1)%4];
					if (isValid(y1, x1) && !isGoal(y1, x1)) {
						y1 += ddy[(d+1)%4];
						x1 += ddx[(d+1)%4];
						if (isGoal(y1, x1)) {
							//printMap();
							System.out.println(curdist);
							return;
						}
						if (isValid(y1, x1) && map[y1][x1] == 0) {
							map[y1][x1] = curdist + 1;
							q.add(new int[] { y1, x1 });
						}
					}
				}
			}
		}
		System.out.println(-1);
	}

	static boolean isValid(int y, int x) {
		if (y < 0 || y >= 10 || x < 0 || x >= 9)
			return false;
		return true;
	}

	static boolean isGoal(int y, int x) {
		if (y == r2 && x == c2)
			return true;
		return false;
	}
	
	static void printMap() {
		for(int i = 0;i < 10;i++) {
			for(int j = 0;j < 9;j++) {
				System.out.print(map[i][j]+" ");
			}
			System.out.println();
		}
	}
}
