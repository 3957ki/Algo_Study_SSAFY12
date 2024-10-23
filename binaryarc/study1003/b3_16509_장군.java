package study1003;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class b3_16509_장군 {
	static int r1,r2,c1,c2;
	static int[][] move = {
	        {-3, -2}, {-3, 2}, {-2, 3}, {2, 3},
	        {3, 2}, {3, -2}, {2, -3}, {-2, -3}
	    };
	static int[] firstX = {-1,-1,0,0,1,1,0,0};
	static int[] firstY = {0,0,1,1,0,0,-1,-1};
	static int[] secondX = {-1,-1,-1,1,1,1,1,-1};
	static int[] secondY = {-1,1,1,1,1,-1,-1,-1};
	static boolean[][] visited = new boolean[10][9];
	public static void main(String[] args) throws Exception{
		Scanner sc = new Scanner(System.in);
		r1 = sc.nextInt(); //상 위치
		c1 = sc.nextInt();
		r2 = sc.nextInt(); //왕 위치
		c2 = sc.nextInt();
		int ans = bfs();
		System.out.println(ans);

	}
	static int bfs() {
		
		Queue<int[]> dq = new ArrayDeque<int[]>();
		dq.add(new int[] {r1,c1});
		visited[r1][c1] = true;
		int dist = 0;
		
		while(!dq.isEmpty()) {
			int q_size = dq.size();
			dist++;
			
			for(int i=0;i<q_size;i++) {
				int[] cur = dq.poll();
				
				//8방 탐색
				for(int d = 0 ; d < 8 ; d++) {
					//중간에 장애물(왕)이 있는지 체크
					int nr = cur[0] + move[d][0];
					int nc = cur[1] + move[d][1];

					if (nr >= 10 || nr < 0 || nc >= 9 || nc < 0 || visited[nr][nc]) continue;
					if(nr == r2 && nc == c2) {
						return dist;
					}
					
					if (midChk(cur[0], cur[1], d)) continue;
					//이동이 가능한 경우
					visited[nr][nc] = true;
					dq.add(new int[] {nr,nc});
				}
			}
			
		}
		return -1;
	}
	static boolean midChk(int r,int c,int dir) {
		int mr1 = r + firstX[dir]; // 첫 번째 중간 좌표
		int mc1 = c + firstY[dir];
		int mr2 = r + secondX[dir]; // 두 번째 중간 좌표
		int mc2 = c + secondY[dir];
		
        if (mr1 < 0 || mr1 >= 10 || mc1 < 0 || mc1 >= 9 || 
            mr2 < 0 || mr2 >= 10 || mc2 < 0 || mc2 >= 9) {
            return true;
        }
        return (mr1 == r2 && mc1 == c2) || (mr2 == r2 && mc2 == c2);
	}


}
