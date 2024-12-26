import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
public class 달팽이리스트 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int V = Integer.parseInt(st.nextToken());
		
		int arr[] = new int[N+1];
		st = new StringTokenizer(br.readLine());
		for(int i = 1; i <= N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		for(int i = 0; i < M; i++) {
			int K = Integer.parseInt(br.readLine().trim());
			
			if(K < V) sb.append(arr[K+1]).append("\n");
			else {
				sb.append(arr[( (K-(V-1)) % (N-(V-1)) ) + V]).append("\n");
			}
		}
		System.out.println(sb);
	}
}