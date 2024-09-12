import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 컴백홈 {
	static int R, C, K, ans;
	static char map[][];
	static int dr[] = {-1, 1, 0, 0};	// 상 하 좌 우
	static int dc[] = {0, 0, -1, 1};
	static boolean visited[][];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		map = new char[R][C];
		visited = new boolean[R][C];
		
		for(int i = 0; i < R; i++) {
			String str = br.readLine();
			for(int j = 0; j < C; j++) {
				map[i][j] = str.charAt(j);
			}
		}
		ans = 0;
		visited[R-1][0] = true;
		dfs(R-1, 0, 1);
		
		System.out.println(ans);
	}
	
	static void dfs(int r, int c, int cnt) {
		if(cnt > K) return;
		if( r==0 && c==C-1 ) {
			if(cnt==K) ans++;
			return;
		}
		
		for(int d = 0; d < 4; d++) {
			int nr = r + dr[d];
			int nc = c + dc[d];
			
			if( (nr==R) || (nc==C) || (nr<0) || (nc<0) ) continue;	//경계조건
			if( visited[nr][nc] ) continue;
			if(map[nr][nc] == 'T') continue;
			visited[nr][nc] = true;
			dfs(nr, nc, cnt+1);
			visited[nr][nc] = false;
		}
	}
}
