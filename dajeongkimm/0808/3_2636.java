import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;


/**
 * 2636 치즈
 * 공기와 접촉된 칸은 한 시간이 지나면 녹아 없어짐
 * 모두 녹아 없어지는 데 걸리는 시간
 * 모두 녹기 한 시간 전에 남아있는 치즈조각의 칸의 개수
 * 
 * 치즈가 없는 칸은 0 , 치즈가 있는 칸은 1
 */
public class Main {
	static int n,m;
	static int[][] arr;
	
	static int cnt;
	
	static int[] dx = {1,-1,0,0};
	static int[] dy = {0,0,1,-1};
	
	public static void main (String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		arr = new int[n][m];
		
		for (int i=0;i<n;i++) {
			st = new StringTokenizer(br.readLine());
			for (int j=0;j<m;j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int cur_cheese = 0;
		for (int i=0;i<n;i++) {
			for (int j=0;j<m;j++) {
				if (arr[i][j] == 1) cur_cheese++;
			}
		}
		
		if (cur_cheese == 0) {
			System.out.println(0);
			System.out.println(0);
			System.exit(0);
		}
		
		int time = 0;
		
		while (true) {
			time++;
			cnt = BFS();
			cur_cheese -= cnt;
			if (cur_cheese == 0) {
				break;
			}
		}
		
		System.out.println(time);
		System.out.println(cnt);
		
	}
	private static int BFS() {
		ArrayDeque<int[]> queue = new ArrayDeque<>();
		queue.add(new int[] {0,0});
		boolean[][] visited = new boolean[n][m];
		visited[0][0] = true;
		
		int remove_cnt = 0;
		
		while (!queue.isEmpty()) {
			int[] cur = queue.poll();
			int cur_x = cur[0];
			int cur_y = cur[1];
			
			for (int i=0;i<4;i++) {
				int nx = cur_x + dx[i];
				int ny = cur_y + dy[i];
				
				if (nx>=0 && nx<n && ny>=0 && ny<m && !visited[nx][ny]) {
					if (arr[nx][ny] == 0) {
						queue.add(new int[] {nx,ny});
						visited[nx][ny] = true;
					} else {
						visited[nx][ny] = true;
						arr[nx][ny] = 0;
						remove_cnt++;
					}
				}
			}
		}
		return remove_cnt;
	}
}