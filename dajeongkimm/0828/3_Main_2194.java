import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

/**
 * 유닛 이동시키기
 * S는 시작점 E는 끝점
 * 상하좌우 네 방향
 * 
 * 제일 왼쪽 상단을 기준으로 check
 * 유닛을 목적지까지 움직이기 위해 필요한 최소의 이동 횟수
 * 이동이 불가능한 경우에는 -1 출력
 * @author KOREA
 *
 */
public class Main_2194 {
	static int N,M,A,B,K;
	
	static int[][] arr; //장애물은 -2로 초기화
	
	static int start_x, start_y, end_x, end_y;
	
	static int[] dx = {1,-1,0,0};
	static int[] dy = {0,0,1,-1};
	
	static int answer = -1;
	

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		//유닛은 A*B 크기의 2차원 행렬
		A = Integer.parseInt(st.nextToken());
		B = Integer.parseInt(st.nextToken());
		
		K = Integer.parseInt(st.nextToken());
		
		arr = new int[N][M];
		for (int i=0;i<K;i++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken())-1;
			int c = Integer.parseInt(st.nextToken())-1;
			arr[r][c] = -2;
		}
		
		//시작점 위치 좌표
		st = new StringTokenizer(br.readLine());
		start_x = Integer.parseInt(st.nextToken())-1;
		start_y = Integer.parseInt(st.nextToken())-1;
		
		//끝점 위치 좌표
		st = new StringTokenizer(br.readLine());
		end_x = Integer.parseInt(st.nextToken())-1;
		end_y = Integer.parseInt(st.nextToken())-1;
		
		
		
		BFS();
		System.out.println(answer);
		
		
	}
	public static void BFS() {
		ArrayDeque<int[]> queue = new ArrayDeque<>();
		queue.add(new int[] {start_x, start_y});
		int[][] visited = new int[N][M];
		visited[start_x][start_y] = 1;
		
		while (!queue.isEmpty()) {
			int cur[] = queue.poll();
			int cur_x = cur[0];
			int cur_y = cur[1];
//			System.out.println("cur_x: "+cur_x+" cur_y: "+cur_y);
			
			if (cur_x == end_x && cur_y == end_y) {
				answer = visited[cur_x][cur_y]-1;
				return;
			}
			
			for (int i=0;i<4;i++) {
				int nx = cur_x + dx[i];
				int ny = cur_y + dy[i];
				
				if (nx>=0 && nx<=N-A && ny>=0 && ny<=M-B && visited[nx][ny]==0) {
					//A*B 유닛 내에 장애물이 없는지 확인하기
					boolean flag = true;
					A: for (int di=0;di<A;di++) {
						for (int dj=0;dj<B;dj++) {
							if (arr[nx+di][ny+dj] == -2) {
								flag = false;
								break A;
							}
						}
					}
					//유닛 내에 장애물이 없으면
					if (flag) {
						visited[nx][ny] = visited[cur_x][cur_y]+1;
						queue.add(new int[] {nx,ny});
					}
				}
			}
		}
	}

}
