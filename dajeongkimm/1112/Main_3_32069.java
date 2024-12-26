import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_3_32069 {
	static long L;
	static int N,K;
	static int cnt = 0;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		StringBuilder sb = new StringBuilder();
		
		st = new StringTokenizer(br.readLine());
		L = Long.parseLong(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		//모든 가로등의 위치 큐에 넣기 (시작위치)
		Queue<Long> q = new ArrayDeque<>();
		HashSet<Long> visited = new HashSet<>();
		st = new StringTokenizer(br.readLine());
		for (int i=0;i<N;i++) {
			long x = Long.parseLong(st.nextToken());
			q.add(x);
			visited.add(x);
		}
		
		//N개만큼은 무조건 0 (가로등이 있는 곳은 0)
		if (N >= K) {
			for (int i=0;i<K;i++) {
				sb.append(0).append("\n");
			}
			System.out.println(sb);
			return;
		}
		
		for (int i=0;i<N;i++) {
			sb.append(0).append("\n");
			cnt++;
		}
		
		int distance = 0;
		int[] dist = new int[]{-1,1};
		while (!q.isEmpty()) {
			distance++;
			int qSize = q.size();
			for (int i=0;i<qSize;i++) {
				long cur = q.poll();
				
				//-1아니면 +1 가기
				for (int d : dist) {
					long newX = cur + d;
					
					if (newX < 0 || newX >L) continue;
					
					if (!visited.contains(newX)) {
						q.add(newX);
						visited.add(newX);
						sb.append(distance).append("\n");
						cnt++;
						if (cnt == K) {
							System.out.println(sb);
							return;
						}
					}
				}
			}
		}
		
		
		
	}

}
