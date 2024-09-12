package day0912;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/*
 * N개의 지뢰
 * 각 지뢰의 충격 강도 Pi -> Pi 이상의 힘을 가하면 Pi만큼 터짐 (좌우로)
 */

public class B_2232_2_지뢰 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine().trim());

		int arr[] = new int[N];
		int maxValue = 0;
		int index = 0;
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(br.readLine().trim());
			if (maxValue < arr[i]) {
				maxValue = arr[i];
				index = i;
			}
		}
		// input end

		List<Integer> answer = new ArrayList<>();
		answer.add(index);
		boolean visited[] = new boolean[N];
		visited[index] = true;

		while (index != -1) {
//			System.out.println("start : " + index);
			// 왼쪽으로 탐색
			int left = index - 1;
			int tmp = index;
			while (left >= 0) {
				// 지뢰 터짐
				if (arr[left] < arr[tmp]) {
					visited[left] = true;
					left--;
					tmp--;
				} else {
					// 더이상 못터짐
					break;
				}
			}

			int right = index + 1;
			tmp = index;
			while (true) {
				if (right >= N) {
					break;
				}
				if (arr[right] < arr[tmp]) {
					visited[right] = true;
					right++;
					tmp++;
				} else
					break;
			}

			index = -1;
			maxValue = 0;
			// 다음 index 찾기
			for (int i = 0; i < N; i++) {
				if (visited[i])
					continue;
				if (maxValue < arr[i]) {
					maxValue = arr[i];
					index = i;
				}
			}
			if (index != -1) {
				answer.add(index);
				visited[index] = true;
			}
//			System.out.println(Arrays.toString(visited));
		}

		Collections.sort(answer);
		for (int i = 0; i < answer.size(); i++) {
			System.out.println(answer.get(i)+1);
		}
	}
}
