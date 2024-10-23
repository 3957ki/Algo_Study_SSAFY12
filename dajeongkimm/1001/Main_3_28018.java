import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 시간이 겹칠까?
 * 
 * 0 ~ 1_000_000
 * 특정한 시각에 선택할 수 없는 좌석이 몇개였는지 
 * @author KOREA
 *
 */
public class Main_3_28018 {
	static int N,Q;
	static int[] used;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		used = new int[1_000_002];
		
		int max_time = 0;
		for (int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			
			max_time = Math.max(max_time, e);
			
			used[s]++;
			used[e+1]--;
		}
		
		for (int i=1;i<=1_000_000;i++) {
			used[i] += used[i-1];
		}
		
//		System.out.println(Arrays.toString(used));
		
		Q = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		for (int i=0;i<Q;i++) {
			int time = Integer.parseInt(st.nextToken());
			if (time > max_time) sb.append(0).append("\n");
			else sb.append(used[time]).append("\n");
		}
		System.out.println(sb);
	}

}
