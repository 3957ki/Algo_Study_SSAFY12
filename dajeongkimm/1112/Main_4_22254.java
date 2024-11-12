import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_4_22254 {
	static int N,X;
	static int[] arr;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken());
		
		arr =new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i=0;i<N;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int min = 1;
		int max = N;
		
		int answer = 0;
		
		while (min <= max) {
			int mid = (min + max)/2;
			
			if (make(mid)) {
				answer = mid;
				max = mid-1;
			}
			else {
				min = mid+1;
			}
		}
		System.out.println(answer);

	}
	static boolean make(int K) {
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		
		if (K == N) return true; 
		
		for (int i=0;i<K;i++) {
			pq.add(arr[i]);
		}
		
		for (int i=K;i<N;i++) {
			int cur = pq.poll();
			int newTime = cur + arr[i];
			if (newTime > X) return false;
			pq.add(newTime);
		}
		return true;
		
	}

}
