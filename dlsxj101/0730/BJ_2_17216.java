import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_2_17216 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int[] A = new int[N];
		int[] dp = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		//수열 A에 입력값 입력(이때 수열 A와 완전히 동일한 dp배열 대입)
		for(int i = 0; i < N; i++) {
			A[i] = dp[i] = Integer.parseInt(st.nextToken());
		}
		
		//N이 1일 때는 dp로 탐색할 필요 없이 값 출력
		if(N==1) {
			System.out.println(A[0]);
			return;
		}
		
		for(int i = 1; i < N; i++) {
			for(int j = 0; j < i; j++) {
				if(A[i] < A[j]) {
					dp[i]=Math.max(dp[j]+A[i], dp[i]);	//dp[i]는 0부터 i까지의 부분 감소 수열의 최댓값이 입력됨
				}										//이때 기존 dp배열에 있던 값과 비교하여 계산값이 더 클 경우 dp배열에 입력시킴
			}
		}
		int max = 0;
		for(int i = 0; i < N; i++) {
			max = Math.max(max, dp[i]);
		}
		System.out.println(max);
	}
}

