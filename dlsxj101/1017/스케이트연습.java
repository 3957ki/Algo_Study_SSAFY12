import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
/*
 * 메모리 : kb
 * 시간 : ms
 * 전략
 * 
 */
public class 스케이트연습 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine().trim());
		int V[] = new int[N];
		int ans[] = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			V[i] = Integer.parseInt(st.nextToken());
		}
		
		ans[N-1] = 1;
		for(int i = N-2; i >= 0; i--) {
			if(V[i] > ans[i+1]) ans[i] = ans[i+1] + 1;
			else if(V[i] == ans[i+1]) ans[i] = ans[i+1];
			else ans[i] = V[i];
			
		}
		long total = 0;
		for(int i : ans) total += i;
		System.out.println(total);
	}
}
