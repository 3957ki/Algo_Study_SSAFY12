package algo;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;


public class Main_1_14495 {
	
	static long [] f;
	
	public static void main(String[] args) {
		
		
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		f = new long[117];		
		f[1] = f[2] = f[3] = 1;
		
		for (int i = 4; i <= n; i++) {
			f[i] = f[i-1] + f[i-3];
		}
		
		
		System.out.println(f[n]);
	}
	
}
