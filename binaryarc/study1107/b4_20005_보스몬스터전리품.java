package study1107;

import java.io.*;
import java.util.*;

public class b4_20005_보스몬스터전리품 {
	static class User {
		int r, c, dps;
		boolean isAttack;
		int moveTime;

		public User(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}

	static int M, N, P;
	static char[][] map;
	static Map<Character, User> Users;
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };
	static int bossR, bossC;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		P = Integer.parseInt(st.nextToken());
		Users = new HashMap<>();
		map = new char[M][];
		for (int i = 0; i < M; i++) {
			map[i] = br.readLine().toCharArray();
			for (int j = 0; j < N; j++) {
				if (map[i][j] != 'B' && map[i][j] != '.' && map[i][j] != 'X') {
					Users.put(map[i][j], new User(i, j));
				} else if (map[i][j] == 'B') {
					bossR = i;
					bossC = j;
				}
			}
		}
		for (int i = 0; i < P; i++) {
			st = new StringTokenizer(br.readLine());
			char ch = st.nextToken().charAt(0);
			int dps = Integer.parseInt(st.nextToken());
			User user = Users.get(ch);
			user.dps = dps;
			Users.put(ch, user);
		}

		for (User user : Users.values()) {
			Queue<int[]> q = new ArrayDeque<>();
			boolean[][] visited = new boolean[M][N];
			q.offer(new int[] { user.r, user.c });
			visited[user.r][user.c] = true;
			user.moveTime = -1;
			int cnt = 0;
			A: while (!q.isEmpty()) {
				int qSize = q.size();
				for (int i = 0; i < qSize; i++) {
					int[] cur = q.poll();
					for (int d = 0; d < 4; d++) {
						int nr = cur[0] + dr[d];
						int nc = cur[1] + dc[d];
						if (nr < 0 || nr >= M || nc < 0 || nc >= N || map[nr][nc] == 'X')
							continue;
						if (visited[nr][nc])
							continue;
						if (map[nr][nc]=='B') {
							user.r = cur[0];
							user.c = cur[1];
							user.moveTime = cnt;
							break A;
						} else {
							visited[nr][nc] = true;
							q.offer(new int[] { nr, nc });
						}
					}
				}
				cnt++;
			}
		}

		st = new StringTokenizer(br.readLine());
		int bossHp = Integer.parseInt(st.nextToken());
		Queue<User> attackingUser = new ArrayDeque<>();
		while (bossHp > 0) {
			for (User user : Users.values()) {
				if (!user.isAttack && user.moveTime == 0) {
					user.isAttack = true;
					attackingUser.add(user);
				} else if (!user.isAttack && user.moveTime > 0) {
					user.moveTime--;
				}
			}
			for(User user : attackingUser) {
				bossHp -= user.dps;
			}
			if (bossHp <= 0) break;  
		}
		int cnt=0;
		for(User user : Users.values()) {
			if(user.isAttack)cnt++;
		}
		System.out.println(cnt);
		
	}
}
