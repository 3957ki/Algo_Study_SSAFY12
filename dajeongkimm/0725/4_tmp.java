import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

class Main {
	static int N,M;
	static int[][] arr;
	static boolean[][] globalVisited;
	static int[] dx = {0,0,1,-1};
	static int[] dy = {1,-1,0,0};
	
	static boolean debug = false;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		int answer = 0;
		arr = new int[N][N];
		for (int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for (int j=0;j<N;j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		while (true) {
			// 1. 크기가 가장 큰 블록 그룹 (무지개 블록 수가 가장 많은 블록)
			// globalVisited, visited, blockVisited
			globalVisited = new boolean[N][N];
			
			boolean[][] removeBlock = new boolean[N][N];
			int[][] blockVisited = new int[N][N];
			
			int cur_count = 0;
			int max_count = 0;
			int cur_rainbow = 0;
			int max_rainbow = 0;
			for (int i=0;i<N;i++) {
				for (int j=0;j<N;j++) {
					if (arr[i][j] > 0 && globalVisited[i][j] == false) {
						cur_count = 0;
						cur_rainbow = 0;
						boolean[][] visited = new boolean[N][N];
						globalVisited[i][j] = true;
						visited[i][j] = true;
						
						int color = arr[i][j];
						
						ArrayDeque<int[]> queue = new ArrayDeque<>();
						queue.add(new int[] {i,j,0});
						cur_count = 0;
						while (!queue.isEmpty()) {
							int[] cur = queue.poll();
							int x = cur[0];
							int y = cur[1];
							int rainbow = cur[2];
							
							cur_rainbow = Math.max(cur_rainbow, rainbow);
							
							for (int k=0;k<4;k++) {
								int nx = x+dx[k];
								int ny = y+dy[k];
								
								
								if (nx>=0 && nx<N && ny>=0 && ny<N && !visited[nx][ny]) {
									//무지개 블록일 때
									if (arr[nx][ny] == 0) {
										visited[nx][ny] = true;
										queue.add(new int[] {nx,ny,rainbow+1});
									} 
									//일반 블록일 때 
									else if (arr[nx][ny]==color) {
										globalVisited[nx][ny] = true;
										visited[nx][ny] = true;
										queue.add(new int[] {nx,ny,rainbow});
									}
								}
							}
							
						}
						
						for (int x=0;x<N;x++) {
							for (int y=0;y<N;y++) {
								if (visited[x][y]) {
									cur_count++;
								}
							}
						}
						if (max_count<cur_count || (max_count == cur_count && max_rainbow <= cur_rainbow)) {
							max_count = cur_count;
							max_rainbow = cur_rainbow;
							removeBlock = visited;
							
						}
						
					}
				}
			}
			// 블록 크기가 2 미만이면 stop!
			if (max_count<2) break;
			answer += max_count*max_count;
			
			// 2. 블록 그룹 제거
			for (int i=0;i<N;i++) {
				for (int j=0;j<N;j++) {
					if (removeBlock[i][j]) {
						arr[i][j] = -2;
					}
				}
			}
			if (debug) {
				printArr();
			}
			
			// 3. 중력 작용
			gravity(arr);
			
			if(debug) {
				System.out.println("After Gravity");
				printArr();
			}
			// 4. 90도 반시계 방향 회전
			arr = turn(arr);
			// 5. 중력 작용
			gravity(arr);
		}
		
		System.out.println(answer);
	}
	
	private static void gravity(int[][] arr) {
		for (int i=N-2;i>=0;i--) {
			for (int j=0;j<N;j++) {
				if (arr[i][j] > -1) {
					int cur_i = i;
					while (true) {
						if ((cur_i+1<N) && arr[cur_i+1][j]==-2) {
							cur_i++;
						} else break;
					}
					if (i == cur_i) continue;
					int tmp = arr[i][j];
					arr[cur_i][j] = tmp;
					arr[i][j] = -2;
				}
			}
		}
	}
	
	private static int[][] turn(int[][] arr) {
		int[][] result = new int[N][N];
		for (int i=0;i<N;i++) {
			for (int j=0;j<N;j++) {
				result[i][j] = arr[j][N-1-i];
			}
		}
		return result;
	}
	
	private static void printArr() {
		for (int i=0;i<arr.length;i++) {
			for (int j=0;j<arr[0].length;j++) {
				System.out.print(arr[i][j]+" ");
			}
			System.out.println();
		}
		
	}
}