package day0827;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B_22858_1번_원상복구 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken()); // 카드의 개수
		int K = Integer.parseInt(st.nextToken()); // 카드를 섞은 횟수
		st = new StringTokenizer(br.readLine());
		int last[] = new int[N];
		for (int i = 0; i < N; i++) {
			last[i] = Integer.parseInt(st.nextToken());
		}
		int Di[] = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			Di[i] = Integer.parseInt(st.nextToken());
		}
		// input end
		for (int i = 0; i < K; i++) {
			int tmp[] = new int[N];
			for (int j = 0; j < N; j++) {
				tmp[Di[j] - 1] = last[j];
			}
			for (int j = 0; j < N; j++) {
				last[j] = tmp[j];
			}
		}
		for (int i = 0; i < N; i++) {
			System.out.print(last[i]+" ");
		}
	}
}
