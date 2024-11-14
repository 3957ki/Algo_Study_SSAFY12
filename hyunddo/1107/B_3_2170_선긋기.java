package day1107;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class B_3_2170_선긋기 {

	static class Lines implements Comparable<Lines> {

		int start;
		int end;

		public Lines(int start, int end) {
			super();
			this.start = start;
			this.end = end;
		}

		@Override
		public int compareTo(Lines o) {
			return Integer.compare(this.start, o.start);
		}

	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine().trim());

		List<Lines> list = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine().trim());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			list.add(new Lines(a, b));
		}

		Collections.sort(list);

		int start = list.get(0).start;
		int end = list.get(0).end;
		int sum = end-start;

		for (int i = 1; i < N; i++) {
			int nstart = list.get(i).start;
			int nend = list.get(i).end;

			if (nstart >= end) { // 새로 시작
				sum += nend - nstart;
				start = nstart;
				end = nend;
			} else { // 겹치는 부분이 있다.
				if (nend <= end) {
					continue;
				} else {
					sum += nend - end;
					end = nend;
				}
			}
		}
		System.out.println(sum);
	}
}
