package study1031;

import java.util.*;
import java.io.*;

public class b2_2784_가로세로퍼즐 {
	static String[] str_arr;
	static boolean[] visited;

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		str_arr = new String[6];
		visited = new boolean[6];
		for (int i = 0; i < 6; i++) {
			str_arr[i] = sc.next();
		}

		permu(0, new int[3]);
		System.out.println(0);
	}

	public static void permu(int cnt, int[] arr) {
		if (cnt == 3) {
			char[][] chk_map = new char[3][];

			for (int i = 0; i < 3; i++) {
				chk_map[i] = str_arr[arr[i]].toCharArray();
			}

			boolean[] chk_visited = new boolean[6];
			boolean[] visited_c = new boolean[3];

			boolean find = false;
			for (int i = 0; i < 6; i++) {
				if (visited[i])
					continue;
				for (int j = 0; j < 3; j++) {
					if (visited_c[j])
						continue;
					String str = "" + chk_map[0][j] + chk_map[1][j] + chk_map[2][j];
					if (str.equals(str_arr[i])) {
						visited[i] = true;
						visited_c[j] = true;
						break;
					}
				}
				if (!visited[i])
					return;
			}

			for (int i = 0; i < 3; i++) {
				for (int j = 0; j < 3; j++) {
					System.out.print(chk_map[i][j]);
				}
				System.out.println();
			}
			System.exit(0);
		}

		for (int i = 0; i < 6; i++) {
			if (visited[i])
				continue;
			visited[i] = true;
			arr[cnt] = i;
			permu(cnt + 1, arr);
			visited[i] = false;
		}
	}
}
