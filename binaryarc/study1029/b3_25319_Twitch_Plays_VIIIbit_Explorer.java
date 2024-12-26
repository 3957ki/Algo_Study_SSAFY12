package study1029;

import java.io.*;
import java.util.*;

public class b3_25319_Twitch_Plays_VIIIbit_Explorer {
	static class Node {
		int r;
		int c;
		int cnt;
		String dir;
		char ch;

		public Node(int r, int c, String s, int cnt, char ch) {
			this.r = r;
			this.c = c;
			this.dir = s;
			this.cnt = cnt;
			this.ch = ch;
		}
	}

	static int N, M, S;
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };
	static char[] dd = { 'U', 'D', 'L', 'R' };
	static char[][] map;
	static String goal;
	static int[] ch_map;
	static int C = 0; // 강화횟수
	static int L = 0; // 이동횟수
	static StringBuilder sb;
	static int cur_r, cur_c;
	static Map<Character, List<int[]>> charPositions;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		map = new char[N][M];
		ch_map = new int['z' + 1];
		charPositions = new HashMap<>();
		for (int i = 0; i < N; i++) {
			char[] input = br.readLine().toCharArray();
			for (int j = 0; j < M; j++) {
				map[i][j] = input[j];
				charPositions.putIfAbsent(map[i][j], new ArrayList<>());
				charPositions.get(map[i][j]).add(new int[] { i, j }); // 문자 위치 저장
//				ch_map[map[i][j]]++;
			}
		}
		goal = br.readLine();
		sb = new StringBuilder();
		sovle();
		System.out.println(C + " " + L);
		System.out.println(sb);
	}

	public static void sovle() {
		cur_r = 0;
		cur_c = 0;
		while (true) {
			if (chk()) {
				for (char target : goal.toCharArray()) {
					find(target);
				}
				C++;
			} else {
				L += Math.abs((N - 1) - cur_r) + Math.abs((M - 1) - cur_c);
				break;
			}
		}
	}

	public static boolean chk() {
		int[] chkArr = new int['z' + 1];
		for (char ch : goal.toCharArray()) {
			chkArr[ch]++;
		}

//		boolean[] visited = new boolean['z' + 1];
//		for (char ch : goal.toCharArray()) {
//			if (visited[ch])
//				continue;
//			visited[ch] = true;
//			if (chkArr[ch] > ch_map[ch])
//				return false;
//		}
		for (char ch : goal.toCharArray()) {
			if (charPositions.getOrDefault(ch, Collections.emptyList()).size() < chkArr[ch]) {
				return false; // 필요한 개수보다 적으면 종료
			}
		}
		return true;
	}

	public static void find(char target) {
		List<int[]> targetPositions = charPositions.get(target);
		if (targetPositions == null || targetPositions.isEmpty()) return;
		
		int minDist = Integer.MAX_VALUE;
        String bestDir = "";
        int[] bestPos = null;
        
        for (int[] pos : targetPositions) {
        	boolean[][] visited = new boolean[N][M];
    		visited[cur_r][cur_c] = true;
    		Queue<Node> q = new ArrayDeque<>();
    		q.add(new Node(cur_r, cur_c, "", 0, map[cur_r][cur_c]));

    		while (!q.isEmpty()) {
//    			Node cur = q.poll();
//    			if (cur.ch == target) {
//    				sb.append(cur.dir).append("P");
//    				L += cur.cnt;
//    				map[cur.r][cur.c] = '0';
//    				ch_map[target]--;
//    				cur_r = cur.r;
//    				cur_c = cur.c;
//    				return;
//    			}
    			Node cur = q.poll();
                if (cur.r == pos[0] && cur.c == pos[1]) {
                    if (cur.cnt < minDist) {
                        minDist = cur.cnt;
                        bestDir = cur.dir;
                        bestPos = pos;
                    }
                    break;
                }
    			for (int i = 0; i < 4; i++) {
    				int nr = cur.r + dr[i];
    				int nc = cur.c + dc[i];
    				if (!isAvail(nr, nc) || visited[nr][nc])
    					continue;
    				visited[nr][nc] = true;
    				q.offer(new Node(nr, nc, cur.dir + dd[i], cur.cnt + 1, map[nr][nc]));
    			}
    		}
    		
        }
        if (bestPos != null) {
            sb.append(bestDir).append("P");
            L += minDist;
            map[bestPos[0]][bestPos[1]] = '0';
            charPositions.get(target).remove(bestPos);
            cur_r = bestPos[0];
            cur_c = bestPos[1];
        }
	}

	public static boolean isAvail(int r, int c) {
		return !(r < 0 || r >= N || c < 0 || c >= M || map[r][c] == '0');
	}

}
