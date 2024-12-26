import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
/*
 */
public class 회장뽑기 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine().trim());
		
		int adjMatrix[][] = new int[N+1][N+1];
		for(int i = 1; i <= N; i++) {
			for(int j = 1; j <= N; j++) {
				if( i == j ) continue;
				adjMatrix[i][j] = Integer.MAX_VALUE;
			}
		}
		
		while(true) {
			st = new StringTokenizer(br.readLine());
			
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			if( a == -1 && b == -1) break;
			
			adjMatrix[a][b] = 1;
			adjMatrix[b][a] = 1;
		}
		for(int k = 1; k <= N; k++) {
			for(int i = 1; i <= N; i++) {
				if(i==k) continue;
				for(int j = 1; j <= N; j++) {
					if(i==j || j==k) continue;
					if(adjMatrix[i][k] == Integer.MAX_VALUE || adjMatrix[k][j] == Integer.MAX_VALUE) continue;
					if(adjMatrix[i][j] > adjMatrix[i][k] + adjMatrix[k][j]) {
						adjMatrix[i][j] = adjMatrix[i][k] + adjMatrix[k][j];
					}
				}
			}
		}
		
		//최단 거리 확인용
		System.out.println("---adjMatrix---");
		for(int i = 1; i <= N; i++) {
			for(int j = 1; j <= N; j++) {
				System.out.print(adjMatrix[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println("--------------");
		
		int score = Integer.MAX_VALUE;
		int cnt = 0;
		int arr[] = new int[N+1];
		Arrays.fill(arr, Integer.MIN_VALUE);
		
		// 최단 경로의 최댓값 구하기 (이 값이 score가 됨)
		// 같은 점수인 사람들은 배열에 모아놓기
		for(int i = 1; i <= N; i++) {
			for(int j = 1; j <= N; j++) {
				if( i == j ) continue;
				arr[i] = Math.max(arr[i], adjMatrix[i][j]);
			}
			score = Math.min(score, arr[i]);
		}
		
		// 같은 점수인 사람들을 순서대로 sb에 집어넣기
		// 집어넣으면서 사람 수 세기
		for(int i = 1; i <= N; i++) {
			if(arr[i] == score) {
				cnt++;
				sb.append(i).append(" ");
			}
		}
		
		System.out.println(score + " " + cnt);
		System.out.println(sb);
	}
}