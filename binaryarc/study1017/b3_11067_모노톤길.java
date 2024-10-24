package study1017;

import java.io.*;
import java.util.*;

public class b3_11067_모노톤길 {
	static class Pos implements Comparable<Pos> {
		int x, y;

		public Pos(int x, int y) {
			this.x = x;
			this.y = y;
		}

		@Override
		public int compareTo(Pos o) {
			int res = Integer.compare(this.x, o.x);
			if (res != 0)
				return res;
			return Integer.compare(this.y, this.y);
		}
	}

	static int N;
	static Pos[] cafes;
	static Pos[] ans;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken());

		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			cafes = new Pos[N];
			ans = new Pos[N];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				Pos cafe = new Pos(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
				cafes[i] = cafe;
			}
			Arrays.sort(cafes);
			
			int cur_x = cafes[0].x;
			int cur_y = cafes[0].y;
			
			for(int i=1;i<N;i++) {
				if(cafes[i].y == cur_y) {
					ans[i] = cafes[i];
				}else {
					
				}
			}
			
			
			
			st = new StringTokenizer(br.readLine());
			int m = Integer.parseInt(st.nextToken());
			
			for (int i = 1; i <= m; i++) {
				
			}
		}
	}
}
