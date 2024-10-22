package day1022;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * 모든 알파벳 글자를 몇 칸 뒤의 알파벳으로
 * 암호 해독하기
 */

public class B_1_14584_암호해독 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String cyphertext = br.readLine().trim();
		int N = Integer.parseInt(br.readLine().trim());
		String arr[] = new String[N];
		for (int i = 0; i < N; i++) {
			arr[i] = br.readLine().trim();
		}

		for (int i = 0; i < 26; i++) {
			StringBuilder sb = new StringBuilder(cyphertext);
			for (int j = 0; j < cyphertext.length(); j++) {
				char str = cyphertext.charAt(j);
				sb.setCharAt(j, (char) ((str + i - 'a') % 26 + 'a'));
			}
			String str = sb.toString();
			for (int k = 0; k < N; k++) {
				if (str.contains(arr[k])) {
					System.out.println(str);
					System.exit(0);
				}
			}
		}
	}
}
