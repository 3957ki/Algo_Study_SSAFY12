package day0903;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;



public class B_14594_1번_동방프로젝트 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine().trim());
		int M = Integer.parseInt(br.readLine().trim());

		room[] rooms = new room[M];
		for (int i = 0; i < M; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine().trim());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			rooms[i] = new room(a, b);
		}

		// a, b 의 입력값을 보고 방을 합쳐
		// 그럼 N크기의 배열을 만들어서 a~b까지의 값을 다 arr[a] 값으로 만들어 주셈
		// 값 바뀔때마다 cnt++

		int answer = 1;

		Arrays.sort(rooms);

		int map[] = new int[N + 1];
		for (int i = 1; i < N + 1; i++) {
			map[i] = i;
		}

		for (int i = 0; i < M; i++) {
			int a = rooms[i].roomA;
			int b = rooms[i].roomB;

			for (int r = a + 1; r <= b; r++) {
				map[r] = map[a];
			}
		}

		int start = map[1];
		for (int i = 1; i <= N; i++) {
			if (start != map[i]) {
				answer++;
				start = map[i];
			}
		}

//		System.out.println(Arrays.toString(map));

		System.out.println(answer);

	}

	static class room implements Comparable<room> {
		int roomA;
		int roomB;

		public room(int roomA, int roomB) {
			super();
			this.roomA = roomA;
			this.roomB = roomB;
		}

		@Override
		public int compareTo(room o) {
			return Integer.compare(roomA, o.roomA);
		}

	}
}
