import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
/*
 */
public class 공정컨설턴트호석 {

	static int N, X, high, low;
	static int[] times;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken());

		times = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			times[i] = Integer.parseInt(st.nextToken());
		}
		
		high = N;
		low = 1;
		int K = 0;
		int min = Integer.MAX_VALUE;
		A : while(low <= high) {
			K = (low + high) / 2;
			PriorityQueue<Integer> pq = new PriorityQueue<>();

			for(int i = 0; i < K; i++) {
				pq.add(times[i]);
			}
			for(int i = K; i < N; i++) {
				int tmp = pq.poll();
				if(tmp+times[i] > X) {	// 시간이 X를 넘어가는 순간 다음 탐색 진행(K가 더 큰 쪽으로, 더 많은 공정을 향해)
					low = K + 1;
					continue A;
				}
				if(tmp + times[i] == X) {
					System.out.println(K);
					return;
				}
				pq.add(tmp+times[i]);
			}
			
			//이까지 왔다는 건 무조건 X시간 이내에 들었다는 것
			high = K - 1;
			min = Math.min(min, K);
		}
		System.out.println(min);
	}
}