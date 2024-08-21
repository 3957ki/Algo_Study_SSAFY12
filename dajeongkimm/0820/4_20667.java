import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * N : 총 크롬 탭 수
 * M : 목표 CPU 사용량
 * K : 목표 메모리 할당량
 * 
 * cpu, memory, priority
 * 
 * 크롬 탭을 지워서 CPU와 메모리를 목표 이상 확보하려고 할 때 중요도 합의 최솟값
 * @author SSAFY
 *
 */
public class Main_크롬 {
	static int N,M,K;
	static final int max_cpu = 1_000;
	static final int max_memory = 1_000_000;
	static final int max_priority = 500;
	
//	static final int INF = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); //총 크롬 탭수
		M = Integer.parseInt(st.nextToken()); //목표  CPU 사용량
		K = Integer.parseInt(st.nextToken()); //목표 메모리 할당량
		
		int total_priority = 0;
		
		int[][] arr = new int[N][3];
		for (int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			arr[i][0] = Integer.parseInt(st.nextToken()); //cpu
			arr[i][1] = Integer.parseInt(st.nextToken()); //memory
			arr[i][2] = Integer.parseInt(st.nextToken()); //priority
			total_priority += arr[i][2];
		}
		
		// max_cpu 초과 값은 --> max_cpu + 1 로 취급
		// dp[p][cpu] : 중요도가 p일 때, cpu 사용량이 cpu인 경우의 최대 메모리 사용량
		int[][] dp = new int[total_priority+1][max_cpu+2];
		
		for (int i=0;i<=total_priority;i++) {
			Arrays.fill(dp[i], Integer.MIN_VALUE);
		}
		
		
		// 중요도가 0이고 cpu 사용량이 0일때 메모리 사용량은 0
		dp[0][0] = 0;
		
		for (int i=0;i<N;i++) {
			for (int p=total_priority;p>=arr[i][2];p--) {
				for (int cpu=max_cpu+1;cpu>=0;cpu--) {
					// 현재 탭을 선택 하는 경우 vs 선택하지 않는 경우
					dp[p][Math.min(cpu+arr[i][0], max_cpu+1)] = Math.max(dp[p][Math.min(cpu+arr[i][0], max_cpu+1)], dp[p-arr[i][2]][cpu] + arr[i][1]);
				}
			}
		}
		
//		for (int i=0;i<total_priority+1;i++) {
//			System.out.println(Arrays.toString(dp[i]));
//		}
		
		int answer = -1;
		A: for (int p=0;p<=total_priority;p++) {
			for (int cpu=M;cpu<=max_cpu+1;cpu++) {
				if (dp[p][cpu]>=K) {
					answer = p;
					break A;
				}
			}
		}
		
		System.out.println(answer);
		
		
	}

}
