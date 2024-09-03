import java.io.*;
import java.util.*;
/*
시작지점 -> 왼쪽아래
T -> 지나갈 수 없는 지점
끝지점 -> 오른쪽 위

-아이디어
dfs인듯?
사방탐색을 하면서 T인 지점을 제외하고 진행
방문처리도 해줘야 한다
거리가 K보다 길어지면 카운트 하지 않는다
테케 맵받는 부분이 공백이없다 -> char로 받자
호출 횟수를 저장하는 부분이 필요할 것 같다
*/
public class p1189 {
	static int r,c,k, cnt;
	static char[][] map;
	static boolean[][] isVisit;
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		map = new char[r][c];
		isVisit = new boolean[r][c];
		cnt =0;
		for(int i=0;i<r;i++) {
			String str = br.readLine().trim();
			for(int j=0; j<c;j++) {
				map[i][j] = str.charAt(j);
			}
		}
		//여기 dfs
		dfs(r-1,0,1); // (r-1,0) -> 왼쪽 아래에서부터 시작, 처음부터 개수를 세는 것 같으니깐 카운트를 1을 먼저 넘겨준다
		System.out.println(cnt);
	}
	static void dfs(int x, int y, int callCnt) {
		isVisit[r-1][0] = true;
		if(x == 0 && y == c-1 && callCnt == k) { // 기저, 오른쪽위로 카운트가 k인 상태로 도달했다면 카운트 올리기
			cnt++;
			return;
		}

		for(int i=0;i<4;i++) {
			int nr = x + dx[i];
			int nc = y + dy[i];

			//경계값 이탈이랑 방문했던 곳, 가야할 곳이 T라면 건너뛴다
			if(nr < 0 || nr >= r || nc < 0 || nc >= c || isVisit[nr][nc] || map[nr][nc] == 'T') continue;

			isVisit[nr][nc] = true; // 방문처리
			dfs(nr, nc, callCnt+1); // 현 지점에서 카운트 하나 늘려서 재귀
			isVisit[nr][nc] = false; // 나왔을때 원상복귀 하기 위해 백트래킹
		}
	}
}