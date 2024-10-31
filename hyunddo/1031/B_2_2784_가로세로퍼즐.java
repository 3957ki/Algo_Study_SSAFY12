package day1031;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class B_2_2784_가로세로퍼즐 {
	static List<String> list;
	static boolean visited[];
	static String answer[];
	static boolean find;

	static void method(int cnt) {
		if (cnt == 3) {
			List<String> newList = new ArrayList<>();
			for (int t = 0; t < 6; t++) {
				newList.add(list.get(t));
			}
			for (int i = 0; i < 3; i++) { // 가로 체크
				boolean flag = false;
				for (int j = 0; j < newList.size(); j++) {
					if (newList.get(j).equals(answer[i])) {
						flag = true;
						newList.remove(j);
						break;
					}
				}
				if (!flag)
					return;
			}

			// 세로 체크
			for (int i = 0; i < 3; i++) {
				String tmp = "" + answer[0].charAt(i) + answer[1].charAt(i) + answer[2].charAt(i);
				boolean flag = false;
				for (int j = 0; j < newList.size(); j++) {
					if (newList.get(j).equals(tmp)) {
						flag = true;
						newList.remove(j);
						break;
					}
				}
				if (!flag)
					return;
			}
			find = true;
			for (int i = 0; i < 3; i++) {
				System.out.println(answer[i]);
			}
		}

		for (int i = 0; i < 6; i++) {
			if (find)
				break;
			if (visited[i])
				continue;
			answer[cnt] = list.get(i);
			visited[i] = true;
			method(cnt + 1);
			visited[i] = false;
		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		list = new ArrayList<>();
		for (int i = 0; i < 6; i++) {
			list.add(br.readLine().trim());
		}

		visited = new boolean[6];
		answer = new String[3];

		find = false;
		method(0);
		if (!find)
			System.out.println(0);
	}
}
