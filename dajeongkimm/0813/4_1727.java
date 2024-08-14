import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 메모리 : 15712 KB
 * 시간 : 104 ms
 * 
 * 남자 n명 , 여자 m명
 * 1. 최대한 많은 커플
 * 2. 각 커플을 이루는 두 사람의 성격의 차이의 합이 최소가 되도록 ,, 
 * 
 * dp[i][j] : 남자 (1~i)와 여자 (1~j)가 커플이 될 때 성격차이 합의 최솟값 
 */
public class Main_B_1727_커플만들기 {
	static int answer = Integer.MAX_VALUE;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		int[] arr_n = new int[n];
		int[] arr_m = new int[m];
		
		
		
		st = new StringTokenizer(br.readLine());
		for (int i=0;i<n;i++) {
			arr_n[i] = Integer.parseInt(st.nextToken());
		}
		
		st = new StringTokenizer(br.readLine());
		for (int i=0;i<m;i++) {
			arr_m[i] = Integer.parseInt(st.nextToken());
		}
		
		// DP를 사용하기 위해서는 최적 부분 구조가 성립해야 함 --> "정렬"하고 나서 dp 진행해야함
		Arrays.sort(arr_n);
		Arrays.sort(arr_m);
		
		int[][] dp = new int[n+1][m+1];
		
		for (int i=1;i<=n;i++) {
			for (int j=1;j<=m;j++) {
				dp[i][j] = dp[i-1][j-1] + Math.abs(arr_n[i-1]-arr_m[j-1]);
				//남자가 여자보다 많으면
				// i번째 남자는 솔로이거나 커플이거나 --> 둘 중 최솟값
				if (i>j) {
					dp[i][j] = Math.min(dp[i][j], dp[i-1][j]);
				//여자가 남자보다 많으면
				// j번째 여자는 솔로이거나 커플이거나 --> 둘 중 최솟값
				} else if (i<j) {
					dp[i][j] = Math.min(dp[i][j], dp[i][j-1]);
				}
			}
		}
		
		System.out.println(dp[n][m]);
		
		
		
	}
}