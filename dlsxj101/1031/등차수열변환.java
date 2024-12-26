import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 등차수열변환 {
	static int N, B[], min;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine().trim());
		
		B = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			B[i] = Integer.parseInt(st.nextToken());
		}
		
		//수열이 1개, 2개일 때는 무조건 등차수열 성립
		if(N == 1 || N == 2) {
			System.out.println(0);
			return;
		}
		
		min = Integer.MAX_VALUE;
		dfs(0, 0, 0, B[0]);
		
		if(min == Integer.MAX_VALUE) System.out.println(-1);
		else System.out.println(min);
	}
	/**
	 * @param cnt : 깊이
	 * @param nowDiff : 이전 값과의 차이
	 * @param operCnt : 연산 횟수
	 * @param prev : 이전 값
	 */
	static void dfs(int cnt, int nowDiff, int operCnt, int prev) {
		if(cnt == N-1) {
			if(nowDiff == prev-B[cnt]+1 || nowDiff == prev-B[cnt]-1) operCnt++;
			else if(nowDiff != prev-B[cnt]) return;
			
			min = Math.min(min, operCnt);
			return;
		}
		
		if(operCnt > min) return;	//가지치기
		
		// 맨 처음과 두번째는 무조건 3갈래로 나뉘어짐
		if(cnt == 0) {	//맨 처음은 이전 값이 없으므로 차이를 구할 수 없어서 무조건 3갈래
			dfs(cnt+1, nowDiff, operCnt+1, prev-1);
			dfs(cnt+1, nowDiff, operCnt, prev);
			dfs(cnt+1, nowDiff, operCnt+1, prev+1);
		}
		
		if(cnt == 1) {	//두번째는 이전 값과 차이는 있지만 이전 값과의 차이만 있을 뿐 차이의 변화를 알 수 없으므로 무조건 3갈래
			dfs(cnt+1, prev-B[cnt]+1, operCnt+1, B[cnt]-1);
			dfs(cnt+1, prev-B[cnt], operCnt, B[cnt]);
			dfs(cnt+1, prev-B[cnt]-1, operCnt+1, B[cnt]+1);
		}
		
		//그 외에는 특정 상황만 탐색(이전 값과의 차이가 유지될 경우만 탐색 진행)
		if(nowDiff == prev-B[cnt]+1) dfs(cnt+1, nowDiff, operCnt+1, B[cnt]-1);
		if(nowDiff == prev-B[cnt]) dfs(cnt+1, nowDiff, operCnt, B[cnt]);
		if(nowDiff == prev-B[cnt]-1) dfs(cnt+1, nowDiff, operCnt+1, B[cnt]+1);
	}
}