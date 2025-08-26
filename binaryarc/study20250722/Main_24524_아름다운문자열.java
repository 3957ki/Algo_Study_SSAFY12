package study20250722;

import java.io.*;
import java.util.*;

public class Main_24524_아름다운문자열 {
	static String S, T;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		S = br.readLine().trim();
		T = br.readLine().trim();
		
		Map<Character,Integer> map = new HashMap<>();
		for(int i =0;i<T.length();i++) {
			map.put(T.charAt(i),i);
		}
		
		int[] cnt = new int[T.length()];
		
		for (int i = 0; i < S.length(); i++) {
            if (!map.containsKey(S.charAt(i))) continue;
            int idx = map.get(S.charAt(i));
            
            if (idx == 0) {
                cnt[idx]++;
            } else if (idx > 0 && cnt[idx - 1] > 0) {
                cnt[idx - 1]--;
                cnt[idx]++;
            }
        }

		System.out.println(cnt[T.length() - 1]);

	}
}
