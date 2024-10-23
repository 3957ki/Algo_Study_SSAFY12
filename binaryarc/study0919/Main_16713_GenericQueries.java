package study0919;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_16713_GenericQueries {
	static int N,Q;
	static int[] arr;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		Q = Integer.parseInt(st.nextToken());
		arr = new int[N+1];
		st = new StringTokenizer(br.readLine());
		for(int i=1;i<=N;i++) {
			arr[i] = arr[i-1] ^ Integer.parseInt(st.nextToken());
		}
		
		int result = 0;
		
		for(int i=0;i<Q;i++) {
			st = new StringTokenizer(br.readLine());
			int si = Integer.parseInt(st.nextToken());
			int ei = Integer.parseInt(st.nextToken());
			
			result ^= arr[ei] ^ arr[si-1];
		}
		
		System.out.println(result);
	}
}
