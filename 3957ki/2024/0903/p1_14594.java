import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class p1_14594 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		int[] arr = new int[N+1];
//		1로 채우기
		Arrays.fill(arr, 1);
		for(int i = 0; i < M; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
//			해당 범위에서 end 빼고 다 0으로 바꿈
			for(int j = start; j < end; j++) {
				arr[j] = 0;
			}
		}
		int answer = 0;
//		1의 개수 세기
		for(int i = 1; i <= N; i++) {
			if(arr[i] == 1) answer++;
		}
		
		System.out.println(answer);
	}

}