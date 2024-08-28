import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * 모래성
 * 튼튼함 : 1~9
 * 자기 격자 주변의 8방향(위 아래 왼 오 대각선)
 * --> 모래성이 쌓여있지 않은 부분의 개수가 자기 모래성의 튼튼함보다
 * 많거나 같을 경우 파도에 의해서 무너질 수 있음을 의미
 * 
 * 모래성이 무너진 경우, 그 격자는 모래성이 쌓여있지 않은 것으로 취급
 * 
 * 모래성이 더 이상 모양이 변하지 않게 되려면 파도가 몇번 쳐야하는지?
 * @author KOREA
 *
 */
public class Main_10711 {
	static int H,W;
	static int[][] arr;
	
	static int answer;
	
	//8방향 delta
	static int[] dx = {-1,-1,-1,0,1,1,1,0};
	static int[] dy = {-1,0,1,1,1,0,-1,-1};

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		H = Integer.parseInt(st.nextToken());
		W = Integer.parseInt(st.nextToken());

		arr = new int[H][W];
		answer = 0;
		
		ArrayDeque<int[]> queue = new ArrayDeque<>();
		
		for (int i=0;i<H;i++) {
			String input = br.readLine();
			for (int j=0;j<W;j++) {
				char tmp = input.charAt(j);
				if (tmp == '.') {
					//모래성이 없으면 큐에 넣기
					queue.add(new int[] {i,j});
				}
				else {
					arr[i][j] = tmp-'0';
				}
			}
		}

		
		//파도가 칠때마다 모래성에 닿으면 -1 --> 모래성이 0이되면 모래가 되고 queue에 넣기
		while (!queue.isEmpty()) {
			int queue_size = queue.size();
//			System.out.println(queue_size);
			
			for (int q=0;q<queue_size;q++) {
				int[] cur = queue.poll();
				int cur_x = cur[0];
				int cur_y = cur[1];
				
				//8방향 탐색
				for (int i=0;i<8;i++) {
					int nx = cur_x+dx[i];
					int ny = cur_y+dy[i];
					if (nx>=0 && nx<H && ny>=0 && ny<W) {
						//파도가 모래성에 닿으면
						if (arr[nx][ny] > 0) {
							arr[nx][ny]--;
							if (arr[nx][ny] == 0) {
								//새롭게 모래가 되는 부분 큐에 추가
								queue.add(new int[] {nx,ny});
//								System.out.println("added: "+nx+" "+ny);
							}
						}
					}
				}
			}
//			System.out.println();
			answer++;
		}
		System.out.println(answer-1);

	}
	
	//없어진 개수 0이면 변하지 않은 상태 ,,
//	public static int bfs() {
//		ArrayDeque<int[]> queue = new ArrayDeque<>();
//		queue.add(new int[] {0,0});
//		boolean[][] visited = new boolean[H][W];
//		visited[0][0] = true;
//		
//		int remove_cnt = 0;
//		ArrayList<int[]> remove = new ArrayList<>();
//		
//		while (!queue.isEmpty()) {
//			int cur[] = queue.poll();
//			int cur_x = cur[0];
//			int cur_y = cur[1];
//			
//			for (int i=0;i<4;i++) {
//				int nx = cur_x+dx[i];
//				int ny = cur_y+dy[i];
//				
//				if (nx>=0 && nx<H && ny>=0 && ny<W && !visited[nx][ny]) {
//					//모래성이면
//					if (arr[nx][ny]>=1) {
//						int cnt = count(nx,ny);
//						//튼튼하지 않으면
//						if (cnt>=arr[nx][ny]) {
//							visited[nx][ny] = true;
////							arr[nx][ny] = -1;
//							remove.add(new int[] {nx,ny});
//							remove_cnt++;
//						}
//						//튼튼하면
//						else {
//							visited[nx][ny] = true;
//							queue.add(new int[] {nx,ny});
//						}
//					}
//					//모래성이 없으면
//					else {
//						visited[nx][ny] = true;
//						queue.add(new int[] {nx,ny});
//					}
//				}
//			}
//			
//		}
//		
//		for (int[] xy : remove) {
//			arr[xy[0]][xy[1]] = -1;
//		}
//		
//		return remove_cnt;
//	}
//	
//	//8방향에 모래인 부분 갯수 세기
//	public static int count(int x, int y) {
//		int cnt = 0;
//		for (int dx=-1;dx<=1;dx++) {
//			for (int dy=-1;dy<=1;dy++) {
//				if (arr[x+dx][y+dy] == -1) cnt++;
//			}
//		}
//		return cnt;
//	}
//	
//	public static void printArr(int[][] arr) {
//		for (int i=0;i<H;i++) {
//			for (int j=0;j<W;j++) {
//				System.out.print(arr[i][j]+" ");
//			}
//			System.out.println();
//		}
//	}

}
