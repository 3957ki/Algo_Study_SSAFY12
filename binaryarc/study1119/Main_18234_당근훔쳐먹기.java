package study1119;

import java.io.*;
import java.util.*;

public class Main_18234_당근훔쳐먹기 {
	static class Carrot implements Comparable<Carrot>{
		long w, p;
		public Carrot(long w, long p) {
			this.w = w;
			this.p = p;
		}
		@Override
		public int compareTo(Carrot o) {
			if(this.p == o.p) {
				return Long.compare(this.w, o.w);
			}
			return Long.compare(this.p, o.p);
		}
	}
	static int N;
	static Long T;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); // 당근종류 개수
		T = Long.parseLong(st.nextToken()); // 일하는 날
		Carrot[] carrots = new Carrot[N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			long w = Long.parseLong(st.nextToken()); // 맛정도
			long p = Long.parseLong(st.nextToken()); // 맛증가 영양제
			carrots[i] = new Carrot(w, p);
		}
		Arrays.sort(carrots);
		
		long res = 0;
		int idx = 0;
		for (int i = (int) (T - N); i < T; i++) {
			res += ((carrots[idx].w) + (carrots[idx].p * i));
			idx++;
		}

		System.out.println(res);
	}
}
