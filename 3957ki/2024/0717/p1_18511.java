import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class p1_18511 {
	static int N, K, answer;
	static int[] arr;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		arr = new int[K];
		answer = 0;
		for(int i = 0; i < K; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr); //조합 오름차순

		DFS(0);
		System.out.println(answer);
	}
	
	static void DFS(int num) {
		if(num > N) {
			return;
		}
		answer = Math.max(answer, num);
		for(int i = K-1; i >= 0; i--) {
			DFS(num*10+arr[i]);
		}
	}
}