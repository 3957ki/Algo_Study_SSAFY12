import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class p3_3079 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		long M = Long.parseLong(st.nextToken());
		long[] arr = new long[N + 1];
		for (int i = 1; i <= N; i++) {
			arr[i] = Long.parseLong(br.readLine());
		}
//		게이트 통과 시간을 오름차순으로 정렬
		Arrays.sort(arr);
		long low = 1;
		long high = arr[N] * M;
		long mid = 0;
		long sum = 0;
//		이진 탐색
		Label: while (low <= high) {
			mid = (low + high) / 2;
			sum = 0;
			for (int i = 1; i <= N; i++) {
//				mid 시간안에 해당 게이트에서 통과 가능한 사람 수 더하기
				sum += mid / arr[i];
//				통과 가능한 사람 수가 M 이상일 때
				if (sum >= M) {
					high = mid - 1;
					continue Label;
				}
//				통과 가능한 사람 수가 M보다 작을 때
				if (i == N && sum < M) {
					low = mid + 1;
					continue Label;
				}
			}
		}
//		통과 가능한 사람 수가 M보다 작으면 mid+1 시간이 최소 시간
		System.out.println((sum < M) ? ++mid : mid);
	}
}