import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 규칙적인보스돌이 {

	static int N, M, K;
	static long D[];
	static long max;
	
	static Boss boss[];
	
	static int answer;
	
	static class Boss{
		long P;
		int Q;
		
		public Boss(long p, int q) {
			P = p;
			Q = q;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		D = new long[N];
		long meso[] = new long[N];	// 캐릭터 별 최대 벌 수 있는 메소
		for(int i = 0; i < N; i++) {
			D[i] = Long.parseLong(br.readLine());
		}
		
		boss = new Boss[K];
		for(int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			
			long P = Long.parseLong(st.nextToken());
			int Q = Integer.parseInt(st.nextToken());
			
			boss[i] = new Boss(P, Q);
		}
		
		for(int i = 0; i < N; i++) {
			max = Long.MIN_VALUE;
			dfs(0, D[i] * 900, i, 0);
			
			meso[i] = max;
		}
//		System.out.println(Arrays.toString(meso));
		long total = 0;
		
		Arrays.sort(meso);
		for(int i = 0; i < M; i++) {
			total += meso[N-1-i];
		}
		
		System.out.println(total);
	}
	
	static void dfs(int cnt, long dem, int index, long meso) {
		if(cnt == K) {
			max = Math.max(max, meso);
			return;
		}
		
		if(dem >= boss[cnt].P) {
			dfs(cnt+1, ((dem - (long)boss[cnt].P) / D[index]) * D[index], index, meso + (long)boss[cnt].Q);
		}
		
		dfs(cnt+1, dem, index, meso);
	}
}