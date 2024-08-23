import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;

/**
 * 모든 문자가 같지 않은 문자열 : 행운의 문자열
 * 서로 다른 행운의 문자열이 몇 개인지?
 * @author SSAFY
 *
 */
public class Main_1342 {
	static String S; // S의 길이 <= 10
	static char[] arr;
	static char[] tmp;
	
	static int[] alpha;
	
	static int answer;
	
	static HashSet<String> set;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		S = br.readLine();
		arr = S.toCharArray();
		alpha = new int[26];
		
		for (char a : arr) {
			alpha[a-'a']++;
		}
		
//		tmp = new char[S.length()];
		
		answer = 0;
		
		make_lucky(0,-1);
		System.out.println(answer);
		

	}
	public static void make_lucky(int cnt, int before) {
		if (cnt == S.length()) {
			answer++;
		}
		for (int i=0;i<26;i++) {
			if (alpha[i]>0 && i != before) {
				alpha[i]--;
				make_lucky(cnt+1, i);
				alpha[i]++;
			}
		}
		
		
	}

}
