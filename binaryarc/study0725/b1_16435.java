package study0725;

import java.io.*;
import java.util.*;
public class b1_16435 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		int[] apples = new int[N];
		for(int i=0;i<N;i++)apples[i] = Integer.parseInt(st.nextToken());
		Arrays.sort(apples);
		for(int a : apples) {
			if(L >= a) {
				L++;
			}
		}
		System.out.println(L);
		
		
		
	}

}
