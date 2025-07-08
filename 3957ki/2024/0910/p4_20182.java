import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class p4_20182 {
	
	static final int INF = Integer.MAX_VALUE;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int start = Integer.parseInt(st.nextToken());
		int end = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		
		List<Edge>[] edges = new List[N+1];
		for(int i = 1; i <= N; i++) {
			edges[i] = new ArrayList<>();
		}
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			
			edges[A].add(new Edge(B, weight, 0));
			edges[B].add(new Edge(A, weight, 0));
			
		}
		
//		다익스트라
		PriorityQueue<Edge> pq = new PriorityQueue<>((o1, o2) -> o1.c - o2.c);
//		최대 간선 가중치 배열
		int[] maxEdge = new int[N+1];
		Arrays.fill(maxEdge, INF);
		maxEdge[start] = 0;
		pq.add(new Edge(start, 0, 0));
		
		int answer = -1;
		while(!pq.isEmpty()) {
			Edge e = pq.poll();
			int now = e.v;
//			도착점이라면 종료
			if(now == end) {
				answer = maxEdge[now];
				break;
			}
//			현재 경로 최대 간선이 더 크다면 패스
			if(e.c > maxEdge[now]) continue;
			
			for(Edge edge : edges[now]) {
				int next = edge.v;
//				가진 돈보다 많이들면 패스
				if(e.w+edge.w > C) continue;
				
//				next까지 최대간선이 더 작다면 갱신
				if(maxEdge[next] > Math.max(maxEdge[now], edge.w)) {
					maxEdge[next] = Math.max(maxEdge[now], edge.w);
					pq.add(new Edge(next, e.w+edge.w, maxEdge[next]));
				}
			}
		}
		
		System.out.println(answer);
		
	}
	
	static class Edge{
		int v, w, c;

		public Edge(int v, int w, int c) {
			this.v = v;
			this.w = w;
			this.c = c;
		}
		
	}

}