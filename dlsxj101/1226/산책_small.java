import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class 산책_small {

	static int N, M, S, E;
	static List<Integer> adjList[];
	static boolean visited[];
	static int route[];	//방문하는 정점의 루트노드를 기록(탐색하는 경로를 기록하는 효과가 있음)

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		adjList = new List[N+1];
		for(int i = 1; i <= N; i++) {
			adjList[i] = new ArrayList<>();
		}

		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());

			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());

			adjList[A].add(B);
			adjList[B].add(A);
		}
		
		for(int i = 1; i <= N; i++) {
			Collections.sort(adjList[i]);
		}

		st = new StringTokenizer(br.readLine());
		S = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		
		visited = new boolean[N+1];
		route = new int[N+1];
		
		int ans = 0;
		ans += bfs(S, E);
		
		//두번째 bfs를 시작하기 전에 방문배열 초기화
		Arrays.fill(visited, false);
		
		//route 배열에 기록해놓은 경로정보를 이용하여 두번째 bfs를 시작하기 전에 기존 방문 경로를 방문하지 않도록 처리
		int visitedVertex = route[E];
		while(true) {
			if(visitedVertex == 0) break;
			
			visited[visitedVertex] = true;
			visitedVertex = route[visitedVertex];
		}
		
		visited[S] = false;
		ans += bfs(E, S);
		
		System.out.println(ans);
	}

	static int bfs(int S, int E) {
		Queue<Integer> q = new ArrayDeque<>();

		q.add(S);
		visited[S] = true;

		int depth = 0;
		while(!q.isEmpty()) {
			int size = q.size();

			depth++;

			for(int s = 0; s < size; s++) {
				int now = q.poll();
				
				for(int next : adjList[now]) {
					if(visited[next]) continue;
					
					visited[next] = true;
					route[next] = now;
					q.add(next);
					
					if(next == E) return depth;
				}
			}		
		}
		return Integer.MIN_VALUE;
	}
}
