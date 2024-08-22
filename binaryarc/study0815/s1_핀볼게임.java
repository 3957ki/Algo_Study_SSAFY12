package study0815;

import java.io.*;
import java.util.*;
public class s1_핀볼게임 {
	public static class w_hole{
		int r,c,w;
		boolean v;
		public w_hole(int r,int c,int w) {
			this.r = r;
			this.c = c;
			this.w = w;

		}
	}
	static int[][] map;
	static int N;
	static int[] dx = {-1,1,0,0}; //상하좌우
	static int[] dy = {0,0,-1,1};
	
	static int[] dx1 = {1,3,0,2};
	static int[] dy1 = {1,3,0,2};
	
	static int[] dx2 = {3,0,1,2};
	static int[] dy2 = {3,0,1,2};
	
	static int[] dx3 = {2,0,3,1};
	static int[] dy3 = {2,0,3,1};
	
	static int[] dx4 = {1,2,3,0};
	static int[] dy4 = {1,2,3,0};
	
	static int startX,startY;
	static int total_score;
	static ArrayList<w_hole> wList;
	public static void simulation(int r, int c, int dir,int cur_score) {
		while(true) {
			r += dx[dir];
			c += dy[dir];
			System.out.println(startX + ", " + startY);
			System.out.println(r + " " + c + " "+ dir);
			if(r==startX && c == startY) {
				total_score = Math.max(total_score, cur_score);
				return;
			}
			if(r < 0 || r >= N || c < 0 || c >=N) {
				dir = (dir == 0 ? 1 : dir == 1 ? 0 : dir == 2 ? 3 : 2);
				cur_score++;
				continue;
			}
			if(map[r][c]==-1) {
				total_score = Math.max(total_score, cur_score);
				return;
			}
			if(map[r][c]==5) {
				dir = (dir == 0 ? 1 : dir == 1 ? 0 : dir == 2 ? 3 : 2);
				cur_score++;
			}else if(map[r][c]==1) {
				dir = dx[dx1[dir]];
//				r = r + dx[dx1[dir]];
//				c = c + dy[dy1[dir]];
				cur_score++;
			}else if(map[r][c]==2) {
				dir = dx[dx2[dir]];
//				r = r + dx[dx2[dir]];
//				c = c + dy[dy2[dir]];
				cur_score++;
			}else if(map[r][c]==3) {
				dir = dx[dx3[dir]];
//				r = r + dx[dx3[dir]];
//				c = c + dy[dy3[dir]];
				cur_score++;
			}else if(map[r][c]==4) {
				dir = dx[dx4[dir]];
//				r = r + dx[dx4[dir]];
//				c = c + dy[dy4[dir]];
				cur_score++;
			}else if(map[r][c]>=6) {
				//웜홀 하나씩 찾아서 이동
				A:for(int i=0;i<wList.size();i++) {
					w_hole wh = wList.get(i);
					if(wh.w == map[r][c]) {
						for(int j=0;j<wList.size();j++) {
							if(i==j) continue;
							w_hole wh2 = wList.get(j);
							r = wh2.r;
							c = wh2.c;
							cur_score++;
							break A;
						}
					}
				}
			}
		}
		
	}
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken());
		for(int tc=1;tc<=T;tc++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			map = new int[N][N];
			wList = new ArrayList<w_hole>();
			for(int i=0;i<N;i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0;j<N;j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					if(map[i][j]>=6) {
						wList.add(new w_hole(i,j,map[i][j]));
					}
				}
			}
			total_score=0;
			for(int i=0;i<N;i++) {
				for(int j=0;j<N;j++) {
					if(map[i][j] == 0) {
						for(int d=0;d<4;d++) {
							startX=i;
							startY=j;
							simulation(i,j,d,0);
						}
					}
				}
			}
			System.out.println("#"+tc+" "+total_score);
		}
	}

}
