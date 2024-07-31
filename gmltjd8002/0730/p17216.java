package study0730;
import java.io.*;
import java.util.*;

public class p17216 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];
		int[] dp = new int[n];
		int val = 0;
		st = new StringTokenizer(br.readLine());
		
		for(int i=0; i<n;i++) {
			arr[i] = Integer.parseInt(st.nextToken()); //값
		}
		
		dp = Arrays.copyOf(arr, arr.length); // 카피한 다음에 값 변경하는 방식으로?
		
		for(int i=0;i<n;i++) {
			for(int j=0; j<i;j++) {
				if(arr[i] < arr[j]) {
					dp[i] = Math.max(dp[i], dp[j] + arr[i]);
				}
			}
			val = Math.max(val, dp[i]);
		}
		/*
		 부분 수열이므로 값들이 연속되어있단 보장도 없다. (여기서 좀 헤맸음)
		 i는 배열을 순회하고, j는 부분 수열을 구현하는 부분인데 
		 이 때 감소 부분이면
		 dp[i]값은 그대로거나 dp[j]에 현재 위치 값인 arr[i]를 더한 값 중 최대값으로 갱신한다
		 첫 for문을 빠져나와서 기존의 최대값과 현재의 최대값을 비교해 val 변수에 기록한다
		 */
		System.out.println(val);
	}
}
