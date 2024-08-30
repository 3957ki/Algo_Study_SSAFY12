package day0827;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B_15723_2번_n단논법 {

	static boolean premise[][];
	static StringBuilder sb;
	static boolean flag;

	static boolean dfs(int y, int x) {
		if (y == x) {
			flag = true;
			return true;
		}

		for (int i = 0; i < 26; i++) {
			if (premise[y][i])
				dfs(i, x);
			if (flag)
				break;
		}
		if(flag)
			return true;
		else
			return false;

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		premise = new boolean[26][26];
		for (int i = 0; i < N; i++) {
			String str = br.readLine().trim();
			int num1 = str.charAt(0) - 'a';
			int num2 = str.charAt(str.length() - 1) - 'a';
			premise[num1][num2] = true;
		}
		int m = Integer.parseInt(br.readLine());
		for (int i = 0; i < m; i++) {
			String str = br.readLine().trim();
			int num1 = str.charAt(0) - 'a';
			int num2 = str.charAt(str.length() - 1) - 'a';
			flag = false;
			if(dfs(num1, num2)) sb.append("T").append('\n');
			else sb.append("F").append('\n');
		}
		System.out.println(sb);
	}
}
