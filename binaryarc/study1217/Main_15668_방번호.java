package study1217;

import java.io.*;
import java.util.*;

public class Main_15668_방번호 {
	static int N;

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();

		if (N == 2) {
			System.out.println(-1);
			return;
		}
		
		for (int i = 1; i <= 99999; i++) {
			boolean[] visited = new boolean[10];
			
			boolean find = true;
			if(N-i ==0)break;
			
			String strA = Integer.toString(i);
			for(char ch : strA.toCharArray()) {
				if(!visited[ch-'0']) {
					visited[ch-'0'] = true;
				}else {
					find = false;
					break;
				}
			}
			if(!find)continue;
			
			String strB = Integer.toString((N-i));
			for(char ch : strB.toCharArray()) {
				if(!visited[ch-'0']) {
					visited[ch-'0'] = true;
				}else {
					find = false;
					break;
				}
			}
			if(find) {
				System.out.println(strB + " + " +strA);
				return;
			}
		}
		System.out.println(-1);

	}

}
