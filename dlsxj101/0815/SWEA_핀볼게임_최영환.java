import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
class SWEA_핀볼게임_최영환 {
	
	public static void main(String args[]) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		for(int test_case = 1; test_case <= T; test_case++){
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int[][] map = new int[N][N];
			int[][] wormholes = new int[11][4];
			for(int i = 6; i <= 10; i++) {
				wormholes[i][0] = -1;
			}

			for(int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					if ( (map[i][j] >= 6) && (map[i][j] <= 10) ) {
                        int wormhole = map[i][j];
                        if (wormholes[wormhole][0] == -1) {
                            wormholes[wormhole][0] = i;
                            wormholes[wormhole][1] = j;
                        } else {
                            wormholes[wormhole][2] = i;
                            wormholes[wormhole][3] = j;
                        }
                    }
				}
			}
			int[] dr = new int[] {0, 0, 1, -1};	//우, 좌, 하, 상
			int[] dc = new int[] {1, -1, 0, 0};
			
			int max = 0;
			for(int x = 0; x < N; x++) {
				for(int y = 0; y < N; y++) {
					if(map[x][y] == 0) {
						
						for(int d = 0; d < 4; d++) {
							int dir_i = dr[d];		//초기 위치를 기준으로 이동 방향 설정(우, 좌, 하, 상 순서)
							int dir_j = dc[d];
							int cnt = 0;
							int ni = x;
							int nj = y;
//							System.out.print("a");
							while(true) {
								ni += dir_i;
								nj += dir_j;
								
								if( (ni==N) || (nj==N) || (ni<0) || (nj<0) || (map[ni][nj]==5) ) {
									cnt++;
									dir_i *= -1;
									dir_j *= -1;
									continue;
								}
								if( (map[ni][nj] == -1) || ((ni == x) && (nj == y)) ) {
									max = Math.max(max, cnt);
									break; 	//블랙홀을 만나거나 시작 위치로 돌아오면 최대값 갱신 후 while문 종료
								}
								
								if(map[ni][nj] == 0) continue;
								
								if( (dir_i == 0) && (dir_j == 1) ) {	//우로 이동 중일 때
									if( (map[ni][nj] == 1) || (map[ni][nj] == 2) ) {	//1, 2번을 만나면 역방향으로 전환
										cnt++;
										dir_i *= -1;
										dir_j *= -1;
									}
									else if(map[ni][nj] == 3) {	//3번을 만나면 아래로 방향 전환
										cnt++;
										dir_i = 1;
										dir_j = 0;
									}
									else if(map[ni][nj] == 4) {	//4번을 만나면 위로 방향 전환
										cnt++;
										dir_i = -1;
										dir_j = 0;
									}
									else if (map[ni][nj] >= 6 && map[ni][nj] <= 10) {
	                                    int wormhole = map[ni][nj];
	                                    if (ni == wormholes[wormhole][0] && nj == wormholes[wormhole][1]) {
	                                        ni = wormholes[wormhole][2];
	                                        nj = wormholes[wormhole][3];
	                                        
	                                    } else {
	                                        ni = wormholes[wormhole][0];
	                                        nj = wormholes[wormhole][1];
	                                    }
	                                }
									continue;
								}
								else if( (dir_i == 0) && (dir_j == -1) ) {	//좌로 이동 중일 때
									if( (map[ni][nj] == 3) || (map[ni][nj] == 4) ) {	//3, 4번을 만나면 역방향으로 전환
										cnt++;
										dir_i *= -1;
										dir_j *= -1;
									}
									else if(map[ni][nj] == 2) {	//2번을 만나면 아래로 방향 전환
										cnt++;
										dir_i = 1;
										dir_j = 0;
									}
									else if(map[ni][nj] == 1) {	//1번을 만나면 위로 방향 전환
										cnt++;
										dir_i = -1;
										dir_j = 0;
									}
									else if (map[ni][nj] >= 6 && map[ni][nj] <= 10) {
	                                    int wormhole = map[ni][nj];
	                                    if (ni == wormholes[wormhole][0] && nj == wormholes[wormhole][1]) {
	                                        ni = wormholes[wormhole][2];
	                                        nj = wormholes[wormhole][3];
	                                        
	                                    } else {
	                                        ni = wormholes[wormhole][0];
	                                        nj = wormholes[wormhole][1];
	                                    }
	                                }
									continue;
								}
								else if( (dir_i == -1) && (dir_j == 0) ) {	//위로 이동 중일 때
									if( (map[ni][nj] == 1) || (map[ni][nj] == 4) ) {	//1, 4번을 만나면 역방향으로 전환
										cnt++;
										dir_i *= -1;
										dir_j *= -1;
									}
									else if(map[ni][nj] == 2) {	//2번을 만나면 우측 방향으로 방향 전환
										cnt++;
										dir_i = 0;
										dir_j = 1;
									}
									else if(map[ni][nj] == 3) {	//3번을 만나면 좌측 방향으로 방향 전환
										cnt++;
										dir_i = 0;
										dir_j = -1;
									}
									else if (map[ni][nj] >= 6 && map[ni][nj] <= 10) {
	                                    int wormhole = map[ni][nj];
	                                    if (ni == wormholes[wormhole][0] && nj == wormholes[wormhole][1]) {
	                                        ni = wormholes[wormhole][2];
	                                        nj = wormholes[wormhole][3];
	                                        
	                                    } else {
	                                        ni = wormholes[wormhole][0];
	                                        nj = wormholes[wormhole][1];
	                                    }
	                                }
									continue;
								}
								else if( (dir_i == 1) && (dir_j == 0) ) {	//아래로 이동 중일 때
									if( (map[ni][nj] == 2) || (map[ni][nj] == 3) ) {	//2, 3번을 만나면 역방향으로 전환
										cnt++;
										dir_i *= -1;
										dir_j *= -1;
									}
									else if(map[ni][nj] == 1) {	//1번을 만나면 우측 방향으로 방향 전환
										cnt++;
										dir_i = 0;
										dir_j = 1;
									}
									else if(map[ni][nj] == 4) {	//4번을 만나면 좌측 방향으로 방향 전환
										cnt++;
										dir_i = 0;
										dir_j = -1;
									}
									else if (map[ni][nj] >= 6 && map[ni][nj] <= 10) {
	                                    int wormhole = map[ni][nj];
	                                    if (ni == wormholes[wormhole][0] && nj == wormholes[wormhole][1]) {
	                                        ni = wormholes[wormhole][2];
	                                        nj = wormholes[wormhole][3];
	                                        
	                                    } else {
	                                        ni = wormholes[wormhole][0];
	                                        nj = wormholes[wormhole][1];
	                                    }
	                                }
									continue;
								}
							}
						}
					}
				}
			}
			
			System.out.printf("#%d %d%n", test_case, max);
		}
	}
}