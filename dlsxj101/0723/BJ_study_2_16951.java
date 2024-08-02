import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		int[] tower = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			tower[i] = Integer.parseInt(st.nextToken());
		}
		int min = 9999;
		
		for(int i = 0; i < N; i++) {
			int cnt = 0;
			
			// 기준 인덱스에서 탑 높이가 감소할 때 1보다 작아지는지 검사
			if((tower[i] - (K * i)) < 1) continue;
			
			// 기준 인덱스에서 왼쪽으로 이동하며 탑 높이를 감소시킬 때 탑 높이를 변화시켜야 하는 개수를 카운트
			for(int j = i-1; j >= 0; j--) {
				if((tower[i] - tower[j]) != ((i-j) * K)) {
					cnt++;
				}
			}
			
			// 기준 인덱스에서 오른쪽으로 이동하며 탑 높이를 증가시킬 때 탑 높이를 변화시켜야 하는 개수를 카운트
			for(int j = i+1; j < N; j++) {
				if((tower[j] - tower[i]) != ((j-i) * K)) {
					cnt++;
				}
			}
			min = Math.min(min, cnt);
		}
		System.out.print(min);
	}
}
