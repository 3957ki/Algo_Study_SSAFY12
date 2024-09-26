package study0822;
import java.io.*;
import java.util.*;
public class b2_1342_행운의문자열 {

	static int N;
	static int ans;
	static Set<Character> set;
	static int[] alpha;
	static String input_str;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		set = new HashSet<Character>();
		alpha = new int['z'+1];
		input_str = br.readLine().trim();
		for(char ch : input_str.toCharArray()) {
			set.add(ch);
			alpha[ch]++;
		}
		N = input_str.length();
		ans =0;
		dfs(0,' ');
		System.out.println(ans);
	}
	public static void dfs(int cnt,char prev_ch) {
		if(cnt == N) {
			ans++;
			return;
		}
		for(Character ch : set) {
			if(alpha[ch] == 0 || ch == prev_ch )continue;
			alpha[ch]--;
			dfs(cnt+1,ch);
			alpha[ch]++;
		}
			
		
	}

}
