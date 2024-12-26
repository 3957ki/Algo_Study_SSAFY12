import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 당근훔쳐먹기 {

	static class Carrot implements Comparable<Carrot>{
		long w;
		long p;
		public Carrot(long w, long p) {
			this.w = w;
			this.p = p;
		}
		@Override
		public int compareTo(Carrot o) {
			if(this.p == o.p) return Long.compare(this.w, o.w);
			return Long.compare(this.p, o.p);
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int T = Integer.parseInt(st.nextToken());

		Carrot carrots[] = new Carrot[N];
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());

			long w = Long.parseLong(st.nextToken());
			long p = Long.parseLong(st.nextToken());

			carrots[i] = new Carrot(w, p);
		}

		Arrays.sort(carrots);

		long newT = T - N;
		long ans = 0;

		for(int i = 0; i < N; i++) {
			ans += carrots[i].p * newT + carrots[i].w;

			newT++;
		}
		System.out.println(ans);
	}
}