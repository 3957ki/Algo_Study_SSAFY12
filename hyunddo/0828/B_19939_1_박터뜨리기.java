package day0828;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B_19939_1_박터뜨리기 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		// input end
		
		int answer = 0;
		boolean flag = false;
		int sum = 0;
		for (int i = 1; i <= K; i++) {
			sum += i;
		}
		if (sum > N) {
			answer = -1;
			flag = true;
		}
		if (!flag) {
			N -= sum;
			if (N % K == 0) {
				answer = K - 1;
			} else if (N % K != 0) {
				answer = K;
			}
		}
		sb.append(answer);
		System.out.println(sb);
	}
}