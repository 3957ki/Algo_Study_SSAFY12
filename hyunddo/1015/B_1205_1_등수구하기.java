package day1015;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class B_1205_1_등수구하기 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()); // 현재 리스트의 수
		int score = Integer.parseInt(st.nextToken()); // 태수의 점수
		int P = Integer.parseInt(st.nextToken()); // 리스트의 오를 수 있는 개수

		if (N == 0) {
			System.out.println(1);
			System.exit(0);
		}

		List<Integer> ranking = new ArrayList<>();
		st = new StringTokenizer(br.readLine().trim());
		for (int i = 0; i < N; i++) {
			ranking.add(Integer.parseInt(st.nextToken()));
		}
		// input end

		boolean flag = true;
		if (ranking.size() < P) { // 현재 리스트가 꽉 차 있지 않음
			ranking.add(score);
			Collections.sort(ranking, Collections.reverseOrder());
			int index = 1;
			for (Integer num : ranking) {
				if (num == score) {
					break;
				}
				index++;
			}
			System.out.println(index);
			System.exit(0);
		} else if (ranking.size() == P) { // 현재 리스트가 꽉 참
			int index = 0;
			flag = false;
			for (Integer num : ranking) {
				if (num < score) { // 리스트 안에 태수보다 낮은 점수가 있음
					ranking.set(index, score);
					flag = true;
					break;
				}
				index++;
			}
			if (!flag)
				System.out.println(-1);
			else {
				index = 1;
				for (Integer num : ranking) {
					if (num == score) {
						break;
					}
					index++;
				}
				System.out.println(index);
			}
		}

	}
}
