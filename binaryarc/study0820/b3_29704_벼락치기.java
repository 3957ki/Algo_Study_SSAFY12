package study0820;

import java.util.Arrays;
import java.util.Scanner;

/*
 * 난이도별 문제 N개
 * T일의 제출기간
 * 최소한의 벌금 내기
 */
public class b3_29704_벼락치기 {
	static class Problem implements Comparable<Problem>{
		int level;
		int cost;
		public Problem(int l,int c) {
			this.level = l;
			this.cost = c;
		}
		
		@Override
		public int compareTo(Problem o) {
			if(this.cost == o.cost) {
				return this.level - o.level;
			}else return o.cost-this.cost;
		}
		
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int T = sc.nextInt();
		Problem[] arr = new Problem[N];
		int cost=0;
		for(int i=0;i<N;i++) {
			arr[i] = new Problem(sc.nextInt(), sc.nextInt());
			cost+= arr[i].cost;
		}

		Arrays.sort(arr);
		for(int i=0;i<N;i++) {
			System.out.println(arr[i].level + " " + arr[i].cost);
		}
		
		for(int i=0;i<N;i++) {
			if(arr[i].level <= T && T - arr[i].level >=0) {
				cost -= arr[i].cost;
				T -= arr[i].level;
			}else break;
		}
		System.out.println(cost);
	}
}
