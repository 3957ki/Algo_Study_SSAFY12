package study20250501;

import java.io.*;
import java.util.*;

public class Main_16965_구간과쿼리 {
	static class Node{
		int seq;
		int x,y;
		public Node(int seq,int x,int y) {
			this.seq = seq;
			this.x = x;
			this.y = y;
		}
	}
	
	static List<Integer>[] graph;
	static List<Node> nodes;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();
		
		int n = Integer.parseInt(br.readLine().trim());
		
		graph = new ArrayList[n+1];
		for(int i=1;i<=n;i++)graph[i] = new ArrayList<>();
		nodes = new ArrayList<>();
		
		int curInputSeq = 1;
		for (int qn = 0; qn < n; qn++) {
			st = new StringTokenizer(br.readLine());
			int query = Integer.parseInt(st.nextToken());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			if(query == 1) {
				Node input = new Node(curInputSeq,x,y);
				for(Node node : nodes) {
					if(node.x < x && x < node.y || node.x < y && y < node.y) {
						graph[curInputSeq].add(node.seq);
					}
					if(x < node.x && node.x < y || x < node.y && node.y < y) {
						graph[node.seq].add(curInputSeq);
					}
				}
				nodes.add(input);
				curInputSeq++;
			}else {
				if(bfs(x,y,n)) {
					sb.append(1).append('\n');
				}else {
					sb.append(0).append('\n');
				}
			}
		}
		System.out.println(sb.toString());
	}
	static boolean bfs(int start, int end,int n) {
		Queue<Integer> q = new ArrayDeque<>();
		q.add(start);
		boolean[] visited = new boolean[n+1];
		visited[start] = true;
		
		while(!q.isEmpty()) {
			int cur = q.poll();
			for(int next : graph[cur]) {
				if(next == end)return true;
				
				if(visited[next])continue;
				q.add(next);
				visited[next]= true;
			}
		}
		return false;
	}
}
