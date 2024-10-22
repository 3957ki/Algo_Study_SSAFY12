package day1003;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B_27917_1_UDPC파티 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String str = br.readLine().trim();
		int uc = 0;
		int dp = 0;

		for (int i = 0; i < str.length(); i++) {
			char tmp = str.charAt(i);
			if (tmp == 'U' || tmp == 'C')
				uc++;
			if (tmp == 'D' || tmp == 'P')
				dp++;
		}
		// input end

		if (dp % 2 == 0) {
			if (dp / 2 < uc)
				sb.append("U");
		} else {
			if (dp / 2 + 1 < uc)
				sb.append("U");
		}
		
		if(dp>0)
			sb.append("DP");
		

		System.out.println(sb);

	}
}
