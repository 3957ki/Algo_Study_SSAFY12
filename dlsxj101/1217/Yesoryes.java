import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Yesoryes {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		List<Integer> adjList[] = new List[N+1];
		for(int i = 1; i <= N; i++) {
			adjList[i] = new ArrayList<>();
		}
		
		for(int i = 1; i <= M; i++) {
			st = new StringTokenizer(br.readLine());
			
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			adjList[a].add(b);
		}
		
		int S = Integer.parseInt(br.readLine().trim());
		int gom[] = new int[S];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < S; i++) {
			gom[i] = Integer.parseInt(st.nextToken());
			if(gom[i] == 1) {
				System.out.println("Yes");
				return;
			}
		}
		
		Queue<Integer> q = new ArrayDeque<>();
		boolean visited[] = new boolean[N+1];
		
		q.add(1);
		visited[1] = true;
		
		while(!q.isEmpty()) {
			int index = q.poll();
			
			if(adjList[index].size() == 0) {
				System.out.println("yes");
				return;
			}
			
			A : for(int next : adjList[index]) {
				if(visited[next]) continue;
				
				visited[next] = true;
				for(int g : gom) {
					if(next == g) continue A;
					
				}
				q.add(next);
			}
		}
		System.out.println("Yes");
	}
}