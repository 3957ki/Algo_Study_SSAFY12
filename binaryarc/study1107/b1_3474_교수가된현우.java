package study1107;

import java.io.*;
import java.util.*;

public class b1_3474_교수가된현우 {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int i = 0; i < T; i++) {
			long cnt = 0;
			long num = sc.nextLong();
			System.out.println(countZero(num));
		}
	}
	
	public static int countZero(long n) {
        int count = 0;
        while (n >= 5) {
            n /= 5;
            count += n;
        }
        return count;
    }
	
}
