import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class Main_1_15828 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		Queue<Integer> q = new ArrayDeque<>();
		while(true) {
			int num = Integer.parseInt(br.readLine());
			if (num == -1) break;
			if (num > 0) {
				if (q.size() < N) {
					q.add(num);
				}
				
			}
			else if (num == 0) {
				q.poll();
			}
		}
		
		StringBuilder sb = new StringBuilder();
		
		if (q.size() == 0) {
			System.out.println("empty");
			return;
		}
		
		while (!q.isEmpty()) {
			sb.append(q.poll()).append(" ");
		}
		System.out.println(sb);
		
	}

}
