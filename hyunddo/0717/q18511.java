import java.io.*;
import java.util.*;

public class q18511 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()); // 첫째줄 (N, k 입력)
		StringTokenizer arr = new StringTokenizer(br.readLine()); // 둘째줄 (k 원소 입력)

		int N = Integer.parseInt(st.nextToken()); // N값
		int k = Integer.parseInt(st.nextToken()); // k값
		int Nlength = ((int) (Math.log10(N) + 1)); // N 길이
		int result = 0; // 결과

		int[] karr = new int[k];

		for (int i = 0; i < k; i++) {
			karr[i] = Integer.parseInt(arr.nextToken());
		}
		Arrays.sort(karr); // karr 정렬

		int num = 0;
		for (int j = Nlength-1; j >= 0; j--) { // k원소로 구성된 제일 작은 자연수 생성 -> num
			num += (int) Math.pow(10, j) * karr[0];
		}

		// N보다 num이 큼
		if (num > N) {
			for (int i = Nlength - 2; i >= 0; i--) {
				result += (int) Math.pow(10, i) * karr[k - 1];
			}
		}
		
		// num == N
		else if (num == N) {
			result = num;
		}

		// num이 N보다 작음 num < N
		else {
			for (int i = Nlength; i >= 0; i--) {
				// i번째 자릿수 구하기
				for (int j = 1; j < k; j++) {
					// i번째 자리를 karr[j]로 올렸을때 얼마나 올라감
					int diff = (karr[j] - karr[j - 1]) * (int) Math.pow(10, i - 1);
					if ((num + diff) > N) {
						break;
					} else {
						num += diff;
					}
				}
			}
			result = num;
		}

		System.out.println(result);
	}
}
