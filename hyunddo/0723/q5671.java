import java.io.*;
import java.util.*;

public class q5671 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = "";

		while ((input = br.readLine()) != null) {
			StringTokenizer st = new StringTokenizer(input);
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			int result = 0;

			for (int i = N; i <= M; i++) {
				String str = Integer.toString(i);
				int cnt = 0;
				for (int a = 0; a < str.length() - 1; a++) {
					for (int b = 1; b < str.length(); b++) {
						if (a == b)
							continue;
						else if (str.charAt(a) == str.charAt(b)) { // 같으면 cnt++
							cnt++;
							break;
						}
					}
				}
				if (cnt == 0) // cnt에 하나도 안 더해졌으면
					result++;
			}
			System.out.println(result);
		}
	}
}
