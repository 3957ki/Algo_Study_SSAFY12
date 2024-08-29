import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 박터뜨리기 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		if(N < K*(K+1)/2) System.out.println("-1");
		else if( (N-(K*(K+1)/2)) % K == 0) System.out.println(K-1);
		else System.out.println(K);
	}
}
