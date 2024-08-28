import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 오렌지 출하
 * N개의 오렌지를 상자에 넣어서 
 * i번째 오렌지의 크기는 Ai
 * 
 * 한 상자에 넣는 오렌지의 번호는 연속해야 함
 * 
 * 한 상자에는 최대 M개의 오렌지를 넣을 수 있음
 * 
 * 상자에 오렌지를 넣는 비용 : K + s (a-b)
 * a : 상자에 넣은 가장 큰 오렌지의 크기
 * b : 상자에 넣은 가장 작은 오렌지의 크기
 * s : 상자에 넣은 오렌지의 개수
 * 
 * K : 상자를 포장하는 비용
 * 
 * 모든 오렌지를 포장하는 비용의 최솟갑 구하기
 * @author SSAFY
 *
 */
public class Main_11985 {
	static int N,M,K;
	// 1<=N<=20_000
	// 1<=M<=1000
	// M<=N
	static int[] arr;

	static long[] dp;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		arr = new int[N];
		for (int i=0;i<N;i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		dp = new long[N];
		dp[0] = K; 

		
		for (int i=1;i<N;i++) {
			
			dp[i] = dp[i-1]+K; 
			
			int minj = Math.max(0,  i-M+1);
			
			int min = arr[i];
			int max = arr[i];
			
			for (int j=i-1;j>=minj;j--) {
				min = Math.min(min, arr[j]);
				max = Math.max(max, arr[j]);
				
				if (j-1>=0) {
					dp[i] = Math.min(dp[i], K + (long) (i-j+1)*(max-min) + dp[j-1]);
				} else {
					dp[i] = Math.min(dp[i], K + (long) (i-j+1)*(max-min) + 0);
				}
				
			}
		}
//		System.out.println(Arrays.toString(dp));
		System.out.println(dp[N-1]);
	
	}

}