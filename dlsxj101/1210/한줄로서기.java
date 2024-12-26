import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 한줄로서기 {
	static int answer[], input[];
	static int N;
	static boolean visited[];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine().trim());
		
		input = new int[N+1];
		st = new StringTokenizer(br.readLine());
		for(int i = 1; i <= N; i++) {
			input[i] = Integer.parseInt(st.nextToken());
		}
		
		answer = new int[N];
		visited = new boolean[N+1];
		dfs(0);
	}
	
	static void dfs(int cnt) {
		if(cnt == N) {
			for(int i = 0; i < N; i++) {
				int limit = input[answer[i]];
				for(int j = 0; j < i; j++) {
					if(limit < 0) return;
					if(answer[j] > answer[i]) {
						limit--;
					}
				}
				if(limit != 0) return;
			}
			for(int i : answer) {
				System.out.print(i+" ");
			}
			System.exit(0);
			return;
		}
		
		for(int i = 1; i <= N; i++) {
			if(visited[i]) continue;
			
			answer[cnt] = i;
			
			visited[i] = true;
			dfs(cnt+1);
			visited[i] = false;
		}
	}
}