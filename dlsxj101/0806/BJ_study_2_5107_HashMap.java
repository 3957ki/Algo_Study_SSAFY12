import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class BJ_study_2_5107_HashMap {
	static HashMap<String,String> map;
	static HashMap<String, Boolean> visited;
	static int N, answer;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int test_case = 1;

		while(true) {
			N = Integer.parseInt(br.readLine());
			if(N == 0) break;

			map = new HashMap<>(N);
			visited = new HashMap<>(N);

			for (int i = 1; i <= N; i++) {
				st = new StringTokenizer(br.readLine());
				String firstInput = st.nextToken();
				String secInput = st.nextToken();

				map.put(firstInput, secInput);
				visited.put(firstInput, false);
			}

			answer = 0;

			for(String key : map.keySet()) {
				if(!visited.get(key)) chk(key);
			}

			System.out.printf("%d %d%n", test_case, answer);
			test_case++;
		}

	}

	public static void chk(String start) {	//한 사이클이 돌면 answer를 증가시키게 해야 함
		String current = start;
		while (!visited.get(current)) {
			visited.put(current, true);
			
			String temp = map.get(current);
			current = temp;
		}
		answer++;
	}
}
