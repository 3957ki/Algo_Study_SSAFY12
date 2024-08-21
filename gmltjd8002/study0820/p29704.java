package meAlone;

import java.io.*;
import java.util.*;

/*
 * 0열에 소요일 수
 * 1열에 벌금들 대입
 * sum에 벌금들 합
 * TIL
 * dp만 1~n까지 받지않고 map도 1~n까지 인덱스 맞추기
 * dp -> 현재값은 이전값과 새로 갱신하는 값 중 조건에 부합한 값을 찾는 과정이다 0> 인덱스 잘 보기
 * */
public class p29704 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int t = Integer.parseInt(st.nextToken());
		int[][] map = new int[n+1][2];
		int sumPrice =0; // 총 벌금의 합계
		int res =0;
		int[][] dp = new int[n+1][t+1];
		for(int i=1; i<=n;i++) {
			st = new StringTokenizer(br.readLine());
			map[i][0] = Integer.parseInt(st.nextToken()); // 일 수
			map[i][1] = Integer.parseInt(st.nextToken()); // 벌금
		}
		
		for(int i=1; i<=n;i++) { 
			sumPrice += map[i][1];
		}
		
		for(int i=1; i<=n;i++) {
			for(int j=1; j<=t;j++) { // -> 여기서 t이하인 모든 경우의 수를 순회
				if(map[i][0] <= j){ // 소요일 합이 더 크면 dp로 값을 저장한다
					//현재값 = max(기존 값, 조건을 만족하는 새 갱신값)
					dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-map[i][0]] + map[i][1]); // 이전 값이랑 현재 갱신한 값 중 큰 값
				}else { // 그 외의 경우 값을 옮긴다
					dp[i][j] = dp[i-1][j]; 
				}
			}
		}
//		for(int i=t; i>=1;i--) {
//			dp[i] = Math.max(dp[i-1], dp[i-1-map[i][0]] + dp[map[i][1]]);
//		}
		res = sumPrice - dp[n][t];
		System.out.println(res);
	}

}
