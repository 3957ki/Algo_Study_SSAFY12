import java.io.*;

public class q14495 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine()); // 자연수 n

		long arr[] = new long[n + 1];

		for (int i = 1; i < n + 1; i++) {
			if (i > 3) {
				arr[i] = arr[i - 1] + arr[i - 3];
			}
			else
				arr[i] = 1;
		}

		System.out.println(arr[n]);
	}
}
