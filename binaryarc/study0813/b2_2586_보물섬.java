package study0813;
/*
 * bfs
 * 모든점 방문하기 위해 bfs 함수 안에서 방문배열 사용
 * 
 */
import java.io.*;
import java.util.*;
public class b2_2586_보물섬 {
	static int n,m;
	static char[][] map;
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	public static class Pair{
		int x;
		int y;
		int d;
		public Pair(int x, int y,int d) {
			this.x = x;
			this.y = y;
			this.d = d;
		}
	}
	public static int bfs(int x,int y) {
		Queue<Pair> q = new ArrayDeque<Pair>();
		boolean[][] visited = new boolean[n][m];
		visited[x][y] = true;
		int res =0;
		q.add(new Pair(x,y,0));
		while(!q.isEmpty()) {
			Pair p= q.poll();
			res = Math.max(res,p.d);
			for(int k=0;k<4;k++) {
				int nx = p.x + dx[k];
				int ny = p.y + dy[k];
				if(nx >=0 && nx < n && ny >=0 && ny < m && !visited[nx][ny] && map[nx][ny]=='L') {
					visited[nx][ny] = true;
					q.add(new Pair(nx ,  ny , p.d+1));
				}
			}
		}
		return res;
	}
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m=  Integer.parseInt(st.nextToken());
		map = new char[n][m];
		
		for(int i=0; i <n ; i++) {
			map[i] = br.readLine().toCharArray();
		}
		int ans=0;
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				if(map[i][j]=='L' ) {
					ans = Math.max(ans, bfs(i, j));
				}
			}
		}
		System.out.println(ans);
	}
	
	

}
