package study1003;

import java.io.*;
import java.util.*;

public class b1_27919_UDPC파티 {
	static int V;

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		int uc = 0;
		int dp = 0;
		for(char ch : input.toCharArray()) {
			if(ch == 'U' || ch == 'C') {
				uc++;
			}else if(ch == 'D' || ch == 'P') {
				dp++;
			}
		}
		String ans = "";
		if(uc > ( (dp + 1) /2) ) {
			ans += "U";
		}
		if(dp > 0) {
			ans += "DP";
		}
		System.out.println(ans);
	}
}
