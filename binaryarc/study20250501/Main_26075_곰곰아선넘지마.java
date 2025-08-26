package study20250501;

import java.io.*;
import java.util.*;

public class Main_26075_곰곰아선넘지마 {
	static int N, M;
	static String S, T;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		S = br.readLine();
		T = br.readLine();

		List<Integer> sList = new ArrayList<>();
		List<Integer> tList = new ArrayList<>();
		
		for (int i = 0; i < N + M; i++) {
			if(S.charAt(i) == '1')sList.add(i);
			if(T.charAt(i) == '1')tList.add(i);
		}
		
		
		long sum = 0;
		for(int i=0;i<sList.size();i++) {
			sum += Math.abs(sList.get(i) - tList.get(i));
		}
		
		long X = sum >> 1;
		long Y = sum - X;
		System.out.println(X * X + Y * Y);

	}
}
