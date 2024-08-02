import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.StringTokenizer;

class Main {
	static boolean[][] graph;
	static int[] visited;
	static int N;
	static int answer;
	static ArrayList<LinkedList<Integer>> adList;
	public static void main (String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		graph = new boolean[N+1][N+1];
		visited = new int[N+1];
		for (int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			graph[a][b] = true;
			graph[b][a] = true;
		}
		answer = 0;
		BFS(1);
		for (int i=2;i<N+1;i++) {
			if (visited[i]<4 && visited[i] != 0) {
				answer++;
			}
		}
		System.out.println(answer);
		
	}
	private static void BFS(int start) {
		ArrayDeque<Integer> queue = new ArrayDeque<>();
		queue.add(start);
		visited[start] = 1;
		
		while(!queue.isEmpty()) {
			int cur = queue.poll();
			for (int i=0;i<N+1;i++) {
				if (graph[cur][i] && visited[i] == 0) {
					visited[i] = visited[cur]+1;
					queue.add(i);
				}
			}
		}
	}
	
}