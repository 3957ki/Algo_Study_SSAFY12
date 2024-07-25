package study0725;

import java.io.*;
import java.util.*;
public class p16951 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		int min = Integer.MAX_VALUE;
		st = new StringTokenizer(br.readLine());
		int[] arr = new int[n];
		for(int i=0;i<n;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		for(int i=1; i<=1000;i++) { // 점화식 구현 및 반복
			int cnt =0;
			for(int j=0;j<n;j++)
				if(arr[j] != i+j*k) {
					cnt++;
			}
			min = Math.min(min, cnt);
		}
		System.out.println(min);
	}

}
