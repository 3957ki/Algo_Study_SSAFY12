import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {
	static int N, M;
	static int[][] board;
	static boolean[][] visited;
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,1,-1};

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		board = new int[N][M];
		for (int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for (int j=0;j<M;j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int answer_time = 0;
		int cheese_cnt = 0;
		int cheese_before = 0;
		
		while (true) {
			int break_condition = 0;
			
			visited = new boolean[N][M];
			int tmp = 0;
			for (int i=0;i<N;i++) {
				for (int j=0;j<M;j++) {
					if (!visited[i][j] && board[i][j] == 1) {
						cheese(i,j);
						break_condition++;
					}
				}
			}
			
			if (break_condition == 0) {
				System.out.println("-------------------");
				System.out.println(answer_time);
				System.out.println(cheese_cnt);
				break;
			}
			
			for (int i=0;i<N;i++) {
				for (int j=0;j<M;j++) {
					if (board[i][j] == 2) {
						tmp++;
						board[i][j] = 0;
					}
				}
			}
			
			printArr(board);
			cheese_before = cheese_cnt;
			cheese_cnt = tmp;
			
			answer_time++;
			
//			System.out.println(answer_time+"초");
//			System.out.println(cheese_before);
//			System.out.println(cheese_cnt);
			
		}
		
		
	}
	
	private static void cheese(int x, int y) {
		int remove_cheese = 0;
		ArrayDeque<int[]> queue = new ArrayDeque<>();
		queue.add(new int[] {x,y});
		visited[x][y] = true;
		
		while (!queue.isEmpty()) {
			int[] cur = queue.poll();
			int cur_x = cur[0];
			int cur_y = cur[1];
			int cnt = 0;
			for (int i=0;i<4;i++) {
				int nx = cur_x + dx[i];
				int ny = cur_y + dy[i];
				
				if (nx>=0 && nx<N && ny>=0 && ny<M) {
					if (board[nx][ny] != 0) {
						cnt +=1;
					}
				}
			}
			
			if (cnt==4) continue;
			else {
				board[cur_x][cur_y] = 2;
				for (int i=0;i<4;i++) {
					int nx = cur_x + dx[i];
					int ny = cur_y + dy[i];
					if (nx>=0 && nx<N && ny>=0 && ny<M && !visited[nx][ny] && board[nx][ny] != 0) {
						queue.add(new int[] {nx,ny});
						visited[nx][ny] = true;
					}
				}
			}
		}
		
		
		
	}
	
	private static void printArr(int[][] arr) {
		for (int i=0;i<arr.length;i++) {
			for (int j=0;j<arr[0].length;j++) {
				System.out.print(arr[i][j]+" ");
			}
			System.out.println();
		}
		System.out.println();
	}

}
