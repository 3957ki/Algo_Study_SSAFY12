package study0808;
import java.io.*;
import java.util.*;

//다익스트라? -> dfs
//첫 트라이 -> nullpointer -> 어디가 0일까...(isVisit선언안했었음) -> curCost 갱신이 안되고있음
// isVisit이 첫번째 dfs 이후로 isVisit이 효과가 없음
public class p10971 {
	static int n, cost;
	static int[][] arr;
	static boolean[] isVisit; 
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		n = Integer.parseInt(br.readLine());
		arr = new int[n][n];
		isVisit = new boolean[n];
		for(int i=0; i<n;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<n;j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		cost = Integer.MAX_VALUE;
		for(int i=0; i<n;i++) {
			Arrays.fill(isVisit, false);
			isVisit[i] = true;
			dfs(0,0,0,0); //0,0에서 4,4까지 반복문 및 dfs로 재귀하면서 최소값 찾기
		}
		System.out.println(cost);
	}
	
	public static void dfs(int init, int cur, int step, int curCost) { // 시작위치, 현재위치, 단계?, 현재까지 가격
		if(step == n-1) { //n-1까지 가면 현재 비용 비교(경계값 체크랑 비슷한 느낌)
			//돌아갈 때 비용 계산할 코드
			if(arr[cur][init] != 0) { // 현재 위치에서 시작지점까지 돌아감 -> main의 for문에서 i가 n까지 증가하므로 여기선 이 부분만 구현
				curCost += arr[cur][init];
				cost = Math.min(cost, curCost); //기존 값과 비교해서 최소값 갱신
			}
			return;
		}
		
		for(int i=0; i<n;i++) {
			if((!isVisit[i]) && (arr[cur][i] > 0)) { //시작 위치에서 다음 값이 0이 아니고 방문한 적이 없는 곳으로 이동
				isVisit[i] = true; // 조건을 만족하므로 방문 표시
				dfs(init, i, step+1, curCost + arr[cur][i]); // 경로가 지정되었으므로 step과 현재 위치, 비용 갱신 
			}
		}
	}
}
