package study0801;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class b2_21938 {
	static class Node{
		int x;
		int y;
		public Node(int x,int y) {
			this.x = x;
			this.y = y;
		}
	}
	static int N,M;
	static int[][] screen;
	static int T;
	static boolean[][] visited;
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	
	public static void bfs(int r,int c) {
		
		Queue<Node> q = new ArrayDeque<Node>();
		q.offer(new Node(r,c));
		visited[r][c] =true;
		while(!q.isEmpty()) {
			Node n = q.poll();
			for(int k=0;k<4;k++) {
				int nx = dx[k] + n.x;
				int ny = dy[k] + n.y;
				if(nx >= 0 && nx < N && ny >=0 && ny < M && 
						!visited[nx][ny] && screen[nx][ny] == 1) {
					q.offer(new Node(nx,ny));
					visited[nx][ny] = true;
				}
			}
		}
	}
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st =  new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		screen = new int[N][M];
		visited = new boolean[N][M];
		for(int i=0;i<N;i++) {
			st =  new StringTokenizer(br.readLine());
			for(int j=0;j<M;j++) {
				int R = Integer.parseInt(st.nextToken());
				int G = Integer.parseInt(st.nextToken());
				int B = Integer.parseInt(st.nextToken());
				screen[i][j] = (R+G+B)/3;
			}
		}
		T = Integer.parseInt(br.readLine());
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				if(screen[i][j] < T) screen[i][j] = 0;
				else screen[i][j] = 1;
			}
		}
		int ans=0;
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				if(screen[i][j] == 1 && !visited[i][j]) {
					bfs(i,j);
					ans++;
				}
			}
		}
		System.out.println(ans);
		
	}

}
