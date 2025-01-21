package study20250107;

import java.io.*;
import java.util.*;

public class Main_1662_압축 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		int len = 0;
		int pre_num = 1;
		Deque<int[]> q = new ArrayDeque<>();
		for (int i = 0; i < input.length(); i++) {
			char cur_ch = input.charAt(i);
			if (cur_ch == '(') {
				q.addFirst(new int[] { len - 1, pre_num });
				len = 0;
				continue;
			}

			if (cur_ch == ')') {
				int[] cur = q.pollFirst();
				len = cur[0] + (cur[1] * len);
				continue;
			}

			if (cur_ch != ')' && cur_ch - '0' <= 9) {
				pre_num = cur_ch - '0';
				len++;
				continue;
			}
		}
		System.out.println(len);
	}

}
