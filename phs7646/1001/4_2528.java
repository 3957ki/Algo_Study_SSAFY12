package emptyJava;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class prob4 {
	static int L;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		
		int time = 0;
		st = new StringTokenizer(br.readLine());
		int prev_len = Integer.parseInt(st.nextToken());
		int prev_d = Integer.parseInt(st.nextToken());
		for(int floor = 2;floor <= N;floor++) {
			st = new StringTokenizer(br.readLine());
			int cur_len = Integer.parseInt(st.nextToken());
			int cur_d = Integer.parseInt(st.nextToken());
			
			while(true) {
				int prev_left = getLeftPoint(prev_d==0, prev_len, time);
				int cur_left = getLeftPoint(cur_d==0, cur_len, time);

				//둘이 겹치는가?
				if(prev_left <= cur_left && cur_left <= prev_left+prev_len) break;
				if(cur_left <= prev_left && prev_left <= cur_left+cur_len) break;
				time++;
			}
			prev_d = cur_d;
			prev_len = cur_len;
		}
		System.out.println(time);
	}
	static int getLeftPoint(boolean isLeft,int len,int Time) {
		int half_period = L-len;
		if(half_period == 0) return 0;
		Time %= (half_period<<1);
		if(isLeft) {
			if(Time <= half_period) return Time;
			else return half_period - (Time-half_period);
		} else {
			if(Time <= half_period) return (L-len)-Time;
			else return Time-half_period;
		}
	}
}
