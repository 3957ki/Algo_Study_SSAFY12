import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class p4_2637 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
//		총 부품 N개 부품간 간선의 수 M개
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
//		ahead 개수와 기본 부품이 몇 개씩 필요한 지
		int[][] arr = new int[N+1][N+1];
//		자신이 어느부품에 몇 개가 필요한지 개수를 저장
		int[][] cnt = new int[N+1][N+1];
		
		for(int i = 1; i <= M; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int X = Integer.parseInt(st.nextToken());
			int Y = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
//			ahead 증가
			arr[X][0]++;
//			X를 만드는데 Y가 K개 필요
			cnt[Y][X] = K;
		}
//		위상 정렬 큐
		Queue<Integer> queue = new LinkedList<>();
//		기본 부품 큐
		Queue<Integer> standard = new LinkedList<>();
		for(int i = 1; i <= N; i++) {
//			ahead가 0이면 기본 부품이므로, 2개의 큐에 모두 삽입 후 자신의 부품 1개로 초기화
			if(arr[i][0] == 0) {
				queue.add(i);
				standard.add(i);
				arr[i][i] = 1;
			}
		}
//		위상 정렬
		while(!queue.isEmpty()) {
			int num = queue.poll();
			for(int i = 1; i <= N; i++) {
//				i를 만드는데 필요한 num이 0개라면 패스
				if(cnt[num][i] == 0) continue;
//				i의 ahead 감소
				arr[i][0]--;
//				(num을 만드는데 필요한 j들의 개수 x i를 만드는데 필요한 num의 개수)를 i를 만드는데 필요한 j들의 개수에 더하기
				for(int j = 1; j <= N; j++) {
					arr[i][j] += arr[num][j]*cnt[num][i];
				}
//				i의 ahead가 0이라면 큐에 삽입
				if(arr[i][0] == 0) {
					queue.add(i);
				}
			}
		}
//		완제품 번포 N을 만드는데 필요한 기본부품들을 개수와 함께 출력
		while(!standard.isEmpty()) {
			int num = standard.poll();
			sb.append(num).append(' ').append(arr[N][num]).append('\n');
		}
		System.out.println(sb);
	}
}
