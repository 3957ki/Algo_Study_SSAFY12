import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_study_1_10971 {
	static int N;
	static int[][] W;
	static boolean[] visited;
	static int min = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());

		W = new int[N][N];
		visited = new boolean[N];

		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++) {
				W[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i = 0; i < N; i++) {
			Arrays.fill(visited, false);	//visited 배열을 전부 false로 채움(방문 배열 초기화)
			method(i, i, 1, 0);
		}
		System.out.println(min);
	}
	
	public static void method(int start, int initNum, int cnt, int cost) { //시작 위치, 가장 초기값, 단계?, 현재 비용
		if(cnt == N) {	//단계가 마지막까지 왔을 경우 가장 초기 도시로 이동하는 비용을 더하여 최솟값과 비교
			if(W[start][initNum] != 0) {	//마지막 도시에서 가장 처음 도시로 이동하는 경로가 없을 경우 최솟값 비교를 진행하지 않음
				cost += W[start][initNum];
				min = Math.min(min, cost);
			}
			return;
		}
		
		visited[start] = true;
		for(int i = 0; i < N; i++) {
			if( (W[start][i] == 0) || visited[i] ) continue;	//도시를 이동할 경로가 없거나, 이미 방문한 경우 그냥 넘어감
			
			int newCost = cost + W[start][i];
			method(i, initNum, cnt + 1, newCost);
		}
		visited[start] = false;	//다시 상위 단계에서 새롭게 탐색을 진행해야 하므로 방문배열 복원(백트래킹)
		
	}
}