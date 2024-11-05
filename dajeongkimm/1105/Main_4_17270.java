import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 지헌이는 매번 성하를 기다림
 * 
 * 1. 지헌이의 출발위치 성하의 출발 위치 X
 * 2. 지헌이가 걸리는 최단 시간 + 성하의 최단시간 => 최소
 * 3. 성하랑 지헌이가 같거나 성하가 더 작도록
 * 4. 그 중에 지헌이로부터 가장 가까운 곳 (그 중 가장 번호가 작은 곳)
 * 
 * @author KOREA
 *
 */
public class Main_4_17270 {
	static int V,M;
	static int[][] weight;
	static int J,S;
	
	static int answer = -1;
	static int fromJ = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		V = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		weight = new int[V+1][V+1];
		for (int i=1;i<=V;i++) {
			Arrays.fill(weight[i], 100_000_000);
		}
		for (int i=1;i<=V;i++) {
			weight[i][i] = 0; //자기자신에게 가는 것은 가중치 0
		}
		
		for (int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			//같은 길에 가중치가 다른 경우 고려
			if (weight[a][b] > c) {
				weight[a][b] = c;
				weight[b][a] = c;
			}
		}
		
		st = new StringTokenizer(br.readLine());
		J = Integer.parseInt(st.nextToken()); //지헌 시작
		S = Integer.parseInt(st.nextToken()); //성하 시작
		
		//플루이드와셜 --> A에서 B까지의 최단 경로 저장
		for (int k=1;k<=V;k++) {
			for (int i=1;i<=V;i++) {
				for (int j=1;j<=V;j++) {
					if (weight[i][k] + weight[k][j] < weight[i][j]) {
						weight[i][j] = weight[i][k] + weight[k][j];
					}
				}
			}
		}
		
		int minDistance = Integer.MAX_VALUE / 2;
		for (int i=1;i<=V;i++) {
			if (i == J || i == S) continue;
			minDistance = Math.min(minDistance, weight[J][i]+weight[S][i]);
		}
		
		//거리의 합 최단거리
		for (int i=1;i<=V;i++) {
//			System.out.println(i+": "+(weight[J][i]+weight[S][i]));
			if (i == J || i == S) continue; //시작점은 제외
			
			//지헌이가 성하보다 더 빠르면 안됨
			if (weight[J][i] > weight[S][i]) continue;
			
			// 작은 수부터 탐색하기 때문에 --> 같다면 작은 번호 선택
			if (weight[J][i] + weight[S][i] == minDistance) {
				if (fromJ > weight[J][i]) {
					fromJ = weight[J][i];
					answer = i;
				}
				
			} 
		}
		System.out.println(answer);
		
	}

}
