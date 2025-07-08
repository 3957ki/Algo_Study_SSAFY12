import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p2_16951 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		int[] arr = new int[N + 1];
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		int answer = Integer.MAX_VALUE;
		for (int i = 1; i <= 1000; i++) {
			int count = 0;
			int temp = i;
			for (int j = 0; j < N; j++) {
				temp = i + (K * j);
				if (arr[j] != temp) {
					count++;
				}
			}
			answer = Math.min(count, answer);
		}
		System.out.println(answer);
	}
}
