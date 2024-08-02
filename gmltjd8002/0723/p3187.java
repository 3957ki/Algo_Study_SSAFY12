package study0725;
import java.io.*;
import java.util.*;

//bfs...도 가능할 거 같지만 dfs로
public class p3187 {
	static int r,c,wolf,sheep,wolfSum,sheepSum; // 가로,세로,현재행 늑대/양 수, 잡아먹은 후 각각의 총합
	static char[][] map; // 맵 할당
	static boolean[][] isVisit; // 방문여부 저장
	static int[] dx = {-1,1,0,0}; //델타
	static int[] dy = {0,0,-1,1}; // 델타
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		
		r = Integer.parseInt(st.nextToken()); // 가로
		c = Integer.parseInt(st.nextToken()); // 세로
		
		map = new char[r][c]; 
		isVisit = new boolean[r][c];
		
		for(int i=0; i<r;i++) { // map에 배열 저장 
			String str = br.readLine();
			for(int j=0; j<c;j++) {
				map[i][j] = str.charAt(j);
			}
		}
		
		for(int i=0; i<r;i++) { // 행 및 열을 순회하며
			for(int j=0; j<c;j++) {
				if(!isVisit[i][j] && map[i][j] != '#') { // 방문한 적이 없고 울타리가 아닌 지점이 있으면
					sheep = 0; wolf =0; // 각각을 초기화하고
					dfs(i,j); // 현위치에서 dfs 시작
					if(sheep > wolf) { // 해당범위에 양이 더 많으면
						sheepSum += sheep; // 양이 늑대를 잡아먹는다
					} else {
						wolfSum += wolf; // 아니면 늑대가 양을 먹고
					}
				}
			}
		}
		System.out.println(sheepSum + " " + wolfSum); // 값 출력
	}
	public static void dfs(int x, int y) {
		if(map[x][y] == 'k') sheep++; // 양 추가
		else if(map[x][y] == 'v') wolf++; // 늑대 추가
		isVisit[x][y] = true; // 방문표시
		
		for(int i=0; i<4;i++) { // 델타를 이용한 사방 계산
			int nx = x + dx[i];
			int ny = y + dy[i];
			if((nx <r && nx >=0 && ny <c && ny>=0) // 경계 체크 
					&& !isVisit[nx][ny] && map[nx][ny] !='#') { // 4방향 방문하지 않았고 울타리가 아니라면
				dfs(nx, ny); // 해당 위치에서 다시 dfs
			}
		}
	}
}
