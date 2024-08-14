package study0725;

import java.io.*;
import java.util.*;

//그리디?
public class p16435 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int l = Integer.parseInt(st.nextToken());
		int len = 0;
		int[] arr = new int[n]; // 배열 생성
		StringTokenizer st1 = new StringTokenizer(br.readLine()); // 배열에 들어갈 값
		
		for(int i=0; i<n;i++) { // 값 할당
			arr[i] = Integer.parseInt(st1.nextToken());
		}
		
		Arrays.sort(arr);
		
		for(int idx = 0; idx<n;idx++) {
			l += (arr[idx] <= l ? 1 : 0);
		}
		System.out.println(l + len);
	}

}