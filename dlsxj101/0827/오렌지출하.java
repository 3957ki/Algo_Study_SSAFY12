import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 오렌지출하 {
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		long K = Long.parseLong(st.nextToken());

		long[] A = new long[N+1];

		for(int i = 1; i <= N; i++) A[i] = Long.parseLong(br.readLine().trim());

		long[] dp = new long[N+1];
		dp[0] = 0;

		for(int i = 1; i <= N; i++) {
			long min = dp[i-1]+(A[i]+K);	//오렌지를 1개만 담을 때의 비용을 기본값으로 지정
			long a = A[i];		// 우선 현재 오렌지 크기를 a, b에 지정
			long b = A[i];
			for(int j = 1; j <= M; j++) {	// 오렌지를 2개 ~ M개까지 담아보며 dp에 담을 최솟값 갱신
				if(i-j < 0) continue;
				
				// 오렌지를 2개 담았을 때부터 오렌지가 추가될 때마다 매번 a, b를 갱신해가면서 계산
				a = Math.max(a, A[i-j+1]);	
				b = Math.min(b, A[i-j+1]);

				long val = K + (long)j * (a - b);
				min = Math.min(min, dp[i-j] + val);

				dp[i] = min;
			}
		}
		System.out.println(dp[N]);
	}
}