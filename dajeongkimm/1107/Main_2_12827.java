import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 
 * @author KOREA
 *
 */
public class Main_2_12827 {
	static int N,M,V;
	static int[] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		StringBuilder sb = new StringBuilder();
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		V = Integer.parseInt(st.nextToken());
		
		arr = new int[N+1];
		st = new StringTokenizer(br.readLine());
		for (int i=1;i<=N;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		for (int i=0;i<M;i++) {
			int num = Integer.parseInt(br.readLine());
			sb.append(query(num)).append("\n");
		}
		System.out.println(sb);
		
	}
	
	static int query(int num) {
		if (num <= N-1) {
			return arr[1+num];
		}
		
		num -= N;
		return arr[V + num%(N-V+1)];
	}

}
