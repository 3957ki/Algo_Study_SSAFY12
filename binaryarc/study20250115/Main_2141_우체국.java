package study20250115;

import java.io.*;
import java.util.*;

public class Main_2141_우체국 {
	static class Village {
		long x;
		long people;
		public Village(long x, long p) {
			this.x = x;
			this.people = p;
		}
	}
	static List<Village> list;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		list = new LinkedList<>();
		StringTokenizer st = null;
		long sum = 0;
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			long number = Long.parseLong(st.nextToken());
			long people = Long.parseLong(st.nextToken());
			list.add(new Village(number, people));
			sum += people;
		}
		Collections.sort(list, (o1, o2) -> Long.compare(o1.x, o2.x));
		long cur = 0;
		for(Village v : list) {
			cur += v.people;
			if(cur >= (sum+1)/2) {
				System.out.println(v.x);
				return;
			}
		}
	}

}
