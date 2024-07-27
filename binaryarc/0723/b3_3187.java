package allgostudy0723;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class b3_3187 {
	static int R,C;
	static char[][] map;
	static boolean[][] visited;
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	static int wCount,sCount;
	static int ansW =0;
	static int ansS =0;
	
	public static boolean rangeChk(int r,int c) {
		return r >= 0 && r < R && c >=0 && c < C;
	}
	
	public static void dfs(int r,int c) {
		if(map[r][c] == 'v')wCount++;
		if(map[r][c] == 'k')sCount++;
		
		for(int i=0;i<4;i++) {
			int nx = r + dx[i];
			int ny = c + dy[i];
			if(rangeChk(nx,ny) && !visited[nx][ny] && map[nx][ny] != '#') {
				visited[nx][ny] = true;
				dfs(nx,ny);
			}
		}
	}
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new char[R][C];
		visited = new boolean[R][C];
		for(int i=0;i<R;i++) {
			String str = br.readLine();
			for(int j=0;j<C;j++) {
				map[i][j] = str.charAt(j);
			}
		}
		
		for(int i=0;i<R;i++) {
			for(int j=0;j<C;j++) {
				if(!visited[i][j] && map[i][j] != '#') {
					wCount=0;
					sCount=0;
					visited[i][j] = true;
					dfs(i,j);
					if(wCount >= sCount)ansW += wCount;
					else {
						ansS += sCount;
					}
				}
			}
		}
		System.out.println(ansS + " " + ansW);
		
	}

}
