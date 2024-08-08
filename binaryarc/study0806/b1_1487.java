package study0806;

import java.util.*;
import java.io.*;

//백준 1487 물건팔기
public class b1_1487 {
	public static class buyer{
		int p; //금액
		int d; //배송비
		public buyer(int p, int d){
			this.p = p;
			this.d = d;
		}		
	}
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		ArrayList<buyer> bList = new ArrayList<>();
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			int p = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			bList.add(new buyer(p, d));
		}
		Collections.sort(bList,new Comparator<buyer>() {
			@Override
			public int compare(buyer o1, buyer o2) {
				int result = o1.p - o2.p;
				if(result==0) {
					result = o1.d - o2.d;
				}
				return result;
			}
		});
		int maxPrice = 0;
		int maxTotal = 0;
		for(int i=0;i<N;i++) {
			int total=0;
			for(int j=i;j<N;j++) {
				int benefit = bList.get(i).p - bList.get(j).d;
				if(benefit > 0) {
					total += benefit;
				}
			}
			if(maxTotal < total) {
				maxTotal = total;
				maxPrice = bList.get(i).p;
			}
		}
		System.out.println(maxPrice);
		
	}

}
