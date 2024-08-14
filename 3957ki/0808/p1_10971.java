import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p1_10971 {
	static int N;
	static int[][] arr;
	static boolean[] visited;
	static int answer = Integer.MAX_VALUE;
	static int sum = 0;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N+1][N+1];
		visited = new boolean[N+1];
		for(int i = 1; i <= N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 1; j <= N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
//		DFS
		visited[1] = true;
		DFS(1, 1, 1);
		System.out.println(answer);
	}
	
	static void DFS(int start, int first, int depth) {
//		N개의 도시를 다 방문했을 때
		if(depth == N) {
//			처음도시로 갈 수 없다면 패스
			if(arr[start][first] == 0) return;
//			마지막 비용 저장 후 최소값 구하기
			sum += arr[start][first];
			answer = Math.min(answer, sum);
			sum -= arr[start][first];
			return;
		}
		
		for(int i = 1; i <= N; i++) {
//			방문하지 않았고, 비용이 0이 아니며, 처음 도시로 돌아오는 것이 아닐 때 비용 저장 후 재귀
			if(!visited[i] && arr[start][i] != 0 && i != first) {
				visited[i] = true;
				sum += arr[start][i];
				DFS(i, first, depth+1);
				sum -= arr[start][i];
				visited[i] = false;
			}
		}
	}
}
