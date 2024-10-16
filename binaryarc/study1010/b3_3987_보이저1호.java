package study1010;

import java.beans.Visibility;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class b3_3987_보이저1호 {
	static int N,M;
	static char[][] map;
	static int[] dr = {-1,1,0,0};
	static int[] dc = {0,0,-1,1};
	static int PR,PC;
	static int ans;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new char[N][M];
		for(int i=0;i<N;i++) {
			String input = br.readLine();
			map[i] = input.toCharArray();
		}
		st = new StringTokenizer(br.readLine());
		PR = Integer.parseInt(st.nextToken());
		PC = Integer.parseInt(st.nextToken());
		ans = 0;
		for(int i=0;i<4;i++) {
			ans = Math.max(ans,simul(i, PR, PC));
		}
	}
	private static int simul(int dir,int r,int c) {
		boolean[][][] visited = new boolean[N][M][4];
		visited[r][c][dir] = true;
		int cnt = 0;
		while(true) {
			cnt++;
			int nr = r + dr[dir];
			int nc = c + dc[dir];
			if(nr < 0 || nr >= N || nc < 0 || nc >= M) {
				return cnt;
			}
			
			
		}
		
	}
}
