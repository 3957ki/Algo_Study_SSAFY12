import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class p4_22947 {
	static ArrayDeque<Integer> list = new ArrayDeque<>();
	static int N, K, last;
	static int answer = Integer.MAX_VALUE;
	static int[] time;
	static int[][] arr;
	static boolean[][] direction;
	static int[] time_temp;
	static int[][] arr_temp;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
//		원래 번호별 소요시간과 간선 배열
		time = new int[N + 1];
		arr = new int[N + 1][2];
		direction = new boolean[N + 1][N + 1];
//		임시 배열
		time_temp = new int[N + 1];
		arr_temp = new int[N + 1][2];

		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			time[i] = Integer.parseInt(st.nextToken());
//			자신의 소요시간으로 초기화
			arr[i][1] = time[i];
		}

		for (int i = 1; i <= M; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
//			ahead 개수 증가 후 간선 표시
			arr[end][0]++;
			direction[start][end] = true;
		}
//		임시로 시간배열과 arr배열 저장
		for (int i = 1; i <= N; i++) {
			time_temp[i] = time[i];
			arr_temp[i][0] = arr[i][0];
			arr_temp[i][1] = arr[i][1];
		}
//		위상 정렬
		Queue<Integer> queue = new LinkedList<>();
		queue.add(1);
		int num = 1;
		while (!queue.isEmpty()) {
			num = queue.poll();
			for (int i = 1; i <= N; i++) {
				if (!direction[num][i])
					continue;
				arr_temp[i][0]--;
				arr_temp[i][1] = Math.max(arr_temp[i][1], time_temp[i] + arr_temp[num][1]);
				if (arr_temp[i][0] == 0) {
					queue.add(i);
				}
			}
		}
//		최소값 갱신과 마지막 번호 저장
		answer = Math.min(answer, arr_temp[num][1]);
		last = num;

		DFS(2, 0);

		System.out.println(answer);
	}

	static void DFS(int start, int depth) {
		if (depth == K) {
			search();
			return;
		}
		int L = N - K + depth + 1;
		for (int i = start; i <= L; i++) {
//			마지막 번호를 제외한 나머지 번호 조합 탐색
			if (i == last)
				continue;
			list.addLast(i);
			DFS(i + 1, depth + 1);
			list.removeLast();
		}
	}

	static void search() {
//		임시 배열 저장
		for (int i = 1; i <= N; i++) {
			time_temp[i] = time[i];
			arr_temp[i][0] = arr[i][0];
			arr_temp[i][1] = arr[i][1];
		}
//		조합에 해당하는 번호의 소요시간 0
		for (int i : list) {
			time_temp[i] = 0;
			arr_temp[i][1] = 0;
		}
//		위상 정렬
		Queue<Integer> queue = new LinkedList<>();
		queue.add(1);
		int num = 1;
		while (!queue.isEmpty()) {
			num = queue.poll();
			for (int i = 1; i <= N; i++) {
				if (!direction[num][i])
					continue;
				arr_temp[i][0]--;
				arr_temp[i][1] = Math.max(arr_temp[i][1], time_temp[i] + arr_temp[num][1]);
				if (arr_temp[i][0] == 0) {
					queue.add(i);
				}
			}
		}
//		최소값 갱신
		answer = Math.min(answer, arr_temp[num][1]);
	}
}
