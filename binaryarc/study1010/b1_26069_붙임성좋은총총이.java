package study1010;

import java.io.*;
import java.util.*;

public class b1_26069_붙임성좋은총총이 {
	static Set<String> dancing;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		
		dancing = new HashSet<String>();
		dancing.add("ChongChong");
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			String a = st.nextToken();
			String b = st.nextToken();
			if(dancing.contains(a) || dancing.contains(b)) {
				dancing.add(a);
				dancing.add(b);
			}
		}
		System.out.println(dancing.size());
	}
}