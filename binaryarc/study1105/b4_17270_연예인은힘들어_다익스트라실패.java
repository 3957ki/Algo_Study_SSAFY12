package study1105;

import java.awt.GradientPaint;
import java.io.*;
import java.util.*;

public class b4_17270_연예인은힘들어_다익스트라실패 {
	static int V, E;
	static int[][] graph;
	static int start, end;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		graph = new int[V + 1][V + 1];
		for (int i = 1; i <= V; i++) {
			Arrays.fill(graph[i], 987654321);
			graph[i][i] = 0;
		}
			
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			graph[a][b] = Math.min(graph[a][b], cost);
			graph[b][a] = Math.min(graph[b][a], cost);

		}
		st = new StringTokenizer(br.readLine());
		start = Integer.parseInt(st.nextToken());
		end = Integer.parseInt(st.nextToken());
		
		//플로이드와샬
		for(int k=1;k<=V;k++) {
			for(int i=1;i<=V;i++) {
				for(int j=1;j<=V;j++) {
					if(graph[i][k] + graph[k][j] < graph[i][j]) {
						graph[i][j] = graph[i][k] + graph[k][j];
					}
				}
			}
		}
		
		int sumMinDist = 987654321;
		for(int i=1;i<=V;i++) {
			if(i == start || i == end )continue;
			if(graph[start][i] == 987654321 || graph[end][i]==987654321)continue;
			//조건1.도달 가능 거리중 최소 거리
			sumMinDist = Math.min(sumMinDist, graph[start][i] + graph[end][i]);
		}
		
		int minDist=987654321;
		int res = -1;
		for(int i=1;i<=V;i++) {
			if(i == start || i == end )continue;
			if(graph[start][i] > graph[end][i])continue;
			if((graph[start][i] + graph[end][i]) == sumMinDist) {
				if(minDist > graph[start][i]) {
					minDist = graph[start][i];
					res = i;
				}
			}
		}
		System.out.println(res);
		
		
	}

}
