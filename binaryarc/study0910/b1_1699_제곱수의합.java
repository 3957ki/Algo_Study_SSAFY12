package study0910;

import java.util.Scanner;

public class b1_1699_제곱수의합 {
	static int ans;
	static int memo[] ;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		 memo = new int[100001];
		if(num % Math.sqrt(num) == 0) {
			System.out.println(1);
		}else {
			ans = Integer.MAX_VALUE;
			dfs(num,0);
			System.out.println(ans);
		}
	}
	static void dfs(int n,int cnt) {
		if(cnt >= ans)return;
		if(n == 0 ) {
			ans = Math.min(ans,cnt);
			return;
		}
		if (memo[n] != 0 && memo[n] <= cnt) {
            return;  // 이미 memo에 저장된 최소 횟수보다 크거나 같다면 탐색 중단
        }
        memo[n] = cnt;  // 현재 상태에서의 최소 cnt 기록
		for(int i = (int)Math.sqrt(n) ; i>= 1 ; i--) {
			int pow_num = i*i;
			dfs(n - pow_num , cnt+1);
		}
	}
}
