import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class p2_1758 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(br.readLine()) * (-1);
		}
		Arrays.sort(arr);
		for (int i = 0; i < n; i++) {
			arr[i] *= (-1);
		}
		long answer = 0;
		for (int i = 0; i < n; i++) {
			if (arr[i] - i < 0) {
				continue;
			}
			answer += arr[i] - i;
		}
		System.out.println(answer);
	}
}