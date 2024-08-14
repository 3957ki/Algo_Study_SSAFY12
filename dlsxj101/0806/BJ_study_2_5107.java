import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_study_2_5107 {
	static String[] leftArr;
	static String[] rightArr;
	static boolean[] visited;
	static int N, answer;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int test_case = 1;
		
		while(true) {
			N = Integer.parseInt(br.readLine());
			if(N == 0) break;

			leftArr = new String[N + 1];
			rightArr = new String[N + 1];

			for (int i = 1; i <= N; i++) {
				st = new StringTokenizer(br.readLine());
				leftArr[i] = st.nextToken();
				rightArr[i] = st.nextToken();
			}

			visited = new boolean[N+1];
			answer = 0;
			
			for (int i = 1; i <= N; i++) {
				if(!visited[i]) chk(i);
			}

			System.out.printf("%d %d%n", test_case, answer);
			test_case++;
		}

	}

	public static void chk(int start) {	//한 사이클이 돌면 answer를 증가시키게 해야 함
		int current = start;
		while (!visited[current]) {
			visited[current] = true;
			
			for(int j = 1; j <= N; j++) {
				if(rightArr[current].equals(leftArr[j]) && !visited[j]) {
					current = j;
					break;
				}
			}
		}
		answer++;
	}
}
