package algo;

import java.util.Scanner;

public class Main_1_10971 {
	
	static int[][] W;
	static int N;
	static boolean[] visited;
	static long result = Integer.MAX_VALUE;
	
	
	
	static void dfs(int start, long cost, int now, int vNum) {
		// 노드 다 방문했으면 돌아갈 수 있나 체크 후 결과
		if (vNum == N) {
			if (W[now][start] > 0) {
				result = Math.min(result, (cost+W[now][start]));
			}
			return;
		}
		
		//돌면서 0 이상으로 연결되어있고, 방문하지 않았다면 dfs로 진입, vNum으 방문 
		for (int i = 1; i <= N; i++) {
			if (start == i) continue;
			if (W[now][i] > 0 && !visited[i]) {
				visited[i] = true;
				dfs(start, cost+W[now][i], i, vNum+1);
				visited[i] = false; 	// 아니어서 돌아왔으면 false로
			}
		}
	}
	
	
	
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		W = new int[N+1][N+1];
		
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				W[i][j] = sc.nextInt();
			}
		}
		
		visited = new boolean[N+1];
		visited[1] = true;
		dfs(1, 0, 1, 1);
		

		System.out.println(result);
	}

}
