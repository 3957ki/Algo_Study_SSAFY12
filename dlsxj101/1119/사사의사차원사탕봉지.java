import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/*
 */
public class 사사의사차원사탕봉지 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		long A[] = new long[M];
		st = new StringTokenizer(br.readLine());
		A[0] = Long.parseLong(st.nextToken());
		for(int i = 1; i < M; i++) {
			A[i] = A[i-1] + Long.parseLong(st.nextToken());
		}

		A : for(int i = 0; i < N; i++) {
			long B = Long.parseLong(br.readLine().trim());

			if(A[M-1] < B) {
				sb.append("Go away!").append("\n");
				continue;
			}

			int low = 0;
			int high = M-1;
			int ans = 0;
			while(low <= high) {
				int mid = (low + high) / 2;

				if(A[mid] == B) {
					sb.append(mid+1).append("\n");
					continue A;
				}
				if(A[mid] > B) {
					high = mid -1;
					ans = mid + 1;
				}else low = mid + 1;
			}
			sb.append(ans).append("\n");
		}
		System.out.println(sb);
	}
}















