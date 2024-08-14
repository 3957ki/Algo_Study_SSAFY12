package study0813;
import java.io.*;
import java.util.*;


public class p1986 {
	static int n,m; 
	static int cnt; // 안전한 칸 셀 변수
	static int knightCnt; // 나이트 개수를 받을 변수
	static int curKnight; // 나이트가 몇번 방문했는지 확인할 변수
	static char[][] map; // 판 저장 -> 나중엔 node로 좌표만 받아오게 수정 가능
	static boolean[][] isVisit; // 방문가능한 자리인지 체크
	static int KnightMoveX[] = {1,2,2,1,-1,-2,-2,-1};
    static int KnightMoveY[] = {-2,-1,1,2,2,1,-1,-2};
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken()); // n
		m = Integer.parseInt(st.nextToken()); // m
		cnt =0;
		map = new char[n][m];
		isVisit = new boolean[n][m];
		
		st = new StringTokenizer(br.readLine());
		int queenCnt = Integer.parseInt(st.nextToken());
 
		for(int idx = 0; idx<queenCnt;idx++) { // 퀸 배치 및 방문처리
			int queenX = Integer.parseInt(st.nextToken())-1;
			int queenY = Integer.parseInt(st.nextToken())-1;
			map[queenX][queenY] = 'Q';
			isVisit[queenX][queenY] = true; // 현재 퀸자리도 방문하지 못하므로 방문처리
		}
		
		st = new StringTokenizer(br.readLine());
		knightCnt = Integer.parseInt(st.nextToken());

		for (int idx = 0; idx < knightCnt; idx++) { // 나이트 배치 및 방문처리
		    int knightX = Integer.parseInt(st.nextToken())-1;
		    int knightY = Integer.parseInt(st.nextToken())-1;
		    map[knightX][knightY] = 'K';
		    isVisit[knightX][knightY] = true; // 나이트자리도 방문하지 못하므로 true

		    for (int d = 0; d < 8; d++) { // 나이트 이동 방향
		        int r = knightX + KnightMoveX[d];
		        int c = knightY + KnightMoveY[d];

		        if (r >= 0 && r < n && c >= 0 && c < m && !isVisit[r][c]) { // 경계값 체크
		            isVisit[r][c] = true; // 나이트가 갈 수 있는 곳 바로 방문처리
		        }
		    }
		}
		
		st = new StringTokenizer(br.readLine());
		int pawnCnt = Integer.parseInt(st.nextToken());
		
		for(int idx= 0; idx<pawnCnt;idx++) { // 폰 배치 및 방문처리
			int pawnX = Integer.parseInt(st.nextToken())-1;
			int pawnY = Integer.parseInt(st.nextToken())-1;
			map[pawnX][pawnY] = 'P';
			isVisit[pawnX][pawnY] = true; // 폰은 움직이지 못하므로 그자리에서 바로 방문체크
		}
		
		//폰이나 나이트가 배치된 후에 퀸의 진행방향 추가하기 -> 여기를 수정해야하는데.. 음..
		for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 'Q') {
                    // 상 방향 처리
                    for (int up = i - 1; up >= 0; up--) {
                        if (map[up][j] != 0) break;
                        isVisit[up][j] = true;
                    }

                    // 하 방향 처리
                    for (int down = i + 1; down < n; down++) {
                        if (map[down][j] != 0) break;
                        isVisit[down][j] = true;
                    }

                    // 좌 방향 처리
                    for (int left = j - 1; left >= 0; left--) {
                        if (map[i][left] != 0) break;
                        isVisit[i][left] = true;
                    }

                    // 우 방향 처리
                    for (int right = j + 1; right < m; right++) {
                        if (map[i][right] != 0) break;
                        isVisit[i][right] = true;
                    }

                    // 왼쪽 위 대각선 방향 처리
                    for (int up = i - 1, left = j - 1; up >= 0 && left >= 0; up--, left--) {
                        if (map[up][left] != 0) break;
                        isVisit[up][left] = true;
                    }

                    // 오른쪽 위 대각선 방향 처리
                    for (int up = i - 1, right = j + 1; up >= 0 && right < m; up--, right++) {
                        if (map[up][right] != 0) break;
                        isVisit[up][right] = true;
                    }

                    // 왼쪽 아래 대각선 방향 처리
                    for (int down = i + 1, left = j - 1; down < n && left >= 0; down++, left--) {
                        if (map[down][left] != 0) break;
                        isVisit[down][left] = true;
                    }

                    // 오른쪽 아래 대각선 방향 처리
                    for (int down = i + 1, right = j + 1; down < n && right < m; down++, right++) {
                        if (map[down][right] != 0) break;
                        isVisit[down][right] = true;
                    }
                }
            }
        }
		
		for(int i=0;i<n;i++) { // 방문 가능한 칸 수 찾기
			for(int j=0; j<m;j++) {
				if(!isVisit[i][j]) cnt++;
			}
		}
		System.out.println(cnt);
	}
}