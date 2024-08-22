import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
public class 백준_투플러스원세일 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine().trim());
		int[] cost = new int[N];
		for(int i = 0; i < N; i++) {
			cost[i] = Integer.parseInt(br.readLine().trim());
		}
		Arrays.sort(cost);
		int cnt = 0;
		int total = 0;
		for(int i = N-1; i >= 0; i--) {
			if(cnt%3==2) {
				cnt++;
				continue;
			}
			total += cost[i];
			cnt++;
		}
		System.out.println(total);
		
	}
}