import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Solution_핀볼 {
	static int n;
	static int[][] board;
	
	static int dir;
	
	static int[] dx = {0,-1,0,1};
	static int[] dy = {-1,0,1,0};
	
	static int answer;
	
	static int cur_x, cur_y;
	
	static Map<Integer, int[][]> wormholes; 
//	static int start_x, start_y;

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		for (int t=1;t<=T;t++) {
//			n = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			board = new int[n][n];
			wormholes = new HashMap<>();
			
			for (int i=0;i<n;i++) {
//				st = new StringTokenizer(br.readLine());
//				for (int j=0;j<n;j++) {
//					board[i][j] = Integer.parseInt(st.nextToken());
//				}
				
				st = new StringTokenizer(br.readLine());
                for (int j=0;j<n;j++) {
                    int cell = Integer.parseInt(st.nextToken());
                    board[i][j] = cell;
                    if (cell >= 6 && cell <= 10) {
                        if (!wormholes.containsKey(cell)) {
                            wormholes.put(cell, new int[2][2]);
                        }
                        if (wormholes.get(cell)[0][0] == 0 && wormholes.get(cell)[0][1] == 0) {
                            wormholes.get(cell)[0][0] = i;
                            wormholes.get(cell)[0][1] = j;
                        } else {
                            wormholes.get(cell)[1][0] = i;
                            wormholes.get(cell)[1][1] = j;
                        }
                    }
                }
			}
			
			dir = 0;
			answer = 0;
			
			for (int i=0;i<n;i++) {
				for (int j=0;j<n;j++) {
					if (board[i][j] == 0) {
						pinball(i,j);
					}
				}
			}
//			if (answer>0) answer--;
			System.out.println("#"+t+" "+answer);
		}
		
		
	}
	// 핀볼게임
	private static void pinball(int x, int y) {
	    int start_x = x;
	    int start_y = y;
	    
	    for (int d = 0; d < 4; d++) {
	        int score = 0;
	        dir = d;
	        int nx = x, ny = y;

	        while (true) {
	            nx += dx[dir];
	            ny += dy[dir];
	            
	            if (nx < 0 || ny < 0 || nx >= n || ny >= n) { // 벽에 부딪혔을 때
	                dir = (dir + 2) % 4;
	                score++;
	            } else if (board[nx][ny] == -1 || (nx == start_x && ny == start_y)) { // 종료 조건
	                answer = Math.max(answer, score);
	                break;
	            } else if (board[nx][ny] >= 1 && board[nx][ny] <= 5) { // 블록 1~5
	                score++;
	                oneTofive(board[nx][ny]);
	            } else if (board[nx][ny] >= 6 && board[nx][ny] <= 10) { // 웜홀 6~10
	                int[] newPos = sixToten(board[nx][ny], nx, ny);
	                nx = newPos[0];
	                ny = newPos[1];
	            }
	        }
	    }
	}

//	private static void pinball(int x, int y) {
//		int start_x = x;
//		int start_y = y;
//		int score1 = 0;
////		boolean[][][] visited = new boolean[n][n][4];
//		for (int d=0;d<4;d++) {
//			boolean[][][] visited = new boolean[n][n][4];
//			score1 = 0;
//			dir = d;
//			x = start_x;
//			y = start_y;
//			visited[x][y][dir] = true;
//			A: for (int xx=0;xx<40000;xx++) {
//				int nx = x+dx[dir];
//				int ny = y+dy[dir];
//				if (nx == start_x && ny == start_y) {
//					answer = Math.max(score1, answer);
//					break A;
//				}
//				if (nx>=0 && nx<n && ny>=0 && ny<n && !visited[nx][ny][dir]) {
//					int cur_num = board[nx][ny];
//					if (cur_num == 0) {
//						visited[nx][ny][dir] = true;
//					} else if (cur_num>=1 && cur_num<=5) {
//						score1++;
//						visited[nx][ny][dir] = true;
//						oneTofive(cur_num);
//						visited[nx][ny][dir] = true;
//					} else if (cur_num >=6 && cur_num<=10) {
//						visited[nx][ny][dir] = true;
//						int new_arr[] = sixToten(cur_num, nx, ny);
//						nx = new_arr[0];
//						ny = new_arr[1];
//						visited[nx][ny][dir] = true;
//					} else if (cur_num == -1) {
//						answer = Math.max(score1, answer);
//						break A;
//					}
//					x = nx;
//					y = ny;
//				} else {
//					visited[x][y][dir] = true;
//					dir = (dir+2)%4;
//					visited[x][y][dir] = true;
//					score1++;
//				}
//			}
//			}
//	}
	
	// 숫자 1 ~ 5
	private static void oneTofive(int num) {
		if (num == 1) {
			if (dir==0) dir = 1;
			else if (dir==1) dir=3;
			else if (dir==2) dir = 0;
			else if (dir==3) dir = 2;
		} else if (num == 2) {
			if (dir==0) dir = 3;
			else if (dir==1) dir=2;
			else if (dir==2) dir = 0;
			else if (dir==3) dir = 1;
			
		} else if (num == 3) {
			if (dir==0) dir = 2;
			else if (dir==1) dir=0;
			else if (dir==2) dir = 3;
			else if (dir==3) dir = 1;
		} else if (num == 4) {
			if (dir==0) dir = 2;
			else if (dir==1) dir=3;
			else if (dir==2) dir = 1;
			else if (dir==3) dir = 0;
		} else if (num == 5) {
			if (dir==0) dir = 2;
			else if (dir==1) dir=3;
			else if (dir==2) dir = 0;
			else if (dir==3) dir = 1;
		}
	}
	
	
	// 숫자 6~10 (웜홀)
//	private static int[] sixToten(int num, int x, int y) {
//		int result_x = 0;
//		int result_y = 0;
//		
//		A: for (int i=0;i<n;i++) {
//			for (int j=0;j<n;j++) {
//				if (board[i][j] == num && !(i==x && j==y)) {
//					result_x = i;
//					result_y = j;
//					break A;
//				}
//			}
//		}
//		return new int[] {result_x,result_y};
//	}
	private static int[] sixToten(int num, int x, int y) {
        int[][] positions = wormholes.get(num);
        if (positions[0][0] == x && positions[0][1] == y) {
            return positions[1];
        } else {
            return positions[0];
        }
    }

}
