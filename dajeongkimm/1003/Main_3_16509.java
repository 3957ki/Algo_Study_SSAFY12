import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 장군
 * 궁성 : 왕이 위치할 수 있는 곳
 * 
 * 상이 왕에게 도달할 수 있는 최소 이동 횟수 (BFS)
 * @author KOREA
 *
 */
public class Main_3_16509 {
	static int[] dx = {-3,-3,-2,2,3,3,2,-2};
	static int[] dy = {-2,2,3,3,2,-2,-3,-3};
	
	static int[] firstX = {-1,-1,0,0,1,1,0,0};
	static int[] firstY = {0,0,1,1,0,0,-1,-1};

	static int[] secondX = {-1,-1,-1,1,1,1,1,-1};
	static int[] secondY = {-1,1,1,1,1,-1,-1,-1};
	
	static int[][] visited = new int[10][9];
	static int sx,sy,kx,ky;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		sx = Integer.parseInt(st.nextToken());
		sy = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		kx = Integer.parseInt(st.nextToken());
		ky = Integer.parseInt(st.nextToken());
		
		int answer = bfs();
		System.out.println(answer);

	}
	
	//상이 이동하는 경로에 왕이 있는지 확인해야함 !!! 
	static int bfs() {
		visited[sx][sy] = 1;
		Queue<int[]> queue = new ArrayDeque<>();
		queue.add(new int[] {sx,sy});
		
		while (!queue.isEmpty()) {
			int[] cur = queue.poll();
			int cur_x = cur[0];
			int cur_y = cur[1];
			
			if (cur_x == kx && cur_y == ky) {
				return visited[cur_x][cur_y]-1;
			}
			
			for (int i=0;i<8;i++) {
				if (!correctMove(i,cur_x,cur_y)) {
//					System.out.println(i+" "+cur_x+" "+cur_y);
					continue;
				}
				
				int nx = cur_x + dx[i];
				int ny = cur_y + dy[i];
				
				if (nx>=0 && nx<10 && ny>=0 && ny<9) {
					if (visited[nx][ny] == 0 ) {
						visited[nx][ny] = visited[cur_x][cur_y]+1;
						queue.add(new int[] {nx,ny});
					}
				}
			}
		}
		return -1;
		
	}
	static boolean correctMove(int d, int x, int y) {
		//첫번째
		x += firstX[d];
		y += firstY[d];
		if (x == kx && y == ky) return false;
		
		//두번째
		x += secondX[d];
		y += secondY[d];
		if (x == kx && y == ky) return false;
		
		return true;
	}
	

}
