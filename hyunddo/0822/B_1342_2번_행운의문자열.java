package day0822;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class B_1342_2번_행운의문자열 {

	static int answer = 0;
	static int string[];
	static int n;

	static void dfs(int cnt, int s) {
		if (cnt == n) {
			answer++;
			return;
		}

		for (int i = 0; i <= 26; i++) {
			if (string[i] == 0)
				continue;
			if (i != s) {
				string[i]--;
				dfs(cnt + 1, i);
				string[i]++;
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		string = new int[27];
		n = str.length();
		for (int i = 0; i < str.length(); i++) {
			string[str.charAt(i) - 'a']++;
		}
		dfs(0, 100);
		System.out.println(answer);
	}
}
