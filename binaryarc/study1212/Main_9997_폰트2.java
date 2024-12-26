package study1212;

import java.io.*;
import java.util.*;

public class Main_9997_폰트2 {
	static int N;
	static int abcMask;
	static List<Integer> list;
	static int ans;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		list = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			int bitmask = 0;
			for (int j = 0; j < str.length(); j++) {
				bitmask |= (1 << (str.charAt(j) - 'a'));
			}
			list.add(bitmask);
		}

		for (char alpha = 'a'; alpha <= 'z'; alpha++) {
			abcMask |= (1 << (alpha - 'a'));
		}

		ans = 0;
		solve(0, 0);
		System.out.println(ans);

	}

	public static void solve(int cnt, int mask) {

		if (cnt == N) {
			if (mask == abcMask)
				ans++;
			return;
		}

		solve(cnt + 1, mask);
		int bit = list.get(cnt);
		solve(cnt + 1, (mask | bit));
	}

}
