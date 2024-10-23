import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 메모리초과는 해결했는데...
 * 왜 틀리지?
 * 
 * 
 * @author SSAFY
 *
 */

public class Main_B_29704 {

	public static void main(String[] args) throws Exception{
		//System.setIn(new FileInputStream("res/b_29704.txt"));
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(bf.readLine());
		int N = Integer.parseInt(st.nextToken());
		int T = Integer.parseInt(st.nextToken());
		int[][] arr = new int[N + 1][];

		int max = 0;
		int maxDay = 0;
		for(int i = 1;i < N + 1;i++){
			StringTokenizer st2 = new StringTokenizer(bf.readLine());
			int d = Integer.parseInt(st2.nextToken());
			int m = Integer.parseInt(st2.nextToken());

			arr[i] = new int[] {d,m};
			max += m;
			maxDay += d;
		}

		//여기가 maxDay만큼이 아니고 T만큼만 있으면 된다?
		int[][] dp = new int[N + 1][T + 1];

		for(int v = 0;v < N + 1;v++) {
			for(int w = 0;w < T + 1;w++) {
				dp[v][w] = -1; 
			}
		}

		for(int i = 0;i < N + 1;i++) {
			dp[i][T] = max;
		}
		//System.out.println((N+1) + " " + (maxDay+1));
		for(int i = 1;i < N + 1;i++) {
			for(int j = T;j >= 0;j--) {
				// 방문한적 없는 시간이면 스킵
				if(dp[i-1][j] == -1) continue;
				// 현재 시간에 값이 존재하면 받아옴.
				if(dp[i][j] == -1) {
					dp[i][j] = dp[i-1][j]; 
				} 
				// 현재시간에 값이 존재할 때 현재값이 작은지 이전 값이 작은지 비교 후 저장
				else {
					dp[i][j] = Math.min(dp[i][j], dp[i-1][j]);
				}
				// 소모시간이 더 T보다 많아지면 기록안함
				if(j - arr[i][0] < 0) continue;
				// 같은 시간에 방문한적 없으면 그냥 기록
				if(dp[i-1][j - arr[i][0]] == -1) {
					dp[i][j - arr[i][0]] = dp[i-1][j] - arr[i][1];
				} 
				//같은 시간에 기존 값이 작은지, 현재값이 작은지 비교
				else {
					dp[i][j - arr[i][0]] = Math.min(dp[i-1][j - arr[i][0]],dp[i-1][j] - arr[i][1]);
				}
				//System.out.println(dp[i-1][j - arr[i][0]] + " " + (dp[i-1][j] - arr[i][1]));
			}
		}
		int result = Integer.MAX_VALUE;
		for(int v = 0;v < T + 1;v++) {
			if(dp[N][v] < 0) continue;
			result = Math.min(dp[N][v], result);
		}
		System.out.println(result);

	}
}