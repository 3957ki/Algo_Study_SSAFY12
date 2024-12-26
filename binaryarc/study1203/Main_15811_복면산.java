package study1203;

import java.io.*;
import java.util.*;

public class Main_15811_복면산 {
	static char[] aStr, bStr;
	static char[] cStr;
	static Set<Character> set;
	static Map<Character, Integer> map;
	static int N;
	static List<Character> list;
	static boolean[] visited;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		aStr = st.nextToken().toCharArray();
		bStr = st.nextToken().toCharArray();
		cStr = st.nextToken().toCharArray();
		set = new HashSet<>();
		list = new ArrayList<>();
		for (char ch : aStr) {
			set.add(ch);
		}
		for (char ch : bStr) {
			set.add(ch);
		}
		for (char ch : cStr) {
			set.add(ch);
		}

		map = new HashMap<>();
		for (char ch : set) {
			map.put(ch, 0);
		}
		N = set.size();
		list.addAll(set);
		visited = new boolean[10];
		backtrack(0, 0);
		System.out.println("NO");
	}

	public static void backtrack(int cnt, int idx) {
		if (cnt == N) {
			int ten = 1;
			int resA = 0;
			for (int i = aStr.length - 1; i >= 0; i--) {
				resA += map.get(aStr[i]) * ten;
				ten *= 10;
			}
			
			ten = 1;
			int resB = 0;
			for (int i = bStr.length - 1; i >= 0; i--) {
				resB += map.get(bStr[i]) * ten;
				ten *= 10;
			}
			
			ten = 1;
			int resC = 0;
			for (int i = cStr.length - 1; i >= 0; i--) {
				resC += map.get(cStr[i]) * ten;
				ten *= 10;
			}
			
			if(resA + resB == resC) {
				System.out.println("YES");
				System.exit(0);
			}
			return;
		}

		for (int i = 0; i <= 9; i++) {
			if (visited[i])
				continue;
			map.put(list.get(cnt), i);
			visited[i] = true;
			backtrack(cnt + 1, idx + 1);
			visited[i] = false;
		}
	}
}
