import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;
import java.util.StringTokenizer;
/*
 * HashMap에 아이디, 객체를 담아준다.
 * 객체에는 dist가 bfs 탐색으로 들어간다.
 * while 안에서 dist를 줄여가며 dist가 0이 된 녀셕들은 보스를 공격하기 시작
 * 보스 체력이 0이하로 내려가면 while문 종료 후 dist가 0인 녀석들 개수 세기
 */
public class 보스몬스터전리품 {
	
	static class Player{
		int r;
		int c;
		int dist;
		int dps;
		public Player(int r, int c, int dist, int dps) {
			this.r = r;
			this.c = c;
			this.dist = dist;
			this.dps = dps;
		}
	}
	
	static class Boss{
		int r;
		int c;
		public Boss(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}
	
	static int dr[] = {-1, 1, 0, 0};
	static int dc[] = {0, 0 ,-1, 1};
	
	static int R, C, P, bossHP;
	static char map[][];
	static Map<Character, Player> players;
	static Boss boss;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		P = Integer.parseInt(st.nextToken());
		
		players = new HashMap<>();
		
		map = new char[R][C];
		for(int i = 0; i < R; i++) {
			String input = br.readLine().trim();
			for(int j = 0; j < C; j++) {
				map[i][j] = input.charAt(j);
				if(map[i][j] == '.') continue;
				if(map[i][j] == 'X') continue;
				if(map[i][j] == 'B') {
					boss = new Boss(i, j);
					continue;
				}
				players.put(map[i][j], new Player(i, j, 0, 0));
			}
		}
		
		for(int i = 0; i < P; i++) {
			st = new StringTokenizer(br.readLine());
			
			char id = st.nextToken().charAt(0);
			int dps = Integer.parseInt(st.nextToken());
			
			players.get(id).dps = dps;
			players.get(id).dist = dfs(players.get(id).r, players.get(id).c);
		}
		
		bossHP = Integer.parseInt(br.readLine().trim());
		
		while(true) {
			if(bossHP <= 0) break;
			
			int dmg = 0;
			//한 칸씩 이동, 몬스터에 도달했을 경우 공격데미지 누적
			for(char key : players.keySet()) {
				Player tmp = players.get(key);
				
//				System.out.print("key:"+key+" dist:"+tmp.dist+" ");
				tmp.dist--;
				if(tmp.dist < 0) dmg += tmp.dps;
			}
//			System.out.println();
			//보스 공격
			bossHP -= dmg;
//			System.out.println(bossHP);
		}
		int cnt = 0;
		for(char key : players.keySet()) {
			Player tmp = players.get(key);
			
			if(tmp.dist < 0) cnt++;
		}
		System.out.println(cnt);
	}

	private static int dfs(int startR, int startC) {
		
		Queue<int[]> q = new ArrayDeque<>();
		boolean visited[][] = new boolean[R][C];
		
		q.add(new int[] {startR, startC});
		visited[startR][startC] = true;
		
		int depth = 0;
		while(!q.isEmpty()) {
			
			int size = q.size();
			depth++;
			
			while(size-->0) {
				int tmp[] = q.poll();
				int r = tmp[0];
				int c = tmp[1];
				
				for(int d = 0; d < 4; d++) {
					int nr = r + dr[d];
					int nc = c + dc[d];
					
					if( (nr>=R) || (nc>=C) || (nr<0) || (nc<0) ) continue;
					if(map[nr][nc] == 'X') continue;
					if(map[nr][nc] == 'B') return depth;
					if(visited[nr][nc]) continue;
					
					visited[nr][nc] = true;
					q.add(new int[] {nr, nc});
				}
			}
		}
		return Integer.MAX_VALUE;
	}
}


















