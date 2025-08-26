package study20250826;

import java.io.*;
import java.util.*;

public class Main_4781_사탕가게 {
	static int T;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringBuilder ans = new StringBuilder();
		T = Integer.parseInt(br.readLine());
		for (int tc = 0; tc < T; tc++) {
			String goal = br.readLine().trim();
			int cnt = 0;
			for(int i=0;i<goal.length();i++) {
				cnt += getChangeCnt(goal.charAt(i));
			}
			
		}
	}
	
	public static int getChangeCnt(char a) {
		return Math.min(a - 'A', 'Z' + 1 - a);
	}
	

}
