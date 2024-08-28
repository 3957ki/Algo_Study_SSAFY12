import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

/**
 * 스타트 택시
 * 손님을 도착지로 데려다줄 때마다 연료가 충전되고, 연료가 바닥나면 그 날의 업무가 끝남
 * 
 * M명의 승객을 태우는 것이 목표
 * 이동할 때 항상 최단경로로만 이동
 * 
 * 승객을 고를 때 : 현재 위치에서 최단 거리가 가장 짧은 승객 (여러명이면 행번호 가장 작은 승객,,열번호가장작은승객,,)
 * 연료는 한 칸 이동할 때마다 1만큼 소모
 * 한 승객을 목적지로 성공적으로 이동시키면, 그 승객을 태워 이동하면서 소모한 연료 양의 두 배가 충전
 * 이동 도중 연료가 바닥나면 이동에 실패 ,, 그 날의 업무 끝남
 * @author SSAFY
 *
 */
public class Main_19238 {
	static int N,M,fuel;
	
	static int[][] arr;
	
	static int start_x, start_y;
	
	static int[][] goal;
	
	static boolean[] pass;
	
	static int[] dx = {1,-1,0,0};
	static int[] dy = {0,0,1,-1};
	
	static boolean flag = true;
	
//	static int answer;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		fuel = Integer.parseInt(st.nextToken());
		
		arr = new int[N][N];
		for (int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for (int j=0;j<N;j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		st = new StringTokenizer(br.readLine());
		start_x = Integer.parseInt(st.nextToken())-1;
		start_y = Integer.parseInt(st.nextToken())-1;
		
		goal = new int[M][4];
		for (int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			for (int j=0;j<4;j++) {
				goal[i][j] = Integer.parseInt(st.nextToken())-1;
			}
		}
		
		pass = new boolean[M];
		
		int drive_count = 0;
		
		//현재 위치에서 최단 거리가 가장 짧은 승객부터 ,,
		while (drive_count < M) {
			int min_distance = Integer.MAX_VALUE;
			int min_person = -1;
			int x = 0;
			int y = 0;
			for (int i=0;i<M;i++) {
				if (!pass[i]) {
					int tmp_distance = BFS(start_x, start_y, goal[i][0], goal[i][1]);
					if ((tmp_distance < min_distance) && (tmp_distance != -1)) {
						min_person = i;
						min_distance = tmp_distance;
						x = goal[i][0];
						y = goal[i][1];
					}
					if (tmp_distance == min_distance) {
					    if (goal[i][0] < x || (goal[i][0] == x && goal[i][1] < y)) {
					        x = goal[i][0];
					        y = goal[i][1];
					        min_person = i;
					    }
					}

					
				}
			}
			
//			System.out.println(min_person);
			
			if (min_person == -1) {
				flag = false;
				break;
			}
			
			fuel -= min_distance;
			if (fuel < 0) {
				flag = false;
				break;
			}
			
			start_x = goal[min_person][0];
			start_y = goal[min_person][1];
			
			int distance = BFS(start_x, start_y, goal[min_person][2], goal[min_person][3]);
//			System.out.println("distance: "+distance);
			fuel -= distance;
			
			
			if (distance == -1) {
				flag = false;
				break;
			}
			
			if (fuel < 0) {
				flag = false;
				break;
			}
			fuel += distance*2;
			
			start_x = goal[min_person][2];
			start_y = goal[min_person][3];
			
			pass[min_person] = true;
			drive_count++;
//			System.out.println("drive_count: "+drive_count+"    fuel: "+fuel);
			
		}
		
		if (!flag) {
			System.out.println(-1);
		} else {
			System.out.println(fuel);
		}

	}
	/**
	 * 현재 위치와 승객과의 최단 경로 거리 찾기
	 * @param x
	 * @param y
	 * @param target_x
	 * @param target_y
	 * @return
	 */
	public static int BFS(int x, int y, int target_x, int target_y) {
		int cnt = 0 ;
		int[][] visited = new int[N][N];
		visited[x][y] = 1;
		ArrayDeque<int[]> queue = new ArrayDeque<>();
		queue.add(new int[] {x,y});
		
		while (!queue.isEmpty()) {
			int[] cur = queue.poll();
			int cur_x = cur[0];
			int cur_y = cur[1];
			if (cur_x == target_x && cur_y == target_y) {
				return visited[cur_x][cur_y]-1;
			}
			for (int i=0;i<4;i++) {
				int nx = cur_x + dx[i];
				int ny = cur_y + dy[i];
				if (nx>=0 && nx<N && ny>=0 && ny<N && arr[nx][ny] == 0 && visited[nx][ny] == 0) {
					visited[nx][ny] = visited[cur_x][cur_y]+1;
					queue.add(new int[] {nx,ny});
				}
			}
			
		}
		return -1;
	}

}
