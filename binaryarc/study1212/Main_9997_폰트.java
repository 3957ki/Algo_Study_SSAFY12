package study1212;

import java.io.*;
import java.util.*;

public class Main_9997_폰트 {
	static int N;
	static int abcMask;
	static List<String> list;
	static int ans;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		list = new ArrayList<>();
		for (int i = 0; i < N; i++)
			list.add(br.readLine());

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
		String str = list.get(cnt);
		for (int i = 0; i < str.length(); i++) {
			if(((mask & (1 << (str.charAt(i) - 'a'))) == 0)){
				mask |= (1 << (str.charAt(i) - 'a'));
			}
			
		}
		solve(cnt + 1, mask);
	}

}
