import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class p4_19238 {

	static Queue<Node> queue = new ArrayDeque<>();
	static int N, M, K;
	static int[][] map;
	static int[] dx = {0, 0, 1, -1};
	static int[] dy = {1, -1, 0, 0};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		map = new int[N+1][N+1];
		
		for(int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 1; j <= N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
//		시작지점
		st = new StringTokenizer(br.readLine());
		int start_y = Integer.parseInt(st.nextToken());
		int start_x = Integer.parseInt(st.nextToken());
//		승객 위치에 목적지 좌표 int값으로 저장
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int y = Integer.parseInt(st.nextToken());
			int x = Integer.parseInt(st.nextToken());
			int dst_y = Integer.parseInt(st.nextToken());
			int dst_x = Integer.parseInt(st.nextToken());
			map[y][x] = -((dst_y-1)*N + dst_x-1)-1;
		}
//		탐색 시작
		bfs1(start_y, start_x);
		
		System.out.println(K);
		
	}
	
	static void bfs1(int start_y, int start_x) {
		boolean[][] visited = new boolean[N+1][N+1];
//		시작지점이 승객위치라면 거리0으로하고 목적지 이동
		if(map[start_y][start_x] < 0) {
			bfs2(start_y, start_x, 0);
			return;
		}
		queue.add(new Node(start_y, start_x));
		visited[start_y][start_x] = true;
		
		int distance = 1;
		boolean flag = false;
		int nxt_y = Integer.MAX_VALUE;
		int nxt_x = Integer.MAX_VALUE;
		int nxt_dst = Integer.MAX_VALUE;
		while(!queue.isEmpty()) {
			int L = queue.size();
			for(int i = 0; i < L; i++) {
				Node node = queue.poll();
				for(int d = 0; d < 4; d++) {
					int y = node.y + dy[d];
					int x = node.x + dx[d];
					if(x < 1 || x > N || y < 1 || y > N || visited[y][x] || map[y][x] == 1) continue;
//					승객을 만나면 같은거리의 가장 작은 승객 좌표로 값 저장
					if(map[y][x] < 0) {
						flag = true;
						if(nxt_y > y) {
							nxt_y = y;
							nxt_x = x;
							nxt_dst = distance;
						}
						else if(nxt_y == y) {
							nxt_x = Math.min(nxt_x, x);
							nxt_dst = distance;
						}
					}
					queue.add(new Node(y, x));
					visited[y][x] = true;
				}
			}
//			승객을 만난적이 있다면 탐색 종료
			if(flag) {
				queue.clear();
				break;
			}
			distance++;
		}
//		승객을 만난적이 없다면 -1출력하고 종료
		if(!flag) {
			System.out.println(-1);
			System.exit(0);
		}
//		목적지 이동
		bfs2(nxt_y, nxt_x, nxt_dst);
	}
	
	static void bfs2(int nxt_y, int nxt_x, int nxt_dst) {
//		목적지 좌표 구하기
		int dst_y = ((map[nxt_y][nxt_x])*(-1) - 1)/N+1;
		int dst_x = ((map[nxt_y][nxt_x])*(-1) - 1)%N+1;
		int nxt_dst2 = Integer.MAX_VALUE;
		
		int distance = 1;
		map[nxt_y][nxt_x] = 0;
//		현재 위치가 목적지 좌표라면
		if(nxt_y == dst_y && nxt_x == dst_x) {
//			연료가 떨어졌다면 -1출력하고 종료
			if(K < nxt_dst) {
				System.out.println(-1);
				System.exit(0);
			}
			
//			연료와 남은 승객 수 업데이트하고 다음 승객 찾기
			K = K - nxt_dst;
			M--;
			if(M == 0) {
				return;
			}
			bfs1(dst_y, dst_x);
			return;
		}
		
		boolean[][] visited = new boolean[N+1][N+1];
		queue.add(new Node(nxt_y, nxt_x));
		visited[nxt_y][nxt_x] = true;

		A: while(!queue.isEmpty()) {
			int L = queue.size();
			for(int i = 0; i < L; i++) {
				Node node = queue.poll();
				for(int d = 0; d < 4; d++) {
					int y = node.y + dy[d];
					int x = node.x + dx[d];
					if(x < 1 || x > N || y < 1 || y > N || visited[y][x] || map[y][x] == 1) continue;
//					목적지에 도착했다면 거리저장 후 탐색 종료
					if(x == dst_x && y == dst_y) {
						nxt_dst2 = distance;
						queue.clear();
						break A;
					}
					queue.add(new Node(y, x));
					visited[y][x] = true;
				}
			}
			distance++;
		}
//		연료가 떨어졌다면 -1출력 후 종료
		if(K < nxt_dst + nxt_dst2) {
			System.out.println(-1);
			System.exit(0);
		}
//		연료와 남은 승객 수 업데이트 후 다음 승객 탐색
		K = K - nxt_dst + nxt_dst2;
		M--;
		if(M == 0) {
			return;
		}
		bfs1(dst_y, dst_x);
	}

	static class Node{
		int y, x;

		public Node(int y, int x) {
			this.y = y;
			this.x = x;
		}
		
	}
}
