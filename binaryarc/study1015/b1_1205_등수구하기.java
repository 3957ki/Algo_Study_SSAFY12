package study1015;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.StringTokenizer;

public class b1_1205_등수구하기 {
	static int N, P;
	static long new_score;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		new_score = Long.parseLong(st.nextToken());
		P = Integer.parseInt(st.nextToken());

		if (N == 0) {
			System.out.println(1);
			return;
		}

		Long[] arr = new Long[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Long.parseLong(st.nextToken());
		}

		Arrays.sort(arr, Collections.reverseOrder());
		
		
		//가득 차있을때
		if (N == P && arr[N - 1] >= new_score) {
			System.out.println(-1);
			return;
		}

		int rank = 1;
		for (Long num : arr) {
			if(num > new_score) {
				rank++;
			}else {
				break;
			}
		}
		System.out.println(rank);

	}
}
