package day1022;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 * 특정 거리 R 이내에 있는 사람들은 모두 들음
 * R 보다 멀리에 있는 사람들은 모두 들을 수 없음
 * R 값은 매번 바뀜
 * N번의 사람, M번의 종
 */
public class B_2_18248_제야의종 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine().trim());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		int distance[] = new int[M];
		int map[][] = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine().trim());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 1)
					distance[j] += 1;
			}
		}
		// input end
		
		Integer index[] = new Integer[M];
		for (int i = 0; i < M; i++) {
			index[i] = i;
		}
		
		
		Arrays.sort(index, new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				// TODO Auto-generated method stub
				return Integer.compare(distance[o2], distance[o1]);
			}
		});

//		System.out.println(Arrays.toString(distance));
//		System.out.println(Arrays.toString(index));
		
		List<Integer> list = new ArrayList<>();
		Queue<Integer> queue = new ArrayDeque<>();
		for (int j = 0; j < M - 1; j++) {
			int idx = index[j]; // M번째 종
//			System.out.println("j "+ j+" "+index[j]);
//			System.out.println(Arrays.toString(index));
//			System.out.println(idx+" "+distance[idx]);
			if (distance[idx] == M)
				continue;
			for (int i = 0; i < N; i++) {
				if (map[i][idx] != 1) // 종소리 못 들은 사람
					queue.add(i);
			}
			while (!queue.isEmpty()) {
				int person = queue.poll();
				if (map[person][index[j + 1]] == 1) {
					System.out.println("NO");
					System.exit(0);
				}
			}
		}

		System.out.print("YES");

	}
}
