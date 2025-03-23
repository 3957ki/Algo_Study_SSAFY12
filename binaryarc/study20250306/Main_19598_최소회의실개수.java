package study20250306;

import java.io.*;
import java.util.*;

public class Main_19598_최소회의실개수 {

	static int N;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		List<int[]> meetings = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			meetings.add(new int[] { start, end });
		}

		Queue<Integer> pq = new PriorityQueue<>();
		meetings.sort((o1, o2) -> {
			if (o1[0] == o2[0])
				return o1[1] - o2[1];
			return o1[0] - o2[0];
		});

		int ans = 0;
		for (int[] meet : meetings) {
			int curStart = meet[0];
			int curEnd = meet[1];
			
			// 가장 먼저 끝나는 회의가 현재 회의 시작 이전에 끝났다면 제거
			while (!pq.isEmpty() && pq.peek() <= curStart) {
				pq.poll();
			}
			
			// 현재 회의의 종료 시간을 추가 -> 선분증가
			pq.add(curEnd);

			// 필요한 회의실 개수 업데이트
			ans = Math.max(ans, pq.size());
		}
		System.out.println(ans);
	}
}
