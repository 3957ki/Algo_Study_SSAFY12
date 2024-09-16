package study0903;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class b2_1189_컴백홈 {
	static int R,C,K;
	static int[] dr = {-1,1,0,0};
	static int[] dc = {0,0,-1,1};
	static char[][] map;
	static int ans;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		map = new char[R][];
		for(int i=0;i<R;i++) {
			map[i] = br.readLine().toCharArray();
		}
		ans = 0;
		dfs(1,R-1,0,new boolean[R][C]);
		System.out.println(ans);
	}
	static void dfs(int cnt,int r,int c, boolean[][] visit) {
		if(cnt == K && r==0 && c == C-1) {
			ans++;
		}
		visit[r][c] = true;
		for(int i=0;i<4;i++) {
			int nr = r + dr[i];
			int nc = c + dc[i];
			if(nr < 0 || nr >= R || nc < 0 || nc >= C)continue;
			if(visit[nr][nc] || map[nr][nc] == 'T')continue;
			dfs(cnt+1,nr,nc,visit);
		}
		visit[r][c] = false;
		
	}
}
