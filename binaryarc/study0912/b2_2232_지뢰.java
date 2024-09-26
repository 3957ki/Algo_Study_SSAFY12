package study0912;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class b2_2232_지뢰 {
	static class Mine{
		int x,power;
		public Mine(int x,int power) {
			this.x = x;
			this.power = power;
		}
	}
	static int N;
	static int[] power_arr;
	static int[] arr;
	static int cnt;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		PriorityQueue<Mine> pq = new PriorityQueue<>((o1,o2) -> o2.power - o1.power);
		power_arr = new int[N+1];
		arr = new int[N+1];
		for(int i = 1; i <= N;i++) {
			st = new StringTokenizer(br.readLine());
			int x = i;
			int power = Integer.parseInt(st.nextToken());
			arr[i] = power;
			pq.add(new Mine(x,power));
		}
		cnt = 1;
		ArrayList<Integer> lis = new ArrayList<Integer>();
		while(cnt <= N) {
			Mine cur = pq.poll();
			if(arr[cur.x] >= 0) {
				lis.add(cur.x);
				arr[cur.x] = -1;
			}
			cnt++;
			boom(cur);
		}
		Collections.sort(lis);
		for(Integer n  : lis)System.out.println(n);
	}
	public static void boom(Mine m) {

		Queue<Mine> dq = new ArrayDeque<Mine>();
		dq.add(m);

		while(!dq.isEmpty()) {
			Mine cur = dq.poll();
			int cur_x = cur.x;
			int next_left = cur_x - 1;
			int next_right = cur_x + 1;
			if(next_left >= 1 && arr[next_left] >= 0) {
				if(arr[next_left] - cur.power < 0) {
					arr[next_left] = -1;  // 폭발 처리 (음수로 만듦)
	                dq.add(new Mine(next_left, power_arr[next_left]));
				}
			}
			if(next_right <= N && arr[next_right] >= 0) {
				if(arr[next_right]  - cur.power < 0) {
					arr[next_right] = -1;  // 폭발 처리 (음수로 만듦)
	                dq.add(new Mine(next_right, power_arr[next_right]));
				}
			}
		}


	}
}
