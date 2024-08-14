import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_study_1_1986 {
	static int[] qr = new int[] {0, 1, 1, 1, 0, -1, -1, -1};	//퀸의 델타
	static int[] qc = new int[] {1, 1, 0, -1, -1, -1, 0, 1};
	static int[] kr = new int[] {-1, 1, 2, 2, 1, -1, -2, -2};	//나이트의 델타
	static int[] kc = new int[] {2, 2, -1, 1, -2, -2, 1, -1};


	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		int[][] map = new int[n][m];

		st = new StringTokenizer(br.readLine());
		int cntQ = Integer.parseInt(st.nextToken());

		for(int i = 0; i < cntQ; i++) {
			int x = Integer.parseInt(st.nextToken())-1;
			int y = Integer.parseInt(st.nextToken())-1;
			map[x][y] = 9;	//나이트는 5, 폰은 7, 퀸은 9
		}
		st = new StringTokenizer(br.readLine());
		int cntK = Integer.parseInt(st.nextToken());

		for(int i = 0; i < cntK; i++) {
			int x = Integer.parseInt(st.nextToken())-1;
			int y = Integer.parseInt(st.nextToken())-1;
			map[x][y] = 5;	//나이트는 5, 폰은 7, 퀸은 9
		}
		st = new StringTokenizer(br.readLine());
		int cntP = Integer.parseInt(st.nextToken());

		for(int i = 0; i < cntP; i++) {
			int x = Integer.parseInt(st.nextToken())-1;
			int y = Integer.parseInt(st.nextToken())-1;
			map[x][y] = 7;	//나이트는 5, 폰은 7, 퀸은 9
		}

		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				if(map[i][j] == 5) {	//나이트를 만나면
					int ni = 0;
					int nj = 0;
					for(int a = 0; a < 8; a++) {
						ni = i + kr[a];
						nj = j + kc[a];
						if( (ni == n) || (nj == m) || (ni < 0) || (nj < 0) || (map[ni][nj] == 5) || (map[ni][nj] == 7) || (map[ni][nj] == 9) ) continue;
						map[ni][nj] = 1;	//체스판에 1은 안전하지 않은 지역
					}
				}
				if(map[i][j] == 9) { //퀸을 만나면	
					for(int a = 0; a < 8; a++) {
						int ni = 0;
						int nj = 0;
						int x = i;
						int y = j;
						while(true) {
							ni = x + qr[a];
							nj = y + qc[a];
							if( (ni == n) || (nj == m) || (ni < 0) || (nj < 0) || (map[ni][nj] == 5) || (map[ni][nj] == 7) || (map[ni][nj] == 9) ) break;
							map[ni][nj] = 1;	//체스판에 1은 안전하지 않은 지역
							x = ni;
							y = nj;
						}
					}
				}
			}
		}
		int safeCnt = 0;
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				if(map[i][j] == 0) safeCnt++;
			}
		}
		System.out.println(safeCnt);
	}

}
