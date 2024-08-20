import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 백준_호반우 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int[] quality = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			quality[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(quality);

		int answer = 0;
		for(int i = N-1; i >= N/2; i--) answer += quality[i]*2;
		
		if(N%2 == 1) answer -= quality[N/2];
		
		System.out.println(answer);
	}
}
