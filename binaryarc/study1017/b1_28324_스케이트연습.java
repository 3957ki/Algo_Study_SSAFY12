package study1017;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class b1_28324_스케이트연습 {
	static int N;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		int[] arr = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		int[] ans_arr = new int[N];
		long cur_speed = 1;// 도착지에서 0이어야 하기 때문에 마지막속도는 1
		long ans = 1; // 속도 합 저장할 변수
		// 뒤에서 부터
		for (int i = N - 2; i >= 0; i--) {
			//이전 속도는 앞의속도보다 1크거나, 그것보다 작아야함
			cur_speed = Math.min(arr[i], cur_speed + 1);
			ans += cur_speed;
		}
		System.out.println(ans);

	}

}
