import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class p2_5567 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());
		boolean[][] arr = new boolean[n+1][n+1];
		int answer = 0;
		for(int i = 0; i < m; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int node1 = Integer.parseInt(st.nextToken());
			int node2 = Integer.parseInt(st.nextToken());
			arr[node1][node2] = true;
			arr[node2][node1] = true;
		}
		Queue<Integer> queue = new LinkedList<>();
		boolean[] visited = new boolean[n+1];
		queue.add(1);
		visited[1] = true;
		for(int i = 2; i < n+1; i++) {
			if(!visited[i] && arr[1][i]) {
				queue.add(i);
				visited[i] = true;
				answer++;
			}
		}
		while(!queue.isEmpty()) {
			int start = queue.poll();
			for(int i = 1; i < n+1; i++) {
				if(!visited[i] && arr[start][i]) {
					visited[i] = true;
					answer++;
				}
			}
		}
		System.out.println(answer);
		
	}
}
