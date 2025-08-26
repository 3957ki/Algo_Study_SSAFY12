package study20250715;

import java.io.*;
import java.util.*;

public class Main_10472_십자뒤집기 {
	static int[][] change = { { 0, 1, 3 }, { 0, 1, 2, 4 }, { 1, 2, 5 }, { 0, 3, 4, 6 }, { 1, 3, 4, 5, 7 },
			{ 2, 4, 5, 8 }, { 3, 6, 7 }, { 4, 6, 7, 8 }, { 5, 7, 8 } };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int P = Integer.parseInt(br.readLine().trim());
		while (P-- > 0) {
			int idx = 0;
			String goal = "";
			for (int i = 0; i < 3; i++, idx++) {
				char[] ch = br.readLine().toCharArray();
				for (char c : ch) {
					if (c == '*') {
						goal += "1";
					} else if (c == '.') {
						goal += "0";
					}
				}
			}
			
			int bit = Integer.parseInt(goal, 2);
			if(bit == 0) {
				System.out.println(0);
				continue;
			}
			System.out.println(bfs(bit));
		}
	}

	public static int bfs(int goal) {
		int click = 1;

		Queue<Integer> q = new ArrayDeque<>();
		Set<Integer> set = new HashSet<>();
		q.add(0);
		set.add(0);

		while (!q.isEmpty()) {
			int size = q.size();
			for (int i = 0; i < size; i++) {
				int cur = q.poll();

				for (int j = 0; j < 9; j++) {
					int next = cur;
					for(int color : change[j]) {
						int mask = 1 << color;
						next = next ^ mask;
					}
					if(set.contains(next))continue;
					if(next == goal)return click;
					q.add(next);
					set.add(next);
				}
			}
			click++;
		}
		return click;
	}

}
