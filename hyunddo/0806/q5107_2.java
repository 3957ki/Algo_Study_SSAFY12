package day0806;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class q5107_2 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = 1;
		int N = 0;
		do {
//			String name[][] = new String[N][2];
			N = Integer.parseInt(br.readLine());
			if (N == 0) {
				break;
			}
			HashMap<String, String> name = new HashMap<>();
			HashMap<String, Boolean> visited = new HashMap<>();
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				String s = st.nextToken();
				name.put(s, st.nextToken());
				visited.put(s, false);
			}

			System.out.println(name);
			int answer = 0; // 고리개수
			for (String s : name.keySet()) {
				System.out.println(s);
				if (visited.get(s) == false) {
					answer++;
					visited.replace(s, true);
					String x = name.get(s);
					while (!x.equals(s)) {
						visited.replace(x, true);
						x = name.get(x);
					}
				}
			}
			System.out.println(T + " " + answer);
			T++;
		} while (N != 0);
	}
}
