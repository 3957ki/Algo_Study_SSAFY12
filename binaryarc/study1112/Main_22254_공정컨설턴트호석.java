package study1112;

import java.io.*;
import java.util.*;

public class Main_22254_공정컨설턴트호석 {
	static int N, X;
	static int[] arr;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken());

		arr = new int[N + 1];
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int left = 1;
		int right = N;
		while(left <= right) {
			int mid = (left+right)/2; //공정개수 정하기
			if(isAvail(mid)) {
				right = mid -1;
			}else {
				left = mid + 1;
			}
		}
		System.out.println(left);
	}

	public static boolean isAvail(int mid) {
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		
		for(int i=0;i<mid;i++)pq.offer(0); //이분탐색으로 선택한 공정개수만큼 공정추가
		
		for (int i = 1; i <= N; i++) { 
			int cur = pq.poll(); //가장 적게 사용한 공정
			if (cur + arr[i] > X)
				return false;
			pq.offer(cur + arr[i]);
		}
		return true; //선물 배정 완료
	}
}
