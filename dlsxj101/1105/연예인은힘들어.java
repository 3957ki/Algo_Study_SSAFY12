import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 연예인은힘들어 {
	
	static int V, M, J, S;
	static List<Node> adjList[];
	
	static class Node implements Comparable<Node>{
		int index;
		int cost;
		public Node(int index, int cost) {
			this.index = index;
			this.cost = cost;
		}
		@Override
		public int compareTo(Node o) {
			return Integer.compare(this.cost, o.cost);
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		V = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		adjList = new List[V+1];
		for(int i = 1; i <= V; i++) {
			adjList[i] = new ArrayList<>();
		}
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			adjList[a].add(new Node(b, c));
			adjList[b].add(new Node(a, c));
		}
		
		st = new StringTokenizer(br.readLine());
		J = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		
		int distJ[] = dijkstra(J);
		int distS[] = dijkstra(S);
//		System.out.println(Arrays.toString(distJ));
//		System.out.println(Arrays.toString(distS));
		
		int min = Integer.MAX_VALUE;
		for(int i = 1; i <= V; i++) {	//둘의 최단 시간의 최솟값 구하기(조건 2)
			
			if(distJ[i] == Integer.MAX_VALUE || distS[i] == Integer.MAX_VALUE) continue;
			if( i==S || i==J ) continue;	//조건 1
			
			min = Math.min(min, distJ[i]+distS[i]);
		}
		
		List<Integer> list = new ArrayList<>();
		for(int i = 1; i <= V; i++) {
			
			if(distJ[i] == Integer.MAX_VALUE || distS[i] == Integer.MAX_VALUE) continue;
			if( i==S || i==J ) continue;	//조건 1
			if(distJ[i] > distS[i]) continue;	//조건 3
			
			if(distJ[i]+distS[i] == min) list.add(i);
		}
		
		//조건 4 검토
		int answer = -1;
		min = Integer.MAX_VALUE;
		
		for(int i : list) {
			int tmp = min;
			min = Math.min(min, distJ[i]);
			
			//최솟값 갱신이 일어나면 answer를 해당 인덱스 값으로 갱신
			if(tmp != min) answer = i;
		}
		System.out.println(answer);
	}
	
	static int[] dijkstra(int start) {
		int dist[] = new int[V+1];
		boolean visited[] = new boolean[V+1];
		Arrays.fill(dist, Integer.MAX_VALUE);
		dist[start] = 0;
		
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.add(new Node(start, 0));
		
		while(!pq.isEmpty()) {
			Node tmp = pq.poll();
			int nowVertex = tmp.index;
			
			if(visited[nowVertex]) continue;
			visited[nowVertex] = true;
			
			for(Node next : adjList[nowVertex]) {
				
				if(dist[next.index] > dist[nowVertex] + next.cost) {
					dist[next.index] = dist[nowVertex] + next.cost;
					
					pq.add(new Node(next.index, dist[next.index]));
				}
			}
		}
		
		return dist;
	}
}