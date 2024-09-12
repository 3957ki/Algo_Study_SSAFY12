package day0912;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/*
 * 협상을 통해 알파벳 대문자로 구성된 길이 N의 문자열 S 정하기
 * S에서 0개 이상의 문자를 지워서 대회 이름 T를 만들기
 * T는 길이가 M
 * 맨 뒷글자는 (알파벳 자음), 뒤에서 두번째 세번째는 A
 */

public class B_27466_1_그래서대회이름뭐로하죠 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine().trim());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		String str = br.readLine();
		List<Character> arr = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			arr.add(str.charAt(i));
		}

		while (true) {
			int index = arr.size() - 1;
//			System.out.println(index + 1);
			if (index + 1 < M) { // 문자열 길이가 M보다 작으면 NO
				System.out.println("NO");
				System.exit(0);
			}
			// 마지막이 모음일 때
			if (arr.get(index) == 'A' || arr.get(index) == 'I' || arr.get(index) == 'E' || arr.get(index) == 'O'
					|| arr.get(index) == 'U') {
//				System.out.println("마지막이 모음임");
				arr.remove(index);
				continue;
			} else { // 마지막이 모음이 아님
				if (arr.get(index - 1) != 'A') {
//					System.out.println(arr.get(index-1));
//					System.out.println( " 뒤에서 두번째");
					arr.remove(index - 1);
					continue; 
				}
				if (arr.get(index - 2) != 'A') {
//					System.out.println("뒤에서 세번째");
					arr.remove(index - 2);
					continue;
				}
			}
//			System.out.println(index);
			break;
		}

		if (arr.size() < M) {
			System.out.println("NO");
			System.exit(0);
		}

		else if (arr.size() >= M) {
			System.out.println("YES");
			for (int i = arr.size()-M; i < arr.size(); i++) {
				System.out.print(arr.get(i));
			}
		}

	}
}
