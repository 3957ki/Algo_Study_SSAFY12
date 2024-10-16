package study1003;

import java.io.*;
import java.util.*;
public class b2_2725_보이는점의개수 {
	static int T,N;
	static boolean[][] chk;
	public static void main(String[] args) throws Exception{
		chk = new boolean[1001][1001];
		chk[0][1] = true;
		chk[1][0] = true;
		chk[1][1] = true;
		int cht = 3;
		//기울기가 같으면 보이지않는다?
		
		
		Scanner sc = new Scanner(System.in);
		T = sc.nextInt();
		for(int i=0;i<T;i++) {
			N = sc.nextInt();
			
			int cnt = 0;
			
			for(int x=0;x<=N;x++) {
				for(int y=0;y<=N;y++) {
					
				}
			}
		}
	}

}
