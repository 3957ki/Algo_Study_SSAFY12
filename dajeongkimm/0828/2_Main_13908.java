import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 비밀번호
 * 
 * 
 * @author KOREA
 *
 */
public class Main_13908 {
	static int n,m;

//	static boolean[] visited;
	static int answer;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		boolean[] visited = new boolean[10];
		if (m != 0) {
			st = new StringTokenizer(br.readLine());
			for (int i=0;i<m;i++) {
				int tmp= Integer.parseInt(st.nextToken());
				visited[tmp] = true;
			}
		}
		
		answer = 0;
		dfs(0,0,visited);
		System.out.println(answer);
		

	}
	public static void dfs(int cnt, int pass, boolean[] visited) {
		if (cnt == n) {
			if (pass == m) answer++;
			return;
		}
		
		for (int i=0;i<=9;i++) {
			if (visited[i]) {
				visited[i] = false;
				dfs(cnt+1, pass+1,visited);
				visited[i] = true;
				continue;
			}
			dfs(cnt+1, pass,visited);
		}
		
	}

}
