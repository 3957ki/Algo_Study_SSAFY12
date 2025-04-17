package study20250417;

import java.io.*;
import java.util.*;

public class Main_20955_민서의응급수술 {
	static int N, M;
	static int[] parents;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		parents = new int[N + 1];
		Arrays.fill(parents, -1);

		int addCnt = 0;
		int removeCnt = 0;
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			if(union(a, b)) {
				addCnt++;
			}else {
				removeCnt++;
			}
		}

		System.out.println(removeCnt + ((N - addCnt) - 1));
	}

	static int find(int a) {
		return parents[a] < 0 ? a : (parents[a] = find(parents[a]));
	}

	static boolean union(int a, int b) {
		int rootA = find(a);
		int rootB = find(b);

		if(rootA == rootB)return false;
		
		if(parents[rootA] > parents[rootB]) {
			int t = rootA;
			rootA = rootB;
			rootB = t;
		}
		parents[rootA] += parents[rootB];
		parents[rootB] = rootA;
		return true;
	}
}
