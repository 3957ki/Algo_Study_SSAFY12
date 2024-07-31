import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p2_17216 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] arr = new int[n + 1];
		int[] dp = new int[n + 1];
//		dp값을 arr값으로 초기화
		for (int i = 1; i <= n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			dp[i] = arr[i];
		}
//		n이 1이면 arr[1] 출력하고 끝내기
		if (n == 1) {
			System.out.println(arr[1]);
			return;
		}
		int answer = arr[1];
		for (int i = 2; i <= n; i++) {
			for (int j = i - 1; j >= 1; j--) {
//				거꾸로 탐색하며 자신이 들어갈 수 있는 조합 중 최대값을 dp값으로 저장
				if (arr[j] > arr[i]) {
					dp[i] = Math.max(dp[i], dp[j] + arr[i]);
				}
			}
//			i까지 조합 중 최대값을 갱신
			answer = Math.max(dp[i], answer);
		}

		System.out.println(answer);

	}
}
