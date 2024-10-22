package day1022;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

/*
 * N개의 문제
 * 문제의 난이도 : 정수로 수치화
 * 캠프에서 사용할 문제는 두개 이상
 * L <= 문제 난이도 합 <= R
 * 가장 어려운 - 가장 쉬운 >= x
 */
public class B_3_16938_캠프준비 {

	static int N, L, R, X;
	static int level[];
	static boolean visited[];
	static int answer;

	static void DFS(int depth, int sum, int maxV, int minV, int cnt) {
		if (sum > R) {
//			System.out.println("max : " + sum);
			return;
		}
		if (depth == N) {
			if (sum < L) {
//				System.out.println("min : " + sum);
				return;
			}
			if (maxV - minV < X)
				return;
//			System.out.println(sum+" "+cnt);
			answer++;
			return;
		}
//		visited[cnt] = true;
		DFS(depth + 1, sum + level[depth], Math.max(maxV, level[depth]), Math.min(minV, level[depth]), cnt + 1);
//		visited[cnt] = false;
		DFS(depth + 1, sum, maxV, minV, cnt);
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine().trim());
		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine().trim());
		level = new int[N];
		for (int i = 0; i < N; i++) {
			level[i] = Integer.parseInt(st.nextToken());
		}
		// input end

		answer = 0;
		DFS(0, 0, 0, Integer.MAX_VALUE, 0);
		System.out.println(answer);
	}
}
