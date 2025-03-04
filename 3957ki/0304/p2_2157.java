import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class p2_2157 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		// 인접 행렬
		int[][] edges = new int[N + 1][N + 1];

		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());

			if (start > end)
				continue;

			edges[start][end] = Math.max(cost, edges[start][end]);
		}

		// dp 배열 map(cnt, maxCost)
		Map<Integer, Integer>[] dp = new Map[N + 1];
		for (int i = 1; i <= N; i++) {
			dp[i] = new HashMap<>();
		}

		// 시작 지점은 지역 1개 방문했고 점수 0
		dp[1].put(1, 0);

		// 다음 지점
		for (int i = 2; i <= N; i++) {
			// 어디서 왔는지
			for (int j = 1; j < i; j++) {
				// 못가면 패스
				if (edges[j][i] == 0)
					continue;

				// 갈 수 있으면 이전 지점을 몇번만에 왔고 최대 점수가 얼만지 탐색
				for (Integer cnt : dp[j].keySet()) {
					// 현재 지점을 cnt 만에 왔을때 최대 점수로 갱신
					dp[i].put(cnt + 1, Math.max(dp[i].getOrDefault(cnt + 1, 0), dp[j].get(cnt) + edges[j][i]));
				}
			}
		}

		int max = 0;
		for (Integer cnt : dp[N].keySet()) {
			// 방문한 도시가 M개 넘으면 패스
			if (cnt > M)
				continue;
			max = Math.max(max, dp[N].get(cnt));
		}
		System.out.println(max);
	}
}