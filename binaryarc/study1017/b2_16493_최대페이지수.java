package study1017;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


//0 1 냅색
public class b2_16493_최대페이지수 {
	static int N, M;
	static int[][] chapter;
	static int ans;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		chapter = new int[M+1][2];
		for (int i = 1; i <= M; i++) {
			st = new StringTokenizer(br.readLine());
			chapter[i][0] = Integer.parseInt(st.nextToken()); // 소요 일수
			chapter[i][1] = Integer.parseInt(st.nextToken()); // 페이지 수
		}
		
		//dp 테이블은 i일까지의 최대 페이지수 저장
		int[][] dp = new int[21][201];

		for (int i = 1; i <= M; i++) {
			for (int day = 0; day <= N; day++) {
				if(day - chapter[i][0] >= 0) {
					//지금 챕터의 소요 날짜 전까지의 페이지 최대값 + 지금챕터 페이지 값 , 지금 날짜의 최대값 비교
					dp[i][day] = Math.max(dp[i-1][day - chapter[i][0]] + chapter[i][1], dp[i-1][day]);
				}
				dp[i][day] = Math.max(dp[i-1][day],dp[i][day]);
			}
		}
		System.out.println(dp[M][N]);

	}

}
