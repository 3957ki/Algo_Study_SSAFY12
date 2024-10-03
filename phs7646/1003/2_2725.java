package d1003;

import java.util.Scanner;

public class prob2 {

	public static void main(String[] args) {
		//preprocess
		//서로소인 (x,y) 만 보인다
		int dp[] = new int[1001];
		dp[0] = 0;
		dp[1] = 3;
		dp[2] = 5;
		for(int n = 3;n <= 1000;n++) {
			//(x,n) 중 서로소인 좌표들이 두번씩 추가됨
			int append = 1; // (1,n)
			for(int j = 2;j < n;j++) {
				if(canSee(n,j)) append++; 
			}
			dp[n] = dp[n-1] + 2 * append;
		}
		
		
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int t = 0;t < T;t++) {
			System.out.println(dp[sc.nextInt()]);
		}
	}
	static boolean canSee(int x,int y) {
		//(x,y) 는 보이는가? 최대공약수가 1이면 된다.
		if(x < y) {
			int t = x;
			x = y;
			y = t;
		}
		
		if(x%y == 0) {
			if(y == 1) return true;
			else return false;
		}
		else return canSee(x%y,y);
	}

}
