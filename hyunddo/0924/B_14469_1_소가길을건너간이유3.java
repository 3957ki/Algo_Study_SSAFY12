package day0924;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
 * 농장 둘레에 매우 큰 울타리
 * 여러 마리의 소가 한 번에 들어가려고 하면 줄이 길어짐
 * N마리의 소가 농장에 방문
 */

public class B_14469_1_소가길을건너간이유3 {

	static class Cow implements Comparable<Cow> {
		int arrive;
		int time;

		public Cow(int arrive, int time) {
			super();
			this.arrive = arrive;
			this.time = time;
		}

		@Override
		public int compareTo(Cow o) {
			return Integer.compare(arrive, o.arrive);
		}

	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine().trim());

		Cow arr[] = new Cow[N];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine().trim());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			arr[i] = new Cow(a, b);
		}

		Arrays.sort(arr);

		int answer = arr[0].arrive + arr[0].time;

		for (int i = 1; i < N; i++) {
			if (arr[i].arrive <= answer) {
				answer = answer + arr[i].time;
			} else {
				answer = arr[i].arrive + arr[i].time;
			}
		}

		System.out.println(answer);
	}
}
