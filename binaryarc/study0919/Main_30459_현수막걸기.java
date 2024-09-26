package study0919;

import java.io.*;
import java.util.*;

public class Main_30459_현수막걸기 {
	static int N,M,R;
	static int[] maldduk;
	static Integer[] git;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());

		maldduk = new int[N];
		git = new Integer[M];
		
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			maldduk[i] = Integer.parseInt(st.nextToken());
		}
		
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<M;i++) {
			git[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(git);

		TreeSet<Integer> tSet = new TreeSet<Integer>();
		for(int i=0;i<N;i++) {
			for(int j=i+1;j<N;j++) {
				tSet.add(Math.abs(maldduk[j] - maldduk[i]));
			}
		}
		Integer[] gap = tSet.toArray(new Integer[0]);

		long result = -1;
		
		for(int g : gap) {
			int left = 0;
			int right = M-1;
			while(left <= right) {
				int mid = (left + right) /2;
				if(g * git[mid] <= R*2) {
					result = Math.max(result, g * git[mid]);
					left = mid + 1;
				}else {
					right = mid - 1;
				}
			}
		}
		
		if(result != -1) {
			System.out.printf("%.1f\n", (double)result / 2);
		}else {
			System.out.println(-1);
		}
	}
}
