package study0813;
/*
 * 조건에 따라 위험한 곳에 표시 해두기
 * 표시 완료한뒤 안전한곳 탐색
 */
import java.io.*;
import java.util.*;
public class b1_1986_체스 {
	static int n,m;
	static int[][] map;
	//상하좌우 남동, 북서, 북동, 남서
	static int[] dx = {-1,1,0,0,1,-1,-1,1};
	static int[] dy = {0,0,-1,1,1,-1,1,-1};
	static int[] kx = {2,1,-1,-2,-2,-1,1,2};
	static int[] ky= {1,2,2,1,-1,-2,-2,-1};
	public static void marking(int r,int c, int type) {
		if(type == 1) { // 퀸 대각선 마킹
			for(int i=0 ; i<8 ; i++) {
				int nx=r;
				int ny=c;
				while(true) {
					nx  = nx + dx[i];
					ny  = ny +dy[i];
					if(nx>=0 && nx < n && ny >=0 && ny < m && (map[nx][ny] == 0 || map[nx][ny] == -1)) {
						map[nx][ny] = -1;
					}else break;
				}
			}
		}else if(type==2) {// 나이트 마킹
			for(int i=0 ; i<8 ; i++) {
				int nx = r+kx[i];
				int ny = c+ky[i];
				if(nx>=0 && nx < n && ny >=0 && ny < m  && map[nx][ny]==0 ) {
					map[nx][ny] = -1;
				}
			}
		}else {
			return;
		}
	}
	
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map=new int[n][m];
		for(int i=0;i<3;i++) {
			st = new StringTokenizer(br.readLine());
			int cnt = Integer.parseInt(st.nextToken());
			int type = i+1; // 퀸 : 1 , 나이트 : 2, 폰 : 3
			for(int j=0 ; j < cnt; j++) {
				int r =  Integer.parseInt(st.nextToken())-1;
				int c =  Integer.parseInt(st.nextToken())-1;
				map[r][c] = type;
				if(type==2)marking(r, c, 2);
				
			}
		}
		
		
		int ans=0;
		for(int i=0 ; i<n ; i++) {
			for(int j=0 ; j<m ; j++) {
				if(map[i][j]==1)marking(i , j, 1);
			}
		}
		for(int i=0 ; i<n ; i++) {
			for(int j=0 ; j<m ; j++) {
				if(map[i][j]==0)ans++;
			}
		}
		System.out.println(ans);
	}
}
