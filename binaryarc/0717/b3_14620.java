package algostudy0717;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class b3_14620 {
	static Integer[][] map;
	static Integer[][] valueMap;
	static boolean[][] visited;
	static int N;
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	static int ans = 987654321;
	
	
	public static boolean chkVisted(int r,int c) {
		
		if(visited[r][c])return false;
		for(int i=0;i<4;i++) {
			int nx = r+dx[i];
			int ny = c+dy[i];
			if(!rangeChk(nx,ny) || visited[nx][ny]) return false;
		}
		
		return true;
	}
	
	public static void visitProc(int r,int c) {
		visited[r][c] = true;
		for(int i=0;i<4;i++) {
			int nx = r+dx[i];
			int ny = c+dy[i];
			visited[nx][ny] = true;
		}
	}
	
	public static void resetProc(int r,int c) {
		visited[r][c] = false;
		for(int i=0;i<4;i++) {
			int nx = r+dx[i];
			int ny = c+dy[i];
			visited[nx][ny] = false;
		}
	}
	
	
	public static boolean rangeChk(int r,int c) {
		return r >= 0 && r < N && c >= 0 && c < N;
	}
	
	public static int calCost(int r,int c) {
		int res = map[r][c];
		for(int i=0;i<4;i++) {
			int nx = r+dx[i];
			int ny = c+dy[i];
			res += map[nx][ny];
		}
		return res;
	}
	
	public static void backTracking(int L,int cost) {
		if(L == 3) {
			ans = Math.min(ans,cost);
			return;
		}
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				if(rangeChk(i,j) && chkVisted(i,j)) {
					visitProc(i, j);
					backTracking(L+1, cost+calCost(i,j));
					resetProc(i,j);
				}
			}
			
		}
	}
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		map = new Integer[N][N];
		valueMap = new Integer[N][N];
		visited = new boolean[N][N];
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		backTracking(0,0);

		System.out.println(ans);
	}

}
