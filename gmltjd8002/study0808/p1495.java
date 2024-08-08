package study0808;

import java.io.*;
import java.util.*;
// dp -> 유효한 이전 탐색의 값을 저장해서 다음에 사용
// dp [n+1][m+1] 배열로 선언
// int 형태로 풀다가 코드가 조금 꼬임 -> dfs 방문체크 하는것처럼 boolean타입으로 바꿈 -> 해당 인덱스랑 m 비교

public class p1495 {
	static int n,s,m;
	static int[] V;
	static int[][] dp;
	static boolean[][] isPossible;
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken()); // 곡 개수
		s = Integer.parseInt(st.nextToken()); // 시작 볼륨
		m = Integer.parseInt(st.nextToken()); // 최대 볼륨
		V= new int[n+1];
		dp = new int[n+1][m+1]; 
		isPossible = new boolean[n+1][m+1]; //[곡순서][가능한최대볼륨]
		dp[0][s] = s;
		isPossible[0][s] = true;
		st = new StringTokenizer(br.readLine());
		for(int i=1;i<=n;i++) {
			V[i] = Integer.parseInt(st.nextToken()); // 둘째 줄 값
			for(int p =0;p<=m;p++) { // 최대 볼륨까지
				if(isPossible[i-1][p]) {
					int min = p - V[i];
					int max = p + V[i];
					if(max <=m) isPossible[i][max] = true; // m을 넘지 않는 값이면 true
					if(min >= 0) isPossible[i][min] = true; // 0 보다 작다의 여집합 -> 0이상
					//if(max <=m) dp[i][p] = dp[i][max];
					//if(min >=0) dp[i][p] = dp[i][min];
				}
			}
		}
		int res = -1;
		for(int i =m; i>=0;i--) { // i가 최대 볼륨에 가장 가까운 인덱스부터 시작
			if(isPossible[n][i]) { // true면 그게 이론상 가능한 최대 볼륨
			//if(dp[n][i] <= m) // 볼륨이
				res = i; // 값 받고
				break; // 루프 깨고
			}
		}
		System.out.println(res); // 출력
	}
}