import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p2_1189 {

	static int[] dx = {0, 0, 1, -1};
	static int[] dy = {1, -1, 0, 0};
	static int N, M, K, answer;
	static char[][] map;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		map = new char[N][M];
		for(int i = 0; i < N; i++) {
			map[i] = br.readLine().toCharArray();
		}
//		시작지점에서 방문표시 후 DFS
		DFS(N-1, 0, 1, 1<<(N-1)*M);
		
		System.out.println(answer);
	}

	static void DFS(int y, int x, int dst, int visited) {
//		도착점이고 길이가 K이면 answer++ 
		if(y == 0 && x == M-1) {
			if(dst == K) answer++;
			return;
		}
//		도착안했는데 길이가 K가되면 return
		if(dst == K) return;
//		4방 탐색
		for(int d = 0; d < 4; d++) {
			int Y = y + dy[d];
			int X = x + dx[d];
//			방문했거나 장애물이면 패스
			if(X < 0 || X >= M || Y < 0 || Y >= N || ((visited & 1<<(Y*M + X)) != 0) || map[Y][X] == 'T') continue;
//			다음 탐색
			DFS(Y, X, dst+1, (visited | 1<<(Y*M + X)));
		}
	}
}