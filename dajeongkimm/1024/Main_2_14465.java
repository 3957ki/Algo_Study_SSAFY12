import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2_14465 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		
		boolean[] broken = new boolean[N+1];
		for (int i=0;i<B;i++) {
			int n = Integer.parseInt(br.readLine());
			broken[n] = true;
		}
		
		int answer = Integer.MAX_VALUE;
		int cnt = 0;
		//처음 K개에서 부서진 갯수
		for (int i=1;i<=K;i++) {
			if (broken[i]) cnt++;
		}
		answer = Math.min(answer, cnt);
		for (int i=2;i<=N-K+1;i++) {
			if (broken[i-1]) cnt--; 
			if (broken[i+K-1]) cnt++;
			answer = Math.min(answer, cnt);
		}
		System.out.println(answer);

	}

}
