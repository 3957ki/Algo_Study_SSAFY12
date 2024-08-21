package algo;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;


public class Main07252 {
	
	static int[] dist;
	static Queue<Integer> q = new LinkedList<Integer>();
	static int n;
	static int m;
	
	public static void main(String[] args) {
		
		
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		m = sc.nextInt();
		
		
		ArrayList<Integer>[] graph = new ArrayList[n+1];
		dist = new int[n+1];
		
		
		for(int i = 1; i<n+1; i++) {
			graph[i] = new ArrayList<Integer>();
		}

		for (int i = 0; i<m; i++) {
			int j = sc.nextInt();
			int k = sc.nextInt();
			graph[j].add(k);
			graph[k].add(j);
			
		}
		
		
		boolean[] visit = new boolean[n+1];
		
		bfs(1, graph, visit);
		
		int result = 0;
		
		for (int i = 2; i<dist.length; i++) {
			if(dist[i] > 0 && dist[i] <= 2) {
				result++;
			}
		}
		
		
		System.out.println(result);
			
			
		}
		
			
	
	
	static void bfs(int start, ArrayList<Integer>[] graph, boolean[] visit) {
		
		q.offer(start);
		visit[start] = true;
		
		while(!q.isEmpty()) {
			
			int now = q.poll();
			//System.out.println("now " + now);
						
			if (graph[now].isEmpty()) {
				continue;
			}
			
			for(int i = 0; i < graph[now].size(); i++) {
				int node = graph[now].get(i);
				
				if(!visit[node] && ! q.contains(node) && dist[now] < 2) {
					visit[node] = true;
					dist[node] = dist[now] + 1;
					//System.out.println("dist now = " + dist[now]);
					q.offer(node);
				}
			}
			
			
		}
		
	}
	
	

}
