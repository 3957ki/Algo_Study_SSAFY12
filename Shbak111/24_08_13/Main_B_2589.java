import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * L을 찾아서 
 * @author SSAFY
 *
 */

public class Main_B_2589 {
	static int dis = 0;
	
	static class Point {
		int x;
		int y;
		int distance;
		public Point(int x,int y, int distance) {
			this.x = x;
			this.y = y;
			this.distance = distance;
		}
	}

	public static int BFS(char[][] arr, boolean[][] visited, int x,int y,int distance) {
		int[] dx = {0,0,1,-1};
		int[] dy = {-1,1,0,0};
		int[][] dp = new int[arr.length][arr[0].length];
		Queue<Point> queue = new LinkedList<>();
		queue.offer(new Point(x, y, distance));
		visited[x][y] = true; 
		int tmp = distance;
		dp[x][y] = tmp; 
		
		while(!queue.isEmpty()) {
			Point curr = queue.poll();
			tmp = curr.distance + 1;
			for(int i = 0;i < dx.length;i++) {
				int nx = curr.x + dx[i];
				int ny = curr.y + dy[i];
				
				if(nx >= 0 && nx < arr.length && ny >=0 && ny < arr[0].length) {
					if(visited[nx][ny] || arr[nx][ny] == 'W') continue;
					if(dp[nx][ny] != 0) { 
						tmp = Math.min(curr.distance, tmp);
					}
					visited[nx][ny] = true;
					queue.offer(new Point(nx, ny, tmp));
					dp[nx][ny] = tmp;
				}
			}

			
		}
		
//		for(int i = 0;i < arr.length;i++) {
//			for(int j = 0;j < arr[i].length;j++) {
//				System.out.print(dp[i][j]+ " " );
//			}
//			System.out.println();
//		}
//		System.out.println(tmp);
		return tmp;
	}
	
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		//System.setIn(new FileInputStream("res/treasure.txt"));
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		char[][] arr = new char[N][M];
		boolean[][] visited;
		
		for(int i = 0;i < N;i++) {
			StringTokenizer st2 = new StringTokenizer(bf.readLine());
			String line = st2.nextToken();
			for(int j = 0;j < M;j++) {
				arr[i][j] = line.charAt(j); 
			}
		}
		
		for(int i = 0;i < N;i++) {
			for(int j = 0;j < M;j++) {
				if(arr[i][j] == 'L') {
					visited = new boolean[N][M];
					int result = BFS(arr, visited, i,j,1);
					dis = Math.max(result, dis);
				}
			}
		}
		
		System.out.println(dis - 2);
	}

}