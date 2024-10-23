import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class 채굴 {
	
	static int N, M, K, map[][];
	static int dr[] = {-1, 1, 0, 0};	// 상 하 좌 우
	static int dc[] = {0, 0, -1, 1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		map = new int[N+2][M+2];
		
		for(int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 1; j <= M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		Arrays.fill(map[N+1], -1);
		
		int ans = Integer.MAX_VALUE;
		
		int low = 1;
		int high = 1000001;
		
		A : while(low <= high) {
			int mid = (low+high) / 2;
			
			Queue<int[]> q = new ArrayDeque<>();
			boolean visited[][] = new boolean[N+2][M+2];
			
			q.add(new int[] {0, 0});
			visited[0][0] = true;
			
			int cnt = 0;
			while(!q.isEmpty()) {
				int tmp[] = q.poll();
				
				int r = tmp[0];
				int c = tmp[1];
				
				for(int d = 0 ; d < 4; d++) {
					int nr = r + dr[d];
					int nc = c + dc[d];
					
					if( (nr>=N+2) || (nc>=M+2) || (nr<0) || (nc<0) ) continue;	//경계조건
					if(map[nr][nc] > mid) continue;	//채굴할 수 없으면 패스
					if(map[nr][nc] == -1) continue;	//바닥이면 패스
					if(visited[nr][nc]) continue;	//방문했으면 패스
					
					visited[nr][nc] = true;
					q.add(new int[] {nr, nc});
					
					if(map[nr][nc]==0) continue;	//채굴 현황 갱신할 건데 패딩된 부분이면 패스
					
					//채굴 현황 갱신
					cnt++;	//채굴 한 것 개수 세기
					if(cnt >= K) {	//채굴한 것의 개수가 목표치를 넘어가면 일단 high값 줄여서 탐색해보기
						ans = Math.min(ans, mid);	//일단 목표치는 넘었으니까 최소값 갱신해놓기
						high = mid - 1;
						continue A;
					}
				}
			}
			low = mid + 1;	//목표치 달성 못했으면 low값 높여서 다시 탐색해보기
		}
		System.out.println(ans);
	}
}