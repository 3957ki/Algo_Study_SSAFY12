import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p4_13019 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] A = br.readLine().toCharArray();
		char[] B = br.readLine().toCharArray();
		int[] alpha = new int[26];
		for (int i = 0; i < A.length; i++) {
			alpha[A[i] - 65]++;
			alpha[B[i] - 65]--;
		}

		for (int num : alpha) {
			if (num != 0) {
				System.out.println(-1);
				return;
			}
		}

		int start = A.length - 1;
		int answer = A.length;
		Label: for (int i = B.length - 1; i >= 0; i--) {
			for (int j = start; j >= 0; j--) {
				if (A[j] == B[i]) {
					start = j - 1;
					answer--;
					continue Label;
				}
				if (j == 0) {
					break Label;
				}
			}
		}
		System.out.println(answer);
	}
}
