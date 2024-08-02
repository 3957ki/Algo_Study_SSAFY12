package com.ssafy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class q21938 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()); // 세로
		int M = Integer.parseInt(st.nextToken()); // 가로
		int answer = 0;

		int arr[][] = new int[N][M];
		for (int i = 0; i < N; i++) {
			StringTokenizer x = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				int a = Integer.parseInt(x.nextToken());
				int b = Integer.parseInt(x.nextToken());
				int c = Integer.parseInt(x.nextToken());
				arr[i][j] = (a + b + c) / 3;
			}
		}
		int T = Integer.parseInt(br.readLine()); // 경계값 T

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (arr[i][j] >= T) { // 경계값보다 큼
					arr[i][j] = 255;
				} else // 경계값보다 작음
					arr[i][j] = 0;
			}
		}

		ArrayList<int[]> queue = new ArrayList<>(); // 갈 방향 ...
//        ArrayList<Integer> queue = new ArrayList<>(); // 갈 방향 ...

		int dx[] = { 0, 0, -1, 1 };
		int dy[] = { -1, 1, 0, 0 };
		boolean visited[][] = new boolean[N][M];

//        ArrayList<ArrayList[]> map = new ArrayList<>(); // 갈 방향 ...
		int a = 0;
		int b = 0;
		int di = 0;
		int dj = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (!visited[i][j] && arr[i][j] == 255) {
					answer++;
					queue.add(new int[] { i, j });
					visited[i][j] = true;
					while (!queue.isEmpty()) {
						int index[] = queue.get(0);
						a = index[0];
						b = index[1];
						queue.remove(0);
						for (int x = 0; x < 4; x++) {
							di = a + dx[x];
							dj = b + dy[x];
							if (di >= 0 && dj >= 0 && di < N && dj < M && arr[di][dj] == 255) {
								if (!visited[di][dj] && arr[di][dj] == 255) {
									{
										queue.add(new int[] { di, dj });
										visited[di][dj] = true;
									}
								}
							}

						}
					}
				}
			}
		}

		System.out.println(answer);
	}
}