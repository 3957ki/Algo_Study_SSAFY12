import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Queue;

public class q15721 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int A = Integer.parseInt(br.readLine()); // 게임을 진행하는 사람 <= 2000
		int T = Integer.parseInt(br.readLine()); // 구하고자 하는 번째 T <=10000
		int num = Integer.parseInt(br.readLine()); // 0이번 뻔, 1이면 데기
		int arr[] = new int[A];
		ArrayList<Integer> queue = new ArrayList<Integer>(); // 갈 방향 ...

		int n = 2;
		int cnt = 0;
		int answer = 0;
		while (true) {
			for (int i = 0; i < 4; i++) {
				if (i % 2 == 0)
					queue.add(0); // 0과 2는 뻔
				else
					queue.add(1); // 1과 3은 데
			}

			for (int b = 0; b < n; b++) { // 뻔 n번
				queue.add(0);
			}

			for (int d = 0; d < n; d++) { // 데 n번
				queue.add(1);
			}

			while (!queue.isEmpty()) {
				int x = queue.get(0);
				if (queue.get(0) == num) {
					cnt++;
				}
				queue.remove(0);
				answer++;
				if (cnt == T)
					break;
			}
			if (cnt == T)
				break;
			n++;
		}
		System.out.println((answer-1)%A);
	}
}
