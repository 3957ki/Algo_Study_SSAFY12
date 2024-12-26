import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_2_28066 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		Queue<Integer> q = new ArrayDeque<>();
		for (int i=1;i<=N;i++) {
			q.add(i);
		}
		
		while (q.size() != 1) {
			int num = q.poll();
			q.add(num);
			
			for (int i=0;i<K-1;i++) {
				if (q.size()>=2) {
					q.poll();
				} else break;
			}
		}
		
		System.out.println(q.peek());
	}

}
