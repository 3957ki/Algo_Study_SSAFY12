import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class 백준_행운의문자열 {
	static char[] S, answer;
	static int alpha[], count;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		S = br.readLine().toCharArray();
		alpha = new int[26];
		for(int i : S) alpha[i - 'a']++;
		answer = new char[S.length];
		count = 0;
		dfs(0);
		System.out.println(count);
	}
	static void dfs(int cnt) {
		if(cnt == S.length) {
			count++;
			return;
		}
		
		for(int i = 0; i < 26; i++) {
			if(alpha[i] == 0) continue;
			answer[cnt] = (char) (i + 'a');
			if ( (cnt > 0) && (answer[cnt] == answer[cnt - 1]) ) continue;
			alpha[i]--;
			dfs(cnt+1);
			alpha[i]++;
		}
	}
}