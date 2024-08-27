import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 원상복구 {
	static int N, K, S[], D[];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		S = new int[N];
		D = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) S[i] = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) D[i] = Integer.parseInt(st.nextToken());
		
		for(int i = 0; i < K; i++) method();
	
		for(int i = 0; i < N; i++) sb.append(S[i]).append(" ");;
		
		System.out.println(sb);
	}
	
	static void method() {
		int[] temp = new int[N];
		
		for(int i = 0; i < N; i++) temp[D[i]-1] = S[i];
		
		for(int i = 0; i < N; i++) S[i] = temp[i];
		
	}
	
	
}