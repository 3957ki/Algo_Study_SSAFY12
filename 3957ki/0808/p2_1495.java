import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class p2_1495 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int S = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[] V = new int[N+1];
		st = new StringTokenizer(br.readLine());
		for(int i = 1; i <= N; i++) {
			V[i] = Integer.parseInt(st.nextToken());
		}
//		N이 1이면 
		if(N == 1) {
			int max = Integer.MIN_VALUE;
//			가능한 최대값 저장 후 출력
			if(S+V[1] <= M) {
				max = Math.max(max, S+V[1]);
			}
			if(S-V[1] >= 0) {
				max = Math.max(max, S-V[1]);
			}
			System.out.println(max == Integer.MIN_VALUE ? -1 : max);
			return;
		}
		
		Set<Integer>[] arr = new HashSet[N+1];
		for(int i = 1; i <= N; i++) {
			arr[i] = new HashSet<>();
		}
		int max = Integer.MIN_VALUE;
//		첫번째 곡의 경우의 수 삽입
		if(S+V[1] <= M) {
			arr[1].add(S+V[1]);
		}
		if(S-V[1] >= 0) {
			arr[1].add(S-V[1]);
		}
//		이전 곡 볼륨의 경우의 수를 기준으로 탐색
		for(int i = 2; i <= N; i++) {
			for(int prev : arr[i-1]) {
//				마지막 곡이라면 가능한 최대값 저장
				if(i == N) {
					if(prev+V[i] <= M) {
						max = Math.max(max, prev+V[i]);
					}
					if(prev-V[i] >= 0) {
						max = Math.max(max, prev-V[i]);
					}
					continue;
				}
//				가능한 경우의 수 삽입
				if(prev+V[i] <= M) {
					arr[i].add(prev+V[i]);
				}
				if(prev-V[i] >= 0) {
					arr[i].add(prev-V[i]);
				}
			}
		}
		System.out.println(max == Integer.MIN_VALUE ? -1 : max);
	}
}
