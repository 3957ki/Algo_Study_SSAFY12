package d1003;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class prob1 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine().trim();
		if(s.length() == 0) {
			System.out.println('C');
			return;
		}
		int countUC = 0;
		int countDP = 0;
		for(char c : s.toCharArray()) {
			if(c == 'U' || c == 'C') countUC++;
			else countDP++;
		}
		if(countDP > 0) {
			//DP는 반드시 가능
			if(countUC > ((countDP+1)>>1)) {
				System.out.println("UDP");
			} else {
				System.out.println("DP");
			}
		}
		else {
			System.out.println("U");
		}
		
	}
}
