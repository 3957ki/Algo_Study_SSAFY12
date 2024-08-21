package algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main_8_13_1 {
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int [][] arr = new int[N][M];
		
		// queen 1
		// knight 2
		// pawn 3
		int [] pieceNum = new int[3];
		boolean [][] visited = new boolean[N][M];
		
		List<int[]> queen = new ArrayList<>()
				, knight = new ArrayList<>()
				, pawn = new ArrayList<>();
		
		for (int i = 0; i < 3; i++) {
			st = new StringTokenizer(br.readLine());
			pieceNum[i] = Integer.parseInt(st.nextToken());
			
			for (int j = 0; j < pieceNum[i]; j++) {
				
				int y = Integer.parseInt(st.nextToken()) -1;
				int x = Integer.parseInt(st.nextToken()) -1;
				
				arr[y][x] = i+1;
				visited[y][x] = true;
				int[] tmp = {y, x};
				if (i==0) queen.add(tmp);
				else if (i==1) knight.add(tmp);
				else pawn.add(tmp);
					
			}
		}
		
		
		// Q
		int[] q_dx = {0, 0, 1, -1, 1, 1, -1, -1};
		int[] q_dy = {-1, 1, 0, 0, -1, 1, 1, -1};
		
		for (int i = 0; i < pieceNum[0]; i++) {
			for (int j = 0; j < 8; j++) {
				int dx = queen.get(i)[1] + q_dx[j];
				int dy = queen.get(i)[0] + q_dy[j];
				
				while(true) {
					if (0 <= dx && dx < M && 0<= dy && dy < N && arr[dy][dx] == 0) {
						visited[dy][dx] = true;
						dx += q_dx[j];
						dy += q_dy[j];
					}
					else {
						break;
					}
				}
			}
		}
		
		
		
		// K
		int[] k_dx = {-1, 1, 2, 2,1, -1, -2, -2};
		int[] k_dy = {-2, -2, -1, 1, 2, 2, 1, -1};
		
		for (int i = 0; i < pieceNum[1]; i++) {
			for (int j = 0; j<8; j++) {
				
				int dx = knight.get(i)[1] + k_dx[j];
				int dy = knight.get(i)[0] + k_dy[j];
				
				if (0 <= dx && dx < M && 0<= dy && dy < N && arr[dy][dx] == 0) {
					visited[dy][dx] = true;
				}
			}
		}
		
		int count = 0;

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (!visited[i][j]) count++;
			}
		}
		
		System.out.println(count);
		
	}//main end

}//class end
