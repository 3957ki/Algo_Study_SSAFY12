package study20250304;

import java.io.*;
import java.util.*;

public class Main_17396_백도어 {
	static class Node {
		int no;
		long time;
		public Node(int no, long time) {
			this.no = no;
			this.time = time;
		}
	}

	static int N, M;
	static boolean[] isSafe;
	static List<Node>[] graph;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		isSafe = new boolean[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			isSafe[i] = Integer.parseInt(st.nextToken()) == 1 ? false : true;
		}
		graph = new ArrayList[N];
		for (int i = 0; i < N; i++)
			graph[i] = new ArrayList<>();

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int t = Integer.parseInt(st.nextToken());
			graph[a].add(new Node(b,t));
			graph[b].add(new Node(a,t));
		}
		
		System.out.println(getMinDist(0));
	}
	private static long getMinDist(int start) {
		long[] dist = new long[N];
		Arrays.fill(dist, Long.MAX_VALUE);
		Queue<Node> pq = new PriorityQueue<>((o1,o2)->Long.compare(o1.time, o2.time));
		dist[start] = 0;
		pq.add(new Node(start,0));
		
		while(!pq.isEmpty()) {
			Node node = pq.poll();
			int curNode = node.no;
			long curTime = node.time;
			
			if(curTime > dist[curNode]) continue;
			
			if(curNode == N-1) {
				return curTime;
			}
			
			for(Node next : graph[curNode]) {
				if(next.no != N-1 && !isSafe[next.no])continue;
				
				long newTime = curTime + next.time;
				if(dist[next.no] > newTime) {
					dist[next.no] = newTime;
					pq.add(new Node(next.no,newTime));
				}
			}
			
		}
		return -1;
	}
}
