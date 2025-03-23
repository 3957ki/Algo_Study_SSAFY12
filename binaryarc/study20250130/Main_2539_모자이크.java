package study20250130;

import java.io.*;
import java.util.*;

public class Main_2539_모자이크 {
	static int r, c;
	static int paper;
	static int miss;
	static List<int[]> missList;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		paper = Integer.parseInt(br.readLine());
		missList = new ArrayList<>();
		miss = Integer.parseInt(br.readLine());
		for (int i = 0; i < miss; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			missList.add(new int[] { x, y });
		}
		Collections.sort(missList, (o1, o2) -> o1[1] - o2[1]);

		int left = 1;
		int right = Math.max(r, c);
		while (left <= right) {
			int mid = (left + right) / 2;
			if (isValid(mid)) {
				right = mid - 1;
			} else {
				left = mid + 1;
			}
		}
		System.out.println(left);

	}

	public static boolean isValid(int size) {
		int use_cnt = 0;
		int pre_cover = 0;
		for (int[] point : missList) {
			int cur_x = point[0];
			int cur_y = point[1];
			if (cur_x > size)
				return false; // 밑변에서 부터 시작해서 size만큼 가능
			if (pre_cover == 0 || pre_cover + size <= cur_y) {
				use_cnt++;
				pre_cover = cur_y;
				if(use_cnt > paper)return false;
				continue;
			}
		}
		if (use_cnt <= paper)
			return true;
		else
			return false;
	}

}
