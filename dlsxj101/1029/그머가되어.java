import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class 그머가되어 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		List<Integer> adjList[] = new List[N+1];
		for(int i = 1; i <= N; i++) {
			adjList[i] = new ArrayList<>();
		}
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			
			adjList[start].add(end);
			adjList[end].add(start);
		}
		
		Queue<Integer> q = new ArrayDeque<>();
		boolean visited[] = new boolean[N+1];
		
		q.add(a);
		visited[a] = true;
		
		int depth = 0;
		while(!q.isEmpty()) {
			int size = q.size();
			
			while(size-->0) {
				int tmp = q.poll();
				if(tmp == b) {
					System.out.println(depth);
					return;
				}
				
				for(int i : adjList[tmp]) {
					if(visited[i]) continue;
					visited[i] = true;
					q.add(i);
				}
			}
			depth++;
		}
		System.out.println(-1);
	}
}