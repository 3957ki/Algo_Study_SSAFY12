package a0827;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_4번_색종이붙이기_백트래킹 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	static int[][] paper = new int[10][10];
	static int[] colored = {0, 5, 5, 5, 5, 5};
	static int minPaper = Integer.MAX_VALUE;
	static int N = 10;
	
	public static void main(String[] args) throws IOException {
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				paper[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		solution(0, 0);
		if (minPaper == Integer.MAX_VALUE) {
			System.out.println(-1);
		} else {
			System.out.println(minPaper);
		}
	}
	
	private static void solution(int depth, int cnt) {
		// 모든 색종이를 탐색하면 리턴
		if (depth == N * N) {
			minPaper = Math.min(cnt, minPaper);
			return;
		}

		int x = depth / N;
		int y = depth % N;
		// 종이의 면이 0인 경우
		if (paper[x][y] == 1) {
			// 종이의 면이 1인 경우 
			for (int i = 5; i >= 1; i--) {
				// 종이가 들어가는 지 체크
				if (checkAndFill(x, y, i)) {
					solution(depth + 1, cnt + 1);
					recover(x, y, i);
				}
			}
		} else {
			solution(depth + 1, cnt);
		}
		
	}
	
	private static boolean checkAndFill(int x, int y, int size) {
		if (colored[size] <= 0) return false;
		if (x + size > N || y + size > N) return false;
		
		// 입력에 주어진 색종이 크기만큼 1을 검사하기
		for (int i = x; i < x + size; i++) {
			for (int j = y; j < y + size; j++) {
				if (paper[i][j] != 1) return false;
			}
		}
	
		// 색종이를 붙일 수 있다면 모두 2로 바꿔주기
		for (int i = x; i < x + size; i++) {
			for (int j = y; j < y + size; j++) {
				paper[i][j] = 2;
			}
		}
		
		// 사용할 수 있는 색종이의 개수 줄이기
		colored[size]--;
		return true;
	}
	
	private static void recover(int x, int y, int size) {
		// 1로 다시 원복시키기
		for (int i = x; i < x + size; i++) {
			for (int j = y; j < y + size; j++) {
				paper[i][j] = 1;
			}
		}
		colored[size]++;
	}
}
