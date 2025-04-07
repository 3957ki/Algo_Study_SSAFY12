package algo250327;

import java.io.*;
import java.util.*;

public class Main_2866_문자열잘라내기 {
	static int R, C;
	static Set<String> set;
	static String[] strs;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		strs = new String[C];
		for(int i=0;i<C;i++)strs[i] = "";
		set = new HashSet<>();
		for (int i = 0; i < R; i++) {
			String temp = br.readLine();
			for (int j = 0; j < C; j++) {
				strs[j] = strs[j] + temp.charAt(j);
			}
		}

		int left = 0;
		int right = R - 1;
		int ans = 0;
		while (left <= right) {
			int mid = (left + right) / 2;
			if (isAvail(mid)) {
				left = mid + 1;
				ans = left;
			} else {
				right = mid - 1;
			}
		}
		System.out.println(ans);
	}

	private static boolean isAvail(int mid) {
		for(int i=0;i<C;i++) {
			String temp = strs[i].substring(mid+1,R);
			if(set.contains(temp)) {
				return false;
			}
			set.add(temp);
		}
		set.clear();
		return true;
		
	}

}
