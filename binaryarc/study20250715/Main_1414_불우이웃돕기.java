package study20250715;

import java.io.*;
import java.util.*;

public class Main_1414_불우이웃돕기 {
	static int N;

	static class Node implements Comparable<Node> {
		int from;
		int to;
		int w;

		public Node(int from, int to, int w) {
			this.from = from;
			this.to = to;
			this.w = w;
		}

		@Override
		public int compareTo(Node o) {
			return this.w - o.w;
		}
	}

	static List<Node> edges;
	static int[] parents;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine().trim());
		edges = new ArrayList<>();
		parents = new int[N];
		int total = 0;
		for (int i = 0; i < N; i++) {
			char[] input = br.readLine().trim().toCharArray();
			for (int j = 0; j < N; j++) {
				if(input[j] == '0') continue;
				int w = 0;
				if(input[j] >= 'a' && input[j] <= 'z') {
					w = input[j] - 'a'+ 1;
				}else if(input[j] >='A' && input[j] <= 'Z') {
					w =input[j]-'A'+27;
				}
				edges.add(new Node(i,j,w));
				total += w;
			}
		}
		
		for(int i=0;i<N;i++) {
			parents[i] = i;
		}
		
		Collections.sort(edges);
		
		int mstW = 0;
		int cnt = 0;
		for(Node edge : edges) {
			if(union(edge.from, edge.to)) {
				mstW += edge.w;
				cnt++;
				if(cnt == N-1) break;
			}
		}
		if(cnt != N -1) {
			System.out.println(-1);
		}else {
			System.out.println(total - mstW);
		}
	}
	
	public static int find(int child) {
		if(parents[child] == child) {
			return child;
		}
		return parents[child] = find(parents[child]);
	}
	
	public static boolean union(int a, int b) {
		int pA = find(a);
		int pB = find(b);
		
		if(pA == pB)return false;
		parents[pB] = pA;
		return true;
	}

}
