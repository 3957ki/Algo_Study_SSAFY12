package day0926;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class B_2817_1_ALPS식투표 {

	static class Score implements Comparable<Score> {

		int staff;
		int score;

		public Score(int staff, int score) {
			super();
			this.staff = staff;
			this.score = score;
		}

		@Override
		public int compareTo(Score o) {
			return Integer.compare(score, o.score);
		}

	}

	static class Staff implements Comparable<Staff> {
		String staff;
		double cnt;

		public Staff(String staff, double cnt) {
			super();
			this.staff = staff;
			this.cnt = cnt;
		}

		@Override
		public int compareTo(Staff o) {
			return Double.compare(cnt, o.cnt);
		}

	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int X = Integer.parseInt(br.readLine().trim()); // 참가자 수
		int N = Integer.parseInt(br.readLine().trim()); // 스태프 수

		boolean visited[] = new boolean[26];
		List<Staff> arr = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine().trim());
			String alpabet = st.nextToken();
			int total = Integer.parseInt(st.nextToken());
//			System.out.println(total + " " + X * 0.05);
			if (total < X * 0.05)
				continue;
			visited[alpabet.charAt(0)-'A'] = true;
			for (int j = 1; j <= 14; j++) {
				arr.add(new Staff(alpabet, total / j));
			}
		}
		// input end

		Collections.sort(arr, Collections.reverseOrder());
		for (Staff staff : arr) {
//			System.out.println(staff.staff + " " + staff.cnt);
		}

		Score answer[] = new Score[26];
		for (int i = 0; i < 26; i++) {
			answer[i] = new Score(i, 0);
		}

		for (int i = 0; i < 14; i++) {
			if (arr.size() <= i)
				break;
			int staff = arr.get(i).staff.charAt(0) - 'A';
			answer[staff].score++;
		}

		for (int i = 0; i < 26; i++) {
			if (!visited[i])
				continue;
			char staff = (char) (answer[i].staff + 'A');
			sb.append(staff).append(" ").append(answer[i].score).append('\n');
		}

//		for (Score score : answer) {
//			if (score.score == 0)
//				break;
//			sb.append((char) score.staff).append(" ").append(score.score).append('\n');
//		}
		System.out.println(sb);
	}
}
