package study0806;

import java.io.*;
import java.util.*;

public class p1487 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int n = Integer.parseInt(br.readLine());
		int[][] arr = new int[n][2];
		for(int i=0; i<n;i++) {
			st = new StringTokenizer(br.readLine());
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr, new Comparator<int[]>() { // 최대 비용 순으로 오름차순 정렬
			@Override
			public int compare(int[] o1, int[] o2) {
				int diff = o1[0] - o2[0]; // 차이 계산
				if(diff == 0) { // 차이가 같다면
					diff = o1[1] - o2[1]; // 배송 비용 기준 오름차순
				}
				return diff;
			}
		});
		
		int curMax =0; // 최대 이익일 때 판매가(출력값)
		int maxProfit =0;// 최대 이익
		for(int i=0; i<n;i++) {
			int sum =0; // 현재가로 판매했을 때의 이익 저장
			for(int j=i;j<n;j++) {
				int diff = arr[i][0] - arr[j][1]; // 현재가 기준 차액 계산 
				if(diff > 0) {
					sum += diff; // 흑자면 저장
				}
			}
			if(maxProfit < sum) { // 최대갱신
				maxProfit = sum;
				curMax = arr[i][0];
			}
		}
		System.out.println(curMax);
	}
}
